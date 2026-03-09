package com.dflong.algorithm.leetcode0;

public class _4 {

    public static void main(String[] args) {
        _4 v = new _4();
        double medianSortedArrays = v.findMedianSortedArrays(new int[]{2}, new int[]{});
        System.out.println();
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m > n) return findMedianSortedArrays(B, A); // 保证m < n
        // i + j = m - i + n - j + 1  -> j = (m + n + 1) / 2 - i
        // max(A[i - 1], B[j - 1]) <= min(A[i], B[j])
        // 为了保证上述条件满足 A[i - 1] <= B[j]，B[j - 1] <= A[i]

        int L = 0, R = m;
        while (L <= R) {
            int i = L + (R - L) / 2, j = (m + n + 1) / 2 - i;
            if (i != 0 && j != n && A[i - 1] > B[j]) { // i 减小
                R = i - 1;
            } else if (i != m && j != 0 && B[j - 1] > A[i]) { // i增大
                L = i + 1;
            } else {
                // 找到目标
                int maxLeft = 0, minRight = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                }
                else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 != 0) { // 奇数
                    return maxLeft;
                }

                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(A[i], B[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}
