package com.dflong.algorithm.lcr;

import java.util.Arrays;
import java.util.LinkedList;

public class lcr123 {

    public int[] reverseBookList(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.addFirst(head.val);
            head = head.next;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
