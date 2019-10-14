package com.ksabu.project1;

        import java.util.Random;
        import java.util.concurrent.*;

/**
 * @author ksabu00
 */
public class MyThreadPoolDemo1 {
    public static void main(String[] args) {
        /**
         * 模拟银行排队初级版本
         * 3个窗口
         * 20个客户
         */

        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 1 ; i < 16; i++) {//模拟20个客户来银行办理业务，提交请求。customer
                int finalI = i;
                executorService.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + finalI + "号客户办理业务" +
                            new Random().nextInt(10));
                }, String.valueOf(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
