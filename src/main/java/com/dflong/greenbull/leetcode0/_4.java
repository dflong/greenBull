package com.dflong.greenbull.leetcode0;

public class _4 {

    public static void main(String[] args) {
        _4 v = new _4();
        double medianSortedArrays = v.findMedianSortedArrays(new int[]{2}, new int[]{});
        System.out.println();
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m > n) return findMedianSortedArrays(B, A);

        int L = 0, R = m;
        int k = (m + n + 1) / 2;
        while (L < R) {
            int m1 = (L + R) / 2;
            int m2 = k - m1;
            if (A[m1] < B[m2 - 1]) {
                L = m1 + 1;
            } else {
                R = m1;
            }
        }

        int m1 = L, m2 = k - L;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : A[m1-1],
                m2 <= 0 ? Integer.MIN_VALUE : B[m2-1]);
        if ((m + n) % 2 == 1)
            return c1;
        int c2 = Math.min( m1 >= m ? Integer.MAX_VALUE :A[m1],
                m2 >= n ? Integer.MAX_VALUE : B[m2]);
        return (c1 + c2) * 0.5;
    }

    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // 保证m小于n
        if (m > n) {
            return findMedianSortedArrays(B, A);
        }

        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i != 0 && j != n && A[i - 1] > B[j]) { // i需要减小
                iMax = i - 1;
            } else if (j != 0 && i != m && B[j - 1] > A[i]) { // j需要减小
                iMin = i + 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 == 1) { // 奇数
                    return maxLeft;
                }

                int maxRight = 0;
                if (i == m) {
                    maxRight = B[j];
                } else if (j == n) {
                    maxRight = A[i];
                } else {
                    maxRight = Math.min(A[i], B[j]);
                }

                return (maxLeft + maxRight) / 2.0;
            }
        }

        return 0;
    }

}
