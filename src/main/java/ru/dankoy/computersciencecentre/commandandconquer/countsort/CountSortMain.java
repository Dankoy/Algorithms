package ru.dankoy.computersciencecentre.commandandconquer.countsort;

//Задача на программирование: сортировка подсчётом
//
//
//Первая строка содержит число 1≤n≤10^4, вторая — n натуральных
// чисел, не превышающих 10. Выведите упорядоченную по неубыванию последовательность этих чисел.

import java.util.Arrays;
import java.util.Scanner;

public class CountSortMain {

  public static void main(String[] args) {
    new CountSortMain().run();
  }

//  Sample Input:
//
//      5
//      2 3 9 2 9
//
//  Sample Output:
//
//      2 2 3 9 9


  private void run() {

    Scanner in = new Scanner(System.in);

    int amountOfElements = Integer.parseInt(in.nextLine());
//    System.out.println(amountOfElements);

    int[] array = new int[amountOfElements];

    for (int i = 0; i < amountOfElements; i++) {

      array[i] = in.nextInt();

    }

//    System.out.println(Arrays.toString(array));

    int[] sorted = sortCount(array);

    StringBuilder sb = new StringBuilder();

    // печать результата
    Arrays.stream(sorted)
        .forEach(element -> sb.append(element).append(" "));

    System.out.println(sb);

  }


  /**
   * Реализация алгоритма сортировки подсчетом
   *
   * @param array массив
   * @return отсортированный массив
   */
  private int[] sortCount(int[] array) {

    // Получаем максимальное число в массиве по которому будет определен размер второго массива
    int max = findMax(array);

    int[] countArray = new int[max + 1];

    // записали в массив countArray количество повторений элементов из массива А
    for (int k : array) {

      countArray[k] = countArray[k] + 1;

    }

//    System.out.println(Arrays.toString(countArray));

    // Подсчет кумулятивных сумм

    for (int i = 1; i < countArray.length; i++) {

      countArray[i] = countArray[i] + countArray[i - 1];

    }

//    System.out.println(Arrays.toString(countArray));

    // сортировка

    int[] resultArray = new int[array.length];

    for (int j = array.length - 1; j >= 0; j--) {

      resultArray[countArray[array[j]] - 1] = array[j];
      countArray[array[j]] = countArray[array[j]] - 1;

    }

//    System.out.println(Arrays.toString(resultArray));

    return resultArray;
  }


  /**
   * Ищет и выводит максимальный элемент из массива
   *
   * @param array массив
   * @return максимальный элемент
   */
  private int findMax(int[] array) {

    int max = 0;

    for (int j : array) {

      if (j > max) {
        max = j;
      }

    }

    return max;
  }

}
