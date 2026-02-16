package com.dflong.algorithm.leetcode0;

import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
           // arr = [1, 2]
        double median = medianFinder.findMedian();// 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        double median1 = medianFinder.findMedian();// return 2.0
    }

    public double findMedian() {
        if (minPq.size() > maxPq.size()) {
            return minPq.peek();
        }
        return (minPq.peek() + maxPq.peek()) / 2.0;
    }

    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    public MedianFinder() {
        minPq = new PriorityQueue<Integer>();
        maxPq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
    }

    //
    public void addNum(int num) {
        if (minPq.isEmpty() || num > minPq.peek()) {
            minPq.add(num);
            if (minPq.size() > maxPq.size() + 1) {
                maxPq.add(minPq.poll());
            }
        } else {
            maxPq.add(num);
            if (maxPq.size() > minPq.size()) {
                minPq.add(maxPq.poll());
            }
        }
    }

}
