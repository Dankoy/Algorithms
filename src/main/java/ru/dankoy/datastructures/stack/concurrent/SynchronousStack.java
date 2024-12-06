package ru.dankoy.datastructures.stack.concurrent;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class SynchronousStack<T> {

    private final AtomicReference<Element<T>> head;

    public SynchronousStack() {
        var element = new Element<T>(null);
        head = new AtomicReference<>(element);
    }

    public void push(T obj) {

        Element<T> current;
        Element<T> elem;

        do {
            current = head.get();
            elem = new Element<>(obj, current);

        } while (!head.compareAndSet(current, elem));

    }

    public T pop() {

        Element<T> current;
        Element<T> prev;

        do {

            current = head.get();

            if (Objects.isNull(current.getObj())) {
                return null;
            }

            prev = current.getPrev();

            // while current element in head not equals element in current (because )
        } while (!head.compareAndSet(current, prev));

        return current.getObj();

    }

    private static class Element<T> {

        private final T obj;
        private Element<T> prev;

        public Element(T obj) {
            this(obj, null);
        }

        public Element(T obj, Element<T> prev) {
            this.obj = obj;
            this.prev = prev;
        }

        public T getObj() {
            return obj;
        }

        public Element<T> getPrev() {
            return prev;
        }

    }
}
