package com.dflong.greenbull.leetcode0;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        Node hair = myLinkedList.hair;
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        int i = myLinkedList.get(1);
        myLinkedList.deleteAtIndex(0);
        i = myLinkedList.get(0);
    }


    // 初始化
    Node hair = null;
    // 数量
    int size = 0;

    public MyLinkedList() {
        hair = new Node(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node cur = hair;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = hair.next;
        hair.next = newNode;
        size ++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node cur = hair;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size ++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        Node cur = hair;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node newNode = new Node(val);
        newNode.next = cur.next;
        cur.next = newNode;

        size ++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node cur = hair;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size --;
    }

}

