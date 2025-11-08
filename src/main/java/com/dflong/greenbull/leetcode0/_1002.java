package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1002 {

    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();

        List<Map<Character, Integer>> sets = new ArrayList<>();
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> characters = new HashMap<>();
            String word = words[i];
            for (char c : word.toCharArray()) {
                characters.put(c, characters.getOrDefault(c, 0) + 1);
            }
            sets.add(characters);
        }

        out: for (char c : words[0].toCharArray()) {
            for (Map<Character, Integer> characters : sets) {
                Integer b = characters.get(c);
                if (b != null && b > 0) {
                    characters.put(c, b - 1);
                } else {
                    continue out;
                }
            }
            res.add(c + "");
        }
        return res;
    }
}
