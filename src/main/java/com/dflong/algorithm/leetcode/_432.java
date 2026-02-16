package com.dflong.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _432 {

    class AllOne {

        Node root; // 只是一个标志，不放节点
        Map<String, Node> map; // key指向哪个节点, 数量相同的key指向同一个节点

        public AllOne() {
            root = new Node();
            map = new HashMap<>();
            root.next = root; // 指向自己
            root.prev = root;
        }

        public void inc(String key) {
            if (map.containsKey(key)) {
                Node cur = map.get(key); // 当前节点
                Node next = cur.next; // 下一节点
                if (next == root || next.cnt > cur.cnt + 1) {
                    // 需要新插入一个节点
                    Node insert = cur.insert(new Node(key, cur.cnt + 1));
                    map.put(key, insert);
                } else {
                    // 放在下一节点
                    next.keys.add(key);
                    map.put(key, next);
                }

                cur.keys.remove(key); // 当前节点的set需移除当前key
                if (cur.keys.isEmpty()) {
                    cur.remove();
                }
            } else {
                Node next = root.next;
                if (next == root || next.cnt > 1) {
                    // 新插入一个节点
                    Node insert = root.insert(new Node(key, 1));
                    map.put(key, insert);
                } else {
                    // 放在下一节点
                    next.keys.add(key);
                    map.put(key, next);
                }
            }
        }

        public void dec(String key) {
            Node cur = map.get(key);
            if (cur.cnt == 1) {
                map.remove(key);
            } else {
                Node prev = cur.prev;
                if (prev == root || prev.cnt < cur.cnt - 1) {
                    // 新插入一个节点
                    Node insert = prev.insert(new Node(key, cur.cnt - 1));
                    map.put(key, insert);
                } else {
                    prev.keys.add(key);
                    map.put(key, prev);
                }
            }
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                cur.remove();
            }
        }

        public String getMaxKey() {
            return root.prev != null ? root.prev.keys.iterator().next() : "";
        }

        public String getMinKey() {
            return root.next != null ? root.next.keys.iterator().next() : "";
        }
    }

    class Node{
        Node prev, next;
        Set<String> keys; // 当前节点有多少key数量是cnt的
        int cnt;

        public Node() {
            this("", 0);
        }

        public Node(String key, int cnt) {
            this.cnt = cnt;
            this.keys = new HashSet<>();
            this.keys.add(key);
        }

        public Node insert(Node node) {
            Node cur = this;
            Node next = cur.next;

            node.prev = cur;
            node.next = next;

            cur.next = node;
            next.prev = node;

            return node;
        }

        // 删除当前节点
        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }
}
