package com.epam.client;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread {
    private final Logger log = LogManager.getRootLogger();
    private BufferedReader in;
    private String nickNameClient;

    public ClientThread(BufferedReader inClient, String nickName) {
        in = inClient;
        nickNameClient = nickName;

    }

    public void run() {
            try {
                String fromServer;
                while (true ) {
                    fromServer = in.readLine();
                    if (fromServer.equals(nickNameClient + " вышел")) break;
                    log.info(fromServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


}
