package com.dflong.greenbull.manage;

public interface VehicleStock {

    /**
     * 添加库存
     */
    void addStock(long startTime, long endTime, int stock);

    /**
     * 库存是否足够
     */
    boolean isStockEnough(long startTime, long endTime, int requiredStock);

    /**
     * 扣减库存
     */
    boolean reduceStock(long startTime, long endTime, int stock);

    /**
     * 清理过期区间
     */
    void deleteStock(long startTime, long endTime);
}
