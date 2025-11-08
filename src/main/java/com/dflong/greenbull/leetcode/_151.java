package com.dflong.greenbull.leetcode;

public class _151 {
    // edcbagf
    // fgabcde
    public static void main(String[] args) {
        new _151().reverseWords("  hello world  ");
    }

    public String reverseWords(String s) {
        // 去除两头多余空格，中间多余空格
        StringBuilder sb = removeSpace(s);
        // 整体翻转
        reverse(sb, 0, sb.length() - 1);
        // 单词翻转
        allReverse(sb);
        return sb.toString();
    }

    public StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int L = 0, R = s.length() - 1;
        while (s.charAt(L) == ' ') {L ++;}
        while (s.charAt(R) == ' ') {R --;}
        while (L <= R) {
            if (s.charAt(L) != ' ' || sb.charAt(sb.length() - 1) != ' ') { // sb.charAt(sb.length() - 1) != ' ' 单词之间增加一个空格
                sb.append(s.charAt(L));
            }
            L ++;
        }
        return sb;
    }

    public void reverse(StringBuilder s, int i, int j) {
        while (i < j) {
            char temp = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, temp);
            i ++;
            j --;
        }
    }

    public void allReverse(StringBuilder s) {
        int i = 0, j = 1, n = s.length();
        while (i < n) {
            while (j < n && s.charAt(j) != ' ') {
                j ++;
            }
            reverse(s, i, j - 1);
            i = j + 1;
            j = i + 1;
        }
    }

}
