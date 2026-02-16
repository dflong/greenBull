package com.dflong.algorithm.leetcode;

public class _415 {

    public static void main(String[] args) {

    }

    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (m > 0 || n > 0) {
            int x = 0;
            if (m > 0) {
                x = Integer.parseInt("" + num1.charAt(m - 1));
            }
            int y = 0;
            if (n > 0) {
                y = Integer.parseInt("" + num2.charAt(n - 1));
            }
            int sum = x + y + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            sb.insert(0, sum);
            m --; n --;
        }

        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
