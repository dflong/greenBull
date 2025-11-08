package com.dflong.greenbull.leetcode0;

public class _2653 {

    public static void main(String[] args) {
        _2653 v = new _2653();
        v.getSubarrayBeauty(new int[]{1,-1,-3,-2,3}, 3, 2);
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        // 定长滑动窗口 窗口长度为 k

        int len = nums.length;
        int[] resArr = new int[len - k + 1];
        // 索引 - 50 就是nums的值 ，相应的值就是出现的次数
        int[] valCount = new int[101];

        for(int i = 0; i < k - 1; i++){
            // 存储计数
            valCount[nums[i] + 50]++;
        }
        // 从第一个窗口开始
        for(int i = k - 1; i < len; i++){
            // 滑入最右侧的数据
            valCount[nums[i] + 50]++;

            int val = x;
            for(int j = 0 ; j < 50; j++){
                // 找到第x小的数字
                val -= valCount[j];
                if(val <= 0){
                    // 记录值
                    resArr[i - k + 1] = j - 50;
                    break;
                }
            }
            // 删除最左侧的数据
            valCount[nums[i - k + 1] + 50]--;
        }

        return resArr;

    }

}

