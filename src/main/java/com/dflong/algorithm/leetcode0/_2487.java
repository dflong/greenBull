package com.dflong.algorithm.leetcode0;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2487 {

    public static void main(String[] args) {


        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(13);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        new _2487().removeNodes(n1);
    }

    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            while (!stack.isEmpty() && stack.getLast().val < cur.val) {
                stack.removeLast();
            }
            stack.addLast(cur);
            cur = cur.next;
        }
        if (stack.isEmpty()) return null;
        head = stack.getFirst();
        stack.removeFirst();
        cur = head;
        while (!stack.isEmpty()) {
            cur.next = stack.getFirst();
            cur = cur.next;
            cur.next = null;
            stack.removeFirst();
        }
        return head;
    }
}
