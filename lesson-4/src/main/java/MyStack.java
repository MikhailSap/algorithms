import list.MyDoubleLinkedList;

public class MyStack<T> {
    MyDoubleLinkedList<T> values = new MyDoubleLinkedList<>();

    public void push(T value) {
        values.addFirst(value);
    }

    public T peek() {
        return values.getFirst();
    }

    public T pop() {
        T value = values.getFirst();
        values.removeFirst();
        return value;
    }

    public boolean empty() {
       return values.isEmpty();

    }

    public int size() {
        return values.size();

    }
}
