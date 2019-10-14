package com.ksabu.project1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ksabu00
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * 模拟银行排队初级版本
         * 3个窗口
         * 20个客户
         */

        // ExecutorService threadPool =  Executors.newSingleThreadExecutor(); //一个银行网点，1个受理业务的窗口
        //xecutorService threadPool =  Executors.newCachedThreadPool(); //一个银行网点，可扩展受理业务的窗口
        ExecutorService executorService = Executors.newFixedThreadPool(3);//一个银行网点，3个受理业务的窗口
        try {
            for (int i = 1 ; i < 20; i++) {//模拟20个客户来银行办理业务，提交请求。customer
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
