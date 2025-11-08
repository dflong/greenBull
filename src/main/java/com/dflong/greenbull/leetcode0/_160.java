package com.dflong.greenbull.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();

        while (headA != null) {
            setA.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (setA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
