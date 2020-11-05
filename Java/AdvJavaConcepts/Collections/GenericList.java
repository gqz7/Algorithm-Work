package com.company;

import java.util.Iterator;

public class GenericList<T> implements Iterable<T>{
    private T[] items;
    private int itemsCount = 0;

    public GenericList ( int itemsLength) {
        items = (T[]) new Object[itemsLength];

    }

    public void add (T item) {
        items[itemsCount++] = item;
    }

    public T get( int index )  {
        if (index >= 0 && index < itemsCount) return items[index];
        System.out.println("\n!Index out of bounds!\n");
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T> {

        private GenericList<T> list;
        private int index;

        public ListIterator(GenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.itemsCount);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
