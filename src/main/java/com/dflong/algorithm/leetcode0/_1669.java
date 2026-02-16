package com.dflong.algorithm.leetcode0;

public class _1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 找到a、b点
        ListNode nodeA = null;
        ListNode nodeB = null;
        int index = 1;
        ListNode cur = list1;
        while (cur != null) {
            if (index == a) {
                nodeA = cur;
            }
            if (index == b + 1) {
                nodeB = cur;
                break;
            }
            index ++;
            cur = cur.next;
        }
        nodeA.next = list2;
        cur = list2;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = nodeB;
        return list1;
    }
}
