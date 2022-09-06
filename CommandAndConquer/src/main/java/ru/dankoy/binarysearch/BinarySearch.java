package ru.dankoy.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * В первой строке даны целое число 1≤n≤10^5 и массив A[1…n] из n различных натуральных чисел, не
 * превышающих 10^9, в порядке возрастания, во второй — целое число 1≤k≤10^5 и k натуральных чисел
 * b1,…,bk не превышающих 10^9. Для каждого i от 1 до k необходимо вывести индекс 1≤j≤n, для
 * которого A[j]=bi, или −1, если такого j нет.
 */
public class BinarySearch {

  public static void main(String[] args) {
    new BinarySearch().run();
  }


  public void run() {

//    Sample Input:
//
//    5 1 5 8 12 13
//    5 8 1 23 1 11
//
//    Sample Output:
//
//    3 1 -1 1 -1

    Scanner in = new Scanner(System.in);
    int amountElementsInInputArray = in.nextInt(); // количество элементов в массиве
    int[] sortedInputArray = new int[amountElementsInInputArray];

    // заполняем массив данными
    for (int i = 0; i < amountElementsInInputArray; i++) {
      sortedInputArray[i] = in.nextInt();
    }

    int k = in.nextInt(); // количество элементов второго массива, которые надо найти в первом
    // массиве
    int[] elementsToLookFor = new int[k];

    for (int i = 0; i < k; i++) {
      elementsToLookFor[i] = in.nextInt();
    }

    StringBuilder sb = new StringBuilder();

    // циклимся по всем элементам из второго массива и запускаем бинарный поиск
    Arrays.stream(elementsToLookFor).forEach(element -> sb.append(binarySearch(sortedInputArray,
        element)).append(" "));

    System.out.println(sb);


  }

  private int binarySearch(int[] array, int element) {

    int l = 0;
    int r = array.length - 1;

    while (l <= r) {

      int m = (int) Math.floor((l + r) / 2D);

      if (array[m] == element) {
        return m + 1;
      } else if (array[m] > element) {
        r = m - 1;
      } else {
        l = m + 1;
      }

    }

    return -1;

  }

}