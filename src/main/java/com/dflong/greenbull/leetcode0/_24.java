package com.dflong.greenbull.leetcode0;

public class _24 {

    public static void main(String[] args) {
        _24 v = new _24();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode listNode = v.swapPairs(n1);
        System.out.println();
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode hair = new ListNode(-1), newHead = head.next;
        ListNode pre = head, cur = head.next;
        while (true) {
            hair.next = cur;
            ListNode next = cur.next;
            pre.next = next;
            cur.next = pre;

            hair = pre;
            pre = next;
            if (next == null || next.next == null) break;
            cur = pre.next;
        }

        return newHead;
    }
}
