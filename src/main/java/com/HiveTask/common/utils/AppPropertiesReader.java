package com.HiveTask.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppPropertiesReader {
    private static final Properties properties = new Properties();

    static {
        loadProperties("application.properties");
    }

    private static void loadProperties(String filename) {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {
            if (input == null) {
                System.out.println("Lo siento, no se pudo encontrar el archivo " + filename);
                return;
            }

            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
