package ru.itis.server;

import ru.itis.protocol.Protocol;
import ru.itis.server.connection.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server {
    private volatile List<Connection> connections;
    private volatile int id;

    public Server() throws IOException {
        connections = new ArrayList<>();
        id = 0;
        init();
    }

    private void init() throws IOException {
        ServerSocket s1 = new ServerSocket(Protocol.PORT);
        while (true) {
            Socket client = s1.accept();
            connections.add(new Connection(this, client, id++));
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }

    public Iterator<Connection> connectionsIterator(){
        return connections.iterator();
    }

    public List<Connection> getConnections(){
        return connections;
    }
}
