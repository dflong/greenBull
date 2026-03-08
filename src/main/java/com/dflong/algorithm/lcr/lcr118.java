package com.dflong.algorithm.lcr;

public class lcr118 {

    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;

        UnionSet unionSet = new UnionSet(m);

        for (int[] edge : edges) {
            if (unionSet.isSame(edge[0], edge[1])) {
                return edge;
            }
            unionSet.join(edge[0], edge[1]);
        }

        return null;
    }
}

// 并查集
class UnionSet {

    private int[] parent;

    public UnionSet(int n) {
        parent = new int[n + 1];

        // 初始化
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public void join(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]); // 路径压缩
        return parent[a];
    }

    public boolean isSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }

}
