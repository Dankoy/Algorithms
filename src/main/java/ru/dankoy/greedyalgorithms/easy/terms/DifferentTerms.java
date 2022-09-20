package ru.dankoy.greedyalgorithms.easy.terms;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * различные слагаемые
 * <p>
 * По данному числу 1≤n≤10^9 найдите максимальное число k, для которого n можно представить как
 * сумму  k различных натуральных слагаемых. Выведите в первой строке число k, во второй — k
 * слагаемых.
 */
public class DifferentTerms {

  public static void main(String[] args) {
    new DifferentTerms().run();
  }

  private void run() {

    Scanner in = new Scanner(System.in);
    long n = in.nextLong();

    List<Long> res = calculateTerms(n);

    System.out.println(createResultString(res));

  }

  /**
   * На каждом шаге уменьшаем исходное число на текущее значение итератора цикла и проверяем, то,
   * что осталось, больше следующего значения итератора цикла или нет. Если больше, добавляем
   * текущее значение итератора цикла в список слагаемых и продолжаем, если нет, добавляем
   * оставшуюся часть исходного числа и выходим.
   *
   * @param number число
   * @return список слагаемых
   */
  private List<Long> calculateTerms(long number) {

    List<Long> res = new ArrayList<>();

    long currentRest = number;

    for (long i = 1; i <= number; i++) {

      currentRest = currentRest - i;

      if (currentRest < i + 1) {
        res.add(currentRest + i);
        break;
      } else {
        res.add(i);
      }

    }

    return res;

  }

  private String createResultString(List<Long> result) {

    StringBuilder builder = new StringBuilder();
    String concat;
    for (int i = 0, resultSize = result.size(); i < resultSize; i++) {
      long l = result.get(i);

      if (i != resultSize - 1) {
        builder
            .append(l)
            .append(" ");
      } else {
        builder
            .append(l);
      }

    }

    concat = builder.toString();

    return String.format("%d%n%s", result.size(), concat);

  }
}
