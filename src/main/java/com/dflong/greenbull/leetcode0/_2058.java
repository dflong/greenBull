package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _2058 {

    public static void main(String[] args) {
        _2058 v = new _2058();

        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        v.nodesBetweenCriticalPoints(n1);
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = getList(head);
        if (list.size() < 2) {
            return new int[] {-1, -1};
        }
        int[] res = new int[2];
        res[0] = list.get(1) - list.get(0);
        res[1] = list.get(list.size() - 1) - list.get(0);
        for (int i = 1; i < list.size(); i ++) {
            res[0] = Math.min(res[0], list.get(i) - list.get(i - 1));
        }
        return res;
    }

    private static List<Integer> getList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        int index = 1;
        while (pre != null && cur != null && next != null) {
            if (pre.val < cur.val && cur.val > next.val) {
                list.add(index);
            }
            if (pre.val > cur.val && cur.val < next.val) {
                list.add(index);
            }

            pre = cur;
            cur = next;
            next = cur.next;
            index ++;
        }
        return list;
    }
}
