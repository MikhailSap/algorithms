package util;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private T[] values;
    private static final int CAPACITY = 10;
    private int start = 0;
    private int end = 0;
    private int size = 0;


    public MyQueue() {
        values = (T[]) new Object[CAPACITY];
    }

    public void insert(T element) {
        if (isFull())
            throw new IllegalStateException("Queue is full");
        values[end] = element;
        end = ++end%CAPACITY;
        size++;
    }

    public void remove() {
        if (isEmpty())
            throw new NoSuchElementException();
        values[start] = null;
        start = ++start%CAPACITY;
        size--;
    }

    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return values[start];
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
