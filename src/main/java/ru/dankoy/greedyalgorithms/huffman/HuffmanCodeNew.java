package ru.dankoy.greedyalgorithms.huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class HuffmanCodeNew {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    String s = in.next();
    Map<Character, Integer> map = new HashMap<>();

    // Заполняет Map, где ключ это символ, а значение - количество его повторений
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    Map<Character, Nodee> charNod = new HashMap<>(); // карта соответствия ноды и символа
    Queue<Nodee> nodePriorityQueue = new PriorityQueue<>(Comparator.comparing(Nodee::getSum));

    // Перекладываем из мэпы в лепестки дерева, а так же добавляем каждый лепесток в очердь с
    // приоритетом
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      Nodee node = new Nodee(entry.getValue(), entry.getKey());
      nodePriorityQueue.add(node);
      charNod.put(entry.getKey(), node);
    }

    int sum = 0;
    // Строим дерево до рутовой ноды (последней)
    while (nodePriorityQueue.size() > 1) {
      Nodee first = nodePriorityQueue.poll();
      Nodee second = nodePriorityQueue.poll();
      Nodee parentOfLastTwo = new Nodee(first, second);
      sum = sum + parentOfLastTwo.getSum();
      nodePriorityQueue.add(parentOfLastTwo);
    }

    // Формируем рутовую ноду и запускаем функцию подсчета кодов
    Optional<Nodee> optionalNodee = Optional.ofNullable(nodePriorityQueue.poll());
    optionalNodee.ifPresent(nodee -> {
      if (nodee.isLeaf()) {
        nodee.buildCode("0");
      } else {
        nodee.buildCode("");
      }
    });

    // Печать результата

    if (map.size() == 1) {
      sum = s.length();
    }
    System.out.println(map.size() + " " + sum);

    optionalNodee.ifPresent(Nodee::print);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      sb.append(charNod.get(c).getCode());
    }
    System.out.println(sb);

  }


}


class Nodee {

  int sum;
  String code = "";
  Character character;

  Nodee left;
  Nodee right;
  Nodee parent;

  public Nodee(int sum, Character character) {
    this.sum = sum;
    this.character = character;
  }

  public Nodee(Nodee left, Nodee right) {
    this.left = left;
    this.right = right;
    this.sum = left.sum + right.sum;
    this.left.parent = this;
    this.right.parent = this;
  }

  public boolean isLeaf() {
    return this.left == null && this.right == null;
  }

  public void print() {

    if (isLeaf()) {
      System.out.printf("%s: %s%n", character, code);
    }

    if (left != null) {
      left.print();
    }
    if (right != null) {
      right.print();
    }
  }

  public void buildCode(String code) {

    this.code = code;

    if (left != null) {
      left.buildCode(code + "0");
    }
    if (right != null) {
      right.buildCode(code + "1");
    }

  }

  public int getSum() {
    return sum;
  }

  public String getCode() {
    return code;
  }

  @Override
  public String toString() {
    return "{\"Nodee\":{"

        + "\"sum\":\"" + sum + "\""
        + ", \"code\":\"" + code + "\""
        + ", \"character\":" + character
        + ", \"left\":" + left
        + ", \"right\":" + right
        + "}}";
  }
}
