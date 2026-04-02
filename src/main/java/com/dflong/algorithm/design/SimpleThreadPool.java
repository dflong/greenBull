package com.dflong.algorithm.design;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟线程池实现
 * 功能：如果线程数小于核心线程数，就执行，否则等待
 */
public class SimpleThreadPool {

    // 线程池状态
    private volatile boolean isShutdown = false;

    // 核心线程数
    private final int corePoolSize;

    // 当前线程数
    private final AtomicInteger currentThreadCount = new AtomicInteger(0);

    // 工作队列
    private final BlockingQueue<Runnable> workQueue;

    // 工作线程集合
    private final ConcurrentLinkedDeque<Worker> workers = new ConcurrentLinkedDeque<>();

    // 主锁
    private final ReentrantLock mainLock = new ReentrantLock();

    // 条件变量，用于线程等待
    private final Condition notFull = mainLock.newCondition();

    /**
     * 工作线程
     */
    private final class Worker implements Runnable {
        private final Thread thread;
        private Runnable firstTask;
        private volatile boolean completed = false;

        public Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            this.thread = new Thread(this, "Pool-Thread-" + currentThreadCount.getAndIncrement());
        }

        @Override
        public void run() {
            runWorker(this);
        }

        public void start() {
            thread.start();
        }
    }

    /**
     * 构造函数
     * @param corePoolSize 核心线程数
     * @param queueSize 队列大小
     */
    public SimpleThreadPool(int corePoolSize, int queueSize) {
        if (corePoolSize <= 0) {
            throw new IllegalArgumentException("Core pool size must be greater than 0");
        }
        this.corePoolSize = corePoolSize;
        this.workQueue = new LinkedBlockingQueue<>(queueSize);
    }

    /**
     * 提交任务
     * @param task 要执行的任务
     */
    public void execute(Runnable task) {
        if (task == null) {
            throw new NullPointerException("Task cannot be null");
        }

        if (isShutdown) {
            throw new IllegalStateException("Thread pool is shutdown");
        }

        // 如果当前线程数小于核心线程数，创建新线程执行
        if (currentThreadCount.get() < corePoolSize) {
            if (addWorker(task, true)) {
                return;
            }
        }

        // 否则尝试加入队列
        try {
            // 获取锁
            mainLock.lock();
            try {
                // 如果队列已满，等待
                while (workQueue.remainingCapacity() == 0) {
                    System.out.println("Queue is full, waiting for available space...");
                    notFull.await();
                }

                // 加入队列
                if (workQueue.offer(task)) {
                    System.out.println("Task added to queue, queue size: " + workQueue.size());

                    // 如果当前线程数小于核心线程数，创建新的工作线程
                    if (currentThreadCount.get() < corePoolSize) {
                        addWorker(null, false);
                    }
                }
            } finally {
                mainLock.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Task submission interrupted", e);
        }
    }

    /**
     * 添加工作线程
     * @param firstTask 第一个任务
     * @param core 是否为核心线程
     * @return 是否添加成功
     */
    private boolean addWorker(Runnable firstTask, boolean core) {
        if (isShutdown) {
            return false;
        }

        Worker worker = new Worker(firstTask);
        workers.add(worker);
        worker.start();

        System.out.println("Worker started, current thread count: " + currentThreadCount.get());
        return true;
    }

    /**
     * 工作线程执行逻辑
     * @param worker 工作线程
     */
    private void runWorker(Worker worker) {
        Runnable task = worker.firstTask;
        worker.firstTask = null;

        try {
            while (task != null || (task = getTask()) != null) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is executing task");
                    task.run();
                } catch (Exception e) {
                    System.err.println("Task execution failed: " + e.getMessage());
                } finally {
                    task = null;
                }
            }
        } finally {
            worker.completed = true;
            currentThreadCount.decrementAndGet();
            workers.remove(worker);

            // 释放等待条件
            mainLock.lock();
            try {
                notFull.signal();
            } finally {
                mainLock.unlock();
            }
        }
    }

    /**
     * 从队列获取任务
     * @return 任务
     */
    private Runnable getTask() {
        try {
            return workQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    /**
     * 关闭线程池
     */
    public void shutdown() {
        isShutdown = true;

        // 中断所有工作线程
        for (Worker worker : workers) {
            worker.thread.interrupt();
        }

        System.out.println("Thread pool shutdown initiated");
    }

    /**
     * 立即关闭线程池
     * @return 未执行的任务列表
     */
    public List<Runnable> shutdownNow() {
        isShutdown = true;

        List<Runnable> remainingTasks = new ArrayList<>();
        workQueue.drainTo(remainingTasks);

        // 中断所有工作线程
        for (Worker worker : workers) {
            worker.thread.interrupt();
        }

        return remainingTasks;
    }

    /**
     * 等待所有任务完成
     * @param timeout 超时时间
     * @param unit 时间单位
     * @return 是否成功完成
     */
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        long deadline = System.nanoTime() + nanos;

        for (Worker worker : workers) {
            if (worker.completed) {
                continue;
            }

            long remaining = deadline - System.nanoTime();
            if (remaining <= 0) {
                return false;
            }

            synchronized (worker) {
                while (!worker.completed) {
                    long waitTime = Math.min(remaining, TimeUnit.MILLISECONDS.toNanos(100));
                    worker.wait(waitTime / 1000000, (int) (waitTime % 1000000));
                    remaining = deadline - System.nanoTime();
                    if (remaining <= 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // 获取线程池状态信息
    public String getPoolInfo() {
        return String.format(
                "ThreadPool Status: [Threads: %d/%d, Queue: %d/%d, Shutdown: %b]",
                currentThreadCount.get(),
                corePoolSize,
                workQueue.size(),
                workQueue.remainingCapacity() + workQueue.size(),
                isShutdown
        );
    }

    // 使用示例
    public static void main(String[] args) {
        // 创建线程池，核心线程数3，队列大小5
        SimpleThreadPool threadPool = new SimpleThreadPool(3, 5);

        // 提交10个任务
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
                try {
                    // 模拟任务执行时间
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " completed");
            });

            // 打印线程池状态
            System.out.println(threadPool.getPoolInfo());

            // 添加延迟，模拟任务提交间隔
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 等待所有任务完成
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        threadPool.shutdown();
    }
}

/**
 * 另一种更简单的实现，使用内置的ThreadPoolExecutor
 */
class SimpleThreadPoolUsingExecutor {
    private final ThreadPoolExecutor executor;

    public SimpleThreadPoolUsingExecutor(int corePoolSize, int maxQueueSize) {
        this.executor = new ThreadPoolExecutor(
                corePoolSize,      // 核心线程数
                corePoolSize,      // 最大线程数（与核心线程数相同）
                0L,                // 空闲线程存活时间
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(maxQueueSize),  // 有界队列
                new ThreadPoolExecutor.AbortPolicy()       // 拒绝策略
        );
    }

    public void execute(Runnable task) {
        executor.execute(task);
    }

    public void shutdown() {
        executor.shutdown();
    }

    public String getPoolInfo() {
        return String.format(
                "ThreadPool Status: [Active: %d, Pool: %d, Queue: %d]",
                executor.getActiveCount(),
                executor.getPoolSize(),
                executor.getQueue().size()
        );
    }
}

/**
 * 使用示例
 */
class ThreadPoolExample {
    public static void main(String[] args) {
        System.out.println("=== SimpleThreadPool Example ===");
        simpleThreadPoolExample();

        System.out.println("\n=== ThreadPoolExecutor Example ===");
        threadPoolExecutorExample();
    }

    private static void simpleThreadPoolExample() {
        SimpleThreadPool pool = new SimpleThreadPool(3, 5);

        // 提交任务
        for (int i = 0; i < 8; i++) {
            final int taskId = i;
            pool.execute(() -> {
                System.out.println("Executing task " + taskId);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 等待一段时间
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }

    private static void threadPoolExecutorExample() {
        SimpleThreadPoolUsingExecutor pool = new SimpleThreadPoolUsingExecutor(3, 5);

        // 提交任务
        for (int i = 0; i < 8; i++) {
            final int taskId = i;
            pool.execute(() -> {
                System.out.println("Executor task " + taskId);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            // 打印状态
            System.out.println(pool.getPoolInfo());
        }

        // 等待
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }
}
