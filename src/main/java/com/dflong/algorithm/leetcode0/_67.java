package com.dflong.algorithm.leetcode0;

public class _67 {

    public static void main(String[] args) {
        _67 v = new _67();
        String s = v.addBinary("1010", "1011");
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;

        int carry = 0;
        String res = "";
        while (aLen >= 0 && bLen >= 0) {
            int numa = a.charAt(aLen) - '0';
            int numb = b.charAt(bLen) - '0';
            int sum = numa + numb + carry;
            carry = sum / 2;
            res = sum % 2 + res;

            aLen --;
            bLen --;
        }

        while (aLen >= 0) {
            int numa = a.charAt(aLen) - '0';
            int sum = numa + carry;
            carry = sum / 2;
            res = sum % 2 + res;
            aLen --;
        }

        while (bLen >= 0) {
            int numb = b.charAt(bLen) - '0';
            int sum = numb + carry;
            carry = sum / 2;
            res = sum % 2 + res;
            bLen --;
        }
        if (carry > 0) {
            return carry + res;
        }
        return res;
    }
}
