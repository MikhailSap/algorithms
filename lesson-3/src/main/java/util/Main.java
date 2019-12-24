package util;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        MyStack<Character> myStack = new MyStack<Character>(chars.length);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            myStack.push(chars[i]);
        }

        for (int i = 0; i < chars.length; i++) {
            sb.append(myStack.pop());
        }

        System.out.println(sb.toString());

    }
}
