package com.lix.threadpool;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-03-26 11:17
 **/
public class ControlCenter {


    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool(10);
        System.out.println(simpleThreadPool.getCurrentSize());
        //Thread.sleep(2000);
        for (int i = 0; i < 50; i++) {
            simpleThreadPool.submitTask(() -> {
                System.out.println(Thread.currentThread().getName() + "          hahaha");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            });
        }

        simpleThreadPool.shutDown();
        //Thread.sleep(1000);
        System.out.println(simpleThreadPool.getCurrentSize());
        System.out.println(simpleThreadPool.getDestroy());
    }
}
