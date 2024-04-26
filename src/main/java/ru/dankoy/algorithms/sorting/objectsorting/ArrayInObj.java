package ru.dankoy.algorithms.sorting.objectsorting;

public class ArrayInObj  {
	
	private Person a[];
	private int nElems;
	
	public ArrayInObj(int max) { 	
		a = new Person[max];
		nElems = 0;
	}
	
	public void insert(String last, String first, int age) {
		a[nElems] = new Person(last, first, age);
		nElems++;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			a[i].displayPerson();
		}
		System.out.println(" ");
	}
	
	public void insertionSortLast( ) { 		// Method for sorting by last name of person
		int in, out;
		
		for (out = 1; out < nElems; out++) {
			Person temp = a[out];
			in = out;
			
			while (in > 0 && a[in-1].getLast().compareTo(temp.getLast()) > 0) {
				a[in] = a[in -1];
				--in;
			}
			a[in] = temp;
		}
	}
	
	public void insertionSortFirst( ) {		// Method of sorting by first name of person
		int in, out;
		
		for (out = 1; out < nElems; out++) {
			Person temp = a[out];
			in = out;
			
			while (in > 0 && a[in-1].getFirst().compareTo(temp.getFirst()) > 0) {
				a[in] = a[in -1];
				--in;
			}
			a[in] = temp;
		}
	}
	
	public void insertionSortAge( ) {		// Method of sorting by age of person
		int in, out;
		
		for (out = 1; out < nElems; out++) {
			Person temp = a[out];
			in = out;
			
			while (in > 0 && a[in-1].getAge().compareTo(temp.getAge()) > 0) {
				a[in] = a[in -1];
				--in;
			}
			a[in] = temp;
		}
	}
	
}
