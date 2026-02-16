package com.dflong.algorithm.leetcode;

public class _430 {

    public static void main(String[] args) {

    }

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        Node last = null; // 返回最后一个节点
        while (head != null) {
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                Node next = head.next; // 记录下一个节点
                Node child = head.child; // 子节点开始节点
                Node childLast = dfs(head.child);

                // 合并
                head.next = child;
                child.prev = head;
                head.child = null;

                childLast.next = next;
                if (next != null) {
                    next.prev = childLast;
                }

                // 更新last
                last = childLast;
                head = next;
            }
        }
        return last;
    }
}

class Node {

    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
