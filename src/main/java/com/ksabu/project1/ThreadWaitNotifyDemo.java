package com.ksabu.project1;

/**
 * @author ksabu00
 * 生成者消费者问题（存在问题版本）
 * 当两个线程来分别执行生消时，不存在任何问题，使用if判断不存在安全问题
 * 四个线程来调用时就会出现问题
 */
class sx{
    private int total = 0;

    public synchronized void pro() {
        // 生产者
        if (total != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        total++;
        System.out.println(Thread.currentThread().getName()+"\t"+total);
        this.notifyAll();
    }
    public synchronized void cus() {
        // 消费者
        if (total == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        total--;
        System.out.println(Thread.currentThread().getName()+"\t"+total);
        this.notifyAll();
    }
}



/** 生产者消费者简单模式
 // 高聚低合前提下，线程操作资源类
 // 判断/干活/通知

 * @author 18229
 *
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        sx s = new sx();

        // 生产
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                s.pro();
            }
        }, "A").start();

        // 消费
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                s.cus();
            }
        }, "B").start();

        /*
        // 生产
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                s.pro();
            }
        }, "C").start();

        // 消费
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                s.cus();
            }
        }, "D").start();
        */
    }
}

