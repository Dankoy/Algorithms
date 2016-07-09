
/* The example of bubble sorting algorithm. O(N^2) */

public class BubbleSort extends ArrayBubble {

	public BubbleSort(int max) {
		super(max);
	}

	public static void main(String[] args) {
		int maxSize = 1000; 		// Array size
		ArrayBubble arr = new ArrayBubble(maxSize);
		
		for (int j = 0; j < maxSize; j++) {		// Random insert elements in array
			long n = (long) (java.lang.Math.random()*(maxSize-1));
			arr.insert(n);
		}
		
		arr.display();
		
		long startTime = System.currentTimeMillis();
		
		arr.bubbleSort();
		
		long timeSpent = System.currentTimeMillis() - startTime;
		
		arr.display();
		
		System.out.println("Time taken for sorting: " + timeSpent + " mls.");
	}

}
