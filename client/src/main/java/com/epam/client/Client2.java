package com.epam.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Client2 {
    private static PropertyReader pr = new PropertyReader();
    private static String fromServer, fromUser;
    private static final String HOST_NAME = pr.readPropertiesStr("hostName");
    private static final int PORT_NUMBER = 3232;
    private static Scanner in_ = new Scanner(System.in);
    private static final Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        try (
                Socket kkSocket = new Socket(HOST_NAME, PORT_NUMBER);
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);

                BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        ) {
            for (int i = 0; i < 5; i++) {        // получение последних пяти сообщений
                fromServer = in.readLine();
                System.out.println(fromServer);
            }

            log.info("Введите ник : ");
            fromUser = in_.nextLine();
            String nickName = fromUser;
            ClientThread clientThread = new ClientThread(in, nickName);
            out.println(nickName);
            log.info("Можете писать сообщения");
            out.println(in_.nextLine());
            clientThread.start();

            while (true) {
                fromUser = in_.nextLine();
                out.println(fromUser);
                if (fromUser.equals("Bye.")) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}