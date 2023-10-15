package com.utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class JsonReader {

    private JsonNode rootNode;
    private final String country;
    private final String lang;
    public JsonReader(String country, String lang){
        this.country = country;
        this.lang = lang;
        try {
            // Provide the path to the JSON file
            String filePath = "src/test/resources/test_data/SubscriptionPackageData.json";

            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON data from the file
            File jsonFile = new File(filePath);
            rootNode = objectMapper.readTree(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getCountryName() {
            String ksaEnName = rootNode.get(country).get(lang).get("name").asText();
    }
    public String getPricePackage(String pricePackage) {
        System.out.println(rootNode.get(country).get(lang).get(pricePackage).asText());
        return rootNode.get(country).get(lang).get(pricePackage).asText();
    }
}



