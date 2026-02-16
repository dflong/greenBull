package com.dflong.algorithm.leetcode0;

public class _237 {

    public void deleteNode(ListNode node) {
        int temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;

        node.next = node.next.next;
    }
}
