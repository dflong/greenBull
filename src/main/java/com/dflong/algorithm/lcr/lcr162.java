package com.dflong.algorithm.lcr;

public class lcr162 {

    // 参考_233
    // https://www.bilibili.com/video/BV1Xj411K7oF/
    private char[] s;
    public int digitOneInNumber(int n) {
        s = Integer.toString(n).toCharArray();
        cache = new int[s.length][s.length];
        return f(0, 0 ,true);
    }

    int[][] cache; // 回溯参数是什么就记忆化什么
    // 本题就是记忆化i和oneCnt

    // 返回从第 i 位开始，数字中 1 的个数
    private int f(int i, int oneCnt, boolean isLimit) {
        // 结束条件
        // 前文说过，结束时就表示一条完整的路径，即一个 <= n 的数字，而 ontCnt 则表示该数字中 1 的个数
        // 所以直接返回 oneCnt 即可！！
        if (i == s.length) return oneCnt;

        if (!isLimit && cache[i][oneCnt] > 0) {
            return cache[i][oneCnt];
        }

        int up = isLimit ? s[i] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= up; d++) {
            // 如果 d = 1，oneCnt 就➕1
            res += f(i + 1, oneCnt + (d == 1 ? 1 : 0), isLimit && d == up);
        }

        if (!isLimit) {
            cache[i][oneCnt] = res;
        }

        return res;
    }
}
