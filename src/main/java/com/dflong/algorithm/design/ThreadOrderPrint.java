package com.dflong.algorithm.design;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程交替打印1-20
 */
public class ThreadOrderPrint {

    int count = 1; // 当前打印的数字
    int maxCount = 20; // 最大打印的数字

    int threadCnt = 3;
    int currentThread = 0; // 当前线程编号

    ReentrantLock lock = new ReentrantLock();
    Condition[] conditions = new Condition[threadCnt];

    public void print() {
        for (int i = 0; i < conditions.length; i++) {
            conditions[i] = lock.newCondition();
        }

        for (int i = 0; i < threadCnt; i++) {
            final int threadId = i;
            new Thread(() -> {
                while (true) {
                    lock.lock();
                    try {
                        while (currentThread != threadId) {
                            if (count > maxCount) {
                                conditions[(threadId + 1) % threadCnt].signal(); // 唤醒下一个线程，避免死锁
                                return;
                            }

                            conditions[threadId].await(); // 当前不是自己执行，等待
                        }
                        if (count > maxCount) {
                            conditions[(threadId + 1) % threadCnt].signal(); // 唤醒下一个线程，避免死锁
                            return;
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + count);
                        count++;
                        currentThread = (currentThread + 1) % threadCnt;
                        conditions[currentThread].signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            }, "thread id " + i).start();
        }
    }

    public static void main(String[] args) {
        new ThreadOrderPrint().print();
    }
}
