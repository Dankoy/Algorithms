package ru.dankoy.computersciencecentre.fibonacci;

import java.util.Scanner;


/**
 * Даны целые числа  1 \le n \le 10^{18} и  2 \le m \le 10^5 , необходимо найти остаток от деления n
 * n n-го числа Фибоначчи на m m m.
 */
public class HugeFibonacciNumber {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    String[] ctrArr = str.split(" ");

    long n = Long.parseLong(ctrArr[0]);
    int m = Integer.parseInt(ctrArr[1]); //

    // Ищет и печатает фибоначчи число
    System.out.println(fibonacciModulo(n, m));

  }


  /**
   * Определяет период Пизано
   *
   * @param m целое число
   * @return период Пизано
   */
  private static long pisano(long m) {

    long a = 0, b = 1, c, pp = 0;
    do {
      c = (a + b) % m;
      a = b;
      b = c;
      pp++;
    } while (a != 0 || b != 1);
    return pp;
  }

  /**
   * Рассчитывает остаток от деления числа Фибоначчи n на период Пизано
   *
   * @param n индекс числа Фибоначчи
   * @param m целое число
   * @return остаток от деления
   */
  public static long fibonacciModulo(long n, long m) {

    // Getting the period
    long pisanoPeriod = pisano(m);

    n = n % pisanoPeriod;

    long prev = 0;
    long curr = 1;

    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }

    for (int i = 0; i < n - 1; i++) {
      long temp;
      temp = curr;
      curr = (prev + curr) % m;
      prev = temp;
    }
    return curr % m;
  }

}
