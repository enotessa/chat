package com.epam.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private Properties property = new Properties();

    public PropertyReader() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("client\\src\\main\\resources\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * taking values ​​from properties
     *
     * @param namePr value key
     * @return value by key
     */
    public String readPropertiesStr(String namePr) {
        return property.getProperty(namePr);
    }
}
