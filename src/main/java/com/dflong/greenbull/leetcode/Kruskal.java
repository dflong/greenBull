package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 最小生成树: 把所有点连起来的最小成本
 */
public class Kruskal {

    public int minDist(int[][] edges) {
        // 对边排序
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0 ; i < edges.length; i ++) {
            for (int j = 0; j < edges[i].length; j ++) {
                edgeList.add(new Edge(i, j, edges[i][j]));
            }
        }

        int res = 0;
        List<Edge> resEdge = new ArrayList<>(); // 生成树的边

        edgeList.sort(Comparator.comparingInt(o -> o.val));
        DisJoint disJoint = new DisJoint(edgeList.size() + 1);
        for (Edge edge : edgeList) {
            if (!disJoint.isSame(edge.l, edge.r)) {
                resEdge.add(edge); // 最小生成树的边
                disJoint.join(edge.l, edge.r);
                res += edge.val;
            }
        }
        return res;
    }
}

