package com.dflong.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class _365 {

    public boolean canMeasureWater(int x, int y, int target) {
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{0, 0});

        Set<Long> set = new HashSet<>();
        while (!stack.isEmpty()) {
            if (set.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            int[] pop = stack.pop();
            set.add(hash(pop));

            int remainX = pop[0], remainY = pop[1];
            if (remainX == target || remainY == target || remainX + remainY == target) {
                return true;
            }

            // x水放空
            stack.push(new int[]{0, remainY});
            // y水放空
            stack.push(new int[]{remainX, 0});
            // x水加满
            stack.push(new int[]{x, remainY});
            // y水加满
            stack.push(new int[]{remainX, y});
            // x水倒入y
            stack.push(new int[]{remainX - Math.min(remainX, y - remainY), remainY + Math.min(remainX, y - remainY)});
            // y水倒入x
            stack.push(new int[]{remainX + Math.min(remainY, x - remainX), remainY - Math.min(remainY, x - remainX)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }


//    public boolean canMeasureWater(int x, int y, int target) {
//        if (x + y < target) return false;
//        if (x == 0 || y == 0) return target == 0 || x + y == target;
//        return target % gcd(x, y) == 0;
//    }
//
//    // 寻找最大公约数
//    public int gcd(int a, int b) {
//        int z = b;
//        while (a % b != 0) {
//            z = a % b;
//            a = b;
//            b = z;
//        }
//        return z;
//    }
}
