package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法：用来解决穷举问题 排列、组合等
 * 回溯算法本质是 二叉树， 数据规模决定树的宽度， 递归深度决定树的深度
 */
public class BackTracking {

    List<Integer> list = new ArrayList<>(); // 保存结果

    public void backtracking(int n, int idx) { // 参数不固定
        if (list.size() == n) {
            // 收集结果
            return;
        }

        for (int i = idx; i < n; i++) {
            list.add(i);
            backtracking(n, i + 1);
            list.remove(list.size() - 1); // 回溯
        }
    }
}
