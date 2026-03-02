package com.dflong.algorithm.lcr;

public class lcr027 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseList(slow);
        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
