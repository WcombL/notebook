package com.zrkj.concurrent;

public class SynchronizedDemoSync implements Runnable {
        private static int count = 0;

        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                Thread thread = new Thread(new SynchronizedDemoSync());
                thread.start();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result: " + count);
        }

        @Override
        public void run() {
            synchronized (SynchronizedDemoSync.class){
                for (int i = 0; i < 1000000; i++)
                    count++;
            }
        }
}
