package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _1206 {

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.add(0);
        skiplist.add(4);
        boolean erase = skiplist.erase(0);
        boolean search = skiplist.search(1);
        boolean erase1 = skiplist.erase(1);
        boolean search1 = skiplist.search(1);
        System.out.println(skiplist.search(0));
    }
}

// 跳表节点
class SkiplistNode {
    int key;
    int val;

    SkiplistNode[] forwards;

    public SkiplistNode(int key, int level) {
        this.key = key;
        this.forwards = new SkiplistNode[level];
    }
}

class Skiplist {

    // 基于redis参数
    private static final int MAX_LEVEL = 32;
    private static final double P = 0.25;
    private static Random random = new Random();

    private final SkiplistNode head;

    private int level; // 当前最高层级

    public Skiplist() {
        this.level = 0;
        // 初始化头节点
        this.head = new SkiplistNode(- 1, MAX_LEVEL);
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

    public boolean search(int key) {
        SkiplistNode p = head;
        for (int i = level - 1; i >= 0; i --) {
            while (p.forwards[i] != null && p.forwards[i].key < key) {
                p = p.forwards[i]; // 在当前层向后
            }
            // 指向下一层
        }
        // 这里已经指向最后一层，而且是小于key的第一个节点
        if (p.forwards[0] != null && p.forwards[0].key == key) {
            return true;
        }
        return false;
    }

    public void add(int key) {
        // 是新节点的前驱节点
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];

        SkiplistNode p = head;
        for (int i = level - 1; i >= 0; i --) {
            while (p.forwards[i] != null && p.forwards[i].key < key) {
                p = p.forwards[i];
            }
            // p.forwards[i]是大于的第一个节点，则p是新节点的前驱节点
            update[i] = p;
        }

        int newLv = randomLevel();
        if (newLv > level) { // 已经超出最大层级了，则需要更新层级
            for (int i = level; i < newLv; i ++) {
                update[i] = head;
            }
            level = newLv;
        }

        SkiplistNode newNode = new SkiplistNode(key, newLv);
        for (int i = 0; i < newLv; i ++) {
            newNode.forwards[i] = update[i].forwards[i]; // 新节点的后驱是前驱的后驱
            update[i].forwards[i] = newNode; // 前驱的后驱是新节点
        }

    }

    public boolean erase(int key) {
        // 待删除节点的前驱节点
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];


        SkiplistNode p = head;
        for (int i = level - 1; i >= 0; i --) {
            while (p.forwards[i] != null && p.forwards[i].key < key) {
                p = p.forwards[i];
            }
            // p.forwards[i]是大于的第一个节点，则p是待删除节点的前驱节点
            update[i] = p;
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

        return true;
    }

}
