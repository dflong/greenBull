package com.dflong.greenbull.leetcode0;

public class _29 {

    public int divide(int dividend, int divisor) {
        boolean negative = false;
        if (dividend < 0) negative = !negative;
        if (divisor < 0) negative = !negative;

        long num1 = Math.abs((long)dividend);

        long res = 0;
        while (num1 > 0) {
            long mutiply = 1;
            long num2 = Math.abs((long)divisor);
            if (num1 < num2) break;
            while (num1 >= num2 + num2) {
                num2 += num2;
                mutiply += mutiply;
            }
            num1 -= num2;
            res += mutiply;
        }

        if (negative) res = - res;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        new _29().divide(10, 3);
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node curr = head, next = head.next;
        while (next != head) {
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = node;
        node.next = next;
        return head;
    }

}



