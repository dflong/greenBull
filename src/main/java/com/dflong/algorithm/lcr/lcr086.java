package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

public class lcr086 {

    public String[][] partition(String s) {
        this.s = s;
        backTrack(0, new StringBuilder());

        int rows = res.size();
        String[][] ret = new String[rows][];
        for (int i = 0; i < rows; ++i) {
            int cols = res.get(i).size();
            ret[i] = new String[cols];
            for (int j = 0; j < cols; ++j) {
                ret[i][j] = res.get(i).get(j);
            }
        }
        return ret;

    }

    String s;
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public void backTrack(int idx, StringBuilder sb) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for (int i = idx; i < s.length(); i ++) {
            sb.append(s.charAt(i));
            if (isValid(sb)) {
                path.add(sb.toString());
                backTrack(i + 1, new StringBuilder());
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isValid(StringBuilder sb) {
        int L = 0, R = sb.length() - 1;
        while (L < R) {
            if (sb.charAt(L) != sb.charAt(R)) {
                return false;
            }
            L ++;
            R --;
        }
        return true;
    }
}
