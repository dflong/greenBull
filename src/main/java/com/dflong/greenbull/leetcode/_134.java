package com.dflong.greenbull.leetcode;

public class _134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, curSum = 0;
        int startIdx = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            curSum += gas[i] - cost[i]; // 当前站点油量剩余
            if (curSum < 0) { // 油量不足
                curSum = 0;
                startIdx = i + 1; // 只能从下一个站点开始
            }
        }
        if (sum < 0) return -1;
        return startIdx;
    }
}
