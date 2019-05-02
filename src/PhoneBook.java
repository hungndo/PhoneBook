import java.io.*;
import java.util.Scanner;


public class PhoneBook{
    public static Entry[] entryList = new Entry[200];
    // I will later call each element of entryList indirectly using entryIndexList
	public static int[] entryIndexList = new int[200];
    private static String filename = "phonebook.txt";
    public static int entryIndex = 0;
    
    PhoneBook()throws Exception{
        //read from file
        readPhoneBook();
    }
    //for adding and reading entries, always refers to the next object via entryIndex
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
	                entryList[entryIndex] = new Entry(splitString[0],splitString[1],splitString[2]);
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
    public static void storePhoneBook () throws Exception{
        PrintStream P = new PrintStream(filename);
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
    public static int findEntry(String name){
        int indexOfFoundEntry = -1;
        String tempName = name.toUpperCase();
        for(int i=0; i<entryIndex;i++){
            String tempEntryName = entryList[entryIndexList[i]].name.toUpperCase();
            if(tempName.equals(tempEntryName)){
                System.out.println("--" + entryList[i].name+
                        "  " + entryList [i].number+
                        "  " + entryList [i].notes);
                indexOfFoundEntry= i;
                break;
            }
        }
        return indexOfFoundEntry;
    }
    public static void addEntry(String name, String number, String notes){
        Entry newEntry = new Entry(name,number,notes);
        int duplicateIndex = findEntry(newEntry.name);
    	if(duplicateIndex == -1) {
    		entryList[entryIndex]= newEntry;
    		entryIndexList[entryIndex] = entryIndex;
            entryIndex++;
            sortEntry();
            for(int i =0;i<entryIndex;i++)
            	System.out.println(entryIndexList[i]+" ");
        }
        else {
        	AlertBox.display("Warning", "You already have this person in your contact"
        			+ " list, do you want to merge two contacts?");
        	if(AlertBox.answer == true)
        	{
        		mergeDuplicateEntry(duplicateIndex, newEntry);
        	}
        }
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
    private static void mergeDuplicateEntry(int indexOfEntryThatNeedsToBeReplaced,Entry newEntry) {
    	entryList[entryIndexList[indexOfEntryThatNeedsToBeReplaced]].name = newEntry.name;
    	entryList[entryIndexList[indexOfEntryThatNeedsToBeReplaced]].number = newEntry.number;
    	entryList[entryIndexList[indexOfEntryThatNeedsToBeReplaced]].notes = newEntry.notes;
    }
}