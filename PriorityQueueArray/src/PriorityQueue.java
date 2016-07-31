
// Elements of array is sorting by key from max (0) to (maxSize-1)

public class PriorityQueue {
	
	private int maxSize;
	private long[] queueArray;
	private int nItems;
	
	public PriorityQueue(int s) {
		maxSize = s;
		queueArray = new long[maxSize];
		nItems = 0;
	}
	
	public void insert(long item) {
		int j;
		
		if (nItems == 0) {
			queueArray[nItems++] = item;
		}
		else {
			for(j = nItems - 1; j >= 0; j--) {
				if (item > queueArray[j]) {
					queueArray[j+1] = queueArray[j];
				}
				else {
					break;
				}
			}
			queueArray[j+1] = item;
			nItems++;
		}
	}
	
	public long remove() {
		return queueArray[--nItems];
	}
	
	public long peekMain() {
		return queueArray[nItems-1];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
}
