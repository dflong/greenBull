package com.dflong.algorithm.lcr;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

public class lcr114 {

    // words = ["wrt","wrf","er","ett","rftt"] wertf。 ewrtf错误
    public String alienOrder(String[] words) {
        boolean[][] graph = new boolean[26][26]; // from -> to
        boolean[] visited = new boolean[26];
        int[] inDegree = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                visited[c - 'a'] = true;
            }
        }

        // 生成图、入度
        for (int i = 0; i < words.length - 1; i ++) {
            int j = i + 1;
            char[] pre = words[i].toCharArray(), cur = words[j].toCharArray();

            int idx = 0;
            while (idx < pre.length && idx < cur.length && pre[idx] == cur[idx]) {
                idx ++;
            }
            if (idx < pre.length && idx == cur.length) {
                return "";
            }
            if (idx < pre.length && idx < cur.length) {
                if (!graph[pre[idx] - 'a'][cur[idx] - 'a']) {
                    graph[pre[idx] - 'a'][cur[idx] - 'a'] = true;
                    inDegree[cur[idx] - 'a'] ++;
                    visited[cur[idx] - 'a'] = true;
                }
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (visited[i]) {
                cnt ++;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append((char) (cur + 'a'));
            for (int i = 0; i < 26; i ++) {
                if (graph[cur][i]) {
                    if (-- inDegree[i] == 0) {
                        queue.offer(i);
                    }
                    graph[cur][i] = false;
                }
            }
        }

        return sb.length() == cnt ? sb.toString() : "";
    }



    public static void main(String[] args) {
        new lcr114().alienOrder(new String[] {"wrt","wrf","er","ett","rftt"});
    }
}
