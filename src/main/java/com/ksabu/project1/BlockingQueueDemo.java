package com.ksabu.project1;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ksabu00
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Object> blockingQueue =  new ArrayBlockingQueue<Object>(3);
        List list = null;

        /**
         * 第三种模式：put-->新增个数小于等于最大个数时不返回任何内容    继续添加程序将不会暂停
         *            take-->删除个数小于等于最大个数时不返回任何内容   继续删除程序将不会暂停
         */
        blockingQueue.put("1");
        blockingQueue.put("2");
        blockingQueue.put("3");
        //blockingQueue.put("4");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        //blockingQueue.take();



        /**
         * 第二种模式 offer 当新增个数大于最大个数时，则返回false，代表添加失败
         *           poll  当个数为0的时候继续poll会返回null
        System.out.println(blockingQueue.offer("1"));
        System.out.println(blockingQueue.offer("2"));
        System.out.println(blockingQueue.offer("3"));
        System.out.println(blockingQueue.offer("4"));

        blockingQueue.peek();

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
         */




        /* 第一种模式 add-->超过最大值则返回Queue Full
                     remove-->删除超过最大数则返回错误 java.util.NoSuchElementException
        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.add("2"));
        System.out.println(blockingQueue.add("3"));
        //System.out.println(blockingQueue.add("4"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());*/

    }
}
