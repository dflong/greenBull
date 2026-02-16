package com.dflong.algorithm.leetcode;

public class _168 {

    public static void main(String[] args) {
        new _168().convertToTitle(701);
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int temp = (columnNumber - 1) % 26 + 1;
            sb.append((char) (temp - 1 + 'A'));
            columnNumber = (columnNumber - temp) / 26;
        }

        return sb.reverse().toString();
    }
}
