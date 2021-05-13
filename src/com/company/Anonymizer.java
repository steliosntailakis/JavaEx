package com.company;

import java.io.IOException;
import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Anonymizer {
    private int numberOfLines = 0;
    private int numberOfRows = 0;
    private String[][] dataTable;
    ArrayList<String> configData;
    private String[][] encryptedDataTable;

    public void start() throws FileNotFoundException {
        String[] files = new UserInput().userInput();
        FileHandler fileHandler = new FileHandler();
        //dataset into 2D array
        dataTable = fileHandler.datasetToArray(files[0]);
        //reading the config file
        configData = fileHandler.configToArray(files[1]);
        Encryptor encryptor = new Encryptor();
        encryptedDataTable = encryptor.encryptData(dataTable, configData);
        //encrypted table into textfile
        fileHandler.twoDimensionalArrayToFile(encryptedDataTable,files[2]);
    }


}