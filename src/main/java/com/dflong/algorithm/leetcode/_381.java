package com.dflong.algorithm.leetcode;

import java.util.*;

public class _381 {

    class RandomizedCollection {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        public RandomizedCollection() {

        }

        public boolean insert(int val) {
            list.add(val);
            Set<Integer> orDefault = map.getOrDefault(val, new HashSet<>());
            orDefault.add(list.size() - 1);
            map.put(val, orDefault);

            return orDefault.size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            Set<Integer> indexSet = map.get(val);
            int valIndex = indexSet.iterator().next(); // 删除元素的idx
            int last = list.get(list.size() - 1); // 最后一个元素

            list.set(valIndex, last);
            indexSet.remove(valIndex);

            Set<Integer> lastSet = map.get(last);
            lastSet.remove(list.size() - 1); // 删除最后一个元素位置
            if (valIndex != list.size() - 1) {
                lastSet.add(valIndex); // 添加交换后的位置
            }
            list.remove(list.size() - 1); // 删除最后一个元素

            if(indexSet.isEmpty()) map.remove(val);

            return true;
        }

        public int getRandom() {
            return list.get((int) (Math.random() * list.size()));
        }
    }
}
