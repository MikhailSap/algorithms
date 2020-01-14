package list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyDoubleLinkedList<T> implements Iterable<T>{
    private Node head;
    private int size;

    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }

    public ListIterator<T> listIterator() {
        return new MyIterator<T>();
    }

    public void addFirst(T value) {
        boolean isFirst = isEmpty();
        head = new Node(value, head);
        if (!isFirst)
        head.next.prev = head;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node head = this.head;
        this.head = this.head.next;
        this.head.prev = null;
        size--;
        return (T) head.value;
    }

    public T removeLast() {
        Node removeNode = getLastNode();
        if (removeNode.prev == null)
            return removeFirst();
        removeNode.prev.next = null;
        size--;
        return (T) removeNode.value;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(value);
            return;
        }

        Node currentNode = head;

        if (index == size) {
            int i = 0;
            while (i < index - 1) {
                currentNode = currentNode.next;
                i++;
            }

            currentNode.next = new Node(value, null, currentNode);
            size++;
            return;
        }

        int i = 0;
        while (i < index) {
            currentNode = currentNode.next;
            i++;
        }

        Node insertNode = new Node(value, currentNode, currentNode.prev);
        currentNode.prev = insertNode;
        insertNode.prev.next = insertNode;
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
                if (currentNode.next != null)
                currentNode.next.prev = currentNode;
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

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return (T) getLastNode().value;
    }

    private Node getLastNode() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node currentNode = head;

        int i = 0;
        while (i < size - 1) {
            currentNode = currentNode.next;
            i++;
        }

        return currentNode;
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
        private Node prev;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;

        }
    }

    private class MyIterator<T> implements ListIterator {
        Node forward = head;
        Node backward;
        int index = -1;

        public MyIterator() {
            this.backward = getLastNode();
        }

        public boolean hasNext() {
            boolean hasNext = forward != null;
            return hasNext;
        }

        @Override
        public boolean hasPrevious() {
            boolean hasPrev = backward != null;
            return hasPrev;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(Object o) {
            throw new UnsupportedOperationException();
        }

        public T next() {
            Node next = forward;
            forward = forward.next;
            index++;
            if (next.value == null)
                throw new NullPointerException();
            return (T) next.value;
        }

        @Override
        public T previous() {
            Node prev = backward;
            backward = backward.prev;
            index--;
            if (prev.value == null)
                throw new NullPointerException();
            return (T) prev.value;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
    }
}
