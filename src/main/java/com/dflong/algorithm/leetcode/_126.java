package com.dflong.algorithm.leetcode;
import java.util.*;

public class _126 {

    public static void main(String[] args) {
        new _126().findLadders("hit", "cog", Arrays.asList(
                "hot","dot","dog","lot","log","cog"
        ));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        this.endWord = endWord;
        wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;
        boolean find = bfs(); // 广度遍历生成前缀表
        if (find) {
            path.add(endWord);
            backTrack(endWord); // 从结束向开始深度回溯生成结果
        }
        return res;
    }

    private void backTrack(String endWord) {
        if (endWord.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (preMaps.get(endWord) == null) return;

        for (String pre : preMaps.get(endWord)) {
            path.add(0, pre);
            backTrack(pre);
            path.remove(0);
        }
    }

    private boolean bfs() {
        boolean find = false;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> subVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            subVisited.clear();
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                String curWord = queue.poll();
                Set<String> nextWords = getNextWords(curWord);
                for (String nextWord : nextWords) {
                    if (nextWord.equals(endWord)) {
                        find = true; // 广度遍历，首先找到的肯定最短
                    }

                    if (!visited.contains(nextWord)) {
                        if (!subVisited.contains(nextWord)) { // 子层去重是防止重复加入
                            queue.add(nextWord);
                            subVisited.add(nextWord);
                        }
                        List<String> orDefault = preMaps.getOrDefault(nextWord, new ArrayList<>());
                        orDefault.add(curWord);
                        preMaps.put(nextWord, orDefault);
                    }
                }
            }
            visited.addAll(subVisited);
            if (find) return find;
        }
        return find;
    }

    private Set<String> getNextWords(String word) {
        Set<String> nextWords = new HashSet<>();
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i ++) {
            char old = charArray[i];

            for (char c = 'a'; c <= 'z'; c ++) {
                if (c == old) continue;
                charArray[i] = c;
                if (wordSet.contains(new String(charArray))) {
                    nextWords.add(new String(charArray));
                }
            }
            charArray[i] = old;
        }
        return nextWords;
    }

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    Map<String, List<String>> preMaps = new HashMap<>(); // 前缀表
    Set<String> visited = new HashSet<>();
    Set<String> wordSet;
    String beginWord, endWord;

}

