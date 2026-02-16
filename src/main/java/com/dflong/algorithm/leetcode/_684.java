package com.dflong.algorithm.leetcode;

public class _684 {

    public int[] findRedundantConnection(int[][] edges) {
        init(edges.length);
        for (int[] edge : edges) {
            if (isSame(edge[0], edge[1])) {
                return edge;
            } else {
                join(edge[0], edge[1]);
            }
        }
        return new int[] {};
    }

    int[] father;

    public void init(int n) {
        father = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            father[i] = i;
        }
    }

    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }

    public int find(int u) {
        return u == father[u] ? u : (father[u] = find(father[u]));
    }
}
