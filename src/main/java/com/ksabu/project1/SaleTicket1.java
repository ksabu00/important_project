package com.ksabu.project1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ksabu00
 * 3个售票员销售30张票，使用ReentrantLock来实现
 * 中级版本
 */
class Ticket1 {
    private int ticket = 30;
    Lock lock = new ReentrantLock();

    public void Sale() {
        lock.lock();
        try {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第" + (ticket--) + " 张票，" + "还剩下票数：" + ticket + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class SaleTicket1 {
    public static void main(String[] args) {
        Ticket1 t = new Ticket1();
        /**
         * Lambda Express（前提是函数式接口，只有一个方法）
         * 拷贝小括号，写死右箭头，落地大括号
         */
        new Thread(() -> {for (int i = 1; i <= 40; i++)t.Sale();}, "A").start();
		new Thread(() -> {for (int i = 1; i <= 40; i++)t.Sale();}, "B").start();
		new Thread(() -> {for (int i = 1; i <= 40; i++)t.Sale();}, "C").start();
    }
}
