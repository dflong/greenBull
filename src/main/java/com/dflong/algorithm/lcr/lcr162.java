package com.dflong.algorithm.lcr;

public class lcr162 {

    // 参考_233
    // https://www.bilibili.com/video/BV1Xj411K7oF/
    public int digitOneInNumber(int n) {
        s = Integer.toString(n).toCharArray();
        cache = new int[s.length][s.length];
        return dfs(0, 0 ,true); // isLimit前一位是否受到上界限制
    }

    char[] s;
    int[][] cache;
    // 这里只缓存了idx、oneCnt，没有isLimit,因为只有每次都选择上界的时候才会isLimit = true，也就是快dfs结束的时候

    // idx当前位 isLimit前一位是否受到上界限制
    public int dfs(int idx, int oneCnt, boolean preIsLimit) {
        if (idx == s.length) return oneCnt;

        if (!preIsLimit && cache[idx][oneCnt] > 0) {
            return cache[idx][oneCnt];
        }

        int res = 0;
        int up = preIsLimit ? s[idx] - '0' : 9; // 是否被限制 这里的isLimit是上一位，算出up得到本次的上界

        for (int d = 0; d <= up; d ++) { // s = 123, s[0] = 1且当前选择了2则下一位是受到限制的
            res += dfs(idx + 1, oneCnt + (d == 1 ? 1 : 0), preIsLimit && d == up); // 得到下次的上界
        }

        if (!preIsLimit) {
            cache[idx][oneCnt] = res;
        }

        return res;
    }
}
