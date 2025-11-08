package com.dflong.greenbull.leetcode;

public class _160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if (lengthA > lengthB) {
            return getIntersectionNode(headA, headB, lengthA, lengthB);
        }
        return getIntersectionNode(headB, headA, lengthB, lengthA);
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB, int lenA, int lenB) {
        int diff = lenA - lenB;
        while (diff > 0) {
            headA = headA.next;
            diff--;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
