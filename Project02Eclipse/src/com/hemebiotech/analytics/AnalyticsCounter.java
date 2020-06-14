package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse\\symptoms.txt"));
		String line = reader.readLine();

		//Création de collection
		List<String> lineListe = new ArrayList<>();
		while (line != null) {
			lineListe.add(line);
			line = reader.readLine();
		}
		// Tri de la collection dans l'ordre alphabetique en enlevant les doublons
		TreeSet lineListeWithoutDoublonTreeset = new TreeSet(lineListe);

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		Iterator it = lineListeWithoutDoublonTreeset.iterator();
		while (it.hasNext()){
			Object s = it.next();
			writer.write(s + " = " + Collections.frequency(lineListe, s));
			if(it.hasNext()){
				writer.write("\n");
			}
		}
		writer.close();
	}
	}

