import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class PhoneBook{
    public static Entry[] entryList = new Entry[200];
	public static int[] entryIndexList = new int[200];
    private static Scanner stdin = new Scanner(System.in);
    private static String command ="";
    private static String filename = "phonebook.txt";
    public static int entryIndex = 0;
    
    PhoneBook()throws Exception{
        //read from file
        readPhoneBook();
        /*
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
        */
        System.out.println("Storing file.");
        // store file
        try {
            storePhoneBook(filename);
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public static void readPhoneBook () throws Exception{
        try {
	    	File F = new File(filename);
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
	                entryIndexList[entryIndex] = entryIndex;
	                entryIndex++;
	            }
	        }
	        reader.close();
        }
        catch(FileNotFoundException ex) {
        	ex.printStackTrace();
        }
        sortEntry();
        listAllEntries();
    }
    public static void storePhoneBook (String FileName) throws Exception{
        PrintStream P = new PrintStream(FileName);
        for (int i=0; i < entryIndex; i++) {
            P.println(entryList[entryIndexList[i]].name + "\t" +
                    entryList [entryIndexList[i]].number + "\t" +
                    entryList [entryIndexList[i]].notes);
        }
        P.close();
        System.out.println("Phone book stored.");
    }
    public static void listAllEntries(){
        for (int i=0; i < entryIndex ; i++) {
            System.out.println("--"+ entryList[entryIndexList[i]].name
                    +"  "+entryList[entryIndexList[i]].number
                    +"  "+entryList[entryIndexList[i]].notes);
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
    public static void sortEntry() {
    	// this function sorts the entryIndexList instead of directly to the entryList
    	// so that every it swaps two element, it doesn't need to swap whole objects
    	for(int j = entryIndex-1 ;j>0;j--) {
    		for(int i = 0 ; i< j ; i++) {
    			if( compareStringAlphabetically(entryList[entryIndexList[i]].name, entryList[entryIndexList[i+1]].name)>1)  {
    				int temp = entryIndexList[i];
    				entryIndexList[i] = entryIndexList[i+1];
    				entryIndexList[i+1] = temp;
    			}
    			
    		}
    	}
    }
    private static int compareStringAlphabetically(String stringA, String stringB) {
    	int compareLength = Math.min(stringA.length(), stringB.length());
    	for(int i =0 ; i< compareLength; i++) {
    		if(stringA.charAt(i)!=stringB.charAt(i)) {
    			return stringA.charAt(i) - stringB.charAt(i);
    		}
    	}

    	if(stringA.length()!=stringB.length()) {
    		return stringA.length() - stringB.length();
    	}
    	else {
    		return 0;
    	}
    }

}