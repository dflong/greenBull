package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

public class lcr085 {

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backTrack(0, 0, new StringBuilder());
        return res;
    }

    int n;
    List<String> res = new ArrayList<>();

    public void backTrack(int l, int r, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append("(");
            backTrack(l + 1, r, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            sb.append(")");
            backTrack(l, r + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
