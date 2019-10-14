package com.ksabu.project1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ksabu00
 * 多线程创建的第三种方式
 */

/*class MyThread implements Callable<String>{

        @Override
        public String call() throws Exception {
        return "java0615";
    }
}*/
public class CallAbleDemo {
    public static void main(String[] args) throws Exception {
        /*FutureTask<String> futureTask =  new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "0615";
            }
        });*/

        FutureTask<String> futureTask =  new FutureTask<String>(() -> {
            return  "0615";
        });
        new Thread(futureTask, "AA").start();

        String result = futureTask.get();

        System.out.println(result);

        System.out.println("****主线程" + Thread.currentThread().getName());
    }
}
