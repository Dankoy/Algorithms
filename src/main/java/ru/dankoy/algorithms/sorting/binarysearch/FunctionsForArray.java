package ru.dankoy.algorithms.sorting.binarysearch;

public class FunctionsForArray {
	private long[] a; // Array reference
	private int nElems; // Amount of elements in array
	
	public FunctionsForArray(int max) { // Constructor
		a = new long[max];
		nElems = 0;
	}

	public int size() { 
		return nElems; 
	}

	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems-1;
		int curIn;
		while(true)	{
			curIn = (lowerBound + upperBound ) / 2;
			if(a[curIn]==searchKey) {    // If element has been found
				return curIn; 
			}
			else if (lowerBound > upperBound) {   // If element has not been found
				return nElems;
			}
			else {// Range division
				if(a[curIn] < searchKey) {
				lowerBound = curIn + 1; // In upper part
				}
				else {
					upperBound = curIn - 1; // In lower part
				}
			}
		}
	}

	public void insert(long value) { // inserting data in array
		int j;
		for(j=0; j<nElems; j++) // Determination the position of inserting
			if(a[j] > value) // (linear search)
				break;
		for(int k=nElems; k>j; k--) { // Moving next elements
			a[k] = a[k-1]; // inserting
		}
		a[j] = value;
		nElems++; // Increasing size of array
	}

	public boolean delete(long value) {
		int j = find(value);
		if(j == nElems) { // If element has been found
			return false;
		}
		else { // If element has not been found
			for(int k=j; k < nElems; k++) { // Moving next elements
				a[k] = a[k+1];
			}
			nElems--; // Decreasing size of array
			return true;
		}
	}

	public void display() { // printing array
		for(int j=0; j < nElems; j++) { 
			System.out.print(a[j] + " "); 
		}
		System.out.println("");
	}
	
	public void noDups() {
		for(int i=0; i < nElems - 1; i++) {
			for(int j=i+1; j < nElems; j++) {
				if (a[i] == a[j]) {
					delete(a[j]);
					j--;
				}
			}
		}
	}
	
} // FunctionsForArray