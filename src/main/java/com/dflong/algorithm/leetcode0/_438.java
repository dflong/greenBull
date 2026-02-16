package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _438 {

    public static void main(String[] args) {
        _438 v = new _438();
        List<Integer> anagrams = v.findAnagrams("cbaebabacd", "abc");
    }

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

    public boolean check(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
