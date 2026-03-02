package com.dflong.algorithm.lcr;

public class lcr014 {

    public boolean checkInclusion(String s1, String s2) {
        int[] charNum = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charNum[s1.charAt(i) - 'a'] ++;
        }

        int l = 0, r = 0;
        while (r < s2.length()) {
            charNum[s2.charAt(r) - 'a'] --;
            if (r - l + 1 == s1.length()) {
                boolean check = true;
                for (int i = 0; i < 26; i++) {
                    if (charNum[i] != 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    return true;
                } else {
                    charNum[s2.charAt(l) - 'a']++;
                    l ++;
                }
            }
            r ++;
        }
        return false;
    }
}
