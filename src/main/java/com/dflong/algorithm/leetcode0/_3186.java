package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3186 {

    public static void main(String[] args) {
        new _3186().maximumTotalDamage(new int[]{1,1,3,4});
    }

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < power.length; i++) {
            map.put(power[i], map.getOrDefault(power[i], 0) + 1);
        }

        int n = map.size();
        int[] nums = new int[n];
        int i = 0;
        for (int key : map.keySet()) {
            nums[i ++] = key;
        }

        Arrays.sort(nums);

        long[] dp = new long[n];
        dp[0] = (long) nums[0] * map.get(nums[0]);
        for (i = 1; i < n; i ++) {
            int j = i - 1;
            while (j >= 0 && nums[i] - 2 <= nums[j]) {
                j --;
            }

            if (j >= 0) {
                dp[i] = Math.max(dp[i - 1], dp[j] + (long) map.get(nums[i]) * nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], (long) map.get(nums[i]) * nums[i]);
            }
        }
        return dp[n - 1];
    }


}
