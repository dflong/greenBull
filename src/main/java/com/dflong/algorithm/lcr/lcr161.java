package com.dflong.algorithm.lcr;

public class lcr161 {

    public int maxSales(int[] sales) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int sale : sales) {
            sum += sale;
            if (sum < sale) {
                sum = sale;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
