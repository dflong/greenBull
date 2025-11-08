package com.dflong.greenbull.leetcode0;

public class _23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return dfs(lists, 0, lists.length - 1);
    }

    public ListNode dfs(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode dfs = dfs(lists, left, mid);
        ListNode dfs1 = dfs(lists, mid + 1, right);
        return mergeTwoLists(dfs, dfs1);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode hair = new ListNode(0);
        ListNode cur = hair;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }

        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }

        return hair.next;
    }
}
