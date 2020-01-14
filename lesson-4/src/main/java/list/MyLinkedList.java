package list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyLinkedList<T> implements Iterable<T>{
    private Node head;
    private int size;

    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }

    public void addFirst(T value) {
        head = new Node(value, head);
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node head = this.head;
        this.head = this.head.next;
        size--;
        return (T) head.value;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(value);
            return;
        }

        Node currentNode = head;
        int i = 0;
        while (i < index - 1) {
            currentNode = currentNode.next;
            i++;
        }

        currentNode.next = new Node(value, currentNode.next);
        size++;
    }

    public boolean remove(T value) {
        if (isEmpty())
            return false;
        if (head.value.equals(value)) {
            removeFirst();
            return true;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value.equals(value)) {
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return (T) head.value;
    }

    public int indexOf(T value) {
        return getIndex(value);
    }

    private int getIndex(T value) {
        Node currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.value.equals(value))
                return index;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T value) {
        return getIndex(value) != -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringJoiner joiner = new StringJoiner(",");
        for (T value : this)
            joiner.add(value.toString());

        StringBuilder sb = new StringBuilder("[");
        sb.append(joiner.toString());
        sb.append("]");

        return sb.toString();
    }

    private class Node<T> {
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private class MyIterator<T> implements Iterator{
        Node currentNode = head;


        public boolean hasNext() {
            return currentNode != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (currentNode.value == null)
                throw new NullPointerException();
            Node next = currentNode;
            currentNode = currentNode.next;
            return (T) next.value;
        }
    }
}
