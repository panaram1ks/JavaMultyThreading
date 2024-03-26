package objectsAsConditionVariables;

/**
 * @author E.Parominsky 26/03/2024 09:12
 */
public class MySharedClass {
    private boolean isComplete = false;

    public synchronized void waitUntilComplete() throws InterruptedException {
        while(isComplete == false){
            wait();
        }
    }

//    public void waitUntilComplete() throws InterruptedException {
//        synchronized (this) {
//            while (isComplete == false) {
//                this.wait();
//            }
//        }
//    }

    public synchronized void complete(){
        isComplete = true;
        notify();
    }

//    public void complete() {
//        synchronized (this) {
//            isComplete = true;
//            this.notify();
//        }
//    }
}
