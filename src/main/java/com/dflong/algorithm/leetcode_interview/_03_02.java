package com.dflong.algorithm.leetcode_interview;

import java.util.LinkedList;
import java.util.List;

public class _03_02 {

    class MinStack {

        long min = Integer.MAX_VALUE;
        List<Long> list = new LinkedList<>(); // 存放偏移量

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(long x) {
            if (list.isEmpty()) {
                min = x;
                list.add(0L); // 偏移量为0
            } else {
                long offset = x - min; // 计算偏移量
                list.add(offset);
                if (offset < 0) { // 更新最小值
                    min = x;
                }
            }
        }

        public void pop() {
            long offset = list.remove(list.size() - 1); // 获取偏移量
            if (offset < 0) { // 恢复最小值
                min = min - offset;
            }
        }

        public long top() {
            long offset = list.get(list.size() - 1); // 获取偏移量
            if (offset < 0) {
                return min; // 当前值就是最小值
            }
            return min + offset; // 计算当前值
        }

        public long getMin() {
            return min;
        }
    }
}
