package com.dflong.algorithm.lcr;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class lcr058 {

    class MyCalendar {

        TreeSet<int[]> set = new TreeSet<>((o1, o2) -> o1[0] - o2[0]);
        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            if (set.isEmpty()) {
                set.add(new int[] { start, end });
                return true;
            }

            int[] temp = {end, 0};
            int[] ceiling = set.ceiling(temp); // 大的最近位置
            if (ceiling == set.first() || set.floor(temp)[1] <= start) { // 小的最近位置
                set.add(new int[] { start, end });
                return true;
            }
            return false;
        }
    }
}
