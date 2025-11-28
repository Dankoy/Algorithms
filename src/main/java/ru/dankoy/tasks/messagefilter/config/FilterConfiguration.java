package ru.dankoy.tasks.messagefilter.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import ru.dankoy.tasks.messagefilter.message.Message;
import ru.dankoy.tasks.messagefilter.sender.Sender;

// @RequiredArgsConstructor
// @Configuration
public class FilterConfiguration {

    private final Map<Long, Sender> senderService;
    private final Map<Long, Message> messageService;

    public FilterConfiguration(Map<Long, Sender> senderService, Map<Long, Message> messageService) {
        this.senderService = senderService;
        this.messageService = messageService;
    }

    // @Bean
    public Predicate<Message> typeFilter() {
        return message -> message instanceof Message;
    }

    // @Bean
    public Predicate<Message> bannedFilter() {

        return message -> {

            long senderId = message.getSenderId();

            Sender sender = senderService.get(senderId);

            return !sender.isBanned();

        };

    }

    // @Bean
    public Predicate<Message> idempotencyFilter() {
        return message -> {
            Optional<Message> found = Optional.of(messageService.get(message.getId()));

            return !found.isPresent();

        };
    }

}
