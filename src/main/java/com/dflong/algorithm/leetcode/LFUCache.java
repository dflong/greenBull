package com.dflong.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    Map<Integer, CacheNode> map;
    Map<Integer, LinkedHashSet<CacheNode>> frequencyMap; // 每个频次对应的Node
    int capacity, size = 0;
    int min; // 最小次数

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        CacheNode cacheNode = map.get(key);
        if (cacheNode == null) {
            return -1;
        }
        incFreq(cacheNode);

        return cacheNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        CacheNode cacheNode = map.get(key);
        if (cacheNode != null) { // 原Node已存在
            cacheNode.value = value;
            incFreq(cacheNode);
        } else {
            if (size == capacity) {
                CacheNode deleteNode = removeNode();
                map.remove(deleteNode.key);
                size --;
            }
            CacheNode newNode = new CacheNode(key, value);
            map.put(key, newNode);
            addNode(newNode);
            size ++;
        }
    }

    // 增加新Node
    private void addNode(CacheNode newNode) {
        LinkedHashSet<CacheNode> cacheNodes = frequencyMap.get(1);
        if (cacheNodes == null) {
            cacheNodes = new LinkedHashSet<>();
            frequencyMap.put(1, cacheNodes);
        }
        cacheNodes.add(newNode);
        min = 1;
    }

    // 删除最小访问频次Node
    private CacheNode removeNode() {
        LinkedHashSet<CacheNode> cacheNodes = frequencyMap.get(min);
        CacheNode next = cacheNodes.iterator().next();
        cacheNodes.remove(next);
        return next;
    }

    // 增加Node使用频次
    private void incFreq(CacheNode cacheNode) {
        int freqCnt = cacheNode.freq;
        LinkedHashSet<CacheNode> cacheNodes = frequencyMap.get(freqCnt);
        cacheNodes.remove(cacheNode); // 删除原频次上的Node

        // 之前是最小频次
        if (freqCnt == min && cacheNodes.isEmpty()) {
            min = freqCnt + 1;
        }

        // 加入新频次Set
        cacheNode.freq ++;
        LinkedHashSet<CacheNode> newCacheNodes = frequencyMap.get(freqCnt + 1);
        if (newCacheNodes == null) {
            newCacheNodes = new LinkedHashSet<>();
            frequencyMap.put(freqCnt + 1, newCacheNodes);
        }
        newCacheNodes.add(cacheNode);
    }
}

class CacheNode {
    int key;
    int value;
    int freq = 1;

    public CacheNode() {}

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

