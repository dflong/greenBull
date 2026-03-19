package com.dflong.algorithm.leetcode;

import java.util.HashMap;

public class _2007 {

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 统计每个数出现的次数
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }

        int[] res = new int[n / 2];
        int resIdx = 0;
        // 单独处理 0 的情况
        if (map.containsKey(0)) {
            int count = map.get(0);
            if (count % 2 != 0) {
                return new int[0]; // 0 的数量必须是偶数
            }
            resIdx = count / 2; // 前面都是0
        }

        for (Integer key : map.keySet()) {
            if (key % 2 == 0 && map.containsKey(key / 2)) {
                continue; // 说明有更小的
            }
            while (map.containsKey(key)) {
                int keyCnt = map.get(key);
                int doubleKeyCnt = map.getOrDefault(key * 2, 0);

                if (keyCnt > doubleKeyCnt) {
                    return new int[0]; // 如果当前数的数量大于它的两倍数的数量，说明无法配对
                }
                for (int i = 0; i < keyCnt; i ++) {
                    res[resIdx ++] = key; // 将当前数加入结果数组
                }
                if (doubleKeyCnt > keyCnt) {
                    map.put(key * 2, doubleKeyCnt - keyCnt); // 更新两倍数的数量
                    key *= 2; // 继续配对更大的数
                } else {
                    key *= 4; // 继续配对更大的数
                }

            }
        }

        return res;
    }
}
