package com.dflong.algorithm.leetcode0;

public class _2074 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(3);
        ListNode n9 = new ListNode(8);
        ListNode n10 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        new _2074().reverseEvenLengthGroups(n1);
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode pre = head, cur = head, newHead = head;
        int k = 2;
        boolean reverse = true;

        while (cur != null) {
            head = cur.next;
            int i = 0;
            while (i < k && cur.next != null) {
                cur = cur.next;
                i ++;
            }
            ListNode tail = cur, next = null;
            if (tail != null && tail.next != null) next = tail.next;

            if (reverse) {
                ListNode[] reverses = reverse(head, next);
                head = reverses[0];
                tail = reverses[1];
            }
            if (head == null) break;

            pre.next = head;
            tail.next = next;

            pre = tail;
            cur = tail;
            k ++;
            reverse = !reverse;
        }

        return newHead;
    }

    ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = null, cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return new ListNode[] {pre, head};
    }
}
