package org.example;

import java.util.Random;

public class GeneratorId extends Application implements Runnable {

    @Override
    public void run() {
        Random random = new Random();
        while (writeCount < numberNotation) {
            int randomId = random.nextInt(100);
            synchronized (object) {
                listId.add(randomId);
                object.notifyAll();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
