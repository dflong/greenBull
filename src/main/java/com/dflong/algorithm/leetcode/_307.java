package com.dflong.algorithm.leetcode;

public class _307 {

    public static void main(String[] args) {
        NumArray numArray = new _307().new NumArray(new int[]{1, 3, 5, 6, 7, 8, 10});
        int i = numArray.sumRange(0, 2);
        numArray.update(1, 2);
        i = numArray.sumRange(0, 2);
    }
    class NumArray {

        public NumArray(int[] nums) {
            this.nums = nums;
            n = nums.length;
            trees = new int[n + 1]; // 左开右闭
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
        // 树状数组 https://zhuanlan.zhihu.com/p/574739597
        // 单点修改，求区间和; trees存放前缀和
        // 区间修改，单点查询，trees存放差值nums[i] - nums[i - 1]、单点查询就是trees的0-i位置前缀和

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

