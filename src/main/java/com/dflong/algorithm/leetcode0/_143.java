package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _143 {

    public void reorderList(ListNode head) {
        // 快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next, l1 = head;
        slow.next = null; // 断开l1、l2

        ListNode l2 = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = l2;
            l2 = cur;
            cur = next;
        }

        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
