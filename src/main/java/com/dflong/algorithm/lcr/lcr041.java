package com.dflong.algorithm.lcr;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class lcr041 {

    class MovingAverage {

        Queue<Integer> queue;
        int size;
        double sum;

        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.poll();
            }
            queue.offer(val);
            sum += val;
            return sum / queue.size();
        }
    }
}
