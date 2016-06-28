public class OrderedArray extends OrdArray {
	public OrderedArray(int max) {
		super(max);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		int maxSize = 100; // Размер массива
		OrdArray arr; // Ссылка на массив
		arr = new OrdArray(maxSize); // Создание массива

		arr.insert(77); // Вставка 10 элементов
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		int searchKey = 55; // Поиск элемента

		if( arr.find(searchKey) != arr.size() ) {
			System.out.println("Found " + searchKey);
		}
		else {
			System.out.println("Can't find " + searchKey);
		}
		
		arr.display(); // Вывод содержимого
		
		arr.delete(00);
		arr.delete(55);
		arr.delete(99); // Удаление трех элементов
		
		arr.display(); // Повторный вывод
	}
}