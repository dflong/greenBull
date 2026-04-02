package com.dflong.algorithm.leetcode_interview;

import com.dflong.algorithm.leetcode.ListNode;

public class _02_01 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode cur = hair;
        boolean[] arr = new boolean[20001];
        while (cur.next != null) {
            if (arr[cur.next.val + 10000]) {
                cur.next = cur.next.next; // 已经出现过，删除该节点
            } else {
                arr[cur.next.val + 10000] = true;
                cur = cur.next;
            }
        }
        return hair.next;
    }
}
