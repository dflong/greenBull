package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lcr100 {

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
                if (j == 0) { // 首列
                    newRow.add(res.get(i - 1).get(j) + row.get(j));
                } else if (j == row.size() - 1) { // 尾列
                    newRow.add(res.get(i - 1).get(j - 1) + row.get(j));
                } else { // 左上、右上最小值
                    newRow.add(Math.min(res.get(i - 1).get(j), res.get(i - 1).get(j - 1)) + row.get(j));
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
