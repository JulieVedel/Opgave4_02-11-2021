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

    public static void printPerson(Person person) {
        System.out.println(person.getNr() + " " + person.getNavn() + " " + person.getTal());
    }

    public static void udskrivPersoner(Person[] array, int antal) {
        for (int i = 0; i < antal; i++) {
            printPerson(array[i]);
        }
    }

    public static void udskrivTilFil(Person[] array, int antal) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Personer.ser"));
            for (int i = 0; i < antal; i++) {
                output.writeObject(array[1]);

            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person[] indFraFil() {
        Person[] array1 = new Person[3];
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Personer.ser"));
            String a = (String) input.readObject();

            input.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return array1;
    }

    public static void main(String[] args) throws IOException {
        int amount = 3;
        int[] count = new int[amount];
        String[] name = new String[amount];
        float[] numbers = new float[amount];

        dataToArray(count, name, numbers);
//        printArrays(count, name, numbers);
//        writeToDatafile(count, name, numbers, amount);
//        readDatafile();

        Person Pernille = new Person(count[0], name[0], numbers[0]);
        Person Peter = new Person(count[1], name[1], numbers[1]);
        Person Christian = new Person(count[2], name[2], numbers[2]);

//        printPerson(Pernille);
//        printPerson(Peter);
//        printPerson(Christian);

        Person[] array = {Pernille, Peter, Christian};

        udskrivPersoner(array, array.length);
        udskrivTilFil(array, array.length);
//        Person[] array1 = indFraFil();
//        udskrivPersoner(array1, array1.length);
    }
}
