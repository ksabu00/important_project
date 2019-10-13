package com.ksabu.project1;

import java.util.concurrent.TimeUnit;

/**
 * @author ksabu00
 * 深入讲解Synchronized
//

import java.util.concurrent.TimeUnit;

/**
 *
 * 题目：多线程8锁
 * 1  标准访问，请问先打印邮件还是短信？                                  邮件   Synchronized的方法被锁的是整个类
 * 2  邮件新增暂停4秒钟的方法，请问先打印邮件还是短信？                    邮件   锁掉的是方法，还是一样打印出邮件
 * 3  新增普通的hello方法，请问先打印邮件还是hello				        Hello方法     非Synchronized的方法不会抢占资源，时间效应打印Hello
 * 4  有两部手机，请问先打印邮件还是短信？					            短信   不抢占资源，各司其职，时间效应短信优先
 * 5  两个静态同步方法，同一部手机，请问先打印邮件还是短信？                邮件    static修饰的syn方法其锁的是对象的类型
 * 6  两个静态同步方法，2部手机，请问先打印邮件还是短信？			        邮件   锁的是Class  与对象无关
 * 7  1个静态同步方法,1个普通同步方法，1部手机，请问先打印邮件还是短信？    SMS 各司其职，无关联
 * 8  1个静态同步方法,1个普通同步方法，2部手机，请问先打印邮件还是短信？    SMS 各司其职，无关联
 *
 **/
class Phone{
    public static synchronized void sendEmail() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("邮件");
    }
    public synchronized void sendSms() {
        System.out.println("短信");
    }
    public void Hello() {
        System.out.println("hello");
    }
}


public class Lock8 {
    public static void main(String[] args) throws Exception {
        Phone p = new Phone();
        Phone p1 = new Phone();

        new Thread(() -> {
            try {
                p.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(300);

        new Thread(() -> {
            try {
                p.sendSms();
                //p.Hello();
                //p1.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}