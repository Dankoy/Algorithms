package ru.dankoy.datastructures.stack;

public class StackApp {

	public static void main(String[] args) {
		
		StackX theStack = new StackX(10);	// Creating stack with 10 elements
		
		System.out.println("The sequence of pushing elements in stack:\n");
		int size = theStack.getStackSize();
		for (int i = 0; i < size; i++) {
			long n = (long) (java.lang.Math.random()*(10 - 1));
			theStack.push(n);
			System.out.println("The element �" + (i + 1) + " pushing value: " + n);
		}
		System.out.println("\nThe sequence of popping elements from stack:\n");
				int i = size;
		while( !theStack.isEmpty() ) {		// While stack is not empty
			long value = theStack.pop();
			System.out.println("The element �" + i + " popping value " + value);
			i--;
		}
	}

}
