package com.dflong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20 {

    Stack<Character> stack = new Stack<>();
    Map<Character, Character> map = new HashMap<>();
    {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i]))
                stack.push(map.get(charArray[i]));
            else {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != charArray[i])
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
