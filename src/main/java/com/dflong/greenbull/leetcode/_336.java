package com.dflong.greenbull.leetcode;

import java.util.*;

public class _336 {

    public static void main(String[] args) {
        new _336().palindromePairs(new String[]{"a",""});
    }

    class Trie {
        private Trie[] children;
        private int origIndex = -1;
        public Trie() {
            children = new Trie[26];
        }

        // 顺序插入
        public void insert(String word, int index) {
            Trie p = this;
            int n = word.length();
            for(int i = 0; i < n; i++) {
                int x = word.charAt(i) - 'a';
                if(p.children[x] == null) {
                    p.children[x] = new Trie();
                }
                p = p.children[x];
            }
            p.origIndex = index;
        }

        // 逆序插入
        public void insertRev(String word, int index) {
            Trie p = this;
            int n = word.length();
            for(int i = n - 1; i >= 0; i--) {
                int x = word.charAt(i) - 'a';
                if(p.children[x] == null) {
                    p.children[x] = new Trie();
                }
                p = p.children[x];
            }
            p.origIndex = index;
        }

        public Set<Integer> find(String s) {
            Trie p = this;
            int n = s.length();
            Set<Integer> res = new HashSet<>();
            for(int i = n - 1; i >= 0; i--) {
                // 第三种情况
                if(p.origIndex != -1 && check(s, 0, i)) {
                    res.add(p.origIndex);
                }
                int x = s.charAt(i) - 'a';
                p = p.children[x];
                if(p == null) break;
            }
            // 第一种情况
            if(p != null && p.origIndex != -1) {
                res.add(p.origIndex);
            }
            return res;
        }

        public Set<Integer> findRev(String s) {
            Trie p = this;
            int n = s.length();
            Set<Integer> res = new HashSet<>();
            for(int i = 0; i < n; i++) {
                // 第二种情况
                if(p.origIndex != -1 && check(s, i, n - 1)) {
                    res.add(p.origIndex);
                }
                int x = s.charAt(i) - 'a';
                p = p.children[x];
                if(p == null) break;
            }
            return res;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        List<List<Integer>> res = new ArrayList<>();
        Trie root = new Trie();
        Trie rev = new Trie();
        for(int i = 0; i < n; i++) {
            root.insert(words[i], i);
            rev.insertRev(words[i], i);
        }

        for(int i = 0; i < n; i++) {
            Set<Integer> indexs = root.find(words[i]);
            Set<Integer> revIndexs = rev.findRev(words[i]);
            for(int index : indexs) {
                if(i == index) continue;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(index); tmp.add(i);
                res.add(tmp);
            }
            for(int index : revIndexs) {
                if(i == index) continue;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i); tmp.add(index);
                res.add(tmp);
            }
        }
        return res;
    }

    public boolean check(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }


}
