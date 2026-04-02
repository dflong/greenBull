package com.dflong.algorithm.leetcode_interview;

public class _02_03 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val; // 当前节点和下一个节点交换值
        node.next = node.next.next; // 删除下一个节点
    }
}
