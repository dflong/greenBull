package com.dflong.algorithm.leetcode0;

public class _58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        char[] charArray = s.toCharArray();
        int firstSpace = -1;
        int secondSpace = -1;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] != ' ') {
                if (firstSpace < 0) {
                    firstSpace = i;
                }
            }
            if (charArray[i] == ' ' && firstSpace > 0) {
                secondSpace = i;
                break;
            }
        }
        return firstSpace - secondSpace;
    }
}
