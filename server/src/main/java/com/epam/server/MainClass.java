package com.epam.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class MainClass {
    static FileWriter writerFile;
    static private final String WAY_TO_HISTORY = "server\\src\\main\\resources\\history.txt";
    static ArrayList<String> lines;
    private static BufferedReader fileReader;
    static ArrayList<Server> connectedClients;

    public static void main(String[] args) {
        int portNumber = 3232;
        try {
            writerFile = new FileWriter(WAY_TO_HISTORY, true);
            FileReader fr = new FileReader(WAY_TO_HISTORY);
            fileReader = new BufferedReader(fr);
            lines = new ArrayList<>();
            connectedClients = new ArrayList<>();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        recordHistory();
        System.out.println("Server start");
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);   // Связь с портом; объект для прослушивания на конкретном порту
            while (true) {
                Socket clientSocket = serverSocket.accept();    // Принятие соединения от клиента
                Server threadServer = new Server(clientSocket);
                connectedClients.add(threadServer);

                threadServer.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                writerFile.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void recordHistory() {
        try {
            String tmp;
            while ((tmp = fileReader.readLine()) != null) {
                lines.add(tmp);
            }
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }

}
