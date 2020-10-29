package com.company;

public class GenericNumberList<E extends Number> {

    private E[] items;
    private int count = 0;

    public GenericNumberList(int length ) {
        items = (E[]) new Number[length];
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

}
