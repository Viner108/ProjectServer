package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    //    private static BufferedReader in; // поток чтения из сокета
//    private static BufferedWriter out; // поток записи в сокет

    private static ServerSocket server;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(4004);
                System.out.println("Сервер запущен!");
                Socket socket1 = server.accept();
                try {
                    System.out.println("готовим вх и вых");
                    in = new ObjectInputStream(socket1.getInputStream());
                    out = new ObjectOutputStream(socket1.getOutputStream());
                } finally {
                    socket1.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}