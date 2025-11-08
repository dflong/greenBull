package com.dflong.greenbull.leetcode;

public class _307 {

    public static void main(String[] args) {
        NumArray numArray = new _307().new NumArray(new int[]{1, 3, 5});
        int i = numArray.sumRange(0, 2);
        numArray.update(1, 2);
        i = numArray.sumRange(0, 2);
    }
    class NumArray {

        public NumArray(int[] nums) {
            this.nums = nums;
            n = nums.length;
            trees = new int[n + 1];
            for (int i = 0; i < n; i++) {
                add(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return query(right + 1) - query(left);
        }

        int[] nums;
        int[] trees;
        int n;

        private int lowBit(int x) {
            return x & (- x);
        }

        private void add(int idx, int x) {
            for (int i = idx; i <= n; i += lowBit(i)) {
                trees[i] += x;
            }
        }

        private int query(int idx) {
            int res = 0;
            for (int i = idx; i > 0; i -= lowBit(i)) {
                res += trees[i];
            }
            return res;
        }
    }

}

