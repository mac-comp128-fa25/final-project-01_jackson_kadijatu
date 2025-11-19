/**
 * This class represents a customer in the system. It will take in a text
 * file as an input, and from that file return the customers name, what ingredients 
 * they need to be cured, what allergies/aversions they have, and a script of 
 * dialogue to load.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    public String name;
    public Boolean cureStatus = false;
    public HashMap<String, Integer> cureRecipe;
    public ArrayList<String> connections;
    public int numVisits = 0;
    public int neededVisits;
    public ArrayList<String> dialogue;

    Customer(String fileName){
        int index = fileName.indexOf(".");
        this.name = fileName.substring(0, index);
    }

    //method for parsing dialogue from text file
        
    public static ArrayList<String> getDialogue(String fileName) {
        
        ArrayList<String> dialogue = new ArrayList<String>();
        try {
            java.io.File file = new java.io.File("src/Customers/" + fileName);
            java.util.Scanner input = new java.util.Scanner(file);
            boolean isDialogueLine = false;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.equals("Dialogue:")) {
                    isDialogueLine = true;
                    continue;
                }
                if (isDialogueLine) {
                    dialogue.add(line);
                }
            }
            input.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        
        return dialogue;
    }

    //getCureRecipe
    //getConnections
    //getIngredient
    //getNumNeededVisits

}
