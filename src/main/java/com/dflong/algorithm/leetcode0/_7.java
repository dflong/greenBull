package com.dflong.algorithm.leetcode0;

public class _7 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA ++;
        }

        while (curB != null) {
            curB = curB.next;
            lenB ++;
        }

        if (lenA > lenB) {
            return getIntersectionNode2(headA, headB, lenA, lenB);
        }
        return getIntersectionNode2(headB, headA, lenB, lenA);
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB, int lenA, int lenB) {
        int offset = lenA - lenB;
        while (offset-- > 0) {
            headA = headA.next;
        }

        while (headB != null) {
            if (headA == headB) {
                return headB;
            }
            headB = headB.next;
            headA = headA.next;
        }

        return null;
    }

    public int reverse(int x) {
        long res = 0;
        boolean negative = true;
        if (x < 0) negative = false;

        x = Math.abs(x);
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (!negative) {
            res = res * -1;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
