package ru.dankoy.qicksort;


import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Задача на программирование: точки и отрезки
 * <p>
 * В первой строке задано два целых числа 1≤n≤50000 и 1≤m≤50000 — количество отрезков и точек на
 * прямой, соответственно. Следующие n строк содержат по два целых числа ai и bi (ai≤bi) —
 * координаты концов отрезков. Последняя строка содержит m целых чисел — координаты точек. Все
 * координаты не превышают 10^8 по модулю. Точка считается принадлежащей отрезку, если она находится
 * внутри него или на границе. Для каждой точки в порядке появления во вводе выведите, скольким
 * отрезкам она принадлежит.
 */
public class QuickSort {


  public static void main(String[] args) throws ExecutionException, InterruptedException {
    new QuickSort().run();
  }

  private void run() throws InterruptedException, ExecutionException {

    Scanner in = new Scanner(System.in);

    int amountOfRanges = in.nextInt();
    int amountOfDots = in.nextInt();

    long[] startRanges = new long[amountOfRanges];
    long[] endRanges = new long[amountOfRanges];

    // Получаю массивы начала и конца отрезков
    for (int i = 0; i < amountOfRanges; i++) {

      startRanges[i] = in.nextInt();
      endRanges[i] = in.nextInt();

    }

    // Получаю массив точек
    long[] dots = new long[amountOfDots];
    for (int i = 0; i < amountOfDots; i++) {
      dots[i] = in.nextInt();
    }

//    ExecutorService executorService = Executors.newFixedThreadPool(2);

//    executorService.submit(() -> quicksort(startRanges, 0, startRanges.length - 1));
//    executorService.submit(() -> quicksort(endRanges, 0, endRanges.length - 1));

//    latch.await();

    System.out.println(Arrays.toString(dots));

    // сортируем массивы
    quicksort(startRanges, 0, startRanges.length - 1);
    quicksort(endRanges, 0, endRanges.length - 1);

    System.out.println(Arrays.toString(startRanges));
    System.out.println(Arrays.toString(endRanges));

    StringBuilder sb = new StringBuilder();

    // ищем число вхождений точки в левом массиве и в правом массиве как
    // 1-я будет искать в массиве Х все элементы, которые меньше или равны(!) А и возвращать их количество N
    // 2-я будет искать в массиве У все элементы, которые строго (!) меньше А и возвращать их
    // количество M
    // В цикле прогоните каждую точку из списка через обе функции -  ответом будет разность N - M

    for (int i = 0; i < dots.length; i++) {

//      int finalI = i;
//      Future<Integer> amountOfTimesDotIsLessOrEqualsThanStartRange =
//          executorService.submit(
//              () -> binarySearchWhereElementIsLessOrEqualsThanStartRanges(startRanges,
//                  dots[finalI]));
//
//      Future<Integer> amountOfTimesDotIsLessThanEndRange =
//          executorService.submit(
//              () -> binarySearchWhereElementIsLessThanEndRanges(endRanges, dots[finalI]));
//
//      sb.append(amountOfTimesDotIsLessOrEqualsThanStartRange.get()
//              - amountOfTimesDotIsLessThanEndRange.get())
//          .append(" ");

      int amountOfTimesDotIsLessOrEqualsThanStartRange = binarySearchWhereElementIsLessOrEqualsThanStartRanges(
          startRanges, dots[i]);
      System.out.println(
          "start element - " + dots[i] + " " + amountOfTimesDotIsLessOrEqualsThanStartRange);

      int amountOfTimesDotIsLessThanEndRange = binarySearchWhereElementIsLessThanEndRanges(
          endRanges, dots[i]);
      System.out.println("end element - " + dots[i] + " " + amountOfTimesDotIsLessThanEndRange);

      sb.append(amountOfTimesDotIsLessOrEqualsThanStartRange - amountOfTimesDotIsLessThanEndRange)
          .append(" ");

    }

    System.out.println(sb);

//    executorService.shutdown();

  }


  /**
   * алгоритм быстрой сортировки с выборкой рандомного элементакак середина вместо первого по
   * дефолту
   *
   * @param array массив
   * @param left  левая границы массива
   * @param right правая граница массива
   */
  private void quicksort(long[] array, int left, int right) {

    while (left < right) {

      int m = partition(array, left, right);
      quicksort(array, left, m - 1);
      left = m + 1;
    }
  }

  /**
   * Поиск индекса "середины" массива, где индекс - это место значения элемента, слева которого все
   * элементы меньше него, а справа - больше.
   *
   * @param array массив
   * @param left  левая граница
   * @param right правая граница
   * @return индекс элемента для которого все элементы слева меньше него, а справа - больше
   */
  private int partition(long[] array, int left, int right) {

    // Берем рандомный индекс в пределах размера массива и перетаскиваем элемент с его значением в
    // начало массива
    int randomNum = ThreadLocalRandom.current().nextInt(left, right + 1);

//    int median = medianIndexOfThree(array);

    long firstElementOfArray = array[left];
    long randomElementOfArray = array[randomNum];
    array[left] = randomElementOfArray;
    array[randomNum] = firstElementOfArray;

    long x = array[left];
    int j = left; // граница правой части массива

    for (int i = left + 1; i <= right; i++) {

      if (array[i] <= x) {
        j++;

        // обмениваю элементы. ЗАЧЕМ? Подменяет элемент сам на себя только пока массив изначально
        // был частично отсортирован. Как только пойдут нормальный элементы, то подмена будет
        // происходить jго элемента с iм элементом, который будет правее на 1 и более по индексам
        // в массиве.
        long tmpElement1 = array[j];
        long tmpElement2 = array[i];

        array[j] = tmpElement2;
        array[i] = tmpElement1;

      }

    }

    // последний обмен - ставим x на свое место
    long jElement = array[j];
    array[j] = randomElementOfArray;
    array[left] = jElement;

    return j;
  }


  private int binarySearchWhereElementIsLessOrEqualsThanStartRanges(long[] array, long element) {

    int l = 0;
    int r = array.length - 1;

    int m = 0;

    while (l <= r) {

      m = (int) Math.floor((l + r) / 2D);

      if (array[m] == element) {
        while (m + 1 <= r && array[m + 1] == element) {
          m++;
        }
        m++;
        break;
      }

      // If key is smaller, ignore right half
      else if (array[m] > element) {
        r = m - 1;
      }

      // If key is greater, ignore left half
      else {
        l = m + 1;
        m++;
      }

    }

    return m;

  }

  private int binarySearchWhereElementIsLessThanEndRanges(long[] array, long element) {

    int l = 0;
    int r = array.length - 1;

    int m = 0;

    while (l <= r) {

      m = (int) Math.floor((l + r) / 2D);

      if (array[m] == element) {
        while (m - 1 >= l && array[m - 1] == element) {
          m--;
        }
        break;
      }

      // If key is smaller, ignore right half
      else if (array[m] > element) {
        r = m - 1;
      }

      // If key is greater, ignore left half
      else {
        l = m + 1;
        m++;
      }

    }

    return m;

  }


  private int medianIndexOfThree(long[] array) {

    int l = 0;
    int r = array.length - 1;
    int m = (int) Math.floor((l + r) / 2D);

    long first = array[l];
    long middle = array[m];
    long last = array[r];

    if (first > middle)
    {
      if (middle > last)
        return m;
      else if (first > last)
        return r;
      else
        return l;
    }
    else
    {
      // Decided a is not greater than b.
      if (first > last)
        return l;
      else if (middle > last)
        return r;
      else
        return m;
    }


  }


}
