package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _306 {

    public static void main(String[] args) {
        new _306().isAdditiveNumber("0");
    }

    public boolean isAdditiveNumber(String num) {
        s = num;
        n = s.length();
        // 前两个数确定了整个字符串的位置199100199
        return backTrack(0);
    }

    String s;
    List<List<Integer>> res = new ArrayList<>();
    int n;

    public boolean backTrack(int idx) {
        int len = res.size();
        if (idx == n) {
            if (len >= 3) return true;
            return false;
        }

        int max = s.charAt(idx) == '0' ? idx + 1 : n;

        List<Integer> list = new ArrayList<>();
        for (int i = idx; i < max; i ++) {
            list.add(0, s.charAt(i) - '0');
            if (len < 2 || check(res.get(len - 2), res.get(len - 1), list)) {
                res.add(list);

                if (backTrack(i + 1)) return true;

                res.remove(res.size() - 1);
            }
        }

        return false;
    }

    public boolean check(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        List<Integer> adds = new ArrayList<>();

        int t = 0; // 保留进位
        for (int i = 0; i < list1.size() || i < list2.size(); i ++) {
            if (i < list1.size()) {
                t += list1.get(i);
            }
            if (i < list2.size()) {
                t += list2.get(i);
            }

            adds.add(t % 10);
            t /= 10;
        }

        if (t > 0) adds.add(t);

        if (adds.size() != list3.size()) return false;
        for (int i = 0; i < list3.size(); i ++) {
            if (list3.get(i) != adds.get(i)) return false;
        }

        return true;
    }
}
