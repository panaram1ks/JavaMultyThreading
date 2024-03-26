package lockFreeAtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventoryCount inventoryCount = new InventoryCount();
        Decrementor decrementor = new Decrementor(inventoryCount);
        Incrementer incrementer = new Incrementer(inventoryCount);
        decrementor.start();
        incrementer.start();
        decrementor.join();
        incrementer.join();

        System.out.println(inventoryCount.getItems());
    }

    private static class Decrementor extends  Thread{
        private InventoryCount inventoryCount;

        public Decrementor(InventoryCount inventoryCount) {
            this.inventoryCount = inventoryCount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
//                inventoryCount.decrement();
            }
        }
    }

    private static class Incrementer extends Thread {
        private InventoryCount inventoryCount;

        public Incrementer(InventoryCount inventoryCount) {
            this.inventoryCount = inventoryCount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
                inventoryCount.increment();
            }
        }
    }

    private static class InventoryCount {
        private AtomicInteger atomicInteger = new AtomicInteger(0);

        public int increment() {
            return atomicInteger.incrementAndGet();
        }

        public int decrement() {
            return atomicInteger.decrementAndGet();
        }

        public int getItems(){
            return atomicInteger.get();
        }
    }
}
