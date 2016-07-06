
public class BubbleSort extends ArrayBubble {

	public BubbleSort(int max) {
		super(max);
	}

	public static void main(String[] args) {
		int maxSize = 100; 		// Array size
		ArrayBubble arr = new ArrayBubble(maxSize);
		
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(77); // Вставка 10 элементов
		arr.insert(99);
		arr.insert(66);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(3);
		arr.insert(66);
		
		arr.display();

	}

}
