package ru.dankoy.tasks.messagefilter.message;

import java.util.Objects;

public class Message {

    private final long id;
    private final long senderId;
    private final long recieverId;
    private final String message;

    public Message(long id, long senderId, long recieverId, String message) {
        this.id = id;
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Message)) {
            return false;
        }
        Message message = (Message) o;
        return id == message.id && senderId == message.senderId && recieverId == message.recieverId
                && Objects.equals(message, message.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, senderId, recieverId, message);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", senderId='" + getSenderId() + "'" +
                ", recieverId='" + getRecieverId() + "'" +
                ", message='" + getMessage() + "'" +
                "}";
    }

    public long getId() {
        return this.id;
    }

    public long getSenderId() {
        return this.senderId;
    }

    public long getRecieverId() {
        return this.recieverId;
    }

    public String getMessage() {
        return this.message;
    }

}
