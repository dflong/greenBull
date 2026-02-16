package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

public class lcr087 {

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        backTrack(0, new StringBuilder());
        return res;
    }

    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String s;

    public void backTrack(int idx, StringBuilder sb) {
        if (idx == s.length() && path.size() == 4) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                temp.append(path.get(i)).append(".");
            }
            temp.append(path.get(3));
            res.add(temp.toString());
            return;
        }
        if (idx < s.length() && path.size() == 4) {
            return;
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

    public boolean isValid(StringBuilder s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        if (s.length() > 3) {
            return false;
        }
        if (Integer.parseInt(s.toString()) > 255) {
            return false;
        }

        return true;
    }
}
