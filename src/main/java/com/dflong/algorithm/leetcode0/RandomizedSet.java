package com.dflong.algorithm.leetcode0;

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

    HashMap<Integer, Integer> val2idx; // val - index
    HashMap<Integer, Integer> idx2val; // index - val
    int idx = 0;

    public RandomizedSet() {
        val2idx = new HashMap<>();
        idx2val = new HashMap<>();
    }

    public boolean insert(int val) {
        if (val2idx.containsKey(val)) {
            return false;
        }
        val2idx.put(val, idx);
        idx2val.put(idx, val);
        idx ++;
        return true;
    }

    public boolean remove(int val) {
        if (!val2idx.containsKey(val)) {
            return false;
        }
        Integer curIdx = val2idx.get(val);

        Integer val1 = idx2val.get(idx - 1);

        // 将最后位置的元素放在要删除的位置，最后位置移除
        val2idx.put(val1, curIdx);
        idx2val.put(curIdx, val1);

        val2idx.remove(val);
        idx2val.remove(idx - 1);
        idx --;
        return true;
    }

    public int getRandom() {
        int i = new Random().nextInt(idx);
        Integer integer = idx2val.get(i);
        return integer;
    }
}
