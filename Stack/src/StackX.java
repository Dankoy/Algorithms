
public class StackX {
	
	private int maxSize;  			// Length of array
	private long[] stackArray;		// Link on array
	private int top;				// Top of the stack
	
	public StackX(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1; 		// No elements in stack yet
	}
	
	public void push(long j) {		// Pushing element in stack
		top++;
		stackArray[top] = j;
	}
	
	public long pop() {				// Getting element from stack
		return stackArray[top--];
	}
	
	public long peek() {			// Looking at the element on top of the stack
		return stackArray[top];
	}
	
	public boolean isEmpty() {		// True if stack is empty
		return (top == -1);
	}
	
	public boolean isFull() {		// True if stack is full
		return (top == maxSize-1);
	}
	
}
