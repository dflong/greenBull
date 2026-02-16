package com.dflong.algorithm.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _560 {

    public static void main(String[] args) {
        _560 v = new _560();
        int i = v.subarraySum(new int[]{-1, -1, 1}, 0);
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // key 前缀和 value 次数
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }


}
