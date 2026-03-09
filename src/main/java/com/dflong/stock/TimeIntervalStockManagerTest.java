package com.dflong.stock;

public class TimeIntervalStockManagerTest {

    public static void main(String[] args) {
        TimeIntervalStockManager vehicleStock = new TimeIntervalStockManager();
        vehicleStock.addStock(20260101, 20260301, 20);
        vehicleStock.addStock(20260201, 20260208, 20);
        vehicleStock.addStock(20260103, 20260401, 30);
        vehicleStock.addStock(20260401, 20260501, 30);
        vehicleStock.addStock(20260315, 20260515, 20);
        vehicleStock.addStock(20260301, 20260315, 10);
        vehicleStock.addStock(20260301, 20260315, 10);
        vehicleStock.addStock(20251220, 20260601, 10);
//        vehicleStock.addStock(20251220, 20260205, 10);
        System.out.println("....................");
    }
}
