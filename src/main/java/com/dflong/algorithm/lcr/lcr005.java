package com.dflong.algorithm.lcr;

import java.util.HashMap;
import java.util.Objects;

public class lcr005 {

    public int maxProduct(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (String word : words) {
            int wordLen = word.length();
            int mark = 0;
            for (int i = 0; i < wordLen; i ++) {
                mark |= 1 << (word.charAt(i) - 'a');
            }
            // 生成最大值
            if (wordLen > map.getOrDefault(mark, 0)) {
                map.put(mark, wordLen);
            }
        }

        int max = 0;
        for (Integer mark : map.keySet()) {
            Integer len1 = map.get(mark);

            for (Integer mark2 : map.keySet()) {
                Integer len2 = map.get(mark2);

                if ((mark & mark2) == 0) {
                    max = Math.max(max, len1 * len2);
                }
            }
        }
        return max;
    }
}
