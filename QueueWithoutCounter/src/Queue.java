
// Queue without the counter of elements 'nItems'
// Made methods isEmpty(), isFull(), size() way more difficult

public class Queue {
	
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	
	public Queue(int s) {		// Constructor
		maxSize = s + 1;		// The salvation of problem while queue is not full and 'front' and 'rear' can be on one place
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
	}
	
	public void insert(long j) {	// Adding element in the end of queue
		if (rear == maxSize-1) {	//Cycle moving
			rear = -1;
		}
		queArray[++rear] = j;
	}
	
	public long remove() {			// Removing element from the beginning of queue
		long temp = queArray[front++];	
		if ( front == maxSize) {	// Cycle moving
			front = 0;
		}
		return temp;
	}
	
	public long peekFront() {		// Getting element from the beginning of queue
		return queArray[front];
	}
	
	public boolean isEmpty() {		// True if queue is empty
		return ((rear + 1 == front) || (front + maxSize - 1 == rear));
	}
	
	public boolean isFull() {		// True if queue is full
		return ((rear + 2 == front) || (front + maxSize - 2 == rear));
	}
	
	public int size() {				// Return amount of elements in queue
		if ( rear >= front ) {
			return rear - front + 1;
		}
		else {
			return (maxSize - front) + (rear + 1);
		}
	}
	
}
