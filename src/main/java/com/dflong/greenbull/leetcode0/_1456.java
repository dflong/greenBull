package com.dflong.greenbull.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _1456 {

    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int max = 0, num = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                num ++;
            }
        }
        max = Math.max(max, num);

        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                num ++;
            }
            if (set.contains(s.charAt(i - k))) {
                num --;
            }
            max = Math.max(max, num);
        }

        return max;
    }
}
