package com.dflong.greenbull.leetcode;

public class _458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int state = minutesToTest / minutesToDie + 1; // 每次猪一共有多少状态
        double temp = Math.log(buckets) / Math.log(state) - 1e-5; // - 1e-5为了消除精度问题
        return (int) Math.ceil(temp);
    }
}
