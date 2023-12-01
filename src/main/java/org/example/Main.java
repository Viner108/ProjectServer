package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static int PORT = 8081;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket input = serverSocket.accept();

//        Scanner in = new Scanner(input.getInputStream());
//        while (in.hasNext()) {
//            System.out.println(in.nextLine());
//        }
        InputStream in = input.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(in);
        System.out.println("Start");
        for (int i = 0; i < 1000000; i++) {
            DTO dtoIn = (DTO) ois.readObject();
        }
        in.close();
        input.close();
        serverSocket.close();

    }


}