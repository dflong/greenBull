package com.dflong.algorithm.leetcode0;

public class _167 {

    // 输入：numbers = [2,7,11,15], target = 9
    // 输出：[1,2]
    // 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2]
    public int[] twoSum(int[] numbers, int target) {

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i ++;
            } else {
                j --;
            }
        }
        return new int[]{0, 0};
    }
}
