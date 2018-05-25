package com.zrkj.concurrent;

import javax.xml.transform.Source;

/**
 * 死锁
 */
public class DeadLoackDemo {

    private static Object resource_a = new Object();
    private static Object resource_b = new Object();

    public static void main(String[] args) {
        deadLock();
    }

    private static void deadLock() {
        Thread thread_A = new Thread(()->{
            synchronized (resource_a){
                System.out.println("get resource a");
                try {
                    Thread.sleep(3000);
                    synchronized (resource_b){
                        System.out.println("get resource b");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread_B = new Thread(()->{
            synchronized (resource_b){
                System.out.println("get resource b");
                try {
                    Thread.sleep(3000);
                    synchronized (resource_a){
                        System.out.println("get resource a");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread_A.start();
        thread_B.start();
    }
}
