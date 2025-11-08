package com.dflong.greenbull.leetcode;

import java.util.*;

public class _140 {

    public static void main(String[] args) {
        new _140().wordBreak("catsanddog",
                Arrays.asList("cat","cats","and","sand","dog"));
    }

    List<String> res = new ArrayList<>();
    // 所有单词
    Set<String> set = new HashSet<>();
    // 单词路径
    List<String> path = new ArrayList<>();
    String s;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        set.addAll(wordDict);

        backTracking(0);
        return res;
    }

    public void backTracking(int idx) {
        if (idx == s.length()) {
            res.add(String.join(" ", path));
            return;
        }

        for (int i = idx; i < s.length(); i ++) {
            String str = s.substring(idx, i + 1);
            if (set.contains(str)) {
                path.add(str);
                backTracking(i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
