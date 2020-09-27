package com.epam.client;

import org.apache.log4j.Logger;

public class PrintMessage {
    private static final Logger log = Logger.getLogger(PrintMessage.class);


    public void nick(){
        //System.out.println("Введите ник : ");
        log.info("Пользователь ввел ник");
    }

    public void message() {
        //System.out.println("Можете писать сообщения");
        log.info("Пользователь начал писать сообщения");
    }
}
