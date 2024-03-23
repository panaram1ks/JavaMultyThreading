package resourceSharing;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();

        IncrementThread incrementThread = new IncrementThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

//        // works not parallel and normal
//        incrementThread.start();
//        incrementThread.join();
//        decrementingThread.start();
//        decrementingThread.join();

        // works parallel and NOT normal
        incrementThread.start();
        decrementingThread.start();
        decrementingThread.join();
        incrementThread.join();

        System.out.println("We currently have " + inventoryCounter.getItems() + " items");
    }

    public static class IncrementThread extends Thread {
        private InventoryCounter inventoryCounter;

        public IncrementThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    public static class DecrementingThread extends Thread {
        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    private static class InventoryCounter {
        private Object lock = new Object();
        private int items = 0;

        public void increment() {
            synchronized (lock) {
                items++;
            }
        }

        public synchronized void decrement() {
            synchronized (lock) {
                items--;
            }
        }

        public int getItems() {
            return items;
        }
    }
}
