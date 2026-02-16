package com.dflong.algorithm.leetcode;

public class _203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode cur = hair;

        while (head != null) {
            if (head.val == val) {
                cur.next = head.next;
                head = head.next;
            } else {
                cur = head;
                head = head.next;
            }
        }
        return hair.next;
    }
}


