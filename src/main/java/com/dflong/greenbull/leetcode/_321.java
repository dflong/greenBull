package com.dflong.greenbull.leetcode;

import java.util.Stack;

public class _321 {


    public static void main(String[] args) {
        int[] r = new _321().maxNumber(new int[]{6,7,5}, new int[]{4,8,1}, 3);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int max = Math.max(0, k - nums2.length), min = Math.min(nums1.length, k);
        for (int i = max; i <= min; i ++) {
            // 求单数组的最大值
            int[] ints = maxNumber2(nums1, i);
            int[] ints1 = maxNumber2(nums2, k - i);

            // 合并
            int[] merge = merge(ints, ints1);
            if (compare(merge, 0, res, 0) > 0) {
                System.arraycopy(merge, 0, res, 0, k);
            }

        }

        return res;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }


    // 2,5,6,4,4,0
    // 7,3,8,0,6,5,7,6,2
    public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }


    public int[] maxNumber2(int[] nums, int k) {
        int n = nums.length;
        int top = n - k;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i ++) {
            while (!stack.isEmpty() && nums[i] > stack.peek() && top -- > 0) {
                stack.pop();
            }
            stack.push(nums[i]);
        }

        int[] res = new int[k];
        while (stack.size() > k) {
            stack.pop();
        }
        while (k > 0 && !stack.isEmpty()) {
            res[-- k] = stack.pop();
        }
        return res;
    }
}
