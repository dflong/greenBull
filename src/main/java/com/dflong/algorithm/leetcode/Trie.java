package com.dflong.algorithm.leetcode;

public class Trie {

    Trie[] chars = new Trie[26];
    boolean isEnd = false;

    public void add(String s) {
        Trie addTrie = this;
        for (int i = 0; i < s.length(); i ++) {
            int idx = s.charAt(i) - 'a';
            if (addTrie.chars[idx] == null) {
                addTrie.chars[idx] = new Trie();
            }
            addTrie = addTrie.chars[idx];
        }
        addTrie.isEnd = true;
    }

    public boolean search(String s) {
        Trie searchTrie = this;
        for (int i = 0; i < s.length(); i ++) {
            int idx = s.charAt(i) - 'a';
            if (searchTrie.chars[idx] != null) {
                searchTrie = searchTrie.chars[idx];
            } else {
                return false;
            }
        }

        return searchTrie != null && searchTrie.isEnd;
    }
}
