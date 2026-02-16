package com.dflong.algorithm.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _904 {

    public static void main(String[] args) {
        _904 v = new _904();
        v.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4});
    }

    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, n = fruits.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                max = Math.max(max, r - l);
                map.put(fruits[l], map.getOrDefault(fruits[l], 0) - 1);
                if (map.get(fruits[l]) <= 0) {
                    map.remove(fruits[l]);
                }
                l ++;
            }
            r ++;
        }
        return Math.max(max, r - l);
    }
}
