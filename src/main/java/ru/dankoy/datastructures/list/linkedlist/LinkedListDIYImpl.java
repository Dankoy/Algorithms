package ru.dankoy.datastructures.list.linkedlist;

import java.util.Objects;

public class LinkedListDIYImpl<T> implements LinkedListDIY<T> {

  private int size;
  private Entity<T> head;
  private Entity<T> tail;


  public LinkedListDIYImpl() {

    size = 0;
    head = null;
    tail = null;

  }

  @Override
  public void add(T element) {

    // добавляем в конец и добавляем ссылки на рядом стоящие элементы
    tail = new Entity<>(element, null, tail);

    if (head == null) {
      head = tail;
    }

    size = size + 1;

  }

  @Override
  public void set(int index, T element) {

    checkIndex(index);

    var x = getElementByIndex(index);

    x.setObject(element);

  }

  private void checkIndex(int index) {

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }


  }

  @Override
  public void reverse() {

    var x = head;
    var index = 0;

    while (index < size) {
      var nextElement = x.next;
      var temp = x.previous;

      x.previous = nextElement;
      x.next = temp;

      x = x.previous;
      index++;

    }

    // меняем местами хвост и голову

    var temp = tail;
    tail = head;
    head = temp;


  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T get(int index) {

    checkIndex(index);

    return getElementByIndex(index).object;

  }

  private Entity<T> getElementByIndex(int index) {

    Entity<T> x = head;

    for (int i = 0; i < index; i++) {

      x = x.next;

    }

    return x;

  }


  static class Entity<T> {

    private T object;
    private Entity<T> next;
    private Entity<T> previous;

    Entity(T object, Entity<T> next, Entity<T> previous) {

      this.object = object;
      this.next = next;
      this.previous = previous;

      if (Objects.nonNull(this.previous)) {
        this.previous.setNext(this);
      }

      if (Objects.nonNull(this.next)) {
        this.next.setPrevious(this);
      }

    }


    void setObject(T object) {
      this.object = object;
    }

    Entity<T> getPrevious() {
      return previous;
    }

    Entity<T> getNext() {
      return next;
    }

    void setNext(Entity<T> next) {
      this.next = next;
    }

    void setPrevious(Entity<T> previous) {
      this.previous = previous;
    }


  }

}
