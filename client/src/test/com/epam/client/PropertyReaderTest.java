package com.epam.client;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyReaderTest {
    private final String VALID_ROW = "EPRUTVEW0129.moscow.epam.com";


    @Test
    public void method_that_checks_taking_values_​​from_properties() {
        PropertyReader propertyReader= new PropertyReader();
        String checkValue = propertyReader.readPropertiesStr("hostName");
        assertEquals(VALID_ROW, checkValue);
    }
}