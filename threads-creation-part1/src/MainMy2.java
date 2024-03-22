/*
 * Copyright (c) 2024. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 * @author E.Parominsky 21/03/2024 17:28
 */
public class MainMy2 {

    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }


    public static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + this.currentThread().getName());
        }
    }
}
