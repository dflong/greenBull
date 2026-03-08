package com.dflong.algorithm.lcr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lcr111 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (List<String> equation : equations) {
            String x = equation.get(0);
            String y = equation.get(1);
            if (!map.containsKey(x)) {
                map.put(x, idx ++);
            }
            if (!map.containsKey(y)) {
                map.put(y, idx ++);
            }
        }

        UnionSetWithWeight set = new UnionSetWithWeight(idx);
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            int x = map.get(equation.get(0));
            int y = map.get(equation.get(1));

            set.join(x, y, values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Integer x = map.get(query.get(0));
            Integer y = map.get(query.get(1));
            if (x == null || y == null) {
                res[i] = - 1.d;
            } else {
                res[i] = set.query(x, y);
            }
        }

        return res;
    }
}

// 带权并查集
class UnionSetWithWeight {

    double[] w;
    int[] par;

    UnionSetWithWeight(int n) {
        w = new double[n];
        par = new int[n];

        Arrays.fill(w, 1.0d);
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    private int find(int x) {
        if (x == par[x]) return x;
        int pre = par[x];
        par[x] = find(par[x]);
        w[x] = w[x] * w[pre];
        return par[x];
    }

    public double query(int x, int y) {
        int x1 = find(x);
        int y1 = find(y);
        if (x1 == y1) {
            return w[x] / w[y];
        }

        return - 1.0d;
    }

    public void join(int x, int y, double val) {
        int x1 = find(x);
        int y1 = find(y);
        if (x1 != y1) {
            par[x1] = y1;
            w[x1] = w[y] / w[x] * val;
        }
    }
}
