package com.dflong.greenbull.leetcode0;

public class _147 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        new _147().insertionSortList(listNode);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode hair = new ListNode(-1);
        hair.next = head;

        ListNode cur = head.next;
        ListNode sorted = hair.next;
        while (cur != null) {
            if (cur.val >= sorted.val) {
                sorted = sorted.next;
            } else {
                ListNode pre = hair;
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                sorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = sorted.next;
        }


        return hair.next;
    }
}
