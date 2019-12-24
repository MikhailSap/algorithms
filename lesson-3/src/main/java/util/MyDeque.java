package util;

import java.util.NoSuchElementException;

public class MyDeque<T> {
    private T[] values;
    private static final int CAPACITY = 10;
    private int start = 0;
    private int end = 0;
    private int size = 0;


    public MyDeque() {
        values = (T[]) new Object[CAPACITY];
    }

    public void insertStart(T element) {
        if (isFull())
            throw new IllegalStateException("Queue is full");
        start = ((start + CAPACITY) - 1) % CAPACITY;
        values[start] = element;
        size++;
    }

    public void insertLast(T element) {
        if (isFull())
            throw new IllegalStateException("Queue is full");
        values[end] = element;
        end = ++end%CAPACITY;
        size++;
    }

    public void removeStart() {
        if (isEmpty())
            throw new NoSuchElementException();
        values[start] = null;
        start = ++start%CAPACITY;
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        end = ((end + CAPACITY) - 1) % CAPACITY;
        values[end] = null;
        size--;
    }

    public T peekStart() {
        if (isEmpty())
            throw new NoSuchElementException();
        return values[start];
    }

    public T peekLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return values[((end + CAPACITY) - 1) % CAPACITY];
    }

    public boolean isFull() {
        return size == CAPACITY;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
