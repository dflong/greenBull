package com.dflong.algorithm.lcr;

import java.math.BigDecimal;
import java.util.Stack;

public class lcr147 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

    }

    static class MinStack {

        Stack<Long> stack = new Stack<>(); // 保存偏移值
        long min; // 永远是最小值

        /** initialize your data structure here. */
        public MinStack() {
//            BigDecimal bigDecimal = BigDecimal.valueOf("123456.78");
            BigDecimal bigDecimal1 = new BigDecimal("1234563434321.78");
        }

        public void push(long x) {
            if (stack.isEmpty()) {
                stack.push(0L); // 为了计算偏移值
                min = x;
            } else {
                long dif = x - min;
                stack.push(dif);
                if (dif < 0) {
                    min = x;
                }
            }
        }

        public void pop() {
            long dif = stack.pop();
            if (dif < 0) {
                min = min - dif; // 说明前一个值要大一点
            }
        }

        public long top() {
            long dif = stack.peek();
            if (dif < 0) {
                return min;
                // 说明就是最小值
            } else {
                return min + dif;
            }
        }

        public long getMin() {
            return min;
        }
    }
}
