package com.dflong.algorithm.leetcode;
import java.util.*;

public class _399 {

    public static void main(String[] args) {
        new _399().calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")), new double[]{2.0, 3.0},
                Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a")));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        DisJoint disJoint = new DisJoint(equations.size() * 2);

        // 生成并查集
        int id = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i ++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            if (!map.containsKey(a)) {
                map.put(a, id);
                id ++;
            }
            if (!map.containsKey(b)) {
                map.put(b, id);
                id ++;
            }

            disJoint.join(map.get(a), map.get(b), values[i]);
        }

        // 查询
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i ++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            Integer x = map.get(a);
            Integer y = map.get(b);
            if (x == null || y == null) {
                res[i] = - 1.0;
            } else {
                res[i] = disJoint.isSame(x, y);
            }
        }

        return res;
    }

    class DisJoint {
        int[] father;
        double[] weight;

        public DisJoint(int n) {
            father = new int[n];
            weight = new double[n];

            for (int i = 0; i < n; i ++) {
                father[i] = i;
                weight[i] = 1.0;
            }
        }

        public int find(int x) {
            if (x != father[x]) {
                int fa = father[x];
                father[x] = find(fa);
                weight[x] *= weight[fa];
            }
            return father[x];
        }

        public double isSame(int x, int y) {
            int x1 = find(x);
            int y1 = find(y);
            if (x1 == y1) return weight[x] / weight[y];
            return -1.0;
        }

        public void join(int x, int y, double val) {
            int x1 = find(x);
            int y1 = find(y);
            if (x1 == y1) return;
            father[x1] = y1;
            weight[x1] = weight[y] / weight[x] * val;
        }
    }
}
