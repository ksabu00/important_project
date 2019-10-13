package com.ksabu.project1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther ksabu00
 * 多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 *
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......来10轮
 *
 * 1    高聚低合前提下，线程操作资源类
 * 2    判断/干活/通知
 * 3    多线程交互中，必须要防止多线程的虚假唤醒，也即（判断只用while，不能用if）
 * 4    注意判断标志位的更新
 */
class ShareResource{
    private int flag = 1; // A:1  B:2  C:3

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void print5() {
        lock.lock();
        try {
            // 1 判断
            while (flag !=1) {
                // 暂停
                condition1.await();
            }
            // 2 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3 通知
            flag = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 1 判断
            while (flag !=2) {
                // 暂停
                condition2.await();
            }
            // 2 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3 通知
            flag = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void print15() {
        lock.lock();
        try {
            // 1 判断
            while (flag !=3) {
                // 暂停
                condition3.await();
            }
            // 2 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3 通知
            flag = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource sr = new ShareResource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sr.print5();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sr.print10();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sr.print15();
            }
        }, "CC").start();
    }
}

