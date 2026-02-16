package com.dflong.algorithm.leetcode0;

public class _2181 {

    public ListNode mergeNodes(ListNode head) {
        ListNode hair = new ListNode(-1);
        ListNode cur = hair;
        int sum = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                cur.next = new ListNode(sum);
                cur = cur.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return hair.next;
    }
}
