package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _68 {

    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        List<String> strings = fullJustify(words, 16);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int sumLen = 0;
        int begin = 0, end = 0;
        for (int i = 0; i < words.length; i++) {

            //
            if (sumLen + end - begin + words[i].length()> maxWidth) {

                int aveSpace = (maxWidth - sumLen) / Math.max((end - begin - 1), 1);
                int remainSpace = (maxWidth -sumLen) %  Math.max((end - begin - 1), 1);
                String join = join(words, begin, end, aveSpace, remainSpace);
                res.add(join);
                begin = i;
                end = i + 1;
                sumLen = words[begin].length();

                // 最左
                if (i == words.length - 1) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = begin; j <= words.length - 2; j++) {
                        sb.append(words[j]).append(" ");
                    }
                    sb.append(words[words.length - 1]);
                    sb.append(blank(maxWidth - sb.length()));
                    res.add(sb.toString());
                }


            } else {
                sumLen += words[i].length();
                end ++;

                // 最左
                if (i == words.length - 1) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = begin; j <= words.length - 2; j++) {
                        sb.append(words[j]).append(" ");
                    }
                    sb.append(words[words.length - 1]);
                    sb.append(blank(maxWidth - sb.length()));
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }

    public static String join (String[] words, int begin, int end, int aveSpace, int remainSpace) {
        StringBuilder sb = new StringBuilder();
        if (begin == end - 1) {
            sb.append(words[begin]);
            while (remainSpace > 0) {
                sb.append(' ');
                remainSpace --;
            }
            while (aveSpace > 0) {
                sb.append(' ');
                aveSpace --;
            }
            return sb.toString();
        }

        for (int i = begin; i < end - 1; i++) {
            sb.append(words[i]).append(blank(aveSpace));
            if (remainSpace > 0) {
                sb.append(' ');
                remainSpace --;
            }
        }
        sb.append(words[end - 1]);
        return sb.toString();
    }

    public static String blank(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
