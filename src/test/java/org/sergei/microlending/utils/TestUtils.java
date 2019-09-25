package org.sergei.microlending.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Sergei Visotsky
 */
public class TestUtils {

    public static String readFromJSONFile(String fileName) {
//        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            if (inputStream != null) {
                return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            } else {
                throw new RuntimeException("Required test JSON file not found");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
