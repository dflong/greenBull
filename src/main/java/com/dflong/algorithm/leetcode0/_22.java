package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _22 {

    public static void main(String[] args) {
        _22 v = new _22();
        v.generateParenthesis(3);
    }

    List<String> res = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, new StringBuffer());
        return res;
    }

    public void dfs(int l, int r, StringBuffer sb) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
        }

        if (l < n) {
            sb.append('(');
            dfs(l + 1, r, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            sb.append(')');
            dfs(l, r + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
