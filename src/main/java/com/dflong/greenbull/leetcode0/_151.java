package com.dflong.greenbull.leetcode0;

import java.util.Stack;

public class _151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    // the sky is blue
    // blue is sky the
    public static String reverseWords(String s) {
        Stack<String> res = new Stack<>();

        char[] charArray = s.toCharArray();
        String s1 = "";
        for (int i = 0; i < charArray.length; i++) {
            if ((charArray[i] >= 'a' && charArray[i] <= 'z')  ||
                    (charArray[i] >= 'A' && charArray[i] <= 'Z') ||
                    (charArray[i] >= '0' && charArray[i] <= '9')) {
                s1 += charArray[i];
            } else {
                if (!s1.equals("")) {
                    res.push(s1);
                }
                s1 = "";
            }
        }
        if (!s1.equals("")) {
            res.push(s1);
        }
        s1 = "";
        while (res.size() > 1) {
            s1 += res.pop() + " ";
        }
        s1 += res.pop();
        return s1;
    }
}
