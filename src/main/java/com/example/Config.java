package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Config {




    public static String getPost(String key) {// Path: src/main/java/com/example/Config.java
        // get the message to post
        System.out.println("running code");
        File jsonFile = new File("src/main/resources/data.json");


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            JsonNode credentialsNode = jsonNode.get("post");

            Iterator<String> fieldNames = credentialsNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if (fieldName.equalsIgnoreCase(key)) {
                    return credentialsNode.get(fieldName).asText();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public static String getSearch(String key) {// Path: src/main/java/com/example/Config.java
        // get the thing to search for
        System.out.println("running code");
        File jsonFile = new File("src/main/resources/data.json");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            JsonNode credentialsNode = jsonNode.get("search");

            Iterator<String> fieldNames = credentialsNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if (fieldName.equalsIgnoreCase(key)) {
                    return credentialsNode.get(fieldName).asText();
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static String getEmail(String key) {// Path: src/main/java/com/example/Config.java
        // get the email to login with
        System.out.println("running code");
        File jsonFile = new File("src/main/resources/data.json");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            JsonNode credentialsNode = jsonNode.get("facebookCredentials");

            Iterator<String> fieldNames = credentialsNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if (fieldName.equalsIgnoreCase(key)) {
                    return credentialsNode.get(fieldName).asText();
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    public static String getPassword(String key) {// Path: src/main/java/com/example/Config.java
        // get the password to login with
        System.out.println("running code");
        File jsonFile = new File("src/main/resources/data.json");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            JsonNode credentialsNode = jsonNode.get("facebookCredentials");

            Iterator<String> fieldNames = credentialsNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if (fieldName.equalsIgnoreCase(key)) {
                    return credentialsNode.get(fieldName).asText();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }return null;
    }
}
