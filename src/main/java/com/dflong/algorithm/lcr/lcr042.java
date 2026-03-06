package com.dflong.algorithm.lcr;

import java.util.LinkedList;
import java.util.Queue;

public class lcr042 {

    class RecentCounter {

        public RecentCounter() {

        }

        Queue<Integer> queue = new LinkedList<Integer>();

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }

            return queue.size();
        }
    }
}
