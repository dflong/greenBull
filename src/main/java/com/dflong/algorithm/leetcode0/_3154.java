package com.dflong.algorithm.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _3154 {

    public int kRes = 0;

    Map<String, Integer> map = new HashMap<String, Integer>();

    public int waysToReachStair(int k) {
        kRes = k;
        return dfs(1, 0, true);
    }

    // preDown true可以向下走 false不能向下走
    // i当前位置 jump跳跃次数 preDown是否向下走了
    public int dfs(int i, int jump, boolean preDown) {
        if (i > kRes + 1) {
            return 0;
        }

        int res = i == kRes ? 1 : 0;
//        if (i == kRes) {
//            return res;
//        }
        if (map.containsKey(i + "_" + jump + "_" + preDown)) {
            return map.get(i + "_" + jump + "_" + preDown);
        }

        res += dfs(i + (1 << jump), jump + 1, true);

        if (preDown) {
            res +=  dfs(i - 1, jump, false);
        }
        map.put(i + "_" + jump + "_" + preDown, res);
        return res;
    }
}
