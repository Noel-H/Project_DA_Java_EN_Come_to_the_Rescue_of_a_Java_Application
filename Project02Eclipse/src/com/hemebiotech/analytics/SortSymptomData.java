package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeSet;

/**
 * This class sort symptom
 */
public class SortSymptomData {

    private List<String> data;

    /**
     * @param data a list of symptoms
     */
    public SortSymptomData(List<String> data){
        this.data = data;
    }

    /**
     * @return a list that contain symptoms names in alphabetic order without duplicate
     */
    TreeSet sortSymptom(){

        TreeSet sortedData = null;

        try{
            sortedData = new TreeSet(data);
        } catch (ClassCastException | NullPointerException e2) {
            e2.printStackTrace();
        }

        return sortedData;
    }
}
