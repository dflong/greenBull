package com.dflong.greenbull.manage;

import java.util.Objects;

public class TimeRangeStock implements Comparable<TimeRangeStock> {

    private long startTime;  // 开始时间（闭区间）
    private long endTime;    // 结束时间（开区间）
    private int stock;       // 库存数量

    public TimeRangeStock(long startTime, long endTime, int stock) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.stock = stock;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeRangeStock that = (TimeRangeStock) o;
        return startTime == that.startTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime);
    }

    @Override
    public int compareTo(TimeRangeStock o) {
        if (startTime < o.startTime) {
            return - 1;
        }
        if (startTime == o.startTime) {
            return 0;
        }
        return 1;
    }
}
