package com.dflong.algorithm.leetcode0;

public class _274 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,1};
        int i = hIndex(nums);
        System.out.println(i);
    }

    // 3,0,6,1,5
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int length = citations.length;
        for (int j = 0; j < citations.length; j++) {
            int cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                // 有3篇论文每篇至少引用3次数
                int citation = citations[i]; // 被引用次数
                if (citation >= length) {
                    cnt ++;
                }
            }
            if (cnt >= length) {
                return length;
            }
            length --;
        }
        return 0;
    }
}
