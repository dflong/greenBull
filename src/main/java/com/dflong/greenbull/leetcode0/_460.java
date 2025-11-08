package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _460 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }

        return list.toArray(new int[people.length][]);
    }
}
