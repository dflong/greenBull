package com.dflong.algorithm.leetcode;

import java.util.*;
import java.util.List;

public class _692 {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (Objects.equals(o1.getValue(), o2.getValue())) return - o1.getKey().compareTo(o2.getKey());
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);

            if (pq.size() > k) pq.poll();
        }

        List<String> ans = new ArrayList<>(k);
        while (!pq.isEmpty()) {
            ans.add(pq.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        new _692().topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }
}
