package com.dflong.stock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

/**
 * 时间区间车辆库存管理：
 * 时间区间为 [startTime, endTime)，startTime 为闭区间端点，endTime 为开区间端点。
 *
 */
public class TimeIntervalStockManager {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(4, "4");
        treeMap.put(5, "5");
        treeMap.put(7, "7");
        treeMap.put(8, "8");
        treeMap.put(9, "9");
        treeMap.put(11, "11");
        treeMap.put(12, "12");
        treeMap.put(15, "15");
        treeMap.put(16, "16");
        treeMap.put(18, "18");
        treeMap.put(19, "19");

        NavigableMap<Integer, String> integerStringNavigableMap = treeMap.subMap(10, true, 15, false);
        System.out.println();
    }

    /**
     * key: 区间起始时间
     * value: 从该时间点开始直到下一个 key（或无穷大）之间的库存数量
     *
     * 示例：
     *   0 -> 3
     *   10 -> 5
     * 表示:
     *   [0, 10) 库存为 3
     *   [10, +∞) 库存为 5
     *
     * 若某一时间段不存在 key，则默认库存为 0。
     */
    private final TreeMap<Long, Integer> segments = new TreeMap<>();

    /**
     * 新增库存：在 [startTime, endTime) 区间内增加 stock 数量的库存。
     */
    public void addStock(long startTime, long endTime, int stock) {
        if (startTime >= endTime || stock <= 0) {
            return;
        }

        ensureKey(startTime);
        ensureKey(endTime);

        NavigableMap<Long, Integer> sub = segments.subMap(startTime, true, endTime, false);
        List<Long> keys = new ArrayList<>(sub.keySet());
        for (Long key : keys) {
            int old = segments.get(key);
            segments.put(key, old + stock);
        }

        mergeNeighbors();
    }

    /**
     * 查询在 [startTime, endTime) 区间内，是否始终至少有 stock 数量的库存。
     */
    public boolean isStockEnough(long startTime, long endTime, int stock) {
        if (startTime >= endTime || stock <= 0) {
            return true;
        }

        ensureKey(startTime);
        ensureKey(endTime);

        NavigableMap<Long, Integer> sub = segments.subMap(startTime, true, endTime, false);
        for (Map.Entry<Long, Integer> entry : sub.entrySet()) {
            if (entry.getValue() < stock) {
                return false;
            }
        }
        return true;
    }

    /**
     * 库存扣减：在 [startTime, endTime) 区间内扣减 stock 数量的库存。
     * 若区间内任意一点库存不足，则不做任何修改并返回 false。
     */
    public boolean deductStock(long startTime, long endTime, int stock) {
        if (!isStockEnough(startTime, endTime, stock)) {
            return false;
        }

        ensureKey(startTime);
        ensureKey(endTime);

        NavigableMap<Long, Integer> sub = segments.subMap(startTime, true, endTime, false);
        List<Long> keys = new ArrayList<>(sub.keySet());
        for (Long key : keys) {
            int old = segments.get(key);
            if (stock >= old) {
                segments.put(key, old - stock);
            }
        }

        mergeNeighbors();
        return true;
    }

    /**
     * 删除区间库存：将 [startTime, endTime) 区间内的库存全部清零。
     */
    public void deleteStock(long startTime, long endTime) {
        if (startTime >= endTime) {
            return;
        }

        ensureKey(startTime);
        ensureKey(endTime);

        NavigableMap<Long, Integer> sub = segments.subMap(startTime, true, endTime, false);
        List<Long> keys = new ArrayList<>(sub.keySet());
        for (Long key : keys) {
            segments.put(key, 0);
        }

        mergeNeighbors();
    }

    /**
     * 确保在给定时间点 time 存在一个明确的区间起点。
     * 若不存在，则根据前一个区间的库存值（或 0）插入一个新的 key。
     */
    private void ensureKey(long time) {
        if (segments.containsKey(time)) {
            return;
        }
        Map.Entry<Long, Integer> floor = segments.floorEntry(time);
        int value = (floor == null) ? 0 : floor.getValue();
        segments.put(time, value);
    }

    /**
     * 合并相邻且库存值相同的区间，保持 segments 尽量简洁。
     */
    private void mergeNeighbors() {
        if (segments.isEmpty()) {
            return;
        }

        Iterator<Map.Entry<Long, Integer>> it = segments.entrySet().iterator();
        Map.Entry<Long, Integer> prev = it.next();
        while (it.hasNext()) {
            Map.Entry<Long, Integer> cur = it.next();
            if (Objects.equals(prev.getValue(), cur.getValue())) {
                it.remove();
            } else {
                prev = cur;
            }
        }
    }
}

