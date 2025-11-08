package com.dflong.greenbull.leetcode;

public class MyLinkedList {

    // 初始化
    Node hair = null;
    // 数量
    int size = 0;

    public MyLinkedList() {
        hair = new Node(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node cur = hair.next;
        while (index > 0) {
            cur = cur.next;
            index --;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node next = hair.next;
        Node cur = new Node(val);
        hair.next = cur;
        cur.next = next;
        size ++;
    }

    public void addAtTail(int val) {
        Node cur = hair;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(val);
        size ++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        Node cur = hair;
        while (index > 0) {
            cur = cur.next;
            index --;
        }
        Node newNode = new Node(val);
        Node next = cur.next;
        cur.next = newNode;
        newNode.next = next;
        size ++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node pre = hair;

        while (index > 0) {
            pre = pre.next;
            index --;
        }
        pre.next = pre.next.next;
        size --;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
        System.out.println(1);
    }
}
