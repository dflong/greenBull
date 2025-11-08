package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _282 {

    public static void main(String[] args) {
        new _282().addOperators("105", 5);
    }

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        backTracking(0, 0, "", 0);
        return res;
    }

    List<String> res = new ArrayList<>();
    String num;
    int target;

    public void backTracking(int idx, long sum, String cur, long prev) {
        if (idx == num.length()) {
            if (target == sum) {
                res.add(cur);
            }
            return;
        }

        for (int i = idx; i < num.length(); i ++) {
            if (i != idx && num.charAt(idx) == '0') { // 多位数首位不为0
                break;
            }

            long next = Long.parseLong(num.substring(idx, i + 1));

            if (idx == 0) {
                backTracking(i + 1, sum + next, "" + next, next);
            } else {
                backTracking(i + 1, sum + next, cur + "+" + next, next);
                backTracking(i + 1, sum - next, cur + "-" + next, - next);
                backTracking(i + 1, sum - prev + next * prev, cur + "*" + next, next * prev);
            }
        }
    }
}
