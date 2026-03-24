package com.dflong.algorithm.leetcode_interview;

public class _01_06 {

    public String compressString(String S) {
        if (S.length() == 0) return S;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < S.length(); i++) {
            if (i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1)) {
                cnt ++;
            } else {
                sb.append(S.charAt(i));
                sb.append(cnt);
                cnt = 1;
            }
        }
        return sb.length() < S.length() ? sb.toString() : S;
    }
}