package ru.dankoy.tasks.messagefilter.filters;

public interface Filter<T> {

    public void doFilter(T message);

}
