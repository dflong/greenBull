package com.dflong.greenbull.leetcode;

import java.util.*;

public class _500 {

    public static void main(String[] args) {
        System.out.println(99 *99);
    }

   static Map<Character, Integer> map = new HashMap<>();

   static {
       for (char c : "qwertyuiop".toCharArray()) {
           map.put(c, 1);
       }

       for (char c : "asdfghjkl".toCharArray()) {
           map.put(c, 2);
       }

       for (char c : "zxcvbnm".toCharArray()) {
           map.put(c, 3);
       }
   }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        out: for (String word : words) {
            int idx  = - 1;
            for (char c : word.toLowerCase().toCharArray()) {
                if (idx == - 1) {
                    idx  = map.get(c);
                } else {
                    if (map.get(c) != idx) {
                        continue out;
                    }
                }
            }
            list.add(word);
        }

        return list.toArray(new String[list.size()]);
    }
}
