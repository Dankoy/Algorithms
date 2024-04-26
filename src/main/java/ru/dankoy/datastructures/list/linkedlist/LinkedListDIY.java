package ru.dankoy.datastructures.list.linkedlist;

//	- add
//	- set (int index, …)
//	- reverse - инветирует порядок элементов

public interface LinkedListDIY<T> {

  void add(T element);

  void set(int index, T element);

  void reverse();


  int size();

  T get(int index);
}
