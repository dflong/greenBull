package com.dflong.algorithm.leetcode;

public class _1662 {

    public static void main(String[] args) {
        new _1662().arrayStringsAreEqual(new String[] { "ab", "c" }, new String[] { "a", "bc" });
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int idx = 0, idj = 0;
        while (i < word1.length && j < word2.length) {
           if (word1[i].charAt(idx) != word2[j].charAt(idj)) {
                return false;
           }
           idx ++;
           idj ++;

            if (idx == word1[i].length()) {
                idx = 0;
                i ++;
            }
            if (idj == word2[j].length()) {
                idj = 0;
                j ++;
            }
        }
        return i == word1.length && j == word2.length;
    }
}
