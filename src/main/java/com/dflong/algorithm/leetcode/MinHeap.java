package com.dflong.algorithm.leetcode;

// 最小堆，堆顶元素最小
public class MinHeap {

    int size;
    int[] heap;

    private static final int DEFAULT_CAPACITY = 10;

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
    }

    public MinHeap(int[] arr) {
        this.heap = new int[arr.length * 2]; // 扩容为2倍
        this.size = arr.length;
        System.arraycopy(arr, 0, heap, 0, arr.length);
        heapFy();
    }

    public void add(int val) {
        ensureCapacity(); // 扩容

        // 将元素放在最后一个位置，上移
        heap[size] = val;
        siftUp(size);
        size ++;
    }

    public int peek() {
        return heap[0];
    }

    public int poll() {
        int val = heap[0];
        // 将最后一个元素放到堆顶，下移
        heap[0] = heap[size - 1];
        size --;
        if (size > 0) {
            siftDown(0);
        }
        return val;
    }


    // 插入 上移
    // 如果节点值 < 父节点值，交换
    private void siftUp(int idx) {
        int val = heap[idx]; // 当前节点值
        while (idx > 0) {
            int parentIndex = (idx - 1) / 2;
            if (val >= heap[parentIndex]) {
                break;
            }
            heap[idx] = heap[parentIndex]; // 父节点下移
            idx = parentIndex;
        }
        heap[idx] = val; // 插入当前节点
    }

    // 删除 下移
    // 如果节点值 > 子节点值，交换
    private void siftDown(int idx) {
        int val = heap[idx];
        while (idx < size / 2) {
            int childIdx = idx * 2 + 1; // 左节点
            // 右节点比左节点还小
            if (childIdx + 1 < size && heap[childIdx + 1] < heap[childIdx]) {
                childIdx ++; // 使用右节点
            }
            if (val <= heap[childIdx]) {
                break;
            }
            heap[idx] = heap[childIdx];
            idx = childIdx;
        }
        heap[idx] = val;
    }

    // 堆化 数组调整为堆
    // 从最后一个非叶子节点开始，下移
    private void heapFy() {
        int idx = size / 2 - 1;
        while (idx >= 0) {
            siftDown(idx);
            idx --;
        }
    }

    private void ensureCapacity() {
        if (size == heap.length) {
             int[] newHeap = new int[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
    }
}
