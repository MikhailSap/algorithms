package lesson8.map;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashMap<Key extends Comparable<Key>, Value> {
    private LinkedList<Entry>[] table;
    private int capacity;
    private int index;
    private Entry entry;
    private float loadFactor;
    private int size;

    public MyHashMap() {
        capacity = 16;
        table = new LinkedList[capacity];
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
    }

    public void put(Key key, Value value) {
        if (loadFactor > 0.75) {
            reCapacity();
            add(key, value);
        } else {
            add(key, value);
        }
    }

    private void add(Key key, Value value) {
        index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList();
            table[index].add(new Entry(key, value));
            setLoadFactor(table[index].size());
            size++;
        } else {
            for (Entry e : table[index]) {
                if (key.equals(e.key)) {
                    e.value = value;
                    return;
                }
            }
            table[index].add(new Entry(key, value));
            setLoadFactor(table[index].size());
            size++;
        }
    }

    public Value get(Key key) {
        checkKey(key);
        entry = search(key);
        if (entry == null) {
            throw new NoSuchElementException();
        } else {
            return entry.value;
        }
    }

    public boolean remove(Key key) {
        checkKey(key);
        entry = search(key);
        if (entry == null) {
            throw new NoSuchElementException();
        } else {
            size--;
            return table[index].remove(entry);
        }
    }

    public boolean contains(Key key) {
        index = hash(key);
        if (table[index] == null)
            return false;
        return table[index].contains(key);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for (LinkedList list : table) {
            if (list != null)
                isEmpty = false;
        }
        return isEmpty;
    }

    private Entry search(Key key) {
        index = hash(key);
        if (table[index] == null) {
            throw new NoSuchElementException();
        }
        for (Entry e : table[index]) {
            if (key.equals(e.key)) {
                return e;
            }
        }
        return null;
    }

    private void setLoadFactor(int depth) {
        float tmp = (float) depth / capacity;
        if (tmp > loadFactor)
            loadFactor = tmp;
    }

    private void reCapacity() {
        size = 0;
        loadFactor = 0;
        LinkedList[] oldTable = table;
        capacity *= 2;
        table = new LinkedList[capacity];

        for (LinkedList<Entry> bucket : oldTable) {
            if (bucket == null)
                continue;
            for (Entry e : bucket) {
                add(e.key, e.value);
            }
        }
    }

    private void checkKey(Key key) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (LinkedList<Entry> bucket : table) {
            if (bucket == null)
                continue;
            for (Entry e : bucket) {
                sb.append("[" + e.key + ", " + e.value + "],");
            }
        }
        return sb.toString();
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }


    private class Entry {
        private Key key;
        private Value value;

        public Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
