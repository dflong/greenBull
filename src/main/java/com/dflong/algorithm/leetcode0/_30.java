package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30 {

    public static void main(String[] args) {
        List<Integer> substring = findSubstring(
                "barfoofoobarthefoobarman",
                new String[]{"foo","bar", "the"});
        for (Integer i : substring) {
            System.out.println(i);
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int m = words.length;
        int n = words[0].length();
        for (int i = 0; i < n; i++) {
            Map<String, Integer> allMap = getMap(words);
            int count = 0;
            for (int j = i; j < s.length() - n + 1; j += n) {
                String substring = s.substring(j, j + n);
                allMap.put(substring, allMap.getOrDefault(substring, 0) - 1);
                if (allMap.get(substring) == 0) {
                    allMap.remove(substring);
                }
                count ++;
                if (count == m) {
                    if (allMap.isEmpty()) {
                        res.add(j - (m - 1) * n);
                    }
                    String substring1 = s.substring(j - (m - 1) * n, j - (m - 1) * n + n);
                    allMap.put(substring1, allMap.getOrDefault(substring1, 0) + 1);
                    if (allMap.get(substring1) == 0) {
                        allMap.remove(substring1);
                    }
                    count --;
                }
            }
        }

        return res;
    }

    public static Map<String, Integer> getMap(String[] words) {
        Map<String, Integer> res = new HashMap<>();
        for (String word : words) {
            res.put(word, res.getOrDefault(word, 0) + 1);
        }
        return res;
    }
}
