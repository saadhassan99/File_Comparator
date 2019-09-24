package com.saadhassan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        intro();
        File[] files = files();
        compare(files[0], files[1]);
    }

    public static void intro() {
        System.out.println("Welcome to file comparator. This software is designed to " +
                "\nto compare two file and find differences between them.");
        System.out.println("INSTRUCTIONS: " +
                "\nIn order to avoid any \"file not found\" error. Enter the absolute path of the file");
    }

    /* The following method prompts the user to enter
    the two files he wants to compare */

    public static File[] files() {

        System.out.println();
        System.out.println("Enter the first file name: ");
        Scanner userInput = new Scanner(System.in);
        File file1 = new File(userInput.nextLine());
        while (!file1.exists()) {
            System.out.println("File 1 does not exist. Try again.");
            file1 = new File(userInput.nextLine());
        }

        System.out.println("Enter the second file name: ");
        File file2 = new File(userInput.nextLine());
        while (!file2.exists()) {
            System.out.println("File 2 does not exist. Try again.");
            file2 = new File(userInput.nextLine());
        }
        userInput.close();

        File[] files = new File[2];
        files[0] = file1;
        files[1] = file2;

        return files;
    }

    public static void compare(File file1, File file2) throws FileNotFoundException {
        Scanner scanner1 = new Scanner(new File(file1.getPath()));
        Scanner scanner2 = new Scanner(new File(file2.getPath()));

        int lineCounter = 0;

        while (scanner1.hasNextLine() && scanner2.hasNextLine()) {
            String line = scanner1.nextLine();
            String line2 = scanner2.nextLine();
            lineCounter++;
            if (!line.equals(line2)) {
                System.out.println("Line " + lineCounter + ":");
                System.out.println("< " + line);
                System.out.println("> " + line2);
                System.out.println();
            }

        }
    }
}
