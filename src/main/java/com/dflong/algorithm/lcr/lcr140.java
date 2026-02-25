package com.dflong.algorithm.lcr;

public class lcr140 {

    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode cur = head;
        int count = cnt;
        while (cur != null && count > 0) {
            cur = cur.next;
            count --;
        }
        while (cur != null) {
            cur = cur.next;
            head = head.next;
        }

        return head;
    }
}
