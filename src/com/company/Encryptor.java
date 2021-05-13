package com.company;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Encryptor {

    public String[][] encryptData(String[][] dataTable, ArrayList<String> configData) throws FileNotFoundException {
        String[][] encryptedDataTable = new String[dataTable.length][dataTable[0].length];
        for(int i=0; i < dataTable.length; i++) {
            for (int j = 0; j < dataTable[i].length; j++) {
                encryptedDataTable[i][j] = dataTable[i][j];
            }
        }

        for (int i = 0; i < dataTable.length; i++) {
            System.out.println(dataTable.length);
            System.out.println(configData.size());
            System.out.println(dataTable[0][i]);
            for (int j = 0; j < configData.size(); j++) {
                if(dataTable[0][i].equals(configData.get(j))) {
                    for (int k = 1; k < dataTable[i].length; k++) {
                        System.out.println(encryptedDataTable[k][i]);
                        encryptedDataTable[k][i] = encryptElement(dataTable[k][i]);
                    }
                }
            }
        }

        for (int i = 0; i < dataTable.length; i++) {
            for (int j = 0; j < dataTable[i].length; j++) {
                System.out.println(encryptedDataTable[i][j]+"\t");
            }
            System.out.println("\n");
        }
        return encryptedDataTable;
    }

    public String encryptElement(String element) throws FileNotFoundException {

        String encryptedElement=null;

        try (PrintWriter out = new PrintWriter("passwordoutput1.txt")) {
            out.println(element);
        }
        String key = "54 68 61 74 73 2";
        File inputFile = new File("passwordoutput1.txt");
        File encryptedFile = new File("passwordoutput2.txt");
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            BufferedReader buf = new BufferedReader(new FileReader("passwordoutput2.txt"));
            encryptedElement = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //deleting the files passwordoutput1 for safety
        deleteFileForSecurity();

        return encryptedElement;
    }

    private void deleteFileForSecurity() {
        try
        {
            Files.deleteIfExists(Paths.get("passwordoutput1.txt"));
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(DirectoryNotEmptyException e)
        {
            System.out.println("Directory is not empty.");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }
    }
}
