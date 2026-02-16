package com.dflong.algorithm.leetcode;

public class _388 {

    public static void main(String[] args) {
        new _388().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    }

    public int lengthLongestPath(String input) {
        int res = 0;
        int[] lengths = new int[10000];

        String[] paths = input.split("\n");
        for (String path : paths) {
            int cnt = countTabs(path);
            lengths[cnt + 1] = lengths[cnt] + path.length() - cnt; // 当前制表符的长度 + 当前路径长度 - 制表符数量
            if (path.contains(".")) { // 到了末尾
                res = Math.max(res, lengths[cnt + 1] + cnt); // 加上\
            }
        }
        return res;
    }

    public int countTabs(String s){
        int cnt = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '\t') {
                cnt ++;
            }
        }
        return cnt;
    }
}
