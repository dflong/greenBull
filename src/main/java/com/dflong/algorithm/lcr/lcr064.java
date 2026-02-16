package com.dflong.algorithm.lcr;

public class lcr064 {

    static class MagicDictionary {

        public static void main(String[] args) {
            MagicDictionary magicDictionary = new MagicDictionary();
            magicDictionary.buildDict(new String[]{"hello", "leetcode"});
            boolean hello = magicDictionary.search("hhllo");
            System.out.println(hello);
        }

        // trie树
        MagicDictionary[] dicts = new MagicDictionary[26];
        boolean isEnd = false;

        /** Initialize your data structure here. */
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for (int i = 0; i < dictionary.length; i++) {
                String word = dictionary[i];
                MagicDictionary dict = this;
                for (int j = 0; j < word.length(); j++) {
                    int index = word.charAt(j) - 'a';
                    if (dict.dicts[index] == null) {
                        dict.dicts[index] = new MagicDictionary();
                    }
                    dict = dict.dicts[index];
                }
                dict.isEnd = true;
            }
        }

        public boolean search(String searchWord) {
            return dfs(searchWord, this, 0, false);
        }
        public boolean dfs(String word, MagicDictionary dict, int pos, boolean isReplace) {
            if (pos == word.length()) {
                return isReplace && dict.isEnd;
            }
            int idx = word.charAt(pos) - 'a';
            if (dict.dicts[idx] != null) {
                if (dfs(word, dict.dicts[idx], pos + 1, isReplace)) {
                    return true;
                }
            }
            if (!isReplace) {
                for (int i = 0; i < 26; i ++) {
                    if (i != idx && dict.dicts[i] != null) {
                        if (dfs(word, dict.dicts[i], pos + 1, true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
