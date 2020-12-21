package ru.itis.client.connection;


import ru.itis.protocol.Message;
import ru.itis.protocol.UserAction;
import ru.itis.client.SocketClient;
import ru.itis.client.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageAccepter implements Runnable{
    private SocketClient socket;
    private Thread thread;
    private volatile List<User> users;

    public MessageAccepter(SocketClient socket){
        this.socket = socket;
        this.users = new ArrayList<>();
        thread = new Thread(this);
        thread.start();
    }

    public List<User> getUsers(){
        return users;
    }

    private void addUser(User user){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User oldUser = iterator.next();
            if(oldUser.equals(user)){
               return;
            }
        }

        users.add(user);
    }

    private void setAction(UserAction action, int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getUserId() == id){
                user.setAction(action);
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Ответ сервера
                Message message = Message.readMessage(socket.getInputStream());

                System.out.println("accepter " + message.getUserAction());
                System.out.println(message.getUserId());

                UserAction action = message.getUserAction();

                switch (action){
                    case BATTLE_SEARCH:
                        addUser(new User(message.getUserId(), UserAction.IN_THE_BATTLE));
                        break;
                    case TANK_MOVE_FORWARD:
                        setAction(action, message.getUserId());
                        break;
                    case TANK_MOVE_BACK:
                        setAction(action, message.getUserId());
                        break;
                    case TANK_ROTATE_LEFT:
                        setAction(action, message.getUserId());
                        break;
                    case TANK_ROTATE_RIGHT:
                        setAction(action, message.getUserId());
                        break;
                    case TANK_SHOT:
                        setAction(action, message.getUserId());
                    case STATE:
                        setAction(action, message.getUserId());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
