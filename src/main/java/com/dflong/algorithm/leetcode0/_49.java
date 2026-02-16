package com.dflong.algorithm.leetcode0;

import java.util.*;

public class _49 {

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(str);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            if (!map.containsKey(String.valueOf(charArray))) {
                ArrayList<String> objects = new ArrayList<>();
                objects.add(str);
                map.put(String.valueOf(charArray), objects);
            } else {
                map.get(String.valueOf(charArray)).add(str);
            }
        }

        Collection<List<String>> values = map.values();

        return new ArrayList<>(values);
    }

    public static boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> maps = new HashMap<>();
        for (char c : s.toCharArray()) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> mapt = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }

        for (char c : maps.keySet()) {
            if (!Objects.equals(maps.get(c), mapt.get(c))) {
                return false;
            }
        }

        return maps.size() == mapt.size();
    }
}
