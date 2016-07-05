public class OrderedArrayMain extends FunctionsForArray {
	public OrderedArrayMain(int max) {
		super(max);
	}
	

	public static void main(String[] args) {
		
		int maxSize = 100; // Размер массива
		FunctionsForArray arr; // Ссылка на массив
		arr = new FunctionsForArray(maxSize); // Создание массива

		arr.insert(77); // Вставка 10 элементов
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
		

		int searchKey = 55; // Поиск элемента

		if( arr.find(searchKey) != arr.size() ) {
			System.out.println("Found " + searchKey);
		}
		else {
			System.out.println("Can't find " + searchKey);
		}
		
		arr.display(); // Вывод содержимого
		
//		arr.delete(00);
//		arr.delete(55);
//		arr.delete(99); // Удаление трех элементов
		
		arr.display(); // Повторный вывод
		
		arr.noDups();	
		arr.display();
		
	}
}