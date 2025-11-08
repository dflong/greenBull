package com.dflong.greenbull.leetcode;

import java.util.Random;

public class _382 {

    class Solution {

        ListNode head;
        Random rand = new Random();

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            int res = 0;
            int i = 1;
            ListNode node = head;
            while (node != null) {
                if (rand.nextInt(i) == 0) {
                    res = node.val;
                }
                node = node.next;
                i ++;
            }

            return res;
        }
    }
}
