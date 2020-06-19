package com.hemebiotech.analytics;

public class AnalyticsCounter {

    public static void main(String args[]) {
        ReadSymptomDataFromFile readIt = new ReadSymptomDataFromFile("Project02Eclipse\\symptoms.txt");
        SortSymptomData sortIt = new SortSymptomData(readIt.GetSymptoms());
        WriteSymptomOccurence writeIt = new WriteSymptomOccurence(readIt.GetSymptoms(), sortIt.sortSymptom());
        //generate output
        writeIt.writeSymptomOccurence();
    }
}