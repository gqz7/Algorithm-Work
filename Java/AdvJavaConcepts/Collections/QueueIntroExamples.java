package com.company;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueIntroExamples {
    public static void show() {

        System.out.println("\nQueue Examples Output\n".toUpperCase());

        Queue<Integer> queue = new ArrayDeque<>();

        //use the add method to add elements to a queue
        queue.add(3);
        queue.add(1);
        queue.add(4);
        queue.add(1);
        queue.add(5);
        //one can also use 'offer' which is good when you are adding to a limited queue and dont know when it will hit its limit
        //this is good because offer will just return false, while add will cause an exception to be thrown in this instance

        //use peek to see what element is at the front of a queue
        System.out.println("Element in front of queue: " + queue.peek());

        //peek will return null if the queue is empty, while element has the same functionality but will thrown an exception
        System.out.println("Queue: " + queue);
        System.out.println("Removing the front of the queue");

        //one can use remove or poll to remove the front of a queue,
        //poll will return null if the queue is empty, remove will throw an exception
        //if the queue is not empty they will return the removed element
        queue.remove();
        System.out.println("Queue: " + queue);


        System.out.println("-------------------------------------");
    }

}
