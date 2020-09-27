package com.epam.server;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.*;

public class ServerTest {
    private Server server;

   /* @Before
    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(3232);
            Socket client = serverSocket.accept();
            server = new Server(client);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void method_that_checks_for_the_latest_messages() {
        server.printHistory();
    }*/
}