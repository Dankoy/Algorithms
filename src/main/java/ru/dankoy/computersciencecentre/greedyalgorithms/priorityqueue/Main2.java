package ru.dankoy.computersciencecentre.greedyalgorithms.priorityqueue;

public class Main2 {

    public static void main(String[] args) {

        MinStack<String> stack = new MinStack<>();
        MaxStack<String> maxStack = new MaxStack<>();

        stack.push("first", 1);
        stack.push("second", 4);
        stack.push("third", 0);
        stack.push("fourth", 3);

        maxStack.push("first", 1);
        maxStack.push("second", 4);
        maxStack.push("third", 0);
        maxStack.push("fourth", 3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(maxStack.pop());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.pop());

    }

}
