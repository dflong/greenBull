package com.dflong.algorithm.leetcode0;

public class _1052 {

    public static void main(String[] args) {
        _1052 v = new _1052();
        v.maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                max += customers[i];
            }
        }

        int sum = 0;
        int increase = 0;
        for (int i = 0; i < minutes; i ++) {
            if (grumpy[i] == 1) {
                increase += customers[i];
            }
        }
        sum = increase;
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i - minutes] == 1) {
                increase -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                increase += customers[i];
            }
            sum = Math.max(sum, increase);
        }
        return max + sum;
    }
}
