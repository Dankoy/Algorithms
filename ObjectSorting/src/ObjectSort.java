
public class ObjectSort extends ArrayInObj {
	
	public ObjectSort(int max) {
		super(max);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		int maxSize = 10;
		ArrayInObj arr = new ArrayInObj(maxSize);
		
		arr.insert("Evans", "Patty", 24);
		arr.insert("Smith", "Lorainne", 37);
		arr.insert("Yee", "Tom", 43);
		arr.insert("Adams", "Henry", 63);
		arr.insert("Hashimoto", "Sato", 21);
		
		System.out.println("Before sorting: ");
		arr.display();
		
		arr.insertionSort();
		
		System.out.println("After sorting: ");
		arr.display();
		
	}

}
