package ru.itis.client.connection;

import ru.itis.protocol.Message;
import ru.itis.protocol.UserAction;
import ru.itis.client.SocketClient;
import ru.itis.client.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class MessageSender implements Runnable {
    private SocketClient socket;
    private Thread thread;

    public MessageSender(SocketClient socket) {
        this.socket = socket;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try (PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println(5);
            while (true) {
                // Отправка данных на сервер
                User user = socket.getUser();
                System.out.println(3);
                while (!user.getFlag()) {
                }
                UserAction action = user.getAction();
                System.out.println("sender " + action);
                Message request = Message.createMessage(action, user.getUserId());
                socket.sendMessage(request);
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            try {
                if (e instanceof SocketTimeoutException) {
                    throw new SocketTimeoutException();
                } else {
                    e.printStackTrace();
                }
            } catch (SocketTimeoutException ste) {
                System.out.println("Turn off the client by timeout");
            }
        }
    }
}