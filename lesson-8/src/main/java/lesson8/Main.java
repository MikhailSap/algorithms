package lesson8;

import lesson8.map.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        System.out.println(map.isEmpty());

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println(map.isEmpty());

        System.out.println(map.get("three"));

        System.out.println(map);
        System.out.println(map.size());

        System.out.println(map.remove("two"));

        System.out.println(map);
        System.out.println(map.size());

        for (int i = 0; i < 1000; i++) {
            map.put(String.valueOf(i), i);
        }

        System.out.println(map.size());
        System.out.println(map);
    }
}
