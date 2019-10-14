package com.ksabu.project1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author ksabu00
 * 例子：当下晚自习后，只有当所有同学走完后班长才能关好门然后再离开
 * 简而言之：有一个线程必须最后执行，那么在最后执行的代码前阻止其执行就ok了
 *  CountDownLatch在初始化的时候就会传入一个int类型的参数
 *  方法countDown()每执行一次都会自减1
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(7);

        for (int i = 1; i <= 6; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 当前执行的线程是:" + finalI);
                cdl.countDown();
            }, String.valueOf(i)).start();
        }
        // 自动判断线程是否全部执行完毕,当count值不为0的时候不会执行await后的线程，一直处于死等的状态
        //cdl.await();
        cdl.await(2, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName() + "\t 末线程-关闭离开");
    }
}
