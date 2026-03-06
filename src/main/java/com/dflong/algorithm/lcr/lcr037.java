package com.dflong.algorithm.lcr;

import java.util.LinkedList;

public class lcr037 {

    public static void main(String[] args) {
        new lcr037().asteroidCollision(new int[]{10,2,-5});
    }

    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.addLast(asteroid);
            } else if (stack.peekLast() > 0 && asteroid > 0) {
                stack.addLast(asteroid);
            } else if (stack.peekLast() < 0 && asteroid < 0) {
                stack.addLast(asteroid);
            } else {
                // 栈顶元素往右，当前元素往左
                boolean isAlive = true;
                while (!stack.isEmpty() && stack.peekLast() > 0 && asteroid < 0) {
                    if (stack.peekLast() == - asteroid) {
                        stack.pollLast();
                        isAlive = false;
                        break;
                    } else if (stack.peekLast() < - asteroid) {
                        stack.pollLast();
                        isAlive = true;
                    } else {
                        isAlive = false;
                        break;
                    }
                }
                if (isAlive)
                    stack.addLast(asteroid);
            }
        }

        int size = stack.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = stack.pollLast();
        }

        return result;
    }
}
