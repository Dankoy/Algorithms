

public class FunctionsForArray {
	private long[] a; // Ссылка на массив a
	private int nElems; // Количество элементов данных
	
	public FunctionsForArray(int max) { // Конструктор
		a = new long[max];
		nElems = 0;
	}

	public int size() { 
		return nElems; 
	}

	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems-1;
		int curIn;
		while(true)	{
			curIn = (lowerBound + upperBound ) / 2;
			if(a[curIn]==searchKey) {    // Элемент найден
				return curIn; 
			}
			else if (lowerBound > upperBound) {   // Элемент не найден
				return nElems;
			}
			else {// Деление диапазона
				if(a[curIn] < searchKey) {
				lowerBound = curIn + 1; // В верхней половине
				}
				else {
					upperBound = curIn - 1; // В нижней половине
				}
			}
		}
	}

	public void insert(long value) { // Вставка элемента в массив
		int j;
		for(j=0; j<nElems; j++) // Определение позиции вставки
			if(a[j] > value) // (линейный поиск)
				break;
		for(int k=nElems; k>j; k--) { // Перемещение последующих элементов
			a[k] = a[k-1]; // Вставка
		}
		a[j] = value;
		nElems++; // Увеличение размера
	}

	public boolean delete(long value) {
		int j = find(value);
		if(j == nElems) { // Найти не удалось
			return false;
		}
		else { // Элемент найден
			for(int k=j; k<nElems; k++) { // Перемещение последующих элементов
				a[k] = a[k+1];
			}
			nElems--; // Уменьшение размера
			return true;
		}
	}

	public void display() { // Вывод содержимого массива
		for(int j=0; j < nElems; j++) { // Перебор всех элементов
			System.out.print(a[j] + " "); // Вывод текущего элемента
		}
		System.out.println("");
	}
	
	public void noDups() {
		for(int i=0; i < a.length; i++) {
			for(int j=i+1; j < a.length; j++) {
				if (a[i] == a[j]) {
					a[i] = 0;
				}
			}
		}
	}
	
} //OrdArray
