package com.dflong.greenbull.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _239 {

    public static void main(String[] args) {
        new _239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        int index = 0;
        res[index ++] = queue.peek();
        for (int i = k; i < n; i++) {
            queue.pop(nums[i - k]); // 移除
            queue.push(nums[i]);
            res[index ++] = queue.peek();
        }
        return res;
    }

    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        void push(int x) {
            while (!deque.isEmpty() && deque.peekLast() < x) {
                deque.pollLast(); // 把比当前小的元素都移除
            }
            deque.addLast(x);
        }

        void pop(int val) {
            if (!deque.isEmpty() && deque.peek() == val) {
                deque.poll();
            }
        }

        int peek() {
            return deque.peek();
        }
    }
}
