package com.dflong.greenbull.leetcode0;

import java.util.HashMap;

public class _138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {

        if (head == null) return null;
        Node cur1 = head;
        Node newHead = new Node(head.val);
        Node cur = newHead;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, newHead);

        while (head.next != null) {
            head = head.next;
            Node newNode = new Node(head.val);
            newHead.next = newNode;
            newHead = newNode;
            map.put(head, newHead);
        }

        newHead = cur;
        while (cur1 != null) {
            if (cur1.random != null) {
                newHead.random = map.get(cur1.random);
            }
            cur1 = cur1.next;
            newHead = newHead.next;
        }

        return cur;
    }
}
