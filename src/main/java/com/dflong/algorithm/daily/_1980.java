package com.dflong.algorithm.daily;

public class _1980 {

    public static void main(String[] args) {
        String[] nums = {"01","10"};
        new _1980().findDifferentBinaryString(nums);
    }

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        StringBuilder sb = new StringBuilder();

        // 第idx位取nums[idx]的第idx位相反数
        for (int i = 0; i < n; i ++) {
            char c = nums[i].charAt(i);
            sb.append(c == '0' ? "1" : "0");
        }

        return sb.toString();
    }
}
