package ru.dankoy.greedyalgorithms.easy.continuousknapsackproblem;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Первая строка содержит количество предметов 1≤n≤103 и вместимость рюкзака 0≤W≤2⋅10^6. Каждая из
 * следующих n строк задаёт стоимость 0≤ci≤2⋅10^6 и объём 0< wi≤2⋅10^6 предмета ( n,  W, ci, wi —
 * целые числа). Выведите максимальную стоимость частей предметов (от каждого предмета можно
 * отделить любую часть, стоимость и объём при этом пропорционально уменьшатся), помещающихся в
 * данный рюкзак, с точностью не менее трёх знаков после запятой.
 */
public class ContinuousKnappSack {

  public static void main(String[] args) {
    new ContinuousKnappSack().run();
  }

  private void run() {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long knappSackMaxVolume = in.nextLong();
    List<Item> items = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      items.add(new Item(in.nextLong(), in.nextLong()));
    }

    // сортировка вещей по удельной стоимости вещей в обратном порядке (слева максимум)
    items.sort(Comparator.comparing(item -> ((double) item.price / item.volume),
        Comparator.reverseOrder()));

    double res = 0D;
    for (Item item : items) {
      if (item.volume <= knappSackMaxVolume) {
        res = res + item.price;
        knappSackMaxVolume = knappSackMaxVolume - item.volume;
      } else {
        res = res + (double) item.price * knappSackMaxVolume / item.volume;
        break;
      }
    }
    System.out.print(withBigDecimal(res, 3));

  }

  public static double withBigDecimal(double value, int places) {
    BigDecimal bigDecimal = BigDecimal.valueOf(value);
    bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
    return bigDecimal.doubleValue();
  }

  static class Item {

    private final long price;
    private final long volume;

    public Item(long a, long b) {
      this.price = a;
      this.volume = b;
    }

    @Override
    public String toString() {
      return "{"
          + "\"price\":" + price
          + ", \"volume\":" + volume
          + "}";
    }
  }
}
