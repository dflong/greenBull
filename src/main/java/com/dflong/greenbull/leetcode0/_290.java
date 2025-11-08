package com.dflong.greenbull.leetcode0;

import java.util.HashMap;

public class _290 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");

        if (pattern.length() != s1.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, s1[i]);
            } else {
                String s2 = map.get(c);
                if (!s2.equals(s1[i])) {
                    return false;
                }
            }
        }

        HashMap<String, Character> map1 = new HashMap<String, Character>();
        for (int i = 0; i < s1.length; i++) {
            String c = s1[i];
            if (!map1.containsKey(c)) {
                map1.put(c, pattern.charAt(i));
            } else {
                Character s2 = map1.get(c);
                if (s2 != pattern.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
