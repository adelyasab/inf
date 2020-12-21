package ru.itis.client;

import ru.itis.protocol.Message;

public interface Client {
    void connect();

    void sendMessage(Message message);
//    Message getMessage() throws ClientException;
}
