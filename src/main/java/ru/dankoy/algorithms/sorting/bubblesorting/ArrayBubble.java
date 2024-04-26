package ru.dankoy.algorithms.sorting.bubblesorting;

public class ArrayBubble {
	
	private long[] a;		// link on array
	private int nElems;   //amount of elements in array
	
	public ArrayBubble(int max) { 	//Constructor
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {		//inserting data in array
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {		//print array
		for(int j = 0; j < nElems; j++){
			System.out.print(a[j] + " ");
		}
		System.out.println(" ");
	}
	
	public void bubbleSort() {		//bubble sorting realization
		int out, in;
		for (out = nElems-1; out > 1; out--){
			for (in = 0; in < out; in++){
				if (a[in] > a[in+1]){
					swap(in, in+1);
				}
			}
		}
	}
	
	private void swap(int one, int two) { 		
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	
	public void reverseBubbleSort() {
		int out, in;
		for (out = 0; out < nElems - 1; out++) {
			for (in = nElems - 1; in > out; in--) {
				if (a[in] > a[in-1]) {
					swap(in, in-1);
				}
			}
		}
	}
}
