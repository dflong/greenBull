package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _17 {

    public static void main(String[] args) {
        new _17().letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return res;
        this.digits = digits;
        backTracking(0, new StringBuilder());
        return res;
    }

    List<String> res = new ArrayList<>();
    String[] letters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    String digits;

    // digits = "23"
    public void backTracking(int idx, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letter = letters[digits.charAt(idx) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            backTracking(idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
