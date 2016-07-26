
public class Queue {
	
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int s) {		// Constructor
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long j) {	// Adding element in the end of queue
		if (rear == maxSize-1) {	//Cycle moving
			rear = -1;
		}
		queArray[++rear] = j;
		nItems++;
	}
	
	public long remove() {			// Removing element from the beginning of queue
		long temp = queArray[front++];	
		if ( front == maxSize) {
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public long peekFront() {		// Getting element from the beginning of queue
		return queArray[front];
	}
	
	public boolean isEmpty() {		// True if queue is empty
		return (nItems == 0);
	}
	
	public boolean isFull() {		// True if queue is full
		return (nItems == maxSize);
	}
	
	public int size() {				// Return amount of elements in queue
		return nItems;
	}
	
}
