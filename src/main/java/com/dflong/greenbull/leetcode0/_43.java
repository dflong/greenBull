package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _43 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dps(nums);
        return res;
    }

    public void dps(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permute(nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        new _43().multiply("140", "721");
    }

    public String multiply(String num1, String num2) {
        // 有一方是0
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }

        int len = num2.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num2.length(); i++) {
            list.add(muti(num1, num2.charAt(i), len - i - 1));
        }
        // 合并结果
        for (int i = 0; i < list.size() - 1; i ++) {
            String s1 = list.get(i);
            String s2 = list.get(i + 1);
            list.set(i + 1, add(s1, s2));
        }

        return list.get(list.size() - 1);
    }

    public String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int offSet = 0;
        int i = s1.length() - 1, j = s2.length() - 1;
        while (i >= 0 && j >= 0) {
            char c1 = s1.charAt(i), c2 = s2.charAt(j);
            int res = Character.getNumericValue(c1) + Character.getNumericValue(c2) + offSet;
            if (res >= 0) {
                offSet = res / 10;
                res = res % 10;
            } else {
                offSet = 0;
            }

            sb.insert(0, res);
            i --;
            j --;
        }

        while (i >= 0) {
            char c1 = s1.charAt(i);
            int res = Character.getNumericValue(c1) + offSet;
            if (res >= 0) {
                offSet = res / 10;
                res = res % 10;
            } else {
                offSet = 0;
            }
            sb.insert(0, res);
            i --;
        }

        while (j >= 0) {
            char c2 = s2.charAt(j);
            int res = Character.getNumericValue(c2) + offSet;
            if (res >= 0) {
                offSet = res / 10;
                res = res % 10;
            } else {
                offSet = 0;
            }
            sb.insert(0, res);
            j --;
        }

        if (offSet > 0) {
            sb.insert(0, offSet);
        }
        return sb.toString();
    }

    public String muti(String num, char c, int n) {
        StringBuilder sb = new StringBuilder();
        int offSet = 0;
        for (int i = num.length() - 1; i >= 0; i --) {
            char c1 = num.charAt(i);
            int res = Character.getNumericValue(c1) * Character.getNumericValue(c) + offSet;
            if (res >= 0) {
                offSet = res / 10;
                res = res % 10;
            } else {
                offSet = 0;
            }
            sb.insert(0, res);
        }
        if (offSet > 0) {
            sb.insert(0, offSet);
        }
        sb.append(build0(n));
        return sb.toString();
    }

    public String build0(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
