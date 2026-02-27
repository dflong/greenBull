package com.dflong.algorithm.lcr;

import java.util.HashMap;

public class lcr169 {

    public char dismantlingAction(String arr) {
        HashMap<Character, Boolean> map = new HashMap<>();

        for (char c : arr.toCharArray()) {
            map.put(c, !map.containsKey(c)); // 仅一次才会是true
        }

        for (char c : arr.toCharArray()) {
            if (map.get(c)) {
                return c;
            }
        }

        return ' ';
    }
}
