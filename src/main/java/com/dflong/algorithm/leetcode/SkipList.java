package com.dflong.algorithm.leetcode;

// 节点结构:
// +---------------------------+
// |  key: 5                   |
// |  value: "value-5"         |
// |  forwards: Node[3]        |
// +---------------------------+
//       ↓
// [0] → 下一节点(第0层)
// [1] → 下一节点(第1层)
// [2] → 下一节点(第2层)
// todo 每个节点的 forwards数组存储了该节点在各层的下一个节点指针。数组的长度就是该节点在跳表中的层级。

// Level 3: 3 ----------------------------> 19 -------> 30
//         │                              │           │
// Level 2: 3 --------> 7 --------> 12 --> 19 -------> 30
//         │           │           │      │           │
// Level 1: 3 --> 5 --> 7 --> 9 --> 12 --> 19 --> 21 -> 25 --> 30
//         │     │     │     │     │      │      │     │      │
// Level 0: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30

// Node node3 = {
//    key: 3,
//    value: "value-3",
//    forwards: [node5, node7, node19]  // 长度为3
//    // forwards[0] = node5  (第0层: 3→5)
//    // forwards[1] = node7  (第1层: 3→7)
//    // forwards[2] = node19 (第2层: 3→19)
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList <K extends Comparable<K>, V> {

    // 基于redis参数
    private static final int MAX_LEVEL = 32;
    private static final double P = 0.25;
    private static Random random = new Random();

    // 跳表节点
    private static class SkipListNode<K extends Comparable<K>, V> {
        K key;
        V val;

        SkipListNode<K, V>[] forwards;

        public SkipListNode(K key, V val, int level) {
            this.key = key;
            this.val = val;
            this.forwards = new SkipListNode[level];
        }
    }

    private final SkipListNode<K, V> head;

    private int level; // 当前最高层级

    private int size; // 跳表中节点的数量

    public SkipList() {
        this.level = 1;
        this.size = 0;
        // 初始化头节点
        this.head = new SkipListNode<>(null, null, MAX_LEVEL);
    }


    // ----------------------------------实现-------------------------------------

    // 获取下一个元素层级
    private int randomLevel() {
        int level = 1;
        while (random.nextDouble() < P && level < MAX_LEVEL) {
            level ++;
        }
        return level;
    }

    public V get(K key) {
        SkipListNode<K, V> p = head;
        for (int i = level - 1; i >= 0; i --) {
            while (p.forwards[i] != null && p.forwards[i].key.compareTo(key) < 0) {
                p = p.forwards[i]; // 在当前层向后
            }
            // 指向下一层
        }
        // 这里已经指向最后一层，而且是小于key的第一个节点
        if (p.forwards[0] != null && p.forwards[0].key.compareTo(key) == 0) {
            return p.forwards[0].val;
        }
        return null;
    }

    public void put(K key, V val) {
        // 是新节点的前驱节点
        SkipListNode<K, V>[] update = new SkipListNode[MAX_LEVEL];

        SkipListNode<K, V> p = head;
        for (int i = level - 1; i >= 0; i --) {
            while (p.forwards[i] != null && p.forwards[i].key.compareTo(key) < 0) {
                p = p.forwards[i];
            }
            // p.forwards[i]是大于的第一个节点，则p是新节点的前驱节点
            update[i] = p;
        }

        // todo 如果key已经存在，则更新
        if (p.forwards[0] != null && p.forwards[0].key.compareTo(key) == 0) {
            p.forwards[0].val = val;
            return;
        }

        int newLv = randomLevel();
        if (newLv > level) { // 已经超出最大层级了，则需要更新层级
            for (int i = level; i < newLv; i ++) {
                update[i] = head;
            }
            level = newLv;
        }

        SkipListNode<K, V> newNode = new SkipListNode<>(key, val, newLv);
        for (int i = 0; i < newLv; i ++) {
            newNode.forwards[i] = update[i].forwards[i]; // 新节点的后驱是前驱的后驱
            update[i].forwards[i] = newNode; // 前驱的后驱是新节点
        }

        size ++;
    }

    public boolean remove(K key) {
        // 待删除节点的前驱节点
        SkipListNode<K, V>[] update = new SkipListNode[MAX_LEVEL];


        SkipListNode<K, V> p = head;
        for (int i = level - 1; i >= 0; i --) {
            while (p.forwards[i] != null && p.forwards[i].key.compareTo(key) < 0) {
                p = p.forwards[i];
            }
            // p.forwards[i]是大于的第一个节点，则p是待删除节点的前驱节点
            update[i] = p; // 最差是head节点
        }

        p = p.forwards[0];
        // 不存在
        if (p == null || p.key != key) {
            return false;
        }

        for (int i = 0; i < level; i ++) {
            if (update[i].forwards[i] != p) {
                break; // 从最底层向上搜索，如果当前层已经不包含，则更上层不会出现
            }
            // 跳过当前节点
            update[i].forwards[i] = p.forwards[i];
        }

        // 头节点已经没有后驱节点了，则减少层级
        while (level > 1 && head.forwards[level - 1] == null) {
            level --;
        }

        size --;
        return false;
    }

    public List<V> range(K start, K end) {
        List<V> res = new ArrayList<>();

        SkipListNode<K, V> p = find(start);

        while (p != null && p.key.compareTo(end) <= 0) {
            res.add(p.val);
            p = p.forwards[0];
        }

        return res;
    }

    private SkipListNode<K, V> find(K key) {
        SkipListNode<K, V> p = head;
        for (int i = level - 1; i >= 0 ; i --) {
            while (p.forwards[i] != null && p.forwards[i].key.compareTo(key) < 0) {
                p = p.forwards[i];
            }
        }

        return p.forwards[0];
    }

}
