package com.dflong.greenbull.leetcode;

public class _24 {

    public ListNode swapPairs(ListNode head) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode cur = hair;
        ListNode first, second;
        while (cur.next != null && cur.next.next != null) {
            first = cur.next;
            second = cur.next.next;
            ListNode next = second.next;

            cur.next = second;
            second.next = first;
            first.next = next;

            cur = first;
        }

        return hair.next;
    }
}
