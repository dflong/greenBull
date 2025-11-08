package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _502 {

    public static void main(String[] args) {
        _502 v = new _502();
        int maximizedCapital = v.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        System.out.println(maximizedCapital);
    }


    List<Pair1> list = new ArrayList<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        for (int i = 0; i < profits.length; i++) {
            list.add(new Pair1(capital[i], profits[i]));
        }
        list.sort((o1, o2) -> {
            if (o1.index == o2.index) {
                return o2.value - o1.value;
            }
            return o1.index - o2.index;
        });

        int j = 0;
        while(k > 0 ) {
            for (int i = j; i < list.size(); i++) {
                Pair1 pair = list.get(i);
                if (w >= pair.index) {
                    queue.offer(pair.value);
                    j ++;
                } else {
                    break;
                }
            }
            if (queue.isEmpty()) {
                return w;
            }
            w += queue.poll();
            k --;
        }
        return w;
    }

}

class Pair1 {
    int index;
    int value;

    Pair1(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
