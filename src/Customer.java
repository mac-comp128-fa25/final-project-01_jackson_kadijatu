
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
        this.name = getCustomerName(fileName);
        this.cureStatus = getCureStatus(fileName);
        this.cureRecipe = getCureRecipe(fileName);  
        this.connections = getConnections(fileName);
        this.dialogue = getDialogue(fileName);
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

    //gets the name of a character, given the text file
    public String getCustomerName(String fileName) {
        int index = fileName.indexOf(".");
        return fileName.substring(0, index);
    }

    //given a text file, find the line that starts with "Cured:" and return true or false
    public static Boolean getCureStatus(String fileName) {
        try {
            java.io.File file = new java.io.File("src/Customers/" + fileName);
            java.util.Scanner input = new java.util.Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.startsWith("Cured:")) {
                    String status = line.substring(6).trim();
                    input.close();

                    return status.equalsIgnoreCase("true");
                    
                }
            }
            input.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return false;
    }


    //given a text file, find the lines that start with "Cure Recipe:"
    // for each ingredient following "Cure Recipe," add to a hashmap with ingredient name as key and quantity as value
    public static HashMap<String, Integer> getCureRecipe(String fileName) {
        HashMap<String, Integer> recipe = new HashMap<String, Integer>();

        try {
            java.io.File file = new java.io.File("src/Customers/" + fileName);
            java.util.Scanner input = new java.util.Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.equals("CureRecipe:")) {
                    //delete "CureRecipe:" from the line
                // create a list of ingredients by splitting the line at spaces
                // and use that list to populate the hashmap
                    String[] ingredients = line.trim().split(" ");

                    for (String ingredient : ingredients) {

                        if (recipe.containsKey(ingredient)) {
                            recipe.put(ingredient, recipe.get(ingredient) + 1);
                        } else {
                            recipe.put(ingredient, 1);
                        }
                    }
                }

                

            }
            input.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return recipe;
    }
    

    //given a text file, find the line that starts with "Connections:"
    // create an arrayList of customer names that are listed after "Connections:"
    public ArrayList<String> getConnections(String fileName) {
        ArrayList<String> connections = new ArrayList<String>();

        try {
            java.io.File file = new java.io.File("src/Customers/" + fileName);
            java.util.Scanner input = new java.util.Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.startsWith("Connections:")) {
                    String[] names = line.substring(12).trim().split(" ");

                    for (String name : names) {
                        connections.add(name);
                }
            }
            input.close();
        }

        
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return connections;
    }


    //given a text file, find the line that starts with "Ingredient:"
    // return the ingredient name
    public static String getIngredient(String fileName) {
        try {
            java.io.File file = new java.io.File("src/Customers/" + fileName);
            java.util.Scanner input = new java.util.Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.startsWith("Ingredient:")) {
                    String ingredient = line.substring(11).trim();
                    input.close();
                    return ingredient;
                }
            }
            input.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        
        return ""; // return empty string if ingredient not found
    }


    //given a text file, find the line that starts with "numVisits:"
    // return the integer value following "numVisits:" 
    public static int getNumNeededVisits(String fileName) {
        try {
            java.io.File file = new java.io.File("src/Customers/" + fileName);
            java.util.Scanner input = new java.util.Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.startsWith("numVisits:")) {
                    String numVisitsStr = line.substring(10).trim();
                    input.close();
                    return Integer.parseInt(numVisitsStr);
                }
            }
            input.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        
        return 0; // return 0 if numVisits not found
    }

}
