package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lcr084 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new int[nums.length];
        backTrack();
        return res;
    }

    int[] nums;
    int[] used;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrack() {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (used[i] == 1) {
                continue;
            }
            // 两个相等，前一个元素未选取【1, 1, 2】
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backTrack();
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
