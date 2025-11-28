package ru.dankoy.tasks.messagefilter.filters;

import java.util.function.Predicate;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FilterImpl<T> implements Filter<T> {

    private final Predicate<T> typeFilter;
    private final Predicate<T> bannedFilter;
    private final Predicate<T> idempotencyFilter;

    public FilterImpl(Predicate<T> typeFilter, Predicate<T> bannedFilter, Predicate<T> idempotencyFilter) {
        this.typeFilter = typeFilter;
        this.bannedFilter = bannedFilter;
        this.idempotencyFilter = idempotencyFilter;
    }

    @Override
    public void doFilter(T message) {

        Predicate<T> chain = typeFilter
                .or(bannedFilter)
                .or(idempotencyFilter);

        if (chain.test(message)) {
            // log.info("Filtered message {}", message);
            System.out.println("filtered message " + message);
            throw new IllegalStateException();
        }

    }

}
