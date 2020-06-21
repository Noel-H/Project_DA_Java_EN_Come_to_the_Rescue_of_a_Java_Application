package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class WriteSymptomOccurence {

    private List<String> unsortedList;
    private TreeSet sortedList;

    public WriteSymptomOccurence(List<String> unsortedList, TreeSet sortedList){
        this.unsortedList = unsortedList;
        this.sortedList = sortedList;
    }

    public void writeSymptomOccurence(){

        try {
            FileWriter writer = new FileWriter("result.out");
            Iterator it = sortedList.iterator();
            while (it.hasNext()){
                Object s = it.next();
                writer.write(s + " = " + Collections.frequency(unsortedList, s));
                if(it.hasNext()){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
