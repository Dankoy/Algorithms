package ru.dankoy.bracketsstack;

public class StackX {
	
	private int maxSize;
	private char stackArray[];
	private int top;
	
	public StackX(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;   					// No elements in stack yet
	}
	
	public void push(char j) {
		top++;
		stackArray[top] = j;
	}
	
	public char pop() {
		return stackArray[top--];
	}
	
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
}
