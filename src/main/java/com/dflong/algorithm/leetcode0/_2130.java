package com.dflong.algorithm.leetcode0;

public class _2130 {

    public int pairSum(ListNode head) {
        if (head != null && head.next != null && head.next.next == null) return head.val + head.next.val;
        int max = 0;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = reversePairs(slow.next);

        while (newHead != null) {
            max = Math.max(max, newHead.val + head.val);
            newHead = newHead.next;
            head = head.next;
        }

        return max;
    }

    public ListNode reversePairs(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
