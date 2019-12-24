package util;

import java.util.NoSuchElementException;

public class MyStack<T> {
    private T[] values;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size = 0;


    public MyStack() {
        capacity = DEFAULT_CAPACITY;
        values = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        values = (T[]) new Object[capacity];
    }

    public void push(T element) {
        if (isFull())
            reCapacity();
        values[size] = element;
        size++;
    }

    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return values[size-1];
    }

    public T pop() {
        T element = peek();
        remove();
        return element;
    }

    public void remove() {
        if (isEmpty())
            throw new NoSuchElementException();
        values[size-1] = null;
        size--;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void reCapacity() {
        T[] newValues = (T[]) new Object[capacity*2];
        System.arraycopy(values, 0,newValues, 0, values.length);
        values = newValues;
    }
}
