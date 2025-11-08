package com.dflong.greenbull.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _409 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int res = 0;
        int max = 0;
        for (Character c : map.keySet()) {
            int count = map.get(c);
            int tem = count % 2;
            res += count - tem;
            if (tem == 1) max = 1;
        }

        return res + max;
    }
}
