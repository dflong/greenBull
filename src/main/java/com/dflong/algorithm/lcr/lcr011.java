package com.dflong.algorithm.lcr;

import java.util.HashMap;

public class lcr011 {

    public int findMaxLength(int[] nums) {
        int res = 0;
        int[] preSum = new int[nums.length + 1]; // 只有0，1
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? - 1 : 1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 1; i <= nums.length; i++) {
            int t = preSum[i];
            if (map.containsKey(t)) {
                res = Math.max(res, i - map.get(t)); // 俩个相同值的差就是0
            } else {
                map.put(t, i); // 更新位置
            }
        }

        return res;
    }
}
