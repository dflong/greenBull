package com.dflong.algorithm.lcr;

import java.util.LinkedList;
import java.util.Queue;

public class lcr125 {

    class CQueue {
        Queue<Integer> queue = new LinkedList<>();
        public CQueue() {

        }

        public void appendTail(int value) {
            queue.add(value);
        }

        public int deleteHead() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.remove();
        }
    }
}
