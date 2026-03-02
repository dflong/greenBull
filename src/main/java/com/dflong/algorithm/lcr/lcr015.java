package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

public class lcr015 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = p.length();
        int[] nums = new int[26];
        for (char c : p.toCharArray()) {
            nums[c - 'a']++;
        }
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            nums[c - 'a']--;
            if (r - l + 1 == n) {
                boolean check = true;
                for (int i = 0; i < 26; i++) {
                    if (nums[i] > 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    res.add(l);
                }
                nums[s.charAt(l) - 'a']++;
                l ++;
            }
            r ++;
        }
        return res;
    }
}
