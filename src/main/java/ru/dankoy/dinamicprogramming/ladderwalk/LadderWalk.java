package ru.dankoy.dinamicprogramming.ladderwalk;

import java.util.Arrays;
import java.util.Scanner;

public class LadderWalk {

  public static void main(String[] args) {
    new LadderWalk().run();
  }

  private void run() {

    Scanner in = new Scanner(System.in);

    int amountOfStairs = in.nextInt();

    int[] stairsWeights = new int[amountOfStairs + 1];

    // Заполняем нулевую ступеньку - подножие нулем

    stairsWeights[0] = 0;

    for (int i = 1; i < amountOfStairs + 1; i++) {

      stairsWeights[i] = in.nextInt();

    }

    System.out.println(Arrays.toString(stairsWeights));

    int result = findSum(stairsWeights);
    System.out.println(result);

  }

  /**
   * Находит ссумму всех весов прохождения лестницы для получения максимального значения
   *
   * @param stairsWeights массив весов ступенек
   * @return сумма
   */
  private int findSum(int[] stairsWeights) {

    // Можем идти внизу вверх либо на один шаг поднимаясь, либо на два

    // если ступенек меньше двух, то возвращаем стимость единственной ступени
    if (stairsWeights.length < 2) {
      return stairsWeights[1];
    } else {

      // начиная со сторой ступеньки прохожим лестницу.
      // для каждой итерации находим максимум из двух предыдущих ступенек. При этом добавляем сумму
      // максимума к текущей ступеньки. Таким образом будем знать на какую ступеньку надо наступить,
      // что бы получить максимум по сумме весов
      for (int i = 2; i < stairsWeights.length; i++) {

        int weightOfPreviousOne = stairsWeights[i - 1];
        int weightOfPreviousTwo = stairsWeights[i - 2];
        int weightOfCurrentOne = stairsWeights[i];

        int maxOfPreviousStairs = Math.max(weightOfPreviousOne, weightOfPreviousTwo);

        stairsWeights[i] = maxOfPreviousStairs + weightOfCurrentOne;

      }

    }

    return stairsWeights[stairsWeights.length - 1];
  }

}
