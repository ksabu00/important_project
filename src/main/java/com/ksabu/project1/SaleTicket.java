package com.ksabu.project1;

/**
 * @author ksabu00
 * 3个售票员，销售30张票,使用同步方法来实现
 * 初级版本程序
 */
class Ticket{
    private int ticket = 30;
    public synchronized void Sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "\t 卖出第" + (ticket--) + " 张票，" + "还剩下票数：" + ticket + "张");
        }
    }
}

public class SaleTicket {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i <40 ; i++) {
                    t.Sale();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i < 40; i++) {
                    t.Sale();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 40; i++) {
                    t.Sale();
                }
            }
        }, "C").start();

    }
}
