package com.dflong.algorithm.lcr;

import java.util.HashSet;
import java.util.Set;

public class lcr179 {

    public int[] twoSum(int[] price, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < price.length; i++) {
            if (set.contains(target - price[i])) {
                return new int[]{price[i], target - price[i]};
            }
            set.add(price[i]);
        }

        return null;
    }
}
