package com.dflong.algorithm.lcr;
import java.util.*;

public class lcr108 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        wordSet.add(endWord);

        // 双端bfs 每次只遍历size小的一端
        Queue<String> firQueue = new LinkedList<>();
        firQueue.add(beginWord);

        Queue<String> lastQueue = new LinkedList<>();
        lastQueue.add(endWord);

        Set<String> firVisited = new HashSet<>();
        firVisited.add(beginWord);

        Set<String> lastVisited = new HashSet<>();
        lastVisited.add(endWord);

        int cnt = 0;
        while (!firQueue.isEmpty() && !lastQueue.isEmpty()) {
            cnt ++;
            // 每次只遍历数量小的
            if (firQueue.size() > lastQueue.size()) {
                Queue<String> tq = firQueue;
                firQueue = lastQueue;
                lastQueue = tq;

                Set<String> tV = firVisited;
                firVisited = lastVisited;
                lastVisited = tV;
            }

            int size = firQueue.size();
            while (size-- > 0) {
                String cur = firQueue.poll();
                char[] charArray = cur.toCharArray();

                for (int i = 0; i < charArray.length; i++) {
                    char old = charArray[i];
                    for (char c = 'a'; c <= 'z'; c ++) {
                        charArray[i] = c;
                        String convertStr = String.valueOf(charArray);
                        if (firVisited.contains(convertStr)) {
                            continue;
                        }

                        if (lastVisited.contains(convertStr)) {
                            return cnt + 1;
                        }

                        if (wordSet.contains(convertStr)) {
                            firVisited.add(convertStr);
                            firQueue.add(convertStr);
                        }
                    }
                    charArray[i] = old;
                }
            }
        }
        return 0;
    }
}
