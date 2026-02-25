package com.dflong.algorithm.lcr;

public class lcr121 {

    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        if (plants == null || plants.length == 0 || plants[0].length == 0) return false;
        // [2,3,6,8],
        // [4,5,8,9],
        // [5,9,10,12]
        // 从左下角 往上递减 往右递增
        int m = plants.length, n = plants[0].length;

        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (plants[i][j] == target) {
                return true;
            } else if (plants[i][j] > target) {
                i --;
            } else {
                j ++;
            }
        }
        return false;
    }
}
