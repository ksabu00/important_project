package com.ksabu.project1;

/**
 * @author ksabu00
 * 递归调用，最终导致栈帧满了，然后栈溢出
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class StackOverflowDemo {
    public static  void test(){
        test();
    }
    public static void main(String[] args) {
        test();
    }
}
