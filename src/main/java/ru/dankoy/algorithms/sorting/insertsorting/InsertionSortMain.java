package ru.dankoy.algorithms.sorting.insertsorting;

public class InsertionSortMain {
	
	public static void main(String[] args) {
		
		int maxSize = 10;
		InsertSortMethods arr = new InsertSortMethods(maxSize);
		
		for (int j = 0; j < maxSize; j++) {		// Random insert elements in array
			long n = (long) (java.lang.Math.random()*(maxSize-1));
			arr.insert(n);
		}
		
		arr.display();
		
		long startTime = System.currentTimeMillis();
		
		arr.reverseInsertionSort();
		
		long timeSpent = System.currentTimeMillis() - startTime;
		
		arr.display();
		
		System.out.print("Time taken for sorting: " + timeSpent + " mls.");

	}

}
