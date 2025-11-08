package com.dflong.greenbull.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _1297 {

    public static void main(String[] args) {
        new _1297().maxFreq(
                "aababcaab",
                2, 3, 24);
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> strMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            sb.append(s.charAt(i));
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (sb.length() == minSize) {
                if (map.size() <= maxLetters) {
                    strMap.put(sb.toString(), strMap.getOrDefault(sb.toString(), 0) + 1);
                }
                map.put(sb.charAt(0), map.getOrDefault(sb.charAt(0), 0) - 1);
                if (map.get(sb.charAt(0)) <= 0) {
                    map.remove(sb.charAt(0));
                }
                sb.deleteCharAt(0);
            }
        }
        for (Map.Entry<String, Integer> entry : strMap.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}
