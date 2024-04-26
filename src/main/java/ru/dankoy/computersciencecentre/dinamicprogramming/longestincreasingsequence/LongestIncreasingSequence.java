package ru.dankoy.computersciencecentre.dinamicprogramming.longestincreasingsequence;

import java.util.Scanner;


/**
 * Задача на программирование: наибольшая последовательнократная подпоследовательность
 * <p>
 * Дано целое число 1≤n≤10^3 и массив A[1…n]натуральных чисел, не превосходящих 2⋅10^9. Выведите
 * максимальное 1≤k≤n, для которого найдётся подпоследовательность 1≤i1<i2<…<ik≤n длины k, в которой
 * каждый элемент делится на предыдущий (формально: для  всех 1≤j<k , A[ij] | A[ij+1] ]).
 */
public class LongestIncreasingSequence {

  public static void main(String[] args) {
    new LongestIncreasingSequence().run();
  }


  private void run() {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int[] array = new int[n];

    for (int i = 1; i <= n; i++) {

      array[i - 1] = in.nextInt();

    }

//        System.out.println("array " + Arrays.toString(array));

    int ans = lisBottomUp(array);

    System.out.println(ans);

  }


  private int lisBottomUp(int[] array) {

    // Создать массив D
    int[] arrayD = new int[array.length];

    for (int i = 0; i < array.length; i++) {

      // массив D будет содержать длину кратчайшей подполедовательности заканчивающейся в i-m элементе
      arrayD[i] = 1;

      for (int j = 0; j <= i - 1; j++) {

        // проверяет, что каждый следующей элемент делится на предыдущий, а так же, что значение массива
        // arrayD[j] + 1 больше чем arrayD[i], то есть новое найденное значение по условию не уменьшало количество
        // вхождений в подпоследовательность
        if (array[i] % array[j] == 0 && arrayD[j] + 1 > arrayD[i]) {
          arrayD[i] = arrayD[j] + 1;
        }

      }

    }

//        System.out.println("arrayD: " + Arrays.toString(arrayD));

    int ans = 0;

    // итерация по результурующему массиву и вывод максимума длины подпоследовательности
    for (int i = 0; i < array.length; i++) {

      ans = Math.max(ans, arrayD[i]);

    }

    return ans;

  }
}
