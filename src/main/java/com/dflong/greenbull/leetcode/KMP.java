package com.dflong.greenbull.leetcode;

public class KMP {

    /**
     * KMP算法
     * 用来解决字符串匹配问题
     */
    public int strStr(String haystack, String needle) {
        next = new int[needle.length()];
        getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(i) != haystack.charAt(i)) {
                j = next[j - 1]; // 不匹配时从next数组中获取匹配位置
            }
            if (needle.charAt(i) == haystack.charAt(i)) {
                j ++; // 匹配时，j自增
            }
            if (j == needle.length()) {
                return i - needle.length() + 1; // 匹配成功，返回匹配位置
            }
        }
        return - 1;
    }

    int[] next;

    public void getNext(String needle) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1]; // 不匹配时从next数组中获取匹配位
            }
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        new KMP().strStr("aabaabaafa","aabaaf");
    }

}
