import list.MyDoubleLinkedList;

public class MyQueue<T> {
    MyDoubleLinkedList<T> values = new MyDoubleLinkedList<>();

    public void enqueue(T value) {
        values.addFirst(value);
    }

    public T dequeue() {
        return values.removeLast();
    }

    public T peek() {
        return values.getLast();
    }

    public boolean empty() {
        return values.isEmpty();
    }

    public int size() {
        return values.size();
    }
}
