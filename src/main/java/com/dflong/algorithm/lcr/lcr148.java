package com.dflong.algorithm.lcr;

import java.util.Stack;

public class lcr148 {

    public static void main(String[] args) {
        new lcr148().validateBookSequences(new int[] {6,7,8,9,10,11}, new int[] {9,11,10,8,7,6});
    }

    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        int m = putIn.length, n = takeOut.length;
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < m && j < n) {
            if (stack.isEmpty()) {
                stack.push(putIn[i]);
                i ++;
            } else {
                if (stack.peek() == takeOut[j]) {
                    j ++;
                    stack.pop();
                } else {
                  stack.push(putIn[i]);
                  i ++;
                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != takeOut[j]) {
                return false;
            }
            stack.pop();
            j ++;
        }

        return true;
    }
}
