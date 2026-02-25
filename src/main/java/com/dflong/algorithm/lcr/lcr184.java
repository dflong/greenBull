package com.dflong.algorithm.lcr;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class lcr184 {

    class Checkout {

        public Checkout() {

        }

        // 单调栈， 比栈顶小的不放入
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();

        public int get_max() {
            if (stack.isEmpty()) return - 1;
            return stack.peekFirst();
        }

        public void add(int value) {
            while (!stack.isEmpty() && stack.peekLast() < value) {
                stack.pollLast();
            }
            stack.addLast(value);

            list.add(value);
        }

        public int remove() {
            if (stack.isEmpty()) return - 1;
            Integer num = list.removeFirst();
            if (Objects.equals(stack.getFirst(), num)) {
                stack.pollFirst();
            }
            return num;
        }
    }
}
