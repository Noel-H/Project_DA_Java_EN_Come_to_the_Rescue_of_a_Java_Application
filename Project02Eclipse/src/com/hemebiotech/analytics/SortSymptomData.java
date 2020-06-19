package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeSet;

public class SortSymptomData {

    private List<String> data;

    public SortSymptomData(List<String> data){
        this.data = data;
    }

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
