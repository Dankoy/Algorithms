package ru.dankoy.dinamicprogramming.rucksack.withoutrepetitions;

import java.util.Scanner;


/**
 * Задача на программирование: рюкзак
 * <p>
 * Первая строка входа содержит целые числа 1≤W≤10^4 и 1≤n≤300  — вместимость рюкзака и число
 * золотых слитков. Следующая строка содержит n целых чисел 0≤w1,…,wn≤10^5 задающих веса слитков.
 * Найдите максимальный вес золота, который можно унести в рюкзаке.
 */
public class RucksackWithoutRepetitions {

  public static void main(String[] args) {
    new RucksackWithoutRepetitions().run();
  }


  private void run() {

    Scanner in = new Scanner(System.in);

    int rucksackMaxWeight = in.nextInt();
    int amountOfGoldenIngot = in.nextInt();

    int[] ingotsWeight = new int[amountOfGoldenIngot];

    for (int i = 0; i < amountOfGoldenIngot; i++) {

      ingotsWeight[i] = in.nextInt();

    }

//    System.out.println(rucksackMaxWeight);
//    System.out.println(Arrays.toString(ingotsWeight));

    int[][] d = knapsackWithoutRepetitionsBu(rucksackMaxWeight, ingotsWeight, ingotsWeight);

    System.out.println(d[d.length - 1][d[0].length - 1]);

  }

  /**
   * Рассчитывает матрицу заполнения рюкзака без повторений
   *
   * @param knapsackMaxWeight максимальный вес рюкзака
   * @param itemWeights       массив весов элементов
   * @param itemPrice         массив цен элементов
   * @return матрица заполнения рюкзака без повторений
   */
  private int[][] knapsackWithoutRepetitionsBu(int knapsackMaxWeight, int[] itemWeights,
      int[] itemPrice) {

    int amountOfWeights = itemWeights.length;

    // Создаем результирующую матрицу, где вес - это строка, а элементы рюкзака - это номера
    // строк (столбцы)
    int[][] d = new int[amountOfWeights + 1][knapsackMaxWeight + 1];

    // заполняем первую строку нулями
    for (int w = 0; w <= knapsackMaxWeight; w++) {

      d[0][w] = 0;

    }

    // заполняем первый столбец нулями
    for (int i = 0; i <= amountOfWeights; i++) {

      d[i][0] = 0;

    }

    // формирование матрицы
    for (int i = 1; i <= amountOfWeights; i++) {

      for (int w = 1; w <= knapsackMaxWeight; w++) {

        d[i][w] = d[i - 1][w];

        // получаем вес iтого элемента
        int weightOfIElement = itemWeights[i - 1];
        int priceOfIElement = itemPrice[i - 1];

        // если вес i-го элемента меньше чем текущий вес рюкзака, то ищем максимум из веса с
        // добавлением элемента в рюкзак и без
        if (weightOfIElement <= w) {

          d[i][w] = Math.max(d[i][w], d[i - 1][w - weightOfIElement] + priceOfIElement);

        }

      }

    }

//    System.out.println(Arrays.deepToString(d));

    return d;
  }

}
