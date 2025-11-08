package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _93 {

    public static void main(String[] args) {
        List<String> strings = new _93().restoreIpAddresses("101023");
        System.out.println();
    }

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        backTracking(0, new StringBuilder());
        return res;
    }

    List<String> res =  new ArrayList<>();
    List<String> list = new ArrayList<>();
    String s;

    public void backTracking(int idx, StringBuilder sb) {
        if (list.size() == 4 && idx == s.length()) {
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb1.append(list.get(i)).append(".");
            }
            sb1.append(list.get(3));
            res.add(sb1.toString());
            return;
        }

        if (list.size() == 4 && idx < s.length()) {
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isValid(sb)) {
                list.add(sb.toString());
                backTracking(i + 1, new StringBuilder());
                list.remove(list.size() - 1);
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
