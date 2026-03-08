package com.dflong.greenbull.manage;

import java.util.*;

/**
 * 区间库存推送到redis，使用ZSet sore 使用 startTime
 * 线程安全问题：对库存做修改： 对过期、非包含的区间修改、包含区间增加时不用加锁；删除redis key
 *                         对包含区间做减少区间时，需要加分布式锁，不能从redis、db扣减库存；删除redis key
 * 从redis读取库存 查询、扣减成功后 -> 发送mq -> 插入库存扣减明细，修改库存表区间库存
 *               没有缓存时时增加分布式锁，只能获取到锁的才能从db缓存到redis，其他阻塞
 * 每晚job，执行库存扣减明细回放应用到库存表，更新redis key
 */
public class VehicleStockManager implements VehicleStock {

    // 区间库存
    private List<TimeRangeStock> stockRanges = new ArrayList<>();

    /**
     * 新增库存
     * @param startTime 开始时间（闭区间）
     * @param endTime 结束时间（开区间）
     * @param stock 新增库存数量
     */
    @Override
    public void addStock(long startTime, long endTime, int stock) {
        if (startTime >= endTime || stock <= 0) {
            throw new IllegalArgumentException("参数不合法");
        }

        List<TimeRangeStock> newRanges = new ArrayList<>();
        TimeRangeStock newRange = new TimeRangeStock(startTime, endTime, stock);

        for (TimeRangeStock existing : stockRanges) {
            // 1. 完全不相交：直接保留原区间
            if (existing.getEndTime() <= newRange.getStartTime() ||
                    existing.getStartTime() >= newRange.getEndTime()) {
                newRanges.add(existing);
                continue;
            }

            // 2. 有重叠：拆分处理
            // 左非重叠部分
            if (existing.getStartTime() < newRange.getStartTime()) {
                newRanges.add(new TimeRangeStock(
                        existing.getStartTime(),
                        Math.min(existing.getEndTime(), newRange.getStartTime()),
                        existing.getStock()
                ));
            }

            // 重叠部分（库存累加）
            long overlapStart = Math.max(existing.getStartTime(), newRange.getStartTime());
            long overlapEnd = Math.min(existing.getEndTime(), newRange.getEndTime());
            if (overlapStart < overlapEnd) {
                newRanges.add(new TimeRangeStock(
                        overlapStart,
                        overlapEnd,
                        existing.getStock() + stock
                ));
            }

            // 右非重叠部分
            if (existing.getEndTime() > newRange.getEndTime()) {
                newRanges.add(new TimeRangeStock(
                        Math.max(existing.getStartTime(), newRange.getEndTime()),
                        existing.getEndTime(),
                        existing.getStock()
                ));
            }
        }

        boolean hasOverLap = false;
        // 3. 如果没有重叠区间，直接添加新区间
        if (newRanges.isEmpty() || !hasOverlap(newRanges, newRange)) {
            newRanges.add(newRange);
            hasOverLap = true;
        }

        // 第一段、最后一段比新加入的区间还小，则加入第一段、最后一段截断
        if (!hasOverLap) {
            TimeRangeStock last = newRanges.get(newRanges.size() - 1);
            if (last != newRange && last.getEndTime() < newRange.getEndTime()) {
                newRanges.add(new TimeRangeStock(last.getEndTime(), newRange.getEndTime(), newRange.getStock()));
            }
            TimeRangeStock first = newRanges.get(0);
            if (first != newRange && first.getStartTime() > newRange.getStartTime()) {
                newRanges.add(new TimeRangeStock(newRange.getStartTime(), first.getStartTime(), newRange.getStock()));
            }
        }

        // 4. 合并相邻且库存相同的区间
        stockRanges = mergeAdjacentRanges(newRanges);
    }

    /**
     * 查询库存是否足够
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param requiredStock 所需库存
     * @return 是否足够
     */
    @Override
    public boolean isStockEnough(long startTime, long endTime, int requiredStock) {
        if (startTime >= endTime || requiredStock <= 0) {
            return false;
        }

        // 将查询区间分成多个子区间检查
        List<Long> timePoints = new ArrayList<>();
        timePoints.add(startTime);

        // 收集所有相关的时间点
        for (TimeRangeStock range : stockRanges) {
            if (range.getEndTime() > startTime && range.getStartTime() < endTime) {
                if (range.getStartTime() > startTime) {
                    timePoints.add(range.getStartTime());
                }
                if (range.getEndTime() < endTime) {
                    timePoints.add(range.getEndTime());
                }
            }
        }
        timePoints.add(endTime);

        // 对每个相邻时间点组成的子区间检查库存
        Collections.sort(timePoints);
        for (int i = 0; i < timePoints.size() - 1; i++) {
            long subStart = timePoints.get(i);
            long subEnd = timePoints.get(i + 1);

            for (TimeRangeStock range : stockRanges) {
                if (range.getStartTime() <= subStart && range.getEndTime() >= subEnd) {
                    if (range.getStock() < requiredStock) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * 扣减库存
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param stock 扣减数量
     * @return 是否扣减成功
     */
    @Override
    public boolean reduceStock(long startTime, long endTime, int stock) {
        if (startTime >= endTime || stock <= 0) {
            return false;
        }

        // 1. 先检查库存是否足够
        if (!isStockEnough(startTime, endTime, stock)) {
            return false;
        }

        // 2. 实际扣减
        List<TimeRangeStock> newRanges = new ArrayList<>();

        for (TimeRangeStock existing : stockRanges) {
            // 无重叠区间直接保留
            if (existing.getEndTime() <= startTime || existing.getStartTime() >= endTime) {
                newRanges.add(existing);
                continue;
            }

            // 有重叠区间进行拆分扣减
            // 左非重叠部分
            if (existing.getStartTime() < startTime) {
                newRanges.add(new TimeRangeStock(
                        existing.getStartTime(),
                        Math.min(existing.getEndTime(), startTime),
                        existing.getStock()
                ));
            }

            // 重叠部分（扣减库存）
            long overlapStart = Math.max(existing.getStartTime(), startTime);
            long overlapEnd = Math.min(existing.getEndTime(), endTime);
            if (overlapStart < overlapEnd) {
                int newStock = existing.getStock() - stock;
                if (newStock > 0) {  // 扣减后还有库存
                    newRanges.add(new TimeRangeStock(
                            overlapStart,
                            overlapEnd,
                            newStock
                    ));
                }
                // 扣减到0的区间不添加
            }

            // 右非重叠部分
            if (existing.getEndTime() > endTime) {
                newRanges.add(new TimeRangeStock(
                        Math.max(existing.getStartTime(), endTime),
                        existing.getEndTime(),
                        existing.getStock()
                ));
            }
        }

        // 3. 合并相邻区间
        stockRanges = mergeAdjacentRanges(newRanges);
        return true;
    }

    /**
     * 删除区间库存
     * @param startTime 开始时间
     * @param endTime 结束时间
     */
    @Override
    public void deleteStock(long startTime, long endTime) {
        if (startTime >= endTime) {
            return;
        }

        List<TimeRangeStock> newRanges = new ArrayList<>(32);

        for (TimeRangeStock existing : stockRanges) {
            // 完全不相交：保留
            if (existing.getEndTime() <= startTime || existing.getStartTime() >= endTime) {
                newRanges.add(existing);
                continue;
            }

            // 左非重叠部分
            if (existing.getStartTime() < startTime) {
                newRanges.add(new TimeRangeStock(
                        existing.getStartTime(),
                        Math.min(existing.getEndTime(), startTime),
                        existing.getStock()
                ));
            }

            // 重叠部分（删除，不添加）

            // 右非重叠部分
            if (existing.getEndTime() > endTime) {
                newRanges.add(new TimeRangeStock(
                        Math.max(existing.getStartTime(), endTime),
                        existing.getEndTime(),
                        existing.getStock()
                ));
            }
        }

        stockRanges = mergeAdjacentRanges(newRanges);
    }

    /**
     * 合并相邻且库存相同的区间
     */
    private List<TimeRangeStock> mergeAdjacentRanges(List<TimeRangeStock> ranges) {
        if (ranges.isEmpty()) {
            return new ArrayList<>();
        }

        Collections.sort(ranges);

        List<TimeRangeStock> merged = new ArrayList<>();
        TimeRangeStock current = ranges.get(0);

        for (int i = 1; i < ranges.size(); i++) {
            TimeRangeStock next = ranges.get(i);

            // 如果相邻且库存相同，合并区间
            if (current.getEndTime() == next.getStartTime() &&
                    current.getStock() == next.getStock()) {
                current = new TimeRangeStock(
                        current.getStartTime(),
                        next.getEndTime(),
                        current.getStock()
                );
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);

        return merged;
    }

    /**
     * 检查区间是否有重叠
     */
    private boolean hasOverlap(List<TimeRangeStock> ranges, TimeRangeStock newRange) {
        for (TimeRangeStock range : ranges) {
            if (!(range.getEndTime() <= newRange.getStartTime() ||
                    range.getStartTime() >= newRange.getEndTime())) {
                return true;
            }
        }
        return false;
    }

}
