package ru.dankoy.datastructures.list.arraylist;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class DIYArrayList<E> implements List<E> {

    private final static int INITIAL_ARRAY_SIZE = 10;
    private Object[] array;
    private int lastUsedElement = 0;

    public DIYArrayList() {
        array = new Object[INITIAL_ARRAY_SIZE];
    }

    /**
     * Конструктор, создающий ArrayList определенного размера. Если размер отрицательный - выбрасывается
     * исключение
     *
     * @param arraySize
     */
    public DIYArrayList(int arraySize) {
        array = new Object[arraySize];
        if (arraySize >= 0) {
            array = new Object[arraySize];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + arraySize);
        }
    }

    @Override
    public int size() {
        return lastUsedElement;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        return new DIYArrayListSimpleIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, lastUsedElement);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    /**
     * Метод добавляющий элемент в массив.
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        set(lastUsedElement, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) array, 0, lastUsedElement, c);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        if (index >= array.length) {
            grow();
        }
        E oldElement = (E) array[index];
        array[index] = element;
        if (index >= lastUsedElement) {
            lastUsedElement = index + 1;
        }
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    // Итератор
    @Override
    public ListIterator<E> listIterator() {
        return new DIYArrayListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }

    private void grow() {

        array = Arrays.copyOf(array, array.length * 2);

    }


    private class DIYArrayListSimpleIterator implements Iterator<E> {

        private int currentPlace = 0;
        private int lastReturnedIndex = -1;

        @Override
        public boolean hasNext() {
            if (currentPlace < lastUsedElement) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E next() {
            if (hasNext()) {
                Object element = array[currentPlace];
                lastReturnedIndex = currentPlace;
                currentPlace += 1;
                return (E) element;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    // ListIterator
    private class DIYArrayListIterator implements ListIterator<E> {

        private int currentPlace = 0;
        private int lastReturnedIndex = -1;

        @Override
        public boolean hasNext() {

            if (currentPlace < lastUsedElement) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public E next() {
            if (hasNext()) {
                Object element = array[currentPlace];
                lastReturnedIndex = currentPlace;
                currentPlace += 1;
                return (E) element;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            // крайние случаи здесь могут быть?
            DIYArrayList.this.set(lastReturnedIndex, e);

        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            throw new UnsupportedOperationException();
        }
    }


}
