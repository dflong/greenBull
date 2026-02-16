package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _143 {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        ListNode hair = new ListNode(-1), cur = hair;
        int  i = 0, j = list.size() - 1;
        while (i < j) {
            cur.next = list.get(i ++);
            cur.next.next = list.get(j --);
            cur = cur.next.next;
        }
        if (i == j) { // 奇数
            cur.next = list.get(i);
            cur = cur.next;
        }
        cur.next = null;
        head = hair.next;
    }
}
