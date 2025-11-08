package com.dflong.greenbull.leetcode;

public class _242 {

    public boolean isAnagram(String s, String t) {
         int[] nums = new int[26];
         for (int i = 0; i < s.length(); i++) {
             nums[s.charAt(i) - 'a'] ++;
         }

         for (int i = 0; i < t.length(); i++) {
             nums[t.charAt(i) - 'a'] --;
         }

         for (int i = 0; i < 26; i++) {
             if (nums[i] != 0) {
                 return false;
             }
         }
         return true;
    }
}
