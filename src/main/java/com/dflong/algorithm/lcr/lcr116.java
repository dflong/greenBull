package com.dflong.algorithm.lcr;

public class lcr116 {

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        UnionSet set = new UnionSet(m);

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    set.join(i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < isConnected.length; i ++) {
            if (set.find(i) == i) res ++; // 指向了自己没有相连, 相连时存在路径压缩
        }

        return res;
    }
}
