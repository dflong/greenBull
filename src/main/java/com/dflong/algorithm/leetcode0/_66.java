package com.dflong.algorithm.leetcode0;

import java.util.LinkedList;
import java.util.List;

public class _66 {

    public static void main(String[] args) {
        _66 v = new _66();
        int[] ints = v.plusOne(new int[]{9});
        System.out.println();
    }

    public int[] plusOne(int[] digits) {
        List<Integer> list = new LinkedList<>();
        int carry = 0;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] > 9) {
                digits[i] = 0;
                list.add(0, digits[i]);
                carry = 1;
            } else {
                list.add(0, digits[i]);
                carry = 0;
            }
        }
        if (carry > 0) {
            list.add(0, carry);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
