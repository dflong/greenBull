package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _446 {

    public static void main(String[] args) {
        new _446().numberOfArithmeticSlices(new int[] {0,2000000000,-294967296});
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0, n = nums.length;
        // 当前i位置方差为d的弱等差数列cnt
        HashMap<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i ++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                long d = (long) nums[i] - nums[j];
                // 当前j位置d弱等差的数量
                int cnt = dp[j].getOrDefault(d, 0);
                res += cnt; // 加上位置i等差d的等差数列
                // cnt是j位置的数量 1是j、i两个数的弱等差数列 dp[i].getOrDefault(d, 0)是i原等差数列数量
                dp[i].put(d,  cnt + 1 + dp[i].getOrDefault(d, 0));
            }
        }

        return res;
    }

    // 超时
    public int numberOfArithmeticSlices1(int[] nums) {
        this.nums = new long[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            this.nums[i] = nums[i];
        }
        dfs(0);
        return res;
    }

    int res = 0;
    long[] nums;

    List<Long> path = new ArrayList<>();
    List<List<Long>> paths = new ArrayList<>();
    long k = 0; // 等差
    public void dfs(int idx) {
        if (path.size() >= 3) {
            paths.add(new ArrayList<>(path));
            res ++;
        }

        for (int i = idx; i < nums.length; i ++) {
            if (path.isEmpty()) {
                path.add(nums[i]);
            } else if (path.size() == 1) {
                k = nums[i] % Long.MAX_VALUE - path.get(0) % Long.MAX_VALUE;
                path.add(nums[i]);
            } else {
                if (nums[i] % Long.MAX_VALUE - path.get(path.size() - 1) % Long.MAX_VALUE == k) {
                    path.add(nums[i]);
                } else {
                    continue;
                }
            }
            dfs(i + 1);
            if (!path.isEmpty()) {
                path.remove(path.size() - 1);
            }
        }
    }
}
