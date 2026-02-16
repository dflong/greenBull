package com.dflong.algorithm.leetcode0;

public class _567 {

    public static void main(String[] args) {
        new _567().checkInclusion("ab", "eidbaooo");
    }

    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] nums = new int[26];
        for (int i = 0; i < m; i++) {
            nums[s1.charAt(i) - 'a']++;
        }

        int l = 0, r= 0;
        while (r < n) {
            nums[s2.charAt(r) - 'a']--;
            if (r - l + 1 == m) {
                boolean check = true;
                for (int i = 0; i < 26; i++) {
                    if (nums[i] != 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    return true;
                } else {
                    nums[s2.charAt(l) - 'a']++;
                    l ++;
                }
            }
            r ++;
        }
        return false;
    }

}
