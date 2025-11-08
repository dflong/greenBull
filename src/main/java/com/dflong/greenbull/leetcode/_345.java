package com.dflong.greenbull.leetcode;

import java.util.*;

public class _345 {

    public static void main(String[] args) {
        new _345().reverseVowels("leetcode");
    }

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('A');
        set.add('e'); set.add('E');
        set.add('i'); set.add('I');
        set.add('o'); set.add('O');
        set.add('u'); set.add('U');

        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;
        while (i < j) {
            while (i < s.length() && !set.contains(charArray[i])) {
                i ++;
            }
            while (j >= 0 && !set.contains(charArray[j])) {
                j --;
            }
            if (i >= j) break;
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i ++;
            j --;
        }
        return new String(charArray);
    }
}
