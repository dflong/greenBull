package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _119 {

    public static void main(String[] args) {
        new _119().getRow(5);
    }

    public List<Integer> getRow(int rowIndex) {
        return row.get(rowIndex);
    }

    static List<List<Integer>> row = new ArrayList<>();

    static {
        row.add(Arrays.asList(1));
        row.add(Arrays.asList(1, 1));

        for (int i = 2; i < 33; i ++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            List<Integer> preRow = row.get(i - 1);
            for (int j = 1; j <= preRow.size() - 1; j ++) {
                list.add(preRow.get(j - 1) + preRow.get(j));
            }

            list.add(1);
            row.add(list);
        }
    }
}
