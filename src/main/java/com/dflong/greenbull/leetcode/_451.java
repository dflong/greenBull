package com.dflong.greenbull.leetcode;

import java.util.*;

public class _451 {

    public static void main(String[] args) {
        new _451().frequencySort("tree");
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<SortPair> pq = new PriorityQueue<>(new Comparator<SortPair>() {
            @Override
            public int compare(SortPair o1, SortPair o2) {
                return o2.count - o1.count;
            }
        });
        for (Character c : map.keySet()) {
            SortPair sortPair = new SortPair();
            sortPair.c = c;
            sortPair.count = map.get(c);
            pq.add(sortPair);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            SortPair sortPair = pq.poll();
            int count = sortPair.count;
            char c = sortPair.c;
            while (count > 0) {
                sb.append(c);
                count --;
            }
        }
        return sb.toString();
    }

    class SortPair {
        char c;
        int count;
    }
}
