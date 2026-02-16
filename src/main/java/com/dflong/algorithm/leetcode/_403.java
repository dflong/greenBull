package com.dflong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class _403 {

    public static void main(String[] args) {
        new _403().canCross(new int[] {0,1,2,3,4,8,9,11});
    }

    public boolean canCross(int[] stones) {
        for (int i = 0; i < stones.length; i ++) {
            set.add(stones[i]);
        }
        max = stones[stones.length - 1];

        if (stones[0] + 1 != stones[1]) return false; // 第一步就跳不了
        boolean dfs = dfs(stones[1], 1);
        return dfs;
    }

    int max;
    Set<Integer> set = new TreeSet<>();
    Map<String, Boolean> cache = new HashMap<>(); // 记录搜索过的路径结果

    public boolean dfs(int stone, int k) {
        if (stone == max) return true;

        String key = stone + "_" + k;
        if (cache.containsKey(key)) return cache.get(key); // 里面记录的一定是false

        for (int i = - 1; i <= 1; i ++) {
            int next = stone + i + k;
            if (next == stone) continue; // 原地跳了
            if (set.contains(next)) {
                boolean dfs = dfs(next, k + i);
                cache.put(key, dfs);
                if(dfs) return true;
            }
        }

        cache.put(key, false);
        return false;
    }
}
