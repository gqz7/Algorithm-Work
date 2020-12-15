package com.company.system;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookInventory {
    private volatile int availableBooks = 10;

    public void checkoutBook (String name, int numOfBooks) {
        System.out.println(availableBooks);
        if (availableBooks >= numOfBooks && numOfBooks > 0) {
            System.out.println("Thanks " + name + ". You got " + numOfBooks + " more books to read now.");
            availableBooks -= numOfBooks;
        } else {
            System.out.println("Unfortunately, we cannot fulfill this request, to many books!");
        }
    }

    public int getAvailableBooks() {
        return availableBooks;
    }
}

//synchronized:
//    public synchronized void checkoutBook (String name, int numOfBooks) {
//        System.out.println(availableBooks);
//        if (availableBooks >= numOfBooks && numOfBooks > 0) {
//            System.out.println("Thanks " + name + ". You got " + numOfBooks + " more books to read now.");
//            availableBooks -= numOfBooks;
//        } else {
//            System.out.println("Unfortunately, we cannot fulfill this request, to many books!");
//        }
//    }


//locking:
//  Lock lock = new ReentrantLock();
//    public void checkoutBook (String name, int numOfBooks) {
//        lock.lock();
//        try {
//            System.out.println(availableBooks);
//            if (availableBooks >= numOfBooks && numOfBooks > 0) {
//                System.out.println("Thanks " + name + ". You got " + numOfBooks + " more books to read now.");
//                availableBooks -= numOfBooks;
//            } else {
//                System.out.println("Unfortunately, we cannot fulfill this request, to many books!");
//            }
//        } finally {
//            lock.unlock();
//        }
//    }

//atomic:
//private AtomicInteger availableBooks = new AtomicInteger(10);
//
//    public void checkoutBook (String name, int numOfBooks) {
//        System.out.println(availableBooks);
//        if (availableBooks.get() >= numOfBooks && numOfBooks > 0) {
//            System.out.println("Thanks " + name + ". You got " + numOfBooks + " more books to read now.");
//            availableBooks.set(availableBooks.get() -  numOfBooks);
//        } else {
//            System.out.println("Unfortunately, we cannot fulfill this request, to many books!");
//        }
//    }
//
//    public int getAvailableBooks() {
//        return availableBooks.get();
//    }