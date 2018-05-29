package com.zrkj.concurrent;

public class SynchronizedDemo2 {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
            method();
        }

    }

    private static void method() {
    }
}
