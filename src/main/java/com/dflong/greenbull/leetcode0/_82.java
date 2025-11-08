package com.dflong.greenbull.leetcode0;

public class _82 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        new _82().deleteDuplicates(n1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode hair = new ListNode(-1);
        hair.next = head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = hair, cur = head, next = head.next;
        while (cur != null && next != null) {
            if (cur.val == next.val) {
                while (next != null && next.next != null) {
                    if (next.val == next.next.val) {
                        next = next.next;
                    } else {
                        break;
                    }
                }
                pre.next = next.next;
                cur = next.next;
                if (cur != null) {
                    next = cur.next;
                }
            } else {
                pre = cur;
                cur = next;
                next = next.next;
            }
        }

        return hair.next;
    }
}
