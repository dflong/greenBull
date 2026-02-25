package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lcr157 {

    public String[] goodsOrder(String goods) {
        this.chars = goods.toCharArray();
        Arrays.sort(chars);
        this.n = goods.length();
        visited = new boolean[n];
        backTrack();

        return res.toArray(new String[res.size()]);
    }

    char[] chars;
    int n;
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] visited;
    void backTrack() {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            sb.append(chars[i]);
            backTrack();
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
