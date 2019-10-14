package com.ksabu.project1;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author ksabu00
 * 例子：3个车位，6台车抢占车位
 */
public class SemaPhoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i < 7; i++) {
            int finalI = i;
            new Thread(() -> {
                boolean flag = false;
                try {
                    // 线程执行，消耗一个车位
                    semaphore.acquire();
                    flag = true;
                    System.out.println(Thread.currentThread().getName() + "\t停车成功->" + finalI);
                    // 停车0-9秒
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    // 然后离开车位
                    System.out.println(Thread.currentThread().getName() + "\t"+ finalI + " -----离开车位");
                    // 离开车位后即通知其他车主停车
                    if (flag == true){
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
