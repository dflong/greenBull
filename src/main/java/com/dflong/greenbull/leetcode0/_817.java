package com.dflong.greenbull.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _817 {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int cnt = 0;
        boolean inSet = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!inSet) {
                    cnt ++;
                    inSet = true;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return cnt;
    }
}
