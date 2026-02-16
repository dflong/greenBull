package com.dflong.algorithm.lcr;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;

public class lcr065 {

    Trie root = new Trie();
    HashMap<Trie, String> map = new HashMap<>();

    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        // 倒序构建trie，统计trie树的长度
        for (String word : words) {
            Trie cur = root;
            for (int i = word.length() - 1; i >= 0; i --) {
                cur = cur.get(word.charAt(i));
            }
            map.put(cur, word);
        }

        for (Trie trie: map.keySet()) {
            if (trie.cnt == 0) {
                res += map.get(trie).length() + 1;
            }
        }

        return res;
    }

    class Trie {
        Trie[] tries = new Trie[26];
        int cnt = 0; // 代表访问次数

        public Trie get(char c) {
            if (tries[c - 'a'] == null) {
                tries[c - 'a'] = new Trie();
                cnt ++;
            }
            return tries[c - 'a'];
        }
    }
}
