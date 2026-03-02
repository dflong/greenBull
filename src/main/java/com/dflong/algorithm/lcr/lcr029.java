package com.dflong.algorithm.lcr;

public class lcr029 {

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node curr = head, next = head.next;
        while (next != head) {
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val && insertVal > curr.val) {
                break;
            }
            if (curr.val > next.val && insertVal < next.val) {
                break;
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = node;
        node.next = next;
        return head;
    }
}
class Node {

    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}
