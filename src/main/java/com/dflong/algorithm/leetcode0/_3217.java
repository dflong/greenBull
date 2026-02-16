package com.dflong.algorithm.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _3217 {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            if (set.contains(head.val)) {
                pre.next = head.next;
                head = head.next;
            } else {
                pre = head;
                head = head.next;
            }
        }

        return hair.next;
    }
}
