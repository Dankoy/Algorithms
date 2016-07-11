
class Person {
	private String lastName;
	private String firstName;
	private int age;
	
	public Person(String last, String first, int a) {
		lastName = last;
		firstName = first;
		age = a;
	} 

	public void displayPerson() {
		System.out.print("Last name: " + lastName);
		System.out.print(". First name: " + firstName);
		System.out.println(". Age: " + age);
	}
	
	public String getLast() {
		return lastName;
	}
}

public class ArrayInObj extends Person  {
	
	private Person a[];
	private int nElems;
	
	public ArrayInObj(int max) {
		a = new Person[max];
		nElems = 0;
	}
	
	public void insert(String last, String first, int age) {
		a[nElems] = new Person(last, first, age);
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			a[i].displayPerson();
		}
		System.out.println(" ");
	}
	
	public void insertionSort( ) {
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
	
}