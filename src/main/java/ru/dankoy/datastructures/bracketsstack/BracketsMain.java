package ru.dankoy.datastructures.bracketsstack;

import java.io.*;

public class BracketsMain {
	
	public static void main(String args[]) throws IOException {
		
		String input;
		
		while(true) {
			System.out.println("Enter brackets string: ");
			System.out.flush();
			input = getString();
			
			if (input.equals("")) {		// ENTER is typed
				break;
			}
			
			BracketsChecker bch = new BracketsChecker(input);
			bch.check();
		}
	}
	
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(isr);
		String s = bf.readLine();
		return s;
	}
	
}
