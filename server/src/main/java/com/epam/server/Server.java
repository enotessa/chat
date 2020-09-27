package com.epam.server;

import java.io.*;
import java.net.Socket;

public class Server extends Thread {
    private Socket client;
    private PrintWriter out;

    Server(Socket client) {
        this.client = client;

    }

    public void run() {
        System.out.println("Accepted connection. ");
        try {
            String inputLine, outputLine, nickName;
            out = new PrintWriter(client.getOutputStream(), true);    // Поток ввода, чтение
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));   // Поток вывод, запись
            printHistory();
            inputLine = in.readLine();
            nickName = inputLine;
            while (true) {

                inputLine = in.readLine();
                outputLine = nickName + " : " + inputLine;
                MainClass.writerFile.write(outputLine + "\n");
                MainClass.writerFile.flush();
                MainClass.lines.add(outputLine);
                if (outputLine.equals(nickName + " : Bye.")) {
                    sendToAll(nickName + " вышел");
                    break;
                }
                sendToAll(outputLine);

            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Output closed.");
        }

}

    private void sendToAll(String text) {
        for (Server currentClient: MainClass.connectedClients) {
            currentClient.sendText(text);
        }
    }

    private void sendText(String text){
        out.println(text);
        out.flush();
    }

    private void printHistory() {
        String tmp;
        for (int i = MainClass.lines.size() - 4; i <=  MainClass.lines.size(); i++) {
            tmp =  MainClass.lines.get(i - 1);
            out.println(tmp);
        }
    }

}

