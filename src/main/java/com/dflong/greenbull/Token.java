package com.dflong.greenbull;

import java.util.concurrent.*;

/**
 * 限流
 */
public class Token {

    public static int getInt() {
        return 2889;
    }

    public static String getStr() {
        return "token的String返回值";
    }

    public static void getNull() {
        System.out.println("没有返回值");
    }

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> result = CompletableFuture
                .supplyAsync(() -> getInt())
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> getStr()),
                        (dbResult, apiResult) -> dbResult + "|" + apiResult
                )
                .thenApply(combined -> combined + "|processed")
                .exceptionally(ex -> "错误恢复: " + ex.getMessage());

        result.thenAccept(finalResult -> System.out.println(finalResult));


        //令牌桶，信号量实现，容量为3
        final Semaphore semaphore = new Semaphore(3);

        //定时器，1s一个，匀速颁发令牌
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (semaphore.availablePermits() < 3){
                    semaphore.release();
                }
//                System.out.println("令牌数："+semaphore.availablePermits());
            }
        },100000,100000, TimeUnit.MILLISECONDS);


        //等待，等候令牌桶储存
        Thread.sleep(5);
        //模拟洪峰5个请求，前3个迅速响应，后两个排队
        for (int i = 0; i < 50; i++) {
            semaphore.acquire();
            System.out.println("洪峰："+i);
        }
        //模拟日常请求，2s一个
        for (int i = 0; i < 30; i++) {
            Thread.sleep(1000);
            semaphore.acquire();
            System.out.println("日常："+i);
            Thread.sleep(1000);
        }
        //再次洪峰
        for (int i = 0; i < 5; i++) {
            semaphore.acquire();
            System.out.println("洪峰："+i);
        }
        //检查令牌桶的数量
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            System.out.println("令牌剩余："+semaphore.availablePermits());
        }
    }

}
