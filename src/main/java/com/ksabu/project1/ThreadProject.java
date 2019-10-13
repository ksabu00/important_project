package com.ksabu.project1;

/**
 * @author ksabu00
 */
public class ThreadProject implements Runnable{
    int ticket = 100;
    static Object obj = new Object();
    public void run() {
        while (true) {
            // obj为同步监视器，也可以是this
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadProject w = new ThreadProject();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        t1.start();
    }
}
