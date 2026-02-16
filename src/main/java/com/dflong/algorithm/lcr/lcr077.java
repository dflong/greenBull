package com.dflong.algorithm.lcr;

public class lcr077 {

    public ListNode sortList(ListNode head) {
        return sortList2(head, null);
    }

    public ListNode sortList2(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode sort = sortList2(head, slow);
        ListNode sort1 = sortList2(slow, tail);
        return sort(sort, sort1);
    }

    public ListNode sort(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode(0), dummy = hair;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                hair.next = l1;
                l1 = l1.next;
                hair = hair.next;
            } else {
                hair.next = l2;
                l2 = l2.next;
                hair = hair.next;
            }
        }

        while (l1 != null) {
            hair.next = l1;
            l1 = l1.next;
            hair = hair.next;
        }

        while (l2 != null) {
            hair.next = l2;
            l2 = l2.next;
            hair = hair.next;
        }
        return dummy.next;
    }
}
