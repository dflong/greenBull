package com.dflong.greenbull.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _433 {

    public static void main(String[] args) {
        new _433().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"});
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(endGene)) return - 1;
        this.bank = bank;
        this.endGene = endGene;
        for (int i = 0; i < bank.length; i ++) {
            int check = check(startGene, bank[i]);
            if (check == 1) {
                int[] visited = new int[bank.length];
                visited[i] = 1;
                cnt = 1;
                dfs(bank[i], visited);
            }
        }

        return min == Integer.MAX_VALUE ? - 1 : min;
    }

    public int check(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i ++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt ++;
            }
        }
        return cnt;
    }

    int cnt = 0, min = Integer.MAX_VALUE;
    String endGene;
    String[] bank;

    public void dfs(String startGene, int[] visited) {
        if (startGene.equals(endGene)) {
            min = Math.min(min, cnt);
        }
        for (int i = 0; i < bank.length; i ++) {
            if (visited[i] == 1) {
                continue;
            }
            int check = check(startGene, bank[i]);
            if (check == 1) {
                cnt ++;
                visited[i] = 1;
                dfs(bank[i], visited);
                // 回溯
                cnt --;
                visited[i] = 0;
            }
        }
    }
}
