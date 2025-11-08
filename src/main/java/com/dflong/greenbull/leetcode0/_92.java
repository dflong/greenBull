package com.dflong.greenbull.leetcode0;

public class _92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        int preCnt = left - 1;
        ListNode preNode = null;
        ListNode leftNode = null;

        int aftCnt = right + 1;
        ListNode aftNode = null;
        ListNode rightNode = null;

        int i = 1;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {

            if (i == preCnt) {
                preNode = cur;
            }
            if (i == left) {
                leftNode = cur;
            }
            if (i == aftCnt) {
                aftNode = cur;
            }
            if (i == right) {
                rightNode = cur;
            }
            ListNode next  = cur.next;
            if (i >= left && i<= right) {
                cur.next = pre;
            }
            pre = cur;
            cur = next;
            i ++;
        }

        if (preNode != null) {
            preNode.next = rightNode;
        }
        if (leftNode != null) {
            leftNode.next = aftNode;
        }

        if (left == 1) {
            return rightNode;
        }







//        Stack<Integer> stack = new Stack<>();
//        ListNode cur = head;
//        int cnt = 1;
//        while (cur != null) {
//            if (cnt >= left && cnt <= right) {
//                stack.push(cur.val);
//            }
//            cnt ++;
//            cur = cur.next;
//        }
//
//        cur = head;
//        cnt = 1;
//        while (cur != null) {
//            if (cnt >= left && cnt <= right) {
//                cur.val = stack.pop();
//            }
//            cnt ++;
//            cur = cur.next;
//        }
        return head;
    }
}
