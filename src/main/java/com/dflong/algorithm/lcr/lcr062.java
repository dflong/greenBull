package com.dflong.algorithm.lcr;

public class lcr062 {

    class Trie {

        Trie[] children = new Trie[26];
        boolean isEnd = false;
        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new Trie();
                }
                trie = trie.children[c - 'a'];
            }
            trie.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (trie.children[c - 'a'] == null) {
                    return false;
                }
                trie = trie.children[c - 'a'];
            }
            return trie.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie trie = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (trie.children[c - 'a'] == null) {
                    return false;
                }
                trie = trie.children[c - 'a'];
            }

            return trie != null;
        }
    }
}
