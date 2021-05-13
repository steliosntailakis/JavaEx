package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TxtHandler {
    private int numberOfLines = 0;
    private int numberOfRows = 0;
    private String[][] dataTable;

    public String[][] datasetTxtToArray(String filename){
        ArrayList<String> data = new ArrayList<String>();
        String[] wordsArray;
        System.out.println("datasetToArray called.");
        try {
            BufferedReader buf = new BufferedReader(new FileReader(filename));
            String lineJustFetched = null;

            while (true) {
                lineJustFetched = buf.readLine();
                if (lineJustFetched == null) {
                    break;
                } else {
                    numberOfLines++;
                    wordsArray = lineJustFetched.split("\t");
                    numberOfRows = wordsArray.length;
                    data.addAll(Arrays.asList(wordsArray));
                }
            }
            dataTable = new String[numberOfRows][numberOfLines];

            int counter = 0;
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfLines; j++) {
                    dataTable[i][j] = data.get(counter);
                    counter++;
                    System.out.print(dataTable[i][j] + "\t");
                }
                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTable;
    }

    public ArrayList<String> configTxtToArray(String filename){
        ArrayList<String> configData = new ArrayList<String>();
        try {
            BufferedReader buf = new BufferedReader(new FileReader(filename));
            String lineJustFetched = null;
            while (true) {
                lineJustFetched = buf.readLine();
                if (lineJustFetched == null) {
                    break;
                } else {
                    configData.add(lineJustFetched);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < configData.size(); i++) {
            System.out.println(configData.get(i));
        }
        return configData;
    }
}
