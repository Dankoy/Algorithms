package ru.dankoy.computersciencecentre.greatcommondivisor;

import java.util.Scanner;

/**
 * По данным двум числам  1 \le a, b \le 2 * 10^9 найдите их наибольший общий делитель.
 */
public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int r;
    int a = in.nextInt();
    int b = in.nextInt();
    r = euclidGreatCommonDivisor(a, b);
    System.out.print(r);
  }


  /**
   * Вычисляет наибольший общий делитель по алгоритму Евклида
   *
   * @param a первое целое число
   * @param b второе целое число
   * @return НОД
   */
  public static int euclidGreatCommonDivisor(int a, int b) {
    if (a == 0) {
      return b;
    } else if (b == 0) {
      return a;
    } else if (a >= b) {
      return euclidGreatCommonDivisor(a % b, b);
    } else {
      return euclidGreatCommonDivisor(a, b % a);
    }

  }

}