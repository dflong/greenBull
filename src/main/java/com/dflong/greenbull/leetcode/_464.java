package com.dflong.greenbull.leetcode;

public class _464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) // 一把就赢
            return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) // 一定赢不了
            return false;
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        return dfs(0, 0);
    }

    int maxChoosableInteger, desiredTotal;
    int[] visited = new int[1 << 21]; // 数字是否使用过

    public boolean dfs(int state, int sum) {
        for (int x = 1; x <= maxChoosableInteger; x ++) {
            if (visited[state] == 1) return true;
            if (visited[state] == 2) return false;

            if (((1 << x) & state) > 0) continue; // 已经使用过
            if (x + sum >= desiredTotal) {
                visited[state] = 1;
                return true;
            }

            // 后手false才能赢
            if (!dfs((1 << x) | state, x + sum)) {
                visited[state] = 1;
                return true;
            }
        }
        visited[state] = 2;
        return false;
    }
}
