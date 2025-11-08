package com.dflong.greenbull.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _205 {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (!sMap.containsKey(c1)) {
                sMap.put(c1, c2);
            }
            if (!tMap.containsKey(c2)) {
                tMap.put(c2, c1);
            }
            if (sMap.get(c1) != c2 || tMap.get(c2) != c1) {
                return false;
            }
        }

        return true;
    }
}
