package com.dflong.algorithm.leetcode0;

public class _2807 {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head, cur = head.next;

        while (cur != null) {
            ListNode listNode = get(pre.val, cur.val);
            pre.next = listNode;
            listNode.next = cur;

            pre = cur;
            cur = cur.next;
        }

        return head;
    }

    public ListNode get(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return new ListNode(a);
    }
}
