package com.dflong.algorithm.lcr;

public class lcr002 {

    public static void main(String[] args) {
        new lcr002().addBinary("1", "111");
    }

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }

        // a的长度大于b
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                if (carry == 0) {
                    sb.append('0');
                    carry = 1;
                } else {
                    sb.append('1');
                    carry = 1;
                }
            } else if (a.charAt(i) == '1' || b.charAt(j) == '1') {
                if (carry == 0) {
                    sb.append('1');
                    carry = 0;
                } else {
                    sb.append('0');
                    carry = 1;
                }
            } else {
                if (carry == 0) {
                    sb.append('0');
                } else {
                    sb.append('1');
                    carry = 0;
                }
            }
            i --;
            j --;
        }

        while (i >= 0) {
            if (carry == 1) {
                if (a.charAt(i) == '1') {
                    sb.append('0');
                    carry = 1;
                } else {
                    sb.append('1');
                    carry = 0;
                }
            } else {
                sb.append(a.charAt(i));
            }
            i --;
        }
        if (carry == 1) {
            sb.append('1');
        }
        //   111
        //     1
        //  1000
        return sb.reverse().toString();
    }
}
