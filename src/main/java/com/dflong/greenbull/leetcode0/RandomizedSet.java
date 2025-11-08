package com.dflong.greenbull.leetcode0;

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {


    // ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
    //  [[],              [1],     [2],     [2],       [],       [1],     [2],      []]
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean insert = randomizedSet.insert(1);
        boolean remove = randomizedSet.remove(2);
        boolean insert1 = randomizedSet.insert(2);
        int random = randomizedSet.getRandom();
        boolean remove1 = randomizedSet.remove(1);
        boolean insert2 = randomizedSet.insert(2);
        int random2 = randomizedSet.getRandom();
    }

    HashMap<Integer, Integer> map; // val - index
    HashMap<Integer, Integer> map2; // index - val
    int size = 0;

    public RandomizedSet() {
        map = new HashMap<>();
        map2 = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, size);
        map2.put(size, val);
        size ++;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer size1 = map.get(val);

        Integer val1 = map2.get(size - 1);

        map.put(val1, size1);
        map2.put(size1, val1);

        map.remove(val);
        map2.remove(size - 1);
        size --;
        return true;
    }

    public int getRandom() {
        int i = new Random().nextInt(size);
        Integer integer = map2.get(i);
        return integer;
    }
}
