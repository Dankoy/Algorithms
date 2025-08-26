package ru.dankoy.computersciencecentre.greedyalgorithms.priorityqueue;

import java.util.Arrays;

public class MaxStack<T> {
    private int currentPosition = 0;
    private Object[] array = new Object[10];

    public int getSize() {

        // надо высчитывать каждый раз размер дерева.

        if (currentPosition == 0) {
            return 0;
        } else {
            return currentPosition - 1;
        }

    }

    /**
     * Добавляет элемент с приоритетом в список
     *
     * @param element элемент
     */
    public void push(T element, long priority) {

        Element<T> element1 = new Element<>(element, priority);

        array[currentPosition] = element1;
        currentPosition++;

        if (currentPosition + 1 >= array.length) {
            array = Arrays.copyOf(array, array.length * 2, Object[].class);
        }

        if (currentPosition > 1) {
            siftUp(element1);
        }

    }

    /**
     * Получает максимум из кучи
     *
     * @return максимум
     */
    @SuppressWarnings(value = "unchecked")
    public T pop() {

        // берем максимум в самом начале
        T max = ((Element<T>) array[0]).getEl();

        // просеиваем вниз

        // перетаскиваем последний элемент дерева в корень
        array[0] = array[currentPosition - 1];
        array[currentPosition - 1] = null;

        currentPosition--;

        int[] existingRootChildren = childrenIndexes(0);

        if (existingRootChildren.length > 1) {
            if (((Element<T>) array[0]).getPriority() < ((Element<T>) array[existingRootChildren[0]]).getPriority()
                    || ((Element<T>) array[0]).getPriority() < ((Element<T>) array[existingRootChildren[1]])
                            .getPriority()) {
                siftDown();
            }
        } else if (existingRootChildren.length == 1 && ((Element<T>) array[0])
                .getPriority() < ((Element<T>) array[existingRootChildren[0]]).getPriority()) {
            siftDown();
        }

        return max;

    }

    /**
     * Просеивание вверх
     *
     * @param element элемент
     */
    @SuppressWarnings(value = "unchecked")
    private void siftUp(Element<T> element) {

        // получаю индексы
        int addedElementIndex = currentPosition - 1;
        int parentElementIndex = parentIndexOfElement(addedElementIndex);

        while (addedElementIndex > 0) {

            if (((Element<T>) array[addedElementIndex]).getPriority() >= ((Element<T>) array[parentElementIndex])
                    .getPriority()) {

                Element<T> parentElement = (Element<T>) array[parentElementIndex];

                // удаляем родительский элемент и ставим на его место новый элемент
                array[parentElementIndex] = element;
                array[addedElementIndex] = parentElement;

                addedElementIndex = parentElementIndex;

                parentElementIndex = parentIndexOfElement(addedElementIndex);

            } else {
                break;
            }

        }

    }

    /**
     * Просеивание вниз
     */
    @SuppressWarnings(value = "unchecked")
    private void siftDown() {

        int rootIndex = 0;

        // ищем детей ноды

        int[] children = childrenIndexes(rootIndex);

        while (children.length != 0) {

            int indexWithMaxElement = getMaxElementOfChildren(children);

            Element<T> rootElement = (Element<T>) array[rootIndex];

            if (rootElement.getPriority() < ((Element<T>) array[indexWithMaxElement]).getPriority()) {
                // значения ребенка переносим вверх
                array[rootIndex] = array[indexWithMaxElement];
                array[indexWithMaxElement] = rootElement;

                rootIndex = indexWithMaxElement;

                children = childrenIndexes(rootIndex);
            } else {
                break;
            }

        }

    }

    /**
     * Возвращает индекс максимального элемента детей
     *
     * @param childrenIndexes индексы детей
     * @return индекс максимального элемента
     */
    @SuppressWarnings(value = "unchecked")
    private int getMaxElementOfChildren(int[] childrenIndexes) {

        // может быть либо два элемента либо 1, если два то выбираем максимум из двух
        if (childrenIndexes.length == 2) {

            if (((Element<T>) array[childrenIndexes[0]]).getPriority() >= ((Element<T>) array[childrenIndexes[1]])
                    .getPriority()) {
                return childrenIndexes[0];
            } else {
                return childrenIndexes[1];
            }

            // если только один индекс, то возвращаем его
        } else {
            return childrenIndexes[0];
        }

    }

    /**
     * Возвращает индекс родителя
     *
     * @param indexOfCurrentElement текущий индекс элемента
     * @return индекс родителя
     */
    private int parentIndexOfElement(int indexOfCurrentElement) {

        double parentIndexBeforeFloor = (indexOfCurrentElement - 1) / 2D;

        return (int) Math.floor(parentIndexBeforeFloor);

    }

    /**
     * Получает массив из двух или одного элемента с индексами детей
     *
     * @param indexOfCurrentElement текущий индекс ноды
     * @return массив с индексами детей
     */
    private int[] childrenIndexes(int indexOfCurrentElement) {

        int[] arr = new int[2];

        // indexOfCurrentElement++; // увеличиваю на 1, для соответствия индексу дерева

        int firstChild = 2 * indexOfCurrentElement + 1;
        int secondChild = 2 * indexOfCurrentElement + 2;

        if (firstChild <= getSize()) {
            arr[0] = firstChild;
        }
        if (secondChild <= getSize()) {
            arr[1] = secondChild;
        }

        // удаляем null елементы из массива
        return Arrays.stream(arr)
                .filter(f -> f != 0)
                .toArray();

    }

    @Override
    public String toString() {
        return "{\"MaxPriorityQueue\":{"
                + "\"array\":" + Arrays.toString(array)
                + "}}";
    }

    private static class Element<T> {

        private final T el;
        private final long priority;

        public Element(T el, long priority) {
            this.el = el;
            this.priority = priority;
        }

        public T getEl() {
            return el;
        }

        public long getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return "{\"Element\":{"

                    + "\"el\":" + el
                    + ", \"priority\":\"" + priority + "\""
                    + "}}";
        }
    }
}
