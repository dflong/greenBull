package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 1) {
            List<Integer> row = Arrays.asList(1);
            res.add(row);
        }
        else if (numRows == 2) {
            List<Integer> row = Arrays.asList(1);
            res.add(row);
            List<Integer> row1 = Arrays.asList(1, 1);
            res.add(row1);
        } else {
            List<Integer> row = Arrays.asList(1);
            res.add(row);
            List<Integer> row1 = Arrays.asList(1, 1);
            res.add(row1);

            for (int i = 3; i <= numRows; i++) {
                List<Integer> row2 = new ArrayList<>();
                row2.add(1);

                List<Integer> integers = res.get(i - 2);
                for (int j = 1; j < integers.size(); j++) {
                    row2.add(integers.get(j - 1) + integers.get(j));
                }

                row2.add(1);
                res.add(row2);
            }
        }
        return res;
    }
}
