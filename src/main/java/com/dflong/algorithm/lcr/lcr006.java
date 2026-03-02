package com.dflong.algorithm.lcr;

public class lcr006 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i ++;
            } else {
                j --;
            }
        }
        return new int[]{-1, -1};
    }
}
