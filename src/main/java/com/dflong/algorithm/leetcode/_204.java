package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _204 {

    public static void main(String[] args) {
        new _204().countPrimes(10);
    }

    public int countPrimes(int n) {
        // 只能被1和自身整除
        int count = 0;

        int[] primes = new int[n + 1];
        Arrays.fill(primes, 1);

        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                count ++;

                for (long j = (long) i * i; j < n; j += i) {
                    primes[(int)j] = 0;
                }
            }
        }
        return count;
    }
}
