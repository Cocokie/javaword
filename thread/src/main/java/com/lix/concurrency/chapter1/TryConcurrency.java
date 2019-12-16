package com.lix.concurrency.chapter1;

/**
 *
 */
public class TryConcurrency {
    private static void readFormDataBase(){
        try {
            System.out.println("begin");
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
