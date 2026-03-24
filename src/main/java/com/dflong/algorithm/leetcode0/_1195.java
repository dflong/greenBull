package com.dflong.algorithm.leetcode0;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class _1195 {

    class FizzBuzz {
        private int n;

        AtomicInteger cur = new AtomicInteger(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (cur.get() <= n) {
                if (cur.get() % 3 == 0 && cur.get() % 5 != 0) {
                    printFizz.run();
                    cur.incrementAndGet();
                } else {
                    Thread.yield();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (cur.get() <= n) {
                if (cur.get() % 3 != 0 && cur.get() % 5 == 0) {
                    printBuzz.run();
                    cur.incrementAndGet();
                } else {
                    Thread.yield();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (cur.get() <= n) {
                if (cur.get() % 3 == 0 && cur.get() % 5 == 0) {
                    printFizzBuzz.run();
                    cur.incrementAndGet();
                } else {
                    Thread.yield();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (cur.get() <= n) {
                if (cur.get() % 3 != 0 && cur.get() % 5 != 0) {
                    printNumber.accept(cur.get());
                    cur.incrementAndGet();
                } else {
                    Thread.yield();
                }
            }
        }
    }
}
