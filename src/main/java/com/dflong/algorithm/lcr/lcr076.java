package com.dflong.algorithm.lcr;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class lcr076 {

//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
//        for (int i = 0; i < nums.length; i ++) {
//            if (pq.size() < k) {
//                pq.add(nums[i]);
//            } else {
//                Integer peek = pq.peek();
//                if (peek < nums[i]) {
//                    pq.poll();
//                    pq.add(nums[i]);
//                }
//            }
//        }
//        return pq.peek();
//    }


    int[] nums;
    int k;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.k = nums.length - k;
        return quickSort(nums, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int l, int r) {
        int idx = partition(l, r);
        if (idx == k) return nums[idx];
        else if (idx < k) {
            return quickSort(nums, idx + 1, r);
        } else {
            return quickSort(nums, l, idx - 1);
        }
    }

    private int partition(int l, int r) {
        // 随机选择标点
        int randomIndex = new Random().nextInt(r - l + 1) + l;
        int temp = nums[randomIndex];
        nums[randomIndex] = nums[l];
        nums[l] = temp;
        int idx = l;
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[idx]) {
                j --;
            }
            while (i < j && nums[i] <= nums[idx]) {
                i ++;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
        return i;
    }
}
