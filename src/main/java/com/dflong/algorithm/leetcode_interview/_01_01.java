package com.dflong.algorithm.leetcode_interview;

import java.util.concurrent.*;

public class _01_01 {

    public boolean isUnique(String astr) {
        int[] arr = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int idx = astr.charAt(i) - 'a';
            if (arr[idx] == 1) {
                return false;
            }
            arr[idx] = 1;
        }
        return true;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setMaximumPoolSize(10);
        threadPoolExecutor.setKeepAliveTime(10, TimeUnit.SECONDS);
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadPoolExecutor.setThreadFactory(r -> new Thread(r, "my-thread"));
    }
}
