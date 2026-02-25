package com.dflong.algorithm.lcr;

public class lcr167 {

    public static void main(String[] args) {
        lcr167 lcr167 = new lcr167();
        lcr167.dismantlingAction(" ");
    }

    public int dismantlingAction(String arr) {
        if (arr.isEmpty()) return 0;
        int[] idxs = new int[128]; // 放位置索引
        int res = 1, l = 0;
        for (int r = 0; r < arr.length(); r ++) {
            if (arr.charAt(r) == ' ') {
                continue;
            }
            int idx = arr.charAt(r) - '0';
            if (idxs[idx] != 256) {
                l = Math.max(l, idxs[idx] + 1);
                res = Math.max(res, r - l + 1);
                // 移除左元素，加入当前元素
            }
            idxs[idx] = r;
        }
        res = Math.max(res, arr.length() - l);
        return res;
    }
}
