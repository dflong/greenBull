package com.dflong.algorithm.leetcode0;

public class _19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        ListNode pre = hair;
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return hair.next;
    }
}
