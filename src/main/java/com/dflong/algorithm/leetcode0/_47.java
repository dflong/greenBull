package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47 {

    public static void main(String[] args) {
        new _47().permuteUnique(new int[]{1,1,2});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        Arrays.sort(nums);
        dfs();
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] nums;
    int n;
    int[] used = new int[21]; // 防止重复使用同index

    public void dfs() {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i ++) {
            // for循环保证了从数组中从前往后一个一个取值，再用if判断条件。
            // 所以nums[i - 1]一定比nums[i]先被取值和判断。如果nums[i - 1]被取值了，
            // 那vis[i - 1]会被置1，只有当递归再回退到这一层时再将它置0。
            // 每递归一层都是在寻找数组对应于递归深度位置的值，
            // 每一层里用for循环来寻找。所以当vis[i - 1] == 1时，
            // 说明nums[i - 1]和nums[i]分别属于两层递归中，也就是我们要用这两个数分别放在数组的两个位置，
            // 这时不需要去重。但是当vis[i - 1] == 0时，
            // 说明nums[i - 1]和nums[i]属于同一层递归中（只是for循环进入下一层循环），
            // 也就是我们要用这两个数放在数组中的同一个位置上，这就是我们要去重的情况
            // used[] == true树层去重  used[] == false树枝去重
            //todo used[i - 1 + 10] == 0 前一个位置被递归回溯后改成0了，说明已经使用过了，则当前位置不能再使用
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1 + 10] == 0) continue; //  同90去重，不同写法
            if (used[i + 10] == 0) {
                list.add(nums[i]);
                used[i + 10] = 1;
                dfs();
                list.remove(list.size() - 1);
                used[i + 10] = 0;
            }
        }
    }
}
