package com.ksabu.project1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author ksabu00
 * 屏障阻拦
 * 例子：集齐7个葫芦娃才能召唤神龙的故事，当达到设置的线程数量时才会触发最后执行的代码
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println(Thread.currentThread().getName() + "\t 末线程执行");
        });

        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 当前执行的线程为：" + finalI);
                try {
                    cyclicBarrier.await(2, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
