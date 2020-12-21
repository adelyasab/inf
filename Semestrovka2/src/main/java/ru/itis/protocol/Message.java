package ru.itis.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Message {
    protected final UserAction userAction;
    protected final int userId;

    public Message(UserAction userAction, int id) {
        this.userId = id;
        this.userAction = userAction;
    }

    public static byte[] getBytes(Message message) {
        int rawMessageLength = 4 + 4; // 4 байта на UserAction, 4 байта на X, 4 байта на Y, 4 байта на Deg, 4 байта на id

        byte[] rawMessage = new byte[rawMessageLength];

        int j = 0;
        byte[] type = getTypeBytes(message.getUserAction());
        for (int i = 0; i < type.length; i++) {
            rawMessage[j++] = type[i];
        }

        byte[] id = ByteBuffer.allocate(4).putInt(message.getUserId()).array();
        for (int i = 0; i < id.length; i++) {
            rawMessage[j++] = id[i];
        }

        return rawMessage;
    }

    private static byte[] getTypeBytes(UserAction type) {
        return ByteBuffer.allocate(4).put(type.getByte()).array();
    }

    public static Message createMessage(UserAction userAction, int id) {
        return new Message(userAction, id);
    }

    public static Message readMessage(InputStream inputStream) throws IOException {
        byte[] type = new byte[4];
        byte[] id = new byte[4];

        inputStream.read(type, 0, 4);
        byte typeByte = ByteBuffer.wrap(type, 0, 4).get();

        inputStream.read(id, 0, 4);
        int userId = ByteBuffer.wrap(id, 0, 4).getInt();

        return new Message(UserAction.getMessageType(typeByte), userId);
    }

    public UserAction getUserAction() {
        return userAction;
    }

    public int getUserId() {
        return userId;
    }
}
