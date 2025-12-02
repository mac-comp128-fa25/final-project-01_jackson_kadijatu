import java.util.ArrayList;
import java.lang.Thread;
import java.lang.reflect.Array;
import java.io.File;

/**
 * This is the main class for the game
 */

public class Main {
    public ArrayList<Customer> allCustomers;
    public ArrayList<Customer> availableCustomers;
    public ArrayList<String> customerConnections;
    public ArrayList<String> availableIngredients;

    //initial setup
    public Main() {
        allCustomers = populateAllCustomers("res/allTextFiles/Customers");
        availableCustomers = new ArrayList<Customer>();
        populateAvailableCustomers();
        availableIngredients = new ArrayList<String>();
        //populate availableIngredients from Ingredients class with ingredients available at the start of the game (everything except crowgroass)
        Ingredients ingredients = new Ingredients("ingredients.txt");
        for (String ingredientName : ingredients.getNames()){
            if (!ingredientName.toLowerCase().equals("crowgroass")){
                availableIngredients.add(ingredientName.toLowerCase());
            }

        }
        
        


    }

    //given the folder that the customer text files are in
    //populate and return an arrayList of all customer objects
    public static ArrayList<Customer> populateAllCustomers(String folderName) {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        File customersFolder = new File(folderName);
        File[] listOfCustomers = customersFolder.listFiles();

        for (File file : listOfCustomers) {
            if (file.isFile()) {
                String fileName = file.getName();
                Customer customer = new Customer(fileName);
                customers.add(customer);
            }
        }

        return customers;
    }

    

    // If customer cureStatus is false, and numVisits >= neededVisits, 
    // add to availableCustomers
    public void populateAvailableCustomers() {
        for (Customer c : allCustomers){

            if (!c.cureStatus && c.numVisits >= c.neededVisits){
                availableCustomers.add(c);
            }
        }
    }

    //method to get intro text from text file
    public static ArrayList<String> getIntroText(){
        ArrayList<String> introText = new ArrayList<String>();
        try {
            java.io.File file = new java.io.File("res/allTextFiles/intro.txt");
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

    //method to run intro sequence
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


    //method to slow down printing to console
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    //helper method to get a random customer from availableCustomers
    public Customer getRandomCustomer() {
        int randomIndex = (int) (Math.random() * availableCustomers.size());
        return availableCustomers.get(randomIndex);
    }
    

    


    public static void main(String[] args) {
       
        Main game = new Main();
        //runIntro();
        
        //user input to proceed to
        java.util.Scanner input = new java.util.Scanner(System.in);
            System.out.println("\nPress Enter to Continue...");
            input.nextLine();
        
        System.out.println("Here Comes Your First Customer! Good Luck!");

        //for customer in availableCustomers, choose random customer
        //display customer dialogue
        //give user options for input
        //process user input
        //update potion based on user input or display appropriate information
        //once user inputs "brew", compare potion to cure recipe
        //display appropriate reaction based on comparison
        //update customer cure status and available customers based on reaction
        //repeat until available customers is empty

        
        

        while (game.availableCustomers.size() > 0){
            //print a randomcustomer from the list, then remove them from the list
            Customer currentCustomer = game.getRandomCustomer();
            ArrayList<String> dialogue = currentCustomer.dialogue;
            System.out.println("\n" + currentCustomer.name.toUpperCase() + " enters the shop!\n");
            sleep(50);

            //slowly print the first line in dialogue
            // for(char c : dialogue.get(0).toCharArray()){
            //     System.out.print(c);
            //     sleep(75);
            // }

            //prompt user to enter command
            System.out.println("\n\nEnter a command (type 'help' if you're not sure what to do):");
            String userCommand = input.nextLine();

            //while userCommand is not "brew", keep prompting for command
            while (!userCommand.toLowerCase().equals("brew")) {
                
                //if userCommand is "help", display help text
                if (userCommand.toLowerCase().equals("help")) {
                    //open file titled instructions.txt and print its contents
                    try {
                        java.io.File file = new java.io.File("res/allTextFiles/instructions.txt");
                        java.util.Scanner helpInput = new java.util.Scanner(file);
                        while (helpInput.hasNextLine()) {
                            String line = helpInput.nextLine();
                            System.out.println(line);
                        }
                        helpInput.close();
                    } catch (java.io.FileNotFoundException e) {
                        System.out.println("File not found: instructions.txt");
                    }
                }

                //if userCommand starts with "make ", add ingredient that follows to potion"
                else if (userCommand.toLowerCase().startsWith("add ")) {
                    String ingredient = userCommand.substring(4);
                    System.out.println("You added " + ingredient + " to the potion.");

                    //add ingredient to potion (not implemented yet)
                }

                //if userCommand is "ingredients", display list of available ingredients
                else if (userCommand.toLowerCase().equals("ingredients")) {
                    //display list of available ingredients (not implemented yet)
                }

                //if userCommand is an ingredient, display info about that ingredient
                else if (game.availableIngredients.contains(userCommand.toLowerCase())) {
                    //display info about ingredient (not implemented yet)
                }

                else {
                    System.out.println("Invalid command. Please try again.");
                }

                System.out.println("\nEnter a command (type 'help' if you're not sure what to do):");
                userCommand = input.nextLine();

            }

            //show player that potion is brewing
            //every few seconds, print 3 dots, then erase the line
            //do that like 4 times
            System.out.println("\nBrewing the potion...");
            sleep(200);
            for (int i = 0; i < 4; i++) {
                //print '...' slowly
                for(int d = 0; d < 3; d++){
                    System.out.print(".");
                    sleep(200);
                }
                System.out.print("\r   \r");
                System.out.println();
                sleep(50);
                
            }
            System.out.println("Your potion is finished! Handing to Customer");

            //if customer aversion is in the potion, print their negative reaction

            //if potion matches customers cure, print positive reaction
            //set customer status to cured
            //if they have an ingredient to give, add it to the list of availableIngredients
            //if they have connections to other customers, increment the visited status of 
            //customers they are connected to

            //if potion does not match customers cure, print neutral reaction
            
            game.availableCustomers.remove(currentCustomer);

        }
        
    }


}
