package ru.dankoy.datastructures.stack.concurrent;

import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {

    var stack = new ConcurrStack<Integer>();

    var executorService = Executors.newFixedThreadPool(2);

    Runnable run = () -> stack.push(1);
    Runnable run2 = () -> stack.push(2);

    Runnable run3 = () -> System.out.println(stack.poll());
    Runnable run4 = () -> System.out.println(stack.poll());

    executorService.execute(run);
    executorService.execute(run2);

    executorService.execute(run3);
    executorService.execute(run4);
    executorService.execute(run4);

    executorService.shutdown();
  }
}
