package com.company;

public class DataCollect implements Runnable {
    private String filename;
    public DataCollect (String filename) {
        this.filename = filename;
    }
    public void run() {
        try {
//            System.out.println("\tCollecting Data...");
            System.out.println("\tdata collection running on thread: " + Thread.currentThread().getName());
            //Pause a thread with the sleep method
            Thread.sleep(1000);
                System.out.println("\tCompleted Downloading " + filename);
        } catch (InterruptedException e) {
            System.out.println("\n\tCollecting data interrupted");
//            e.printStackTrace();
        }
    }

}
