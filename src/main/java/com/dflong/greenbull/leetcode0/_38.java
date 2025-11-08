package com.dflong.greenbull.leetcode0;

public class _38 {

    public String countAndSay(int n) {
        String temp = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int begin = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) != temp.charAt(begin)) {
                    sb.append((j - begin)).append(temp.charAt(begin));
                    begin = j;
                }
            }
            sb.append((temp.length() - begin)).append(temp.charAt(begin));
            temp = sb.toString();
        }

        return temp;
    }

}
