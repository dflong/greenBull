package com.dflong.greenbull.leetcode;

public class _390 {

    public static void main(String[] args) {
        new _390().lastRemaining(3);
    }

    public int lastRemaining(int n) {
        if (n == 1) return 1;
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

    // 模拟超时
    public int lastRemaining1(int n) {
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            nums[i] = i;
        }
        int cnt = n;
        int l = 1, r = n;
        while (cnt != 1) {
            // 先从左往右
            while (l <= n && nums[l] == 0) {
                l ++; // 先找第一个
            }
            nums[l] = 0;
            cnt --;
            int sec = 0;
            for (int i = l; i <= n && cnt > 1; i ++ ) { // 先跳过第一个
                if (nums[i] != 0) {
                    if (sec != 0) {
                        nums[i] = 0;
                        cnt --;
                        sec = 0;
                    } else {
                        sec ++;
                    }
                }
            }
            // 再从右往左
            while (cnt != 1 && r >= 1 && nums[r] == 0) {
                r --; // 先找第一个
            }
            if (cnt == 1) break;
            nums[r] = 0;
            cnt --;
            sec = 0;
            for (int i = r; i >= 1 && cnt > 1; i --) {
                if (nums[i] != 0) {
                    if (sec != 0) {
                        nums[i] = 0;
                        cnt --;
                        sec = 0;
                    } else {
                        sec ++;
                    }
                }
            }

            l = 1; r = n;
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }
        return 0;
    }
}
