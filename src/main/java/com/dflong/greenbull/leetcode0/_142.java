package com.dflong.greenbull.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> map = new HashSet<>();

        ListNode slow = head;
        while (slow != null) {
            if (map.contains(slow)) {
                return slow;
            }
            map.add(slow);
            slow = slow.next;
        }
        return null;
    }
}
