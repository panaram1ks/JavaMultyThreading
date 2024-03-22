/*
 * Copyright (c) 2024. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

package exampleInteraption;

import java.math.BigInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author E.Parominsky 22/03/2024 09:12
 */
public class LongCalculation {

    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000000000000000"), new BigInteger("50000000000")));
        thread.setDaemon(true);
        thread.start();
        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power+  " = " + pow(base, power));
        }

        private  BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)){
//                if(Thread.currentThread().isInterrupted()){
//                    System.out.println("Prematurely interrupted calculation");
//                    return BigInteger.ZERO;
//                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
