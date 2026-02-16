package com.dflong.algorithm.leetcode;

public class _273 {

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        for (int i = (int) 1e9, j = 0; i >= 1; i /= 1000, j ++) {
            if (num < i) continue;
            sb.append(num2Str(num / i)).append(num2str_large[j]).append(" ");
            num %= i;
        }

        return sb.toString().trim();
    }

    public String num2Str(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(num2str_small[num / 100]).append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            sb.append(num2str_medium[num / 10]).append(" ");
            num %= 10;
        }

        if (num != 0) {
            sb.append(num2str_small[num]).append(" ");
        }

        return sb.toString();
    }

    static String[] num2str_small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    static String[] num2str_medium = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    static String[] num2str_large = {
            "Billion", "Million", "Thousand", "",
    };

}
