package com.dflong.greenbull.leetcode0;

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.search("aa"); // 返回 False
    }

    WordDictionary[] children;
    boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new WordDictionary();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, this, 0);
    }

    public boolean search(String word, WordDictionary root, int index1) {
        if (index1 == word.length()) {
            return root.isEnd;
        }
        WordDictionary cur = root;
        char c = word.charAt(index1);
        if (c == '.') {
            for (int j = 0; j < 26; j ++) {
                if (cur.children[j] != null && search(word, cur.children[j], index1 + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (cur.children[c - 'a'] != null && search(word, cur.children[c - 'a'], index1 + 1)) {
                return true;
            }
        }
        return false;
    }
}
