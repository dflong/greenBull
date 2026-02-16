package com.dflong.algorithm.leetcode0;

public class _474 {

    public static void main(String[] args) {
        new _474().findMaxForm(new String[]{"10","0001","111001","1","0"}, 4, 3);
    }

    // 一维数组
    public int findMaxForm(String[] strs, int m, int n) {
       int[][] dp = new int[m + 1][n + 1];

       for (int i = 0; i < strs.length; i++) {
           String s = strs[i];
           int num0 = 0, num1 = 0;
           for (int j = 0; j < s.length(); j++) {
               if (s.charAt(j) == '0') {
                   num0 ++;
               } else {
                   num1 ++;
               }
           }

           for (int x = m; x >= num0; x --) {
               for (int y = n; y >= num1; y --) {
                   dp[x][y] = Math.max(dp[x][y], dp[x - num0][y - num1] + 1);
               }
           }
       }
       return dp[m][n];
    }
}
