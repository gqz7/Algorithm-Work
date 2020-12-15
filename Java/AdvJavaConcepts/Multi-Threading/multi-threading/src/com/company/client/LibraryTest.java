package com.company.client;

import com.company.system.BookCheckoutThread;
import com.company.system.BookInventory;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    public static void main(String[] args) {
        BookInventory bookInventory = new BookInventory();
        BookCheckoutThread thread1 = new BookCheckoutThread(bookInventory, "Margie", 3);
        BookCheckoutThread thread2 = new BookCheckoutThread(bookInventory, "Gabe", 3);
        BookCheckoutThread thread3 = new BookCheckoutThread(bookInventory, "Billy", 3);
        BookCheckoutThread thread4 = new BookCheckoutThread(bookInventory, "Cliff", 3);
        BookCheckoutThread thread5 = new BookCheckoutThread(bookInventory, "Arnell", 1);


        List<Thread> threadList = new ArrayList<>();
        threadList.addAll(List.of(thread1,thread2, thread3, thread4, thread5));

        for (Thread thread: threadList) {
            thread.start();
        }


        System.out.println("Final inven: " + bookInventory.getAvailableBooks());

    }
}
