package com.dflong.greenbull.leetcode;
import java.util.*;

public class _127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> haveSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);

        int len = 0;
        int size = queue.size();
        len ++;
        while (!queue.isEmpty()) {
            while (size -- > 0) {
                String word = queue.poll();
                char[] charArray = word.toCharArray();
                for (int i = 0; i < charArray.length; i ++) {
                    char old = charArray[i];
                    for (char c = 'a'; c <= 'z'; c ++) {
                        charArray[i] = c;
                        String newString = new String(charArray);
                        if (wordSet.contains(newString) && !haveSet.contains(newString)) {
                            haveSet.add(newString);
                            queue.add(newString);

                            if (newString.equals(endWord)) {
                                return len + 1;
                            }
                        }
                    }
                    charArray[i] = old;
                }
            }
        }

        return 0;
    }
}
