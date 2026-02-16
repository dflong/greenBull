package com.dflong.algorithm.leetcode0;

public class Trie_1 {

    Trie_1[] arrays;
    boolean isEnd;

    public Trie_1() {
        arrays = new Trie_1[26];
        isEnd = false;
    }

    public void insert(String word){
        Trie_1 cur = this;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.arrays[c - 'a'] == null){
                cur.arrays[c - 'a'] = new Trie_1();
            }
            cur = cur.arrays[c - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word){
        Trie_1 trie1 = searchPrefix(word);
        if (trie1 == null) {
            return false;
        }
        return trie1.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie_1 searchPrefix(String word) {
        Trie_1 cur = this;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.arrays[c - 'a'] == null){
                return null;
            }
            cur = cur.arrays[c - 'a'];
        }
        return cur;
    }
}
