package net.thumbtack.be.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public Properties load(String fileName) {
        Properties prop = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = findFile(fileName);
            prop.load(inputStream);
        } catch (IOException ignore) {
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ignore) {
                }
            }
        }
        return prop;
    }


    private InputStream findFile(String fileName) throws FileNotFoundException {
        InputStream inputStream = findInWorkingDirectory(fileName);
        if (inputStream == null) {
            inputStream = findInClasspath(fileName);
        }
        if (inputStream == null) {
            inputStream = findInSourceDirectory(fileName);
        }
        if (inputStream == null) {
            throw new FileNotFoundException(String.format("File %s not found", fileName));
        }
        return inputStream;
    }

    private InputStream findInSourceDirectory(String fileName) throws FileNotFoundException {
        return new FileInputStream("src/main/resources/" + fileName);
    }


    private InputStream findInClasspath(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    }


    private InputStream findInWorkingDirectory(String fileName) {
        try {
            return new FileInputStream(System.getProperty("user.dir") + fileName);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
