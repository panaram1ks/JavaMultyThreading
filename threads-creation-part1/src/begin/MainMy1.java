package begin;/*
 * Copyright (c) 2024. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 * @author E.Parominsky 21/03/2024 16:19
 */
public class MainMy1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in a new Thread " + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getPriority());
                throw new RuntimeException("Internal Exception");
            }
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println("A critical error happened in thread " + thread.getName() + " the error is " + throwable.getMessage());
            }
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new Thread");
        thread.start();
        Thread.sleep(3000);
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new Thread");


    }

}
