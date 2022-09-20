package ru.dankoy.greedyalgorithms.easy.coversegmentswithdots;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * По данным  n отрезкам необходимо найти множество точек минимального размера, для которого каждый
 * из отрезков содержит хотя бы одну из точек.
 * <p>
 * В первой строке дано число  1 \le n \le 100  отрезков. Каждая из последующих n строк содержит по
 * два числа 0≤l≤r≤10^9 , задающих начало и конец отрезка. Выведите оптимальное число m точек и сами
 * m точек. Если таких множеств точек несколько, выведите любое из них.
 */
public class CoverSegmentsWithDots {

  public static void main(String[] args) {
    new CoverSegmentsWithDots().run();
  }

  private void run() {

    List<Segment> segments = new ArrayList<>();

    Scanner in = new Scanner(System.in);
    int amountOfSegments = in.nextInt();

    for (int i = 1; i <= amountOfSegments; i++) {

      long start = Long.parseLong(in.next());
      long end = Long.parseLong(in.next());

      segments.add(new Segment(start, end));

    }

    // сортировка по концам отрезков
    segments.sort(Comparator.comparing(Segment::getEnd));

    List<Long> result = greedy(segments);

    String out = createResultString(result);
    System.out.println(out);

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


  /**
   * Далее мы определяем список точек, куда записываем правый край первого отрезка из
   * отсортированного списка.  Дальнейшая реализация заключается в проверке, пересекается ли левый
   * край каждого отрезка с крайней точкой в списке точек. Если да - идем к след. отрезку. Если нет
   * - записываем значение правого края отрезка.
   *
   * @param segments отсортированные отрезки
   * @return список точек
   */
  private List<Long> greedy(List<Segment> segments) {

    List<Long> dots = new ArrayList<>();

    dots.add(segments.get(0).end);

    for (int i = 1; i <= segments.size() - 1; i++) {

      Segment next = segments.get(i);

      if (next.start > dots.get(dots.size() - 1)) {
        dots.add(next.end);
      }
    }

    return dots;

  }


  static class Segment {

    private final long start;
    private final long end;

    public Segment(long start, long end) {
      this.start = start;
      this.end = end;
    }

    public long getEnd() {
      return end;
    }

    @Override
    public String toString() {
      return "{"
          + "\"start\":" + start
          + ", \"end\":" + end
          + "}";
    }
  }

}
