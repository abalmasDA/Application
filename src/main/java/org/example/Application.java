package org.example;

import java.util.ArrayList;

public class Application {

    protected static ArrayList<Integer> listId = new ArrayList<>();
    protected static Object object = new Object();
    protected static int writeCount = 0;
    protected static int numberNotation = 20;


    public ArrayList<Thread> createApplication(WritingFile writingFile, GeneratorId generatorId, CleaningResource cleaningResource) {
        ArrayList<Thread> listThread = new ArrayList<>();
        listThread.add(new Thread(writingFile));
        listThread.add(new Thread(generatorId));
        listThread.add(new Thread(cleaningResource));
        return listThread;
    }

    public void runApplication(ArrayList<Thread> listThread) {
        for (int i = 0; i < listThread.size(); i++) {
            listThread.get(i).start();
        }
    }

}