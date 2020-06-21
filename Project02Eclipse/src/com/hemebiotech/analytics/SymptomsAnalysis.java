package com.hemebiotech.analytics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SymptomsAnalysis {

    public Properties config;

    private boolean loadConfig() {

        config = new Properties();

        try {
            InputStream file = new FileInputStream("Project02Eclipse\\configs.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }


    public void launchSymptomsAnalysis () {
        if (!loadConfig()){
            return;
        }
        ReadSymptomDataFromFile readIt = new ReadSymptomDataFromFile(config.getProperty("filepath"));
        SortSymptomData sortIt = new SortSymptomData(readIt.getSymptoms());
        WriteSymptomOccurence writeIt = new WriteSymptomOccurence(readIt.getSymptoms(), sortIt.sortSymptom());
        writeIt.writeSymptomOccurence();
    }
}
