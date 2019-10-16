package com.ksabu.project1;

/**
 * @author ksabu00
 */
class Animal{
    private String name;
}
public class StackFillException {
    public static void main(String[] args) {

        Object object = new Object();

        System.out.println(object.getClass());
        // Object类的负加载器为BootStrap  输出值为null，因为底层为c++语言实现，无法调用输出
        System.out.println(object.getClass().getClassLoader());
        System.out.println("------");

        Animal animal = new Animal();
        System.out.println(animal.getClass().getClassLoader());
        System.out.println(animal.getClass().getClassLoader().getParent());
        System.out.println(animal.getClass().getClassLoader().getParent().getParent());
    }
}
