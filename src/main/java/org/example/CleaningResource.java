package org.example;

public class CleaningResource extends Application implements Runnable {
    @Override
    public void run() {
        while (writeCount < numberNotation) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (object) {
                listId.clear();
                object.notifyAll();
            }
        }
    }
}
