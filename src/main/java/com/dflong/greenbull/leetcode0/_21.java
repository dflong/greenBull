package com.dflong.greenbull.leetcode0;

public class _21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode newNode = new ListNode(list1.val);
                head.next = newNode;
                head = newNode;
                list1 = list1.next;
            } else {
                ListNode newNode = new ListNode(list2.val);
                head.next = newNode;
                head = newNode;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            ListNode newNode = new ListNode(list1.val);
            head.next = newNode;
            head = newNode;
            list1 = list1.next;
        }

        while (list2 != null) {
            ListNode newNode = new ListNode(list2.val);
            head.next = newNode;
            head = newNode;
            list2 = list2.next;
        }
        return cur.next;
    }
}
