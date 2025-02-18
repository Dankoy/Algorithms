package ru.dankoy.datastructures.stack.concurrent;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrStack<T> {

  private AtomicReference<Node<T>> head;

  public ConcurrStack() {
    head = new AtomicReference<>(new Node<>(null, null));
  }

  public void push(T obj) {

    Node<T> currentValue;
    Node<T> newValue;

    do {

      currentValue = head.get();
      newValue = new Node<>(head.get(), obj);

    } while (!head.compareAndSet(currentValue, newValue));
  }

  public T poll() {

    Node<T> currentValue;
    Node<T> newValue;

    do {

      if (head.get().prev == null) {
        throw new NoSuchElementException();
      }

      newValue = head.get().prev;
      currentValue = head.get();

    } while (!head.compareAndSet(currentValue, newValue));

    return currentValue.element;
  }

  private static final class Node<T> {

    private Node<T> prev;
    private T element;

    Node(Node<T> prev, T element) {
      this.prev = prev;
      this.element = element;
    }
  }
}
