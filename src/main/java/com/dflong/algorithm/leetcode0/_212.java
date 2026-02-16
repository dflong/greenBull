package com.dflong.algorithm.leetcode0;

public class _212 {

}

class Trie1 {

    Trie1[] children = new Trie1[26];
    boolean isEnd;

    public void addWord(String word) {
        Trie1 trie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (trie.children[c - 'a'] == null) {
                trie.children[c - 'a'] = new Trie1();
            }
            trie = trie.children[c - 'a'];
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {
        Trie1 trie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (trie.children[c - 'a'] == null) {
                return false;
            }
            trie = trie.children[c - 'a'];
        }
        return trie != null && trie.isEnd;
    }
}
