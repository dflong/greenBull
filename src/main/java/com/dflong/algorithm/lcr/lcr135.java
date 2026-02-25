package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class lcr135 {

    public static void main(String[] args) {
        int[] ints = new lcr135().countNumbers(2);
    }

    public int[] countNumbers(int cnt) {
        for (int n = 1; n <= cnt; n ++) {
            dfs(0, n);
        }
        int[] nums = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            nums[i] = Integer.parseInt(res.get(i));
        }
        return nums;
    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    void dfs(int idx, int n) { // idx 第几位
        if (idx == n) {
            res.add(sb.toString());
            return;
        }

        int start = idx == 0 ? 1 : 0; // 首位数字不能为0
        for (int i = start; i <= 9; i ++) {
            sb.append(i); // 添加1-9
            dfs(idx + 1, n);
            sb.deleteCharAt(sb.length() - 1); // 回溯
        }
    }
}
