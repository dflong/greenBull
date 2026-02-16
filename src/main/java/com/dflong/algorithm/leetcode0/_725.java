package com.dflong.algorithm.leetcode0;

public class _725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        // 获取链表长度
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n ++;
            cur = cur.next;
        }

        int num = n / k, remain = n % k;
        for (int i = 0; i < k; i++) {
            res[i] = head;
            int j = num;
            if (remain-- > 0) {
                j += 1;
            }
            while (head != null && j > 1) {
                j --;
                head = head.next;
            }
            if (head == null) {
                break;
            }
            ListNode pre = head;
            head = head.next;
            pre.next = null;
        }

        return res;
    }
}
