package com.dflong.greenbull.leetcode;

import java.util.Stack;

public class _739 {

    public static void main(String[] args) {
        new _739().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] res = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i ++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}
