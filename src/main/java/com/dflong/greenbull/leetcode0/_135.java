package com.dflong.greenbull.leetcode0;

public class _135 {

    public static void main(String[] args) {
        int[] ratings = {1,3,4,5,2};
        System.out.println(candy(ratings));
    }
    // 1,2,87,87,87,2,1
    // 1,2,3, 1, 3, 2,1
    public static int candy(int[] ratings) {
        int sum = 0;
        int n = ratings.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }

        for (int num : res) {
            sum += num;
        }
        return sum;
    }
}
