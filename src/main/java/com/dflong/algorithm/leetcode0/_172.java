package com.dflong.algorithm.leetcode0;

public class _172 {

    public static void main(String[] args) {
        _172 v = new _172();
        int i = v.trailingZeroes(30);
        System.out.println();
    }

    public int trailingZeroes(int n) {
       int res = 0;
       for (int i = 5; i <= n; i++) {
           for (int j = i; j % 5 == 0; j = j / 5) {
               res ++;
           }
       }
       return res;
    }
}
