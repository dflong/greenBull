package com.dflong.algorithm.leetcode0;

public class _25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair;


        while (head != null) {
            ListNode tail = prev;

            int i = 0;
            while (i < k) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
                i ++;
            }
            ListNode next = tail.next;

            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            prev.next = head;
            tail.next = next;

            prev = tail;
            head = next;
        }

        return hair.next;
    }

    ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (cur != pre) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return new ListNode[] {tail, head};
    }
}
