package com.dflong.algorithm.lcr;

public class lcr136 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode hair = new ListNode(- 1);
        hair.next = head;
        ListNode prev = hair;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                return hair.next;
            }
            prev = prev.next;
            head = head.next;
        }

        return hair.next;
    }
}
