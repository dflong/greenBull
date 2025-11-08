package com.dflong.greenbull.leetcode;

import java.util.TreeSet;

public class _475 {

    public static void main(String[] args) {
        new _475().findRadius(new int[]{1,2,3,4}, new int[]{1,4});
    }

    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int heater : heaters) {
            set.add(heater);
        }

        int max = 0;
        for (int house : houses) {
            if (set.contains(house)) {
                continue;
            }

            int temp = 0;
            Integer ceiling = set.ceiling(house);
            Integer floor = set.floor(house);
            if (ceiling != null && floor != null) {
                temp = Math.min(Math.abs(ceiling - house), Math.abs(floor - house));
            }
            else if (ceiling != null) {
                temp = Math.abs(ceiling - house);
            }
            else if (floor != null) {
                temp = Math.abs(floor - house);
            }
            max = Math.max(max, temp);
        }

        return max;
    }
}
