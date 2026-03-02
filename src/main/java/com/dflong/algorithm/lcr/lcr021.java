package com.dflong.algorithm.lcr;

public class lcr021 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode(0);
        hair.next = head;

        ListNode sec = hair, first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            sec = sec.next;
        }
        sec.next = sec.next.next;

        return hair.next;
    }
}
