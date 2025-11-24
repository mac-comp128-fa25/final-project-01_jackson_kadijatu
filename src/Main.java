import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Thread;

/**
 * This is the main class for the game
 */

public class Main {
    public ArrayList<Customer> allCustomers;
    public ArrayList<Customer> availableCustomers;
    public ArrayList<String> gameDialogue;

    //initialize list of all customers in game
    //initialize list of available customers
    //initialize directed graph for customer connections

    //initial setup
    public Main() {
        allCustomers = populateAllCustomers("src/Customers/");
        availableCustomers = new ArrayList<Customer>();
        //populateAvailableCustomers();
        
        //gameDialogue = getGameDialogue("GameDialogue.txt");


    }

    //given the folder that the customer text files are in
    //populate and return an arrayList of all customer objects
    public static ArrayList<Customer> populateAllCustomers(String folderName) {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        java.io.File customersFolder = new java.io.File(folderName);
        java.io.File[] listOfCustomers = customersFolder.listFiles();

        for (java.io.File file : listOfCustomers) {
            System.out.println(file.getName());
            if (file.isFile()) {
                String fileName = file.getName();
                Customer customer = new Customer(fileName);
                customers.add(customer);
            }
        }

        return customers;
    }



    //method to slow down printing to console
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static ArrayList<String> getIntroText(){
        ArrayList<String> introText = new ArrayList<String>();
        try {
            java.io.File file = new java.io.File("src/intro.txt");
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                introText.add(line);
            }
            input.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: intro.txt");
        }

        return introText;
    }

    public static void runIntro(){
        ArrayList<String> introText = getIntroText();
        for(String line : introText){
            for(char c : line.toCharArray()){
                System.out.print(c);
                sleep(75);
            }
            System.out.println();
            sleep(700);
        }
    }


    public static void main(String[] args) {
        //open intro text file
        //for each line in intro text file, print to console one character at a time with small delay
        // after each line, time.sleep for a longer delay
        
        runIntro();
        
        //game loop

    }

    //initial game text, gives introduction to rules, objectives, and controls
    // ie. "Welcome to your Apothecary! Your goal is to cure as many customers 
    // as possible by creating the right recipes for their ailments. You don't
    // have to cure them all, but the more you cure, the better your score!
    // When a customer comes in, pay attention to what they say - How they describe
    // their symptoms will help you figure out what ingredients you need to use,and in
    // what quantities. Be careful, cause if you get it wrong,you could hurt them!
    // If you ever need to know what ingredients you have, type "Ingredients" into
    // the console. To see what each ingredient does, type the nameof the ingredient.
    //To make a recipe, type "add" followed by the ingredient names.

    //after initial text, first line of customer dialogue is displayed
    //player is prompted to enter a command
    //once player has entered make:...
    //time.sleep, display "brewing..."
    //display giving to customer and reaction
    //display appropriate reaction based on recipe
    //if cured, update cure status, increment numVisits for customer connections, remove from availableCustomers
    //if not cured, display appropriate dialogue
    //if numVisits for customer reaches neededVisits, add to availableCustomers

    //loop through until the size of availableCustomers is 0




}
