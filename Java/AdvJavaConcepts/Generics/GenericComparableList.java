package com.company;

public class GenericComparableList<E extends Comparable> {

    public E[] items;
    private int count = 0;

    public GenericComparableList(int length ) {
        items = (E[]) new Comparable[length];
    }

    public void add( E item) {
        if (count < items.length) {
            items[count++] = item;
        } else {
            System.out.println("List full, can not add anymore elements");
        }
    }

    public E get ( int index ) {
        if ( index >= 0 && index < items.length ) {
            return items[index];
        } else {
            System.out.println("Not a valid index, returning null");
            return null;
        }
    }

    public int getCount() {
        return count;
    }
}
