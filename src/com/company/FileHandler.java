package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {

    private String[][] dataTable;
    private ArrayList<String> configData;
    private String[][] encryptedDataTable;

    public String[][] datasetToArray(String filename) {
        if(filename.endsWith(".txt")) {
            dataTable = new TxtHandler().datasetTxtToArray(filename);
        } else {
            System.out.println("File type not supported.");
        }
        return dataTable;
    }

    public ArrayList<String> configToArray(String filename) {
        if(filename.endsWith(".txt")) {
            configData = new TxtHandler().configTxtToArray(filename);
        } else {
            System.out.println("File type not supported.");
        }
        return configData;
    }

    public void twoDimensionalArrayToFile(String[][] encryptedDataTable, String filename){
        try
        {
            PrintWriter pr = new PrintWriter(filename);
            int flag;
            for (int i=0; i< encryptedDataTable.length; i++) {
                flag = i;
                for (int j = 0; j < encryptedDataTable[i].length; j++) {
                    pr.print(encryptedDataTable[i][j] + "\t");
                }
                pr.println("");
            }
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
}


