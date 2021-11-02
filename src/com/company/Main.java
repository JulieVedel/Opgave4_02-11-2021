package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void dataToArray(int[] count, String[] name, float[] numbers) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Persondata.txt"));

        for (int i = 0; i < count.length; i++) {
            count[i] = scanner.nextInt();
            name[i] = scanner.next();
            numbers[i] = scanner.nextFloat();
        }
    }

    public static void printArrays(int[] count, String[] name, float[] numbers) {
        System.out.println("Værdierne i int-arrayet er: " + Arrays.toString(count));
        System.out.println("Navnene i string-arrayet er: " + Arrays.toString(name));
        System.out.println("Tallene i float-arrayet er: " + Arrays.toString(numbers));
    }

    public static void writeToDatafile(int[] count, String[] name, float[] numbers, int amount) {
        try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream("Datafile.dat"));
            for (int i = 0; i < amount; i++) {
                output.writeBytes((count[i] + " " + name[i] + " " + numbers[i] + "\n"));

            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDatafile() throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream("Datafile.dat"));
        int value = input.readByte();
        try {
            while (value != -1) {
                System.out.print(Character.toString(value));
                value = input.read();
            }
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        int amount = 3;
        int[] count = new int[amount];
        String[] name = new String[amount];
        float[] numbers = new float[amount];

        dataToArray(count, name, numbers);
        printArrays(count, name, numbers);

        writeToDatafile(count, name, numbers, amount);
        readDatafile();

    }
}
