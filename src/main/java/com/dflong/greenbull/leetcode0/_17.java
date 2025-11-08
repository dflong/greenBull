package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _17 {

    public static void main(String[] args) {
        _17 v = new _17();
        v.letterCombinations("23");
    }

    String digits;
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits == null || digits.isEmpty()) return result;
        dfs(0, new StringBuffer());
        return result;
    }

    public void dfs(int idx, StringBuffer sb) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int c = digits.charAt(idx) - '0';
        String letter = letters[c];
        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            dfs(idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
