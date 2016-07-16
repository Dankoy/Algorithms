
public class BracketsChecker {
	
	private String input;
	
	public BracketsChecker(String in) {		// Constructor
		input = in;
	}
	
	public void check() {
		int stackSize = input.length();		// The size of stack equals the size of input string
		
		StackX stack = new StackX(stackSize);
		
		for (int j = 0; j < stackSize; j++) {
			char ch = input.charAt(j);
			switch(ch) {
				
				case '{':
				case '[':
				case '(':
					stack.push(ch);
					break;
					
				case '}':
				case ']':
				case ')':
					if( !stack.isEmpty() ) {		// If the stack is not empty
						char chx = stack.pop(); 	// Pop and check
						
						if ( (ch == '}' && chx != '{' ) || (ch == ']' && chx != '[') || (ch == ')' && chx != '(') ) {
							System.out.println("Error: " + ch + " at " + j);
						}
						else {
							System.out.println("All is good");
						}
						break;
					}
					
				default:		// Ignoring other symbols
					break;
			}
		}
		
		if ( !stack.isEmpty() ) { 		// If all symbols are checked but stack is still has elements
			System.out.println("Error: missing right delimiter");
		}
		
	}
}
