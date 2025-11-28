package ru.dankoy.tasks.messagefilter;

import java.util.Map;

import ru.dankoy.tasks.messagefilter.config.FilterConfiguration;
import ru.dankoy.tasks.messagefilter.filters.Filter;
import ru.dankoy.tasks.messagefilter.filters.FilterImpl;
import ru.dankoy.tasks.messagefilter.message.Message;
import ru.dankoy.tasks.messagefilter.sender.Sender;

public class MessageFilterMain {

    public static void main(String[] args) {

        // config

        Map<Long, Sender> senderService = Map.of(1L, new Sender(1L, true), 2L, new Sender(2L, false));
        Map<Long, Message> messageService = Map.of(1L, new Message(1L, 1L, 2L, "mess1"), 2L,
                new Message(2L, 2L, 1L, "mess2"));
        FilterConfiguration filterConfiguration = new FilterConfiguration(senderService, messageService);

        var p1 = filterConfiguration.bannedFilter();
        var p2 = filterConfiguration.idempotencyFilter();
        var p3 = filterConfiguration.typeFilter();

        Filter<Message> filter = new FilterImpl<>(p3, p1, p2);

        // do filter

        Message message1 = new Message(1L, 1L, 2L, "mess1"); // should be filtered
        Message message2 = new Message(2L, 2L, 1L, "mess2"); // should not filtered

        filter.doFilter(message1);
        filter.doFilter(message2);

    }

}
