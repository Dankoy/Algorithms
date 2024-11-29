package ru.dankoy.datastructures.list.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDYI2<T> implements List<T> {

    private Element<T> head;
    private int size = 0;

    LinkedListDYI2() {
        head = new Element<>(null, null, null);
        head.setNext(head);
        head.setPrev(head);

    }

    @Override
    public boolean add(T e) {

        if (size == 0) {

            var elem = new Element<T>(e, head, head);

            head.setNext(elem);
            head.setPrev(elem);

        } else {
            var lastElement = head.getPrev();
            var elem = new Element<>(e, lastElement, head);
            lastElement.setNext(elem);
            head.setPrev(elem);
        }

        size++;

        return true;

    }

    public T get() {

        return head.getPrev().getE();

    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public T set(int idx, T e) {

        Element<T> foundElement = null;

        if (idx >= size) {
            throw new IndexOutOfBoundsException(idx);
        }

        for (int i = 0; i <= idx; i++) {
            foundElement = head.getNext();
        }

        // получить объект слева и вставить между ними

        var prev = foundElement.getPrev();

        var elem = new Element<>(e, prev, foundElement);

        prev.setNext(elem);
        foundElement.setPrev(elem);

        size++;

        return e;

    }

    private static class Element<T> {

        private final T e;
        private Element<T> prev;
        private Element<T> next;

        Element(T e, Element<T> prev, Element<T> next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        T getE() {
            return e;
        }

        void setPrev(Element<T> prev) {
            this.prev = prev;
        }

        void setNext(Element<T> next) {
            this.next = next;
        }

        Element<T> getPrev() {
            return prev;
        }

        Element<T> getNext() {
            return next;
        }

    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
