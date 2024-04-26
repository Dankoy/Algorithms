package ru.dankoy.algorithms.sorting.insertsorting;

public class InsertSortMethods {
	
	private long a[];
	private int nElems;
	
	public InsertSortMethods(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
	}
	
	public void insertionSort() {
		int in, out;
		
		for (out = 1; out < nElems; out++ ) {
			long temp = a[out];
			in = out;
			while (in > 0 && a[in-1] >= temp) {
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
		}
	}
	
	public void reverseInsertionSort() {
		int in, out;
		
		for (out = a.length - 1; out >= 0; out--) {
			long temp = a[out];
			in = out;
			while (in < nElems - 1 && a[in+1] >= temp) {
				a[in] = a[in+1];
				++in;
			}
			a[in] = temp;
		}
	}
}
