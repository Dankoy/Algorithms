package ru.dankoy.priorityqueuearray;// The implementation of priority queue based on array (the slower implementation of queue than if it is based on  heap).
// The lack of queues based on array is slow inserting, but it is appropriate in case if the amount of elements is small
// and speed of inserting is not really important.

// Elements of array is sorting by key from max (0) to (maxSize-1). The lower element has higher priority

public class PriorityQueue {
	
	private int maxSize;
	private long[] queueArray;
	private int nItems;
	
	public PriorityQueue(int s) {						// Constructor for queue array
		maxSize = s;
		queueArray = new long[maxSize];
		nItems = 0;
	}
	
	public void insert(long item) {						// Inserting element
		int j;
		
		if (nItems == 0) {								// If queue is empty then insert element in 0 position
			queueArray[nItems++] = item;
		}
		else {											// If queue is not empty  
			for(j = nItems - 1; j >= 0; j--) {			// then checking elements in reverse way
				if (item > queueArray[j]) {				// and if the new element is bigger then
					queueArray[j+1] = queueArray[j];	// move checking element inside queue up
				}
				else {
					break;
				}
			}
			queueArray[j+1] = item;						// Actual inserting of new element
			nItems++;
		}
	}
	
	public long remove() {								// Removing minimal element
		return queueArray[--nItems];
	}
	
	public long peekMin() {							// Reading minimal element
		return queueArray[nItems-1];
	}
	
	public boolean isEmpty() {	
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
}
