package com.dflong.greenbull.leetcode;


import java.util.*;

public class _126_1 {

    public static void main(String[] args) {
        new _126_1().findLadders("hit", "cog", Arrays.asList(
                "hot","dot","dog","lot","log","cog"
        ));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!wordSet.contains(endWord)) {
            return res;
        }

        Map<String, List<String>> prevWords = new HashMap<>();
        boolean found = bfs(beginWord, endWord, wordSet, prevWords);
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.addFirst(endWord);
            dfs(beginWord, endWord, prevWords, path, res);
        }
        return res;
    }

    private boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> prevWords) {
        boolean found = false;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Set<String> currentLevelVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            currentLevelVisited.clear();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                List<String> nextWords = getNextWords(currentWord, wordSet);
                for (String nextWord : nextWords) {
                    if (nextWord.equals(endWord)) {
                        // 只标记找到了，还需要完成这一层前驱关系的建立，才能退出循环
                        found = true;
                    }
                    if (!visited.contains(nextWord)) {
                        if (!currentLevelVisited.contains(nextWord)) {
                            queue.offer(nextWord);
                            currentLevelVisited.add(nextWord);
                        }
                        // 记录前驱
                        prevWords.computeIfAbsent(nextWord, a -> new ArrayList<>()).add(currentWord);
                    }
                }
            }
            visited.addAll(currentLevelVisited);
            if (found) {
                return true;
            }
        }
        return false;
    }

    private void dfs(String beginWord, String endWord, Map<String, List<String>> prevWords, Deque<String> path, List<List<String>> res) {
        if (endWord.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 不作此判断会报空指针异常
        if (!prevWords.containsKey(endWord)) {
            return;
        }
        for (String precursor : prevWords.get(endWord)) {
            path.addFirst(precursor);
            dfs(beginWord, precursor, prevWords, path, res);
            path.removeFirst();
        }
    }

    private List<String> getNextWords(String word, Set<String> wordSet) {
        List<String> nextWords = new ArrayList<>();
        char[] charArray = word.toCharArray();
        int wordLen = word.length();
        for (int i = 0; i < wordLen; i++) {
            char originChar = charArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == originChar) {
                    continue;
                }
                charArray[i] = j;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
            charArray[i] = originChar;
        }
        return nextWords;
    }

}
