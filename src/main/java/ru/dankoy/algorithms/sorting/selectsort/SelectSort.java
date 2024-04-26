package ru.dankoy.algorithms.sorting.selectsort;

public class SelectSort extends ArraySelect  {

	public SelectSort(int max) {
		super(max);
	}

	public static void main(String[] args) {
		
		int maxSize = 10;
		ArraySelect arr = new ArraySelect(maxSize);
		
		for (int j = 0; j < maxSize; j++) {		// Random insert elements in array
			long n = (long) (java.lang.Math.random()*(maxSize-1) + 1);
			arr.insert(n);
		}
		
		arr.display();
		
		long startTime = System.currentTimeMillis();
		
		arr.reverseSelectionSort();
		
		long timeSpent = System.currentTimeMillis() - startTime;
		
		arr.display();
		
		System.out.println("Time taken for sorting: " + timeSpent + " mls.");
	}

}
