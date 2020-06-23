package com.hemebiotech.analytics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class count symptom from a file and then write occurrence in a new file
 */
public class SymptomsAnalysis {

    public Properties config;

    /**
     * Check the path of the configuration files
     * @return true if the path file is correct
     */
    private boolean loadConfig() {

        config = new Properties();

        try {
            InputStream file = new FileInputStream("Project02Eclipse\\config.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Count symptom from a file and then write occurrences in a new file
     */
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
