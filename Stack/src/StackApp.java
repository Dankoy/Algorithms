
public class StackApp {

	public static void main(String[] args) {
		
		StackX theStack = new StackX(10);	// Creating stack with 10 elements
		
		theStack.push(20);
		theStack.push(40);
		theStack.push(60);
		theStack.push(80);
		
		while( !theStack.isEmpty() ) {		// While stack is not empty
			long value = theStack.pop();
			System.out.print(value + " ");	
		}
		System.out.println(" ");
	}

}
