package com.dflong.algorithm.leetcode;

public class _445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode re1 = reverseList(l1);
        ListNode re2 = reverseList(l2);

        int carry = 0;
        ListNode hair = new ListNode();
        ListNode cur = hair;
        while (re1 != null || re2 != null) {
            int sum = carry;
            if (re1 != null) {
                sum += re1.val;
                re1 = re1.next;
            }
            if (re2 != null) {
                sum += re2.val;
                re2 = re2.next;
            }
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        ListNode next = hair.next;
        hair.next = null;
        ListNode listNode = reverseList(next);
        return listNode;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
