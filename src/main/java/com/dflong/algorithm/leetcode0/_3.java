package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3 {

    // 输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        int max = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i ++) {
            char c = charArray[i];
            if (map.containsKey(c)) {
                max = Math.max(max, end - begin + 1);
                begin = Math.max(map.get(c) + 1, begin);
                end = i;
                map.put(c, i);
            } else {
                end = i;
                map.put(c, i);
            }
        }

        return Math.max(max, end - begin + 1);
    }

    public static void main(String[] args) {
        new _3().lengthOfLongestSubstring1("abba");
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] nums = new int[128];
        Arrays.fill(nums, -1);
        int max = 1;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i);
            if (nums[idx] != -1) {
                // 发现重复就计算
                begin = Math.max(nums[idx] + 1, begin);
            }
            max = Math.max(max, i - begin + 1);
            nums[idx] = i;
        }
        return max;
    }
}
