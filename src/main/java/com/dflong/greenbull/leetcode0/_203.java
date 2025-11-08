package com.dflong.greenbull.leetcode0;

public class _203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode prev = hair;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                head = head.next;
            } else {
                prev = head;
                head = head.next;
            }
        }

        return hair.next;
    }
}
