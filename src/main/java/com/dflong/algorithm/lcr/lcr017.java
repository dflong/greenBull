package com.dflong.algorithm.lcr;

public class lcr017 {

    public String minWindow(String s, String t) {
        String res = "";
        int[] tCnt = new int[60];
        int diff = 0;
        for (char c : t.toCharArray()) {
            tCnt[c - 'A'] ++;
        }

        for (int i : tCnt) {
            if (i != 0) diff ++;
        }

        int min = Integer.MAX_VALUE;
        int[] sCnt = new int[60];
        int l = 0;
        for (int r = 0; r < s.length(); r ++) {
            int idx = s.charAt(r) - 'A';
            sCnt[idx] ++;

            if (sCnt[idx] == tCnt[idx]) {
                diff --;
            }

            while (diff == 0) {
                int off = r - l + 1;
                if (off < min) {
                    min = Math.min(min, off);
                    res = s.substring(l, r + 1);
                }

                int x = s.charAt(l) - 'A';
                sCnt[x] --;
                l ++; // 左缩

                // 左缩会导致t数量发送变化，而且不够的数量
                if (tCnt[x] != 0 && sCnt[x] < tCnt[x]) {
                    diff ++; // 产生差异
                }
            }
        }

        return res;
    }
}
