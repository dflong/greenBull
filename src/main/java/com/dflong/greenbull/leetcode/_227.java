package com.dflong.greenbull.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _227 {

    public static void main(String[] args) {
        new _227().calculate("1*2-3/4+5*6-7*8+9/10");
    }

//    // 使用 map 维护一个运算符优先级
//    // 这里的优先级划分按照「数学」进行划分即可
//    Map<Character, Integer> map = new HashMap<>();
//
//    {
//        map.put('-', 1);
//        map.put('+', 1);
//        map.put('*', 2);
//        map.put('/', 2);
//        map.put('%', 2);
//        map.put('^', 3);
//    }
//    public int calculate(String s) {
//        // 将所有的空格去掉
//        s = s.replaceAll(" ", "");
//        char[] cs = s.toCharArray();
//        int n = s.length();
//        // 存放所有的数字
//        Deque<Integer> nums = new ArrayDeque<>();
//        // 为了防止第一个数为负数，先往 nums 加个 0
//        nums.addLast(0);
//        // 存放所有「非数字以外」的操作
//        Deque<Character> ops = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//            char c = cs[i];
//            if (c == '(') {
//                ops.addLast(c);
//            } else if (c == ')') {
//                // 计算到最近一个左括号为止
//                while (!ops.isEmpty()) {
//                    if (ops.peekLast() != '(') {
//                        calc(nums, ops);
//                    } else {
//                        ops.pollLast();
//                        break;
//                    }
//                }
//            } else {
//                if (isNumber(c)) {
//                    int u = 0;
//                    int j = i;
//                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
//                    while (j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] - '0');
//                    nums.addLast(u);
//                    i = j - 1;
//                } else {
//                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
//                        nums.addLast(0);
//                    }
//                    // 有一个新操作要入栈时，先把栈内可以算的都算了
//                    // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
//                    while (!ops.isEmpty() && ops.peekLast() != '(') {
//                        char prev = ops.peekLast();
//                        if (map.get(prev) >= map.get(c)) {
//                            calc(nums, ops);
//                        } else {
//                            break;
//                        }
//                    }
//                    ops.addLast(c);
//                }
//            }
//        }
//        // 将剩余的计算完
//        while (!ops.isEmpty()) calc(nums, ops);
//        return nums.peekLast();
//    }
//    void calc(Deque<Integer> nums, Deque<Character> ops) {
//        if (nums.isEmpty() || nums.size() < 2) return;
//        if (ops.isEmpty()) return;
//        int b = nums.pollLast(), a = nums.pollLast();
//        char op = ops.pollLast();
//        int ans = 0;
//        if (op == '+') ans = a + b;
//        else if (op == '-') ans = a - b;
//        else if (op == '*') ans = a * b;
//        else if (op == '/')  ans = a / b;
//        else if (op == '^') ans = (int)Math.pow(a, b);
//        else if (op == '%') ans = a % b;
//        nums.addLast(ans);
//    }
//    boolean isNumber(char c) {
//        return Character.isDigit(c);
//    }


    Stack<Integer> num = new Stack<>(); // 存放数字
    Stack<Character> ops = new Stack<>(); // 存在运算符

    // 定于运算符优先级
    Map<Character, Integer> map = new HashMap<>();
    {
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('%', 2);
        map.put('^', 3);
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        num.push(0);
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peek() == '(') {
                        ops.pop();
                        break;
                    }
                    cal();
                }
            } else if (Character.isDigit(c)) {
                int res = 0;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    res = res * 10 + s.charAt(j) - '0';
                    j ++;
                }
                num.push(res);
                i = j - 1;
            } else {

                // + +1 -> + 0+1
                if (i > 0 && (s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-' || s.charAt(i - 1) == '(')) {
                    num.push(0);
                }

                // 1 + 1 - 1
                while (!ops.isEmpty() && ops.peek() != '(') {
                    char pre = ops.peek();
                    if (map.get(pre) >= map.get(c)) {
                        cal();
                    } else {
                        break;
                    }
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            cal();
        }

        return num.peek();
    }

    public void cal() {
        if (num.isEmpty() || ops.isEmpty() || num.size() < 2) {
            return;
        }

        int b = num.pop(), a = num.pop();
        char op = ops.pop();

        int res = 0;
        if (op == '+') {
            res = a + b;
        } else if (op == '-') {
            res = a - b;
        } else if (op == '*') {
            res = a * b;
        } else if (op == '/') {
            res = a / b;
        } else if (op == '^') {
            res = (int)Math.pow(a, b);
        } else if (op == '%') {
            res = a % b;
        }

        num.push(res);
    }
}
