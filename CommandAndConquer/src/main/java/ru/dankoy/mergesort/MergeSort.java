package ru.dankoy.mergesort;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Задача на программирование: число инверсий
 * <p>
 * Первая строка содержит число 1≤n≤10^5, вторая — массив A[1…n], содержащий натуральные числа, не
 * превосходящие 10^9. Необходимо посчитать число пар индексов 1≤i<j≤n, для которых A[i]>A[j].
 * (Такая пара элементов называется инверсией массива. Количество инверсий в массиве является в
 * некотором смысле его мерой неупорядоченности: например, в упорядоченном по неубыванию массиве
 * инверсий нет вообще, а в массиве, упорядоченном по убыванию, инверсию образуют каждые два
 * элемента.)
 */
public class MergeSort {

//  Sample Input:
//      5
//      2 3 9 2 9
//  Sample Output:
//      2

  private long changes = 0;

  public static void main(String[] args) {
    new MergeSort().run();
  }


  private void run() {

    Scanner in = new Scanner(System.in);

    int amountOfElements = Integer.parseInt(in.nextLine());
    System.out.println(amountOfElements);

    int[] array = new int[amountOfElements];

    for (int i = 0; i < amountOfElements; i++) {

      array[i] = in.nextInt();

    }

    System.out.println(Arrays.toString(array));

    int[] sorted = iterativeMergeSort(array);

    System.out.println(Arrays.toString(sorted));
    System.out.println(changes);

  }


  private int[] iterativeMergeSort(int[] array) {

    Queue<int[]> queue = new ArrayDeque<>();

    for (int i = 0; i < array.length; i++) {

      // заполняем очередь данными массива
      queue.add(new int[]{array[i]});

    }

    // todo: так же можно было реализовать без хитрого коллектора - если нечетный массив, то
    //  добавлять элемент в конец с огромным значением, например Integer.MAX. То есть в массиве
    //  надо поддержать количество элементов кратное 2^n

    //todo: вся хитрая штука с поддержкой размера массива кратным 2^n или коллектора как
    // реализовано ниже - не нужно, если нужно просто отсортировать массив.

    List<int[]> collector = new ArrayList<>();

    while (!queue.isEmpty()) {

      // если размер очереди = 1, то берем только один элемент и добавляем его во временный массив
      if (queue.size() == 1) {

        int[] arr1 = queue.poll();
        collector.add(arr1);

        // перекладываем данные из коллектора в очередь
        // таким образом в очереди массивы находятся всегда в правильном порядке
        for (int[] ints : collector) {
          queue.add(ints);
        }
        collector = new ArrayList<>();

      } else {
        // если в массиве два элемента, то берем их и мерджим. результат добавляем в кооллектор

        int[] arr1 = queue.poll();
        int[] arr2 = queue.poll();

        int[] res = merge(arr1, arr2);

        collector.add(res);

      }

      // если очередь пустая, то проверяем количество элементов в коллекторе. Если там больше
      // двух элементов, то добавляем их в очередь и повторяем цикл заново. Если элемент только
      // один, это значит, что мы получили результат и надо выйти из цикла
      if (queue.isEmpty() && collector.size() > 1) {
        // заполняем данные из коллектора
        for (int[] ints : collector) {
          queue.add(ints);
        }
        collector = new ArrayList<>();
      }


    }

    return collector.get(0);
  }

  /**
   * Мерджит два массива
   *
   * @param array1 массив
   * @param array2 массив
   * @return замердженный массив
   */
  private int[] merge(int[] array1, int[] array2) {

    int currentPositionArray1 = 0;
    int currentPositionArray2 = 0;

    int[] result = new int[array1.length + array2.length];

    // циклимся по первому и второму массиву, сравнивая значения

    int resultPosition = 0;
    while (currentPositionArray1 < array1.length && currentPositionArray2 < array2.length) {

      int element1 = array1[currentPositionArray1];
      int element2 = array2[currentPositionArray2];

      // сравниваем элементы и мерджим
      if (element2 >= element1) {
        result[resultPosition] = element1;
        currentPositionArray1++;
        resultPosition++;
      } else {
        // если элемент второго массива меньше первого, то добавляем счетчик
        result[resultPosition] = element2;
        currentPositionArray2++;
        resultPosition++;
        changes = changes + array1.length - currentPositionArray1; // инверсия  = размер массива
        // слева минус позиция сравниваемого элемента
      }

    }

    boolean array1IsEmpty = false;
    boolean array2IsEmpty = false;

    //делаем проверку на какой массив закончился, а в каком еще элементы есть
    if (currentPositionArray1 == array1.length) {
      array1IsEmpty = true;
    }
    if (currentPositionArray2 == array2.length) {
      array2IsEmpty = true;
    }

    //если массив 1 пустой, а массив 2 нет, то перекладываем в результат остатки из второго массива
    if (array1IsEmpty && !array2IsEmpty) {
      while (currentPositionArray2 < array2.length) {
        result[resultPosition] = array2[currentPositionArray2];
        currentPositionArray2++;
        resultPosition++;
      }
    } else if (array2IsEmpty && !array1IsEmpty) {
      while (currentPositionArray1 < array1.length) {
        result[resultPosition] = array1[currentPositionArray1];
        currentPositionArray1++;
        resultPosition++;
      }
    }

    return result;
  }

}
