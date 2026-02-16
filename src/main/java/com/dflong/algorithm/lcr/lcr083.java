package com.dflong.algorithm.lcr;

import com.sun.corba.se.impl.naming.cosnaming.NamingUtils;

import java.util.ArrayList;
import java.util.List;

public class lcr083 {

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.used = new int[nums.length];
        backTrack();
        return res;
    }

    int[] nums;
    int[] used;
    List<List<Integer>> res = new ArrayList<List<Integer>>();
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
            path.add(nums[i]);
            used[i] = 1;
            backTrack();
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
