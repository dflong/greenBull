package com.dflong.greenbull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AllOf {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 自定义线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread() + " cf1 do something....");
                System.out.println("cf1 任务完成");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "cf1 任务完成";
            }, executorService);

            CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread() + " cf2 do something....");
//                int a = 1/0;
                System.out.println("cf2 任务完成");
                return "cf2 任务完成";
            }, executorService);

            CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread() + " cf3 do something....");

                System.out.println("cf3 任务完成");
                return "cf3 任务完成";
            }, executorService);

            CompletableFuture<Void> cfAll = CompletableFuture.allOf(cf1, cf2, cf3).handle((result, ex) -> {
                if (ex == null) {
                    try {
                        return "处理后的正常结果：" + cf1.get() + cf2.get() + cf3.get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    return "处理后的异常结果：" + ex.getMessage();
                }
            }).thenAccept(System.out::println);

        } finally {
            executorService.shutdown();
            System.out.println("................................");
        }

    }
}
