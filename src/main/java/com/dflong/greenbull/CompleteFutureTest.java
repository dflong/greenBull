package com.dflong.greenbull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompleteFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Token token = new Token();

        // 使用默认线程池
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return token.getStr();
            }
        });
//        System.out.println(stringCompletableFuture.get());

        // 自定义线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("do something....");
        }, executorService);

        // 后续处理有返回值
        CompletableFuture<Integer> future2 = future1.thenApply(res -> {
            System.out.println("gjhhbbvv"+res);
            return token.getInt();
        });


        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            // int a = 1/0;
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.handle((result, e) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            return result+2;
        });

        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());

        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf4 do something....");
            return 2;
        });

        CompletableFuture<Integer> cf5 = cf4.thenCombine(cf3, (a, b) -> {
            System.out.println(Thread.currentThread() + " cf5 do something....");
            return a + b;
        });

        System.out.println("cf5结果->" + cf5.get());



    }
}
