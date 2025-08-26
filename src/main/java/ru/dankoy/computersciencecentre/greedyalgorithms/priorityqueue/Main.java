package ru.dankoy.computersciencecentre.greedyalgorithms.priorityqueue;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  private final MaxStack<Long> maxPriorityQueue = new MaxStack<>();

  public static void main(String[] args) {
    new Main().run();
  }

  private void run() {

    Scanner in = new Scanner(System.in);

    int numberOfOperations = Integer.parseInt(in.nextLine());

    for (int i = 0; i < numberOfOperations; i++) {

      String op = in.nextLine();

      if (op.contains("Insert")) {
        String[] extractor = op.split(" ");
        long number = Long.parseLong(extractor[1]);

        maxPriorityQueue.push(number, number);

      } else if (op.contains("ExtractMax")) {

        long max = maxPriorityQueue.pop();

        System.out.println(max);
      }

    }

  }

}
