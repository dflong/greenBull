package com.dflong.algorithm.lcr;

public class lcr173 {

    public int takeAttendance(int[] records) {
        // [0, 1, 2, 3, 4, 5, 6, 8]
        // 没少时 idx = nums[idx]
        int l = 0, r = records.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (records[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l; // 循环跳出时l > j
    }
}
