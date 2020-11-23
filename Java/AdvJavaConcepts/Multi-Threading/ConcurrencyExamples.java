package com.company;

public class ConcurrencyExamples {
    public static void showExamples() {


        System.out.println("How many threads are being utilized right now: " + Thread.activeCount());
        System.out.println("How many threads are available total: " + Runtime.getRuntime().availableProcessors());
        //all the processes that occur here will start one after the other without waiting for the others to finish
        //this means they all start and end around the same time, but never in a guaranteed order
        //the only reason they all end at the same time is because their task is not demanding and is completed very quickly after the artificial waiting time
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nRunning A Task On Another Thread");
            Thread collectingTask = new Thread(new DataCollect("file" + i));
            collectingTask.start();
        }

        //to have task occur synchronously use the 'join' method
        //this will start each task only after the last one has finished, since these thread tasks are considered linked to each other
        for (int i = 5; i <= 10; i++) {
            try {
                System.out.println("\n\nRunning A Task On Another Thread");
                Thread collectingTask = new Thread(new DataCollect("file" + i));
                collectingTask.start();
                collectingTask.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //use the interrupt method on a thread to stop its process while it is being executed,
        //the thread's processing code will need to check the 'isInterrupted' method to see if the thread has been interrupted
        Thread interruptedThread = new Thread(new DataCollect("file404"));
        interruptedThread.start();
        interruptedThread.interrupt();



    }
}
