package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WritingFile extends Application implements Runnable {
    @Override
    public void run() {
        while (writeCount < numberNotation) {
            Integer id;
            synchronized (object) {
                while (listId.isEmpty() && writeCount < numberNotation) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (writeCount >= numberNotation) {
                    break;
                }
                id = listId.remove(0);
            }
            try (FileWriter fileWriter = new FileWriter("result.txt", true)) {
                fileWriter.write("ID: " + id + " Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
                System.out.println("Строка " + writeCount + " успішно записана!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                writeCount++;
                object.notifyAll();
            }
        }
        System.out.println("Файл записаний.");
        System.exit(0);
    }
}
