package com.dflong.greenbull.leetcode0;

public class _134 {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    // gas = [1,2,3,4,5],
    //cost = [3,4,5,1,2]
    // sum=[-2,-4,-6,-3,0]
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curSum = 0, sum = 0, index = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];
            if (curSum < 0) {
                curSum = 0;
                index = i + 1;
            }
        }
        if (sum < 0) return -1;
        return index;
    }
}
