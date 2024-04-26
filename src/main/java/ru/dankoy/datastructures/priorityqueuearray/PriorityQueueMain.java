package ru.dankoy.datastructures.priorityqueuearray;

import java.io.IOException;

public class PriorityQueueMain {

	public static void main(String[] args) throws IOException {
		
		PriorityQueue theQueue = new PriorityQueue(5);
		
		theQueue.insert(30);
		theQueue.insert(50);
		theQueue.insert(10);
		theQueue.insert(40);
		theQueue.insert(20);
		
		while( !theQueue.isEmpty() ) {
			long item = theQueue.remove();
			System.out.print(item + " ");
		}
		System.out.println(" ");
		
	}

}
