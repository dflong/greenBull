package com.dflong.algorithm.lcr;

import java.util.LinkedList;

public class lcr038 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                Integer idx = stack.pollLast();
                res[idx] = i - idx;
            }
            stack.addLast(i);
        }

        return res;
    }
}
