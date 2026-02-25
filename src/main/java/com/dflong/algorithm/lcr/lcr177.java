package com.dflong.algorithm.lcr;

public class lcr177 {

    public static void main(String[] args) throws InterruptedException {
        lcr177 lc = new lcr177();

        synchronized (lc) {
            lc.wait(); // 要在获取锁后使用
        }
    }

    public int[] sockCollocation(int[] sockets) {
        // 有俩个不相同的，其他俩次相同
        int sum = 0;
        for (int num : sockets) {
            sum ^= num;
        }

        int temp = 1;
        while ((temp & sum) == 0) {
            temp <<= 1; // sum是俩个不相同数字的异或结果，找这俩个树的不相同位1
        }

        int a = 0, b = 0;
        for (int socket : sockets) {
            if ((temp & socket) == 0) {
                a ^= socket;
            } else {
                b ^= socket;
            }
        }
        return new int[]{a, b};
    }
}
