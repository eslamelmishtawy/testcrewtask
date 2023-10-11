package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public Properties init_prop(){
        Properties p = new Properties();
        try {
            FileInputStream pF = new FileInputStream("src/test/resources/config/config.properties");
            p.load(pF);
        } catch (IOException e){
            e.printStackTrace();
        }
        return p;
    }
}
