package ru.itis.client;


import ru.itis.client.connection.MessageAccepter;
import ru.itis.client.connection.MessageSender;
import ru.itis.client.model.User;
import ru.itis.protocol.Protocol;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AppClient implements Runnable {
    private final User user;
    private volatile MessageAccepter messageAccepter;

    public AppClient(User user) {
        this.user = user;
        Thread thread = new Thread(this);
        thread.start();
    }

    public MessageAccepter getMessageAccepter() {
        return messageAccepter;
    }

    @Override
    public void run() {
        try {
            SocketClient socket = new SocketClient(InetAddress.getLocalHost(), Protocol.PORT, user);
            socket.connect();
            messageAccepter = new MessageAccepter(socket);
            new MessageSender(socket);
            while (true) {

            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}
