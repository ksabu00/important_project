package com.ksabu.zk;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ksabu00
 */
public class OrderService {
    GetNumUtil numUtil = new GetNumUtil();
    //private Lock lock = new ReentrantLock();
     ZKLock lock = new ZkDistributedLock();
    public void getOrderNumber() {
        try {
            lock.lock();
            numUtil.getOrderNum();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //OrderService orderService =  new OrderService();
        for (int i = 1; i <= 20; i++) {

            new Thread(() -> {
                new OrderService().getOrderNumber();
            }, String.valueOf(i)).start();
        }
    }

    /*public String getOrderNumber() {
        try {
            lock.lock();
            return numUtil.getOrderNum();
        } finally {
            lock.unlock();
        }
    }



    public static void main(String[] args) {
        OrderService orderService =  new OrderService();
        for (int i = 1; i <= 20; i++) {

            new Thread(() -> {
                System.out.println(orderService.getOrderNumber());
            }, String.valueOf(i)).start();
        }
    }*/


    /*GetNumUtil numUtil = new GetNumUtil();
    public String getOrderNumber(){
        return numUtil.getOrderNum();
    }



    public static void main(String[] args) {
        OrderService orderService =  new OrderService();
        for (int i = 1; i <= 20; i++) {

            new Thread(() -> {
                System.out.println(orderService.getOrderNumber());
            }, String.valueOf(i)).start();
        }
    }*/
}
