package com.dflong.algorithm.lcr;

public class lcr172 {

    public static void main(String[] args) {
        new lcr172().countTarget(new int[] {2, 2, 3, 4, 4, 4, 5, 6, 6, 8}, 4);
    }

    public int countTarget(int[] scores, int target) {
        int r = binarySearchR(scores, target);
        int l = binarySearchL(scores, target);
        if (l == -1 || r == -1) return 0;
        return r - l + 1;
    }

    int binarySearchL(int[] scores, int target) {
        int i = 0, j = scores.length - 1, res = - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (scores[mid] == target) {
                res = mid;
                j = mid - 1;
            } else if (scores[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return res;
    }

    int binarySearchR(int[] scores, int target) {
        int i = 0, j = scores.length - 1, res = - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (scores[mid] == target) {
                res = mid;
                i = mid + 1;
            } else if (scores[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return res;
    }
}
