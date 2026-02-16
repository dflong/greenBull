package com.dflong.algorithm.leetcode;

public class _278 {

    public static void main(String[] args) {
        new _278().firstBadVersion(5);
    }

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    boolean isBadVersion(int version) {
        boolean[] num = new boolean[] {true, true, true, true, false, false};

        return num[version];
    }
}
