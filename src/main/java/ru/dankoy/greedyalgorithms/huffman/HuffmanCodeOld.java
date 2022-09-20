package ru.dankoy.greedyalgorithms.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCodeOld {

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

    Map<Character, Node> charNod = new HashMap<>();

    PriorityQueue<Node> que = new PriorityQueue<>();



    // Перекладываем из мэпы в лепестки дерева, а так же добавляем каждый лепесток в очердь с
    // приоритетом
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      Leaf nod = new Leaf(entry.getKey(), entry.getValue());
      charNod.put(entry.getKey(), nod);
      que.add(nod);
    }

    System.out.println(que);


    // Строим дерево до рутовой ноды (последней)
    int sum = 0;
    while (que.size() > 1) {
      Node first = que.poll();
      Node second = que.poll();
      InnerNode node = new InnerNode(first, second);
      sum = sum + node.sum;
      que.add(node);
    }
    if (map.size() == 1) {
      sum = s.length();
    }
    System.out.println(map.size() + " " + sum);

    System.out.println(charNod);

    // Формируем рутовую ноду
    Node root = que.poll();
    if (map.size() == 1) {
      root.biltkod("0");
    } else {
      root.biltkod("");
    }

        System.out.println(charNod);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      sb.append(charNod.get(c).kod);
    }
    System.out.println(sb.toString());
  }
}



class Node implements Comparable<Node> {

  final int sum;
  String kod = "";

  void biltkod(String kod) {
    this.kod = kod;
  }

  public Node(int sum) {
    this.sum = sum;
  }

  @Override
  public int compareTo(Node o) {
    return Integer.compare(sum, o.sum);
  }

  @Override
  public String toString() {
    return "{"
        + "\"sum\":" + sum
        + ", \"kod\":\"" + kod + "\""
        + "}";
  }
}

class InnerNode extends Node {

  Node left;
  Node right;

  @Override
  void biltkod(String kod) {
    super.biltkod(kod);
    left.biltkod(kod + "0");
    right.biltkod(kod + "1");
  }

  public InnerNode(Node left, Node right) {
    super(left.sum + right.sum);
    this.left = left;
    this.right = right;
  }
}

class Leaf extends Node {

  char ch;

  @Override
  void biltkod(String kod) {
    super.biltkod(kod);
    System.out.println(ch + ": " + kod);
  }

  public Leaf(char ch, int count) {
    super(count);
    this.ch = ch;
  }

  @Override
  public String toString() {
    return "{\"Leaf\":"
        + ", \"ch\":\"" + ch + "\""
        + ", \"sum\":\"" + sum + "\""
        + ", \"kod\":\"" + kod + "\""
        + "}";
  }
}
