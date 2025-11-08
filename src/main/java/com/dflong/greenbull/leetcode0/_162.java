package com.dflong.greenbull.leetcode0;

public class _162 {

    public static void main(String[] args) {
        _162 v = new _162();
        int peakElement = v.findPeakElement(new int[]{3,4,3});
        System.out.println(peakElement);
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}
