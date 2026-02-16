package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _131 {

    public static void main(String[] args) {
        new _131().partition("aab");
    }

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0, new StringBuilder());
        return res;
    }
    String s;
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();
    public void dfs(int index, StringBuilder sb) {
        if (index == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isValid(sb)) {
                cur.add(sb.toString());
                dfs(i + 1, new StringBuilder());
                cur.remove(cur .size() - 1);
            }
        }
    }

    private boolean isValid(StringBuilder sb){
        for (int i = 0; i < sb.length()/ 2; i++){
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)){return false;}
        }
        return true;
    }


//    public List<List<String>> partition(String s) {
//        this.s = s;
//        this.n = s.length();
//        f = new boolean[n][n];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(f[i], true);
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i + 1; j < n; j++) {
//                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
//            }
//        }
//        dfs(0);
//        return res;
//    }
//
//    List<List<String>> res = new ArrayList<>();
//    List<String> list = new ArrayList<>();
//    String s; int n;
//    boolean[][] f;
//
//    public void dfs(int index) {
//        if (index == n) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//
//        for (int i = index; i < n; i++) {
//            if (f[index][i]) {
//                list.add(s.substring(index, i + 1));
//                dfs(i + 1);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
}
