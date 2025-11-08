package com.dflong.greenbull.leetcode0;

public class _941 {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        boolean isDown = false;
        boolean isUp = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) return false;
            if (arr[i - 1] > arr[i]) {
                isDown = true;
            } else if (arr[i - 1] < arr[i] && isDown) {
                return false;
            } else if (arr[i - 1] < arr[i]) {
                if (isDown) return false;
                isUp = true;
            }
        }

        return isUp && isDown;
    }

    public static void main(String[] args) {
        new _941().validMountainArray(new int[]{1,3,2});
    }
}
