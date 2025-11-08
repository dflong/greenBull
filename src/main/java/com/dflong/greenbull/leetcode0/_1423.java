package com.dflong.greenbull.leetcode0;

public class _1423 {

    public static void main(String[] args) {
        _1423 v = new _1423();
        v.maxScore(new int[] {11,49,100,20,86,29,72}, 4);
    }

    // n - k - 1, n + k + 1
    // 11,49,100,20,86,29,72,11,49,100,20,86,29,72
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int max = 0, sum = 0;
        int l = n - k, r = n - k;
        int[] nums = new int[2 * n];
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = cardPoints[i % n];
        }

        for (int i = n - k; i < n + k; i ++) {
            sum += nums[i];
            if (r - l + 1 == k) {
                max = Math.max(max, sum);
                sum -= nums[l];
                l ++;
            }
            r ++;
        }

        return max;
    }
}
