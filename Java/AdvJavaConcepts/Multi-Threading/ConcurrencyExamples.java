package com.company;

public class ConcurrencyExamples {
    public static void showExamples() {

        System.out.println("How many threads are being utilized right now: " + Thread.activeCount());
        System.out.println("How many threads are available total: " + Runtime.getRuntime().availableProcessors());

        for (int i = 1; i <= 12; i++) {
            System.out.println("\n\nRunning A Task On Another Thread");
            Thread downloadTask = new Thread(new DataCollect("file" + i));
            downloadTask.start();
        }


    }
}
