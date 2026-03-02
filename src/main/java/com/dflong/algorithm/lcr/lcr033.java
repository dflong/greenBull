package com.dflong.algorithm.lcr;

import java.util.*;

public class lcr033 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            if (!map.containsKey(String.valueOf(charArray))) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(String.valueOf(charArray), list);
            } else {
                map.get(String.valueOf(charArray)).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }
}
