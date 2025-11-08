package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _212 {

    int m, n;
    int[][] visited;
    char[][] board;
    Set<String> set = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        this.board = board;

        // 构建树
        Trie trie = new Trie();
        for (String str : words) {
            trie.add(str);
        }

        visited = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                dfs(i, j, new StringBuilder(), trie);
            }
        }

        return new ArrayList<>(set);
    }


    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void dfs(int i, int j, StringBuilder sb, Trie trie) {
        if (!isValid(i, j, trie)) {
            return;
        }

        sb.append(board[i][j]);
        visited[i][j] = 1;

        // 是否在结果集中
        if (trie.chars[board[i][j] - 'a'].isEnd) {
            set.add(sb.toString());
        }

        for (int[] dir : dirs) {
            dfs(i + dir[0], j + dir[1], sb, trie.chars[board[i][j] - 'a']);
        }

        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = 0;
     }

    public boolean isValid(int i, int j, Trie trie) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1 || trie.chars[board[i][j] - 'a'] == null) return false;
        return true;
    }
}
