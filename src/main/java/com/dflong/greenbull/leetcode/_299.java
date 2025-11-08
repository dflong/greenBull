package com.dflong.greenbull.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _299 {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int aCnt = 0, bCnt = 0;

        for (int i = 0; i < secret.length(); i ++) {
            char c = secret.charAt(i);
            char c1 = guess.charAt(i);
            if (c == c1) {
                aCnt ++;
                set.add(i);
            } else {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (int i = 0; i < guess.length(); i ++) {
            if (set.contains(i)) {
                continue;
            }
            char c = guess.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                bCnt ++;
                map.put(c, map.get(c) - 1);
            }
        }

        return aCnt + "A" + bCnt + "B";
    }
}
