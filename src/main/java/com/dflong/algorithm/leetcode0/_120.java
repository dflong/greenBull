package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        _120 v = new _120();
        int i = v.minimumTotal(triangle);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(triangle.get(0).get(0)));
        res.add(Arrays.asList(triangle.get(1).get(0) + triangle.get(0).get(0), triangle.get(1).get(1) + triangle.get(0).get(0)));

        for (int i = 2; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> newRow = new ArrayList<>();
            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    newRow.add(res.get(i - 1).get(j) + row.get(j));
                } else if (j == row.size() - 1) {
                    newRow.add(res.get(i - 1).get(j - 1) + row.get(j));
                } else {
                    newRow.add(Math.min(res.get(i - 1).get(j) + row.get(j), res.get(i - 1).get(j - 1) + row.get(j)));
                }
            }
            res.add(newRow);
        }

        List<Integer> integers = res.get(res.size() - 1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < integers.size(); i++) {
            min = Math.min(min, integers.get(i));
        }
        return min;
    }
}
