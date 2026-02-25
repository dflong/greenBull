package com.dflong.algorithm.lcr;

import com.dflong.algorithm.leetcode0.MedianFinder;

import java.util.PriorityQueue;

public class lcr160 {

    class MedianFinder {

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
}
