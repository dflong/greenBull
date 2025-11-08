package com.dflong.greenbull.leetcode0;

import java.util.HashMap;

public class LRUCache {


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(2, 2);
        int i = lRUCache.get(2);// 返回 1
        lRUCache.put(1, 1);
        lRUCache.put(4, 1);
        int i1 = lRUCache.get(2);// 返回 -1 (未找到)lRUCache = {LRUCache@502}

    }

    int capacity;
    HashMap<Integer, DLinkNode> map;
    DLinkNode hair = null;
    DLinkNode tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        hair = new DLinkNode(-1);
        hair.key = -1;
        tail = new DLinkNode(-1);
        tail.key = -1;
        hair.next = tail;
        tail.prev = hair;
    }

    public void print(){
        DLinkNode hair1 = hair;
        while (hair1 != null) {
            System.out.print(hair1.key + ", ");
            hair1 = hair1.next;
        }
        System.out.println("++++++++++++++");
        DLinkNode tail1 = tail;
        while (tail1 != null) {
            System.out.print(tail1.key + ", ");
            tail1 = tail1.prev;
        }
    }

    public int get(int key) {
        DLinkNode cur = map.get(key);
        if (cur == null) {
            return -1;
        }
        if (hair.next.key == key) {
            return cur.val;
        }
        DLinkNode prev = cur.prev;
        DLinkNode next = cur.next;

        // 删除结点
        prev.next = next;
        next.prev = prev;

        // 新增头结点
        cur.prev = hair;
        cur.next = hair.next;
        hair.next.prev = cur;
        hair.next = cur;

        return cur.val;
    }

    public void put(int key, int value) {
        DLinkNode cur = map.get(key);
        if (cur == null) {
            // 超出最大容量，移除尾元素
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                DLinkNode prev = tail.prev.prev;

                prev.next = tail;
                tail.prev = prev;

            }

            cur = new DLinkNode(value);
            cur.key = key;
            DLinkNode next = hair.next;

            hair.next = cur;
            cur.prev = hair;

            cur.next = next;
            next.prev = cur;

            map.put(key, cur);
        } else {
            cur.val = value;
            // 头元素的下一个就是自己
            if (hair.next.key == key) {
                return;
            }
            DLinkNode prev = cur.prev;
            DLinkNode next = cur.next;

            // 删除结点
            prev.next = next;
            next.prev = prev;

            // 新增头结点
            cur.prev = hair;
            cur.next = hair.next;
            hair.next.prev = cur;
            hair.next = cur;

        }
    }
}

class DLinkNode {
    int val;
    int key;
    DLinkNode next;
    DLinkNode prev;
    public DLinkNode(int val) {
        this.val = val;
    }
}
