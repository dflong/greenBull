package com.dflong.algorithm.leetcode0;

public class _2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode(0);
        ListNode cur = hair;

        int ct = 0;
        while (l1 != null || l2 != null) {
            ListNode next = new ListNode(ct);
            ct = 0; // 使用后恢复
            if (l1 != null) {
                next.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                next.val += l2.val;
                l2 = l2.next;
            }

            if (next.val > 9) {
                next.val -= 10;
                ct ++; // 有进位
            }

            cur.next = next;
            cur = next;
        }

        if (ct > 0) {
            cur.next = new ListNode(ct);
        }
        return hair.next;
    }
}
