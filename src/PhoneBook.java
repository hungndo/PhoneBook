import java.io.*;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class PhoneBook{
    private static Entry[] entryList = new Entry[200];
    private static Scanner stdin = new Scanner(System.in);
    private static String command ="";
    private static String filename = "phonebook.txt";
    private static int entryIndex = 0;
    
    PhoneBook() {//throws Exception{
/*
        System.out.println("Use \"e\" for enter, \"e\" for find, \"l\" for list, \"q\" for quit.");
        //read from file
        try {
            entryIndex = readPhoneBook(filename);
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        // main loop
        while(!command.equals("q")) {
            System.out.print("Command: ");
            command= stdin.nextLine();
            switch (command.charAt(0)) {
                //enter
                case 'e':
                    enterEntry(command.substring(2));
                    break;
                //find
                case 'f':
                    String name = command.substring(2);
                    findEntry(name);
                    break;
                //list
                case 'l':
                    listAllEntries();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
        System.out.println("Storing file.");
        // store file
        try {
            storePhoneBook(filename);
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }*/
    }
    public static int readPhoneBook (String FileName) throws Exception{
        File F = new File(FileName);
        Scanner reader = new Scanner(F);
        String currentLine;
        while(reader.hasNextLine()){
            currentLine = reader.nextLine();
            String emptySpace = currentLine.trim();
            if(!emptySpace.equals("")) {
                String[] splitString = currentLine.split("\\t+");
                entryList[entryIndex] = new Entry();
                entryList[entryIndex].name = splitString[0];
                entryList[entryIndex].number = splitString[1];
                entryList[entryIndex].notes = splitString[2];
                entryIndex++;
            }
        }
        reader.close();
        return entryIndex;
    }
    public static void storePhoneBook (String FileName) throws Exception{
        PrintStream P = new PrintStream(FileName);
        for (int i=0; i < entryIndex; i++) {
            P.println(entryList[i].name + "\t" +
                    entryList [i].number + "\t" +
                    entryList [i].notes);
        }
        P.close();
        System.out.println("Phone book stored.");
    }
    public static void listAllEntries(){
        for (int i=0; i < entryIndex ; i++) {
            System.out.println("--"+ entryList[i].name
                    +"  "+entryList[i].number
                    +"  "+entryList[i].notes);
        }
    }
    public static void findEntry(String name){
        boolean found = false;
        String tempName = name.toUpperCase();
        for(int i=0; i<entryIndex;i++){
            String tempEntryName = entryList[i].name.toUpperCase();
            if(tempName.equals(tempEntryName)){
                System.out.println("--" + entryList[i].name+
                        "  " + entryList [i].number+
                        "  " + entryList [i].notes);
                found= true;
                break;
            }
        }
        if(!found)
            System.out.println("** No entry with code "+ name);
    }
    public static void enterEntry(String name){
        entryList[entryIndex]= new Entry();
        entryList[entryIndex].name = name;
        System.out.print("Enter number: ");
        entryList[entryIndex].number= stdin.nextLine();
        System.out.print("Enter notes:");
        entryList[entryIndex].notes= stdin.nextLine();
        entryIndex++;
    }

}