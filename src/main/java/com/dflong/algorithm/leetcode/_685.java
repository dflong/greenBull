package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _685 {

    public static void main(String[] args) {
        new _685().findRedundantDirectedConnection(new int[][] {
                {1,2}, {1, 3}, {2,3}
        });
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        // 存在入度为2的点
        int[] degrees = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
           degrees[edges[i][1]] ++;
        }

        List<Integer> list = new ArrayList<>(); // 度为2的边
        for (int i = edges.length - 1; i >= 0; i --) {
            if (degrees[edges[i][1]] == 2) {
                list.add(i);
            }
        }

        if (!list.isEmpty()) {
            init(edges.length + 1);
            for (int i = 0; i < edges.length; i ++) {
                if (list.get(0) == i) continue;// 不使用这条边构图
                if (isSame(edges[i][0], edges[i][1])) { // 还存在环，说明是另外一条边有问题
                    return new int[] {edges[list.get(1)][0], edges[list.get(1)][1]};
                }
                join(edges[i][0], edges[i][1]);
            }
            return new int[] {edges[list.get(0)][0], edges[list.get(0)][1]};
        } else {
            // 没有度为2的，构成了有向环
            init(edges.length + 1);
            for (int i = 0; i < degrees.length; i++) {
                if (isSame(edges[i][0], edges[i][1])) {
                    return new int[] {edges[i][0], edges[i][1]};
                } else {
                    join(edges[i][0], edges[i][1]);
                }
            }
        }

        return new int[] {};
    }

    int[] father;

    public void init(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public boolean isSame(int k, int v) {
        k = find(k);
        v = find(v);
        return k == v;
    }

    public void join(int k, int v) {
        k = find(k);
        v = find(v);
        if (k == v) return;
        father[v] = k;
    }

    public int find(int x) {
        return x == father[x] ? x : (father[x] = find(father[x]));
    }
}
