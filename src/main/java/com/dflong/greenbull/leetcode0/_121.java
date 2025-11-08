package com.dflong.greenbull.leetcode0;

public class _121 {

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        int i = maxProfit(price);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
       int price = prices[0];
       int profit = 0;
       for (int i = 1; i < prices.length; i ++) {
           price = Math.min(price, prices[i]);
           profit = Math.max(profit, prices[i] - price);
       }

       return profit;
    }
}
