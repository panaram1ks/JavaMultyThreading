/*
 * Copyright (c) 2024. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

package joiningThreads;
import java.math.BigInteger;

/**
 * @author E.Parominsky 22/03/2024 12:10
 */
public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result;

        PowerCalculatingThread first = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread second = new PowerCalculatingThread(base2, power2);

        first.start();
        second.start();

        first.join();
        second.join();

        result = first.getResult().add(second.getResult());
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            int intExponent = power.intValueExact();
            result = base.pow(intExponent);
           /*
           Implement the calculation of result = base ^ power
           */
        }

        public BigInteger getResult() { return result; }
    }
}
