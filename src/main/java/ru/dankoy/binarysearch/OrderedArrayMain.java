package ru.dankoy.binarysearch;

public class OrderedArrayMain extends FunctionsForArray {
	public OrderedArrayMain(int max) {
		super(max);
	}
	

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int maxSize = 100; // Size of array
		FunctionsForArray arr; // Array reference 
		arr = new FunctionsForArray(maxSize); // creating the array

		arr.insert(77); // Inserting elements
		arr.insert(99);
		arr.insert(66);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(3);
		arr.insert(66);
		arr.insert(88);
		arr.insert(66);
		arr.insert(22);
		

		int searchKey = 55; // Searching for element

		if( arr.find(searchKey) != arr.size() ) {
			System.out.println("Found " + searchKey);
		}
		else {
			System.out.println("Can't find " + searchKey);
		}
		
		arr.display(); 
		arr.delete(searchKey);
		
		arr.display(); 
		
		arr.noDups();	
		arr.display();
		
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("Time spent for running program: " + timeSpent + " mls.");
		
	}
}