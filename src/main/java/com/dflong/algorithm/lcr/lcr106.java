package com.dflong.algorithm.lcr;

public class lcr106 {

    public boolean isBipartite(int[][] graph) {
        // 一条边的俩个结点来自不同集合，使用并查集
        // 图中每个顶点的所有邻接点都应该属于同一集合，且不与顶点处于同一集合
        UnionSet set = new UnionSet(graph.length);

        for (int i = 0; i < graph.length; i++) {
            int[] ints = graph[i];
            for (int j : ints) {
                if (set.isSame(i, j)) return false;
                set.join(ints[0], j);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new lcr106().isBipartite(new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}});
    }
}


