package com.company;

import java.util.Scanner;

public class UserInput {

    public String[] userInput() {
        String[] files = new String[3];

        Scanner s = new Scanner(System.in);
        System.out.println("Insert dataset file.");
        files[0] = s.nextLine();
        System.out.println("Insert config file.");
        files[1] = s.nextLine();
        System.out.println("Insert output file name.");
        files[2] = s.nextLine();

        return files;
    }
}
