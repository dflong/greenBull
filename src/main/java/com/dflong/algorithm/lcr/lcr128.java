package com.dflong.algorithm.lcr;

public class lcr128 {

    public int inventoryManagement(int[] stock) {
        // 4,5,8,3,4 旋转数组
        int i = 0, j = stock.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            // 使用stack[m] 和stock[j] 判断，无法和stock[i]比较
            if (stock[m] < stock[j]) {
                j = m; // 在作侧，包括m
            } else if (stock[m] > stock[j]) {
                i = m + 1; // m比j还大，说明左侧有顶峰
            } else {
                // 相等缩短j
                j --;
            }
        }
        return stock[i];
    }
}
