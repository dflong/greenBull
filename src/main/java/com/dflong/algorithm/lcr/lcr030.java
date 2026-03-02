package com.dflong.algorithm.lcr;

import java.util.HashMap;
import java.util.Random;

public class lcr030 {

    class RandomizedSet {

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
}
