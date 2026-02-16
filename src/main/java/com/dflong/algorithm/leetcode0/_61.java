package com.dflong.algorithm.leetcode0;

public class _61 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        new _61().rotateRight(listNode, 2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            n ++;
        }

        k = k % n;
        if (k == 0) return head;

        ListNode end = cur; // 最后一个结点
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode slow = hair;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        end.next = head;
        return newHead;
    }
}
