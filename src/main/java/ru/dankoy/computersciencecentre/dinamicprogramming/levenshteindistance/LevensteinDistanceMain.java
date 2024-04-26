package ru.dankoy.computersciencecentre.dinamicprogramming.levenshteindistance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Задача на программирование: расстояние редактирования
 * <p>
 * <p>
 * Вычислите расстояние редактирования двух данных непустых строк длины не более 10^2,
 * содержащих строчные буквы латинского алфавита.
 */
public class LevensteinDistanceMain {

  public static void main(String[] args) {
    new LevensteinDistanceMain().run();
  }


  private void run() {

    Scanner in = new Scanner(System.in);
    String string1 = in.next();
    String string2 = in.next();

    int result = levensteinDistance(string1, string2);

    System.out.println(result);

  }

  /**
   * Считает дистанцию Левенштейна
   *
   * @param string1 строка1
   * @param string2 строка2
   * @return минимальное количество изменений необходимых для преобразования A в B.
   */
  private int levensteinDistance(String string1, String string2) {

    char[] string1Chars = string1.toCharArray();
    char[] string2Chars = string2.toCharArray();

    int string1Length = string1Chars.length;
    int string2Length = string2Chars.length;

    int[][] matrix = new int[string1Length + 1][string2Length + 1];

    // Заполняем первую строку i значением
    for (int i = 0; i <= string1Length; i++) {
      matrix[i][0] = i;
    }

    //Заполняем первый столбец j значением
    for (int j = 0; j <= string2Length; j++) {
      matrix[0][j] = j;
    }

    // Вычисляем последующие значения матрицы по правилам алгоритма
    for (int i = 1; i <= string1Length; i++) {

      for (int j = 1; j <= string2Length; j++) {

        int diff = diff(string1Chars[i - 1], string2Chars[j - 1]);

        matrix[i][j] = Math.min(Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1),
            matrix[i - 1][j - 1] + diff);


      }

    }

    System.out.println(Arrays.deepToString(matrix));

    return matrix[string1Length][string2Length];
  }


  /**
   * Сравнивает два символа
   *
   * @param a символ строки
   * @param b символ
   * @return 1 если не равны, 0 если равны
   */
  private int diff(char a, char b) {

    int compare = Character.compare(a, b);

    if (compare == 0) {
      return 0;
    } else {
      return 1;
    }

  }

}
