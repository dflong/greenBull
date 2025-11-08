package com.dflong.greenbull.leetcode;

public class _19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        // 1. 定义快慢指针
        ListNode fast = head;
        ListNode slow = hair;
        // 2. 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 3. 快慢指针一起走，直到快指针走到末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 4. 删除慢指针的下一个节点
        slow.next = slow.next.next;
        return hair.next;
    }
}
