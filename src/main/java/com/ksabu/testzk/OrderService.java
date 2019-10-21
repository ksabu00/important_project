package com.ksabu.testzk;

/**
 * @author ksabu00
 */
public class OrderService {
    OrderNumberGenerateUtil orderNumberGenerateUtil = new OrderNumberGenerateUtil();

    private ZKLock zkLock = new ZkDistributedLock();

    public void getOrderNumber(){
        zkLock.lock();
        try {
            System.out.println(orderNumberGenerateUtil.getOrderNumber());
        } finally {
            zkLock.unlock();
            System.out.println(Thread.currentThread().getName() + "\t" + "释放锁成功");
        }
    }
    public static void main(String[] args) {
        //OrderService orderService = new OrderService();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                new OrderService().getOrderNumber();
            },String.valueOf(i)).start();
            System.out.println();
            System.out.println();
        }
    }





    /*加锁版抢购，且数据源为全新的OrderService()
    private Lock lock = new ReentrantLock();

    public String getOrderNumber(){
        try {
            lock.lock();
            return  orderNumberGenerateUtil.getOrderNumber();
        	} finally {
        		lock.unlock();
        	}


    }
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                String result = new OrderService().getOrderNumber();
                System.out.println("订单标号：" + result);
            },String.valueOf(i)).start();
        }
    }*/


    /*普通版本
    public String getOrderNumber(){

        return  orderNumberGenerateUtil.getOrderNumber();
    }
    public static void main(String[] args) {
       OrderService orderService = new OrderService();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                String result = orderService.getOrderNumber();
                System.out.println("订单标号：" + result);
            },String.valueOf(i)).start();
        }
    }*/
}
