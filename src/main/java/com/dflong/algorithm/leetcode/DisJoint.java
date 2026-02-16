package com.dflong.algorithm.leetcode;

public class DisJoint {

    public static void main(String[] args) {
        DisJoint disJoint = new DisJoint(5);
        disJoint.join(1, 2);
        disJoint.join(1, 3);
        disJoint.join(2, 4);
        disJoint.join(3, 4);
        System.out.println(disJoint.isSame(1, 4));
    }

    /**
     * 并查集主要功能
     * 将两个元素加入集合中
     * 判断两个元素是否在一个集合中
     */
    int[] father;

    public DisJoint(int n) {
        father = new int[n];
        for (int i = 0; i < n; i ++) {
            father[i] = i;
        }
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

    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }
}
