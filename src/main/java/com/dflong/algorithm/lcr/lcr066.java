package com.dflong.algorithm.lcr;


import java.util.HashMap;

public class lcr066 {

    class MapSum {

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> preMap = new HashMap<>();
        /** Initialize your data structure here. */
        public MapSum() {

        }

        public void insert(String key, int val) {
            int offset = val - map.getOrDefault(key, 0);
            map.put(key, val);

            for (int i = 0; i < key.length(); i ++) {
                String str = key.substring(0, i + 1);
                preMap.put(str, preMap.getOrDefault(str, 0) + offset);
            }
        }

        public int sum(String prefix) {
            return preMap.getOrDefault(prefix, 0);
        }
    }
}
