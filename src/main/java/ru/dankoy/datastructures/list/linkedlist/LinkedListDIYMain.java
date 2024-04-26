package ru.dankoy.datastructures.list.linkedlist;

import java.util.stream.IntStream;

public class LinkedListDIYMain {

  public static void main(String[] args) {

    var list = new LinkedListDIYImpl<Integer>();

    IntStream.range(0, 3).forEach(list::add);

    for (int i = 0; i < list.size(); i++) {
      System.out.println("idx: " + i + " " + list.get(i));
    }

    System.out.println("--------------------------");

    list.set(0, 111111);

    for (int i = 0; i < list.size(); i++) {
      System.out.println("idx: " + i + " " + list.get(i));
    }

    System.out.println("--------------------------");

    list.reverse();

    for (int i = 0; i < list.size(); i++) {
      System.out.println("idx: " + i + " " + list.get(i));
    }


  }

}
