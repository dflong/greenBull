package com.dflong.algorithm.leetcode_interview;

public class _02_04 {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0), bigHead = new ListNode(0);
        ListNode small = smallHead, big = bigHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null; // 断开大链表的尾部
        small.next = bigHead.next; // 连接小链表和大链表
        return smallHead.next; // 返回小链表的头节点
    }
}
