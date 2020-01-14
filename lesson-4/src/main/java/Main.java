

import list.MyDoubleLinkedList;
import list.MyLinkedList;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        // Односвязный список
        MyLinkedList<String> list = new MyLinkedList<String>();

        list.addFirst("lol");
        list.addFirst("lul");
        list.addFirst("lalala");
        list.add(0, "bbb");

        System.out.println(list.remove("bbb"));
        System.out.println(list);

        // Двусвязный список
        MyDoubleLinkedList<String> doubleList = new MyDoubleLinkedList<>();

        doubleList.addFirst("a");
        doubleList.addFirst("b");
        doubleList.addFirst("c");

        doubleList.add(3, "q");
        doubleList.remove("b");

        System.out.println(doubleList);

        for (String s : doubleList)
            System.out.println(s + "->");

        ListIterator listIterator = doubleList.listIterator();
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous() + "<-");
        }

        // Очередь
        MyQueue<String> myQueue = new MyQueue<>();

        myQueue.enqueue("one");
        myQueue.enqueue("two");
        myQueue.enqueue("three");

        System.out.println(myQueue.size());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.size());

        // Стек
        MyStack<String> myStack = new MyStack<>();

        myStack.push("lalala");
        myStack.push("trololo");

        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
    }
}
