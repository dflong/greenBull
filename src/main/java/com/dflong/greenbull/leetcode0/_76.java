package com.dflong.greenbull.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _76 {

    public static void main(String[] args) {
        System.out.println(minWindow("a", "b"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        if (s.length() < t.length()) {
            return "";
        }

        String res = "";

        Map<Character, Integer> tMap = getMap(t);

        Map<Character, Integer> sMap = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            boolean check = check(tMap, sMap);
            while (check) {
                String sub = s.substring(l, r + 1);
                if (res == "" || sub.length() < res.length()) {
                    res = sub;
                }
                char c1 = s.charAt(l);
                sMap.put(c1, sMap.getOrDefault(c1, 0) - 1);
                l ++;
                check = check(tMap, sMap);
            }
            r ++;
        }

        return res;
    }

    public static boolean check(Map<Character, Integer> tMap,
                         Map<Character, Integer> sMap){
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            Integer integer = sMap.get(key);
            if (integer == null || value > integer) {
                return false;
            }
        }

        return true;
    }

    public static Map<Character, Integer> getMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        return map;
    }
}
