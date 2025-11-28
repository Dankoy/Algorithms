package ru.dankoy.tasks.messagefilter.sender;

import java.util.Objects;

public class Sender {

    private final long id;
    private final boolean banned;

    public Sender(long id, boolean banned) {
        this.id = id;
        this.banned = banned;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sender)) {
            return false;
        }
        Sender sender = (Sender) o;
        return id == sender.id && banned == sender.banned;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, banned);
    }

    public long getId() {
        return this.id;
    }

    public boolean getBanned() {
        return this.banned;
    }

    public boolean isBanned() {
        return this.banned;
    }

}
