import java.util.ArrayList;
import java.lang.Thread;
import java.io.File;

/**
 * This is the main class for the game
 */

public class Main {
    public static ArrayList<Customer> allCustomers;
    public ArrayList<Customer> availableCustomers;
    public static ArrayList<String> allCustomerNames;
    public ArrayList<String> customerConnections;
    public ArrayList<Ingredient> allIngredients;;
    public ArrayList<String> availableIngredients;
    public Potion currentPotion;
    public int PlayerScore;

    //initial setup
    public Main() {
        allCustomerNames = new ArrayList<>();
        allCustomers = new ArrayList<>();
        availableCustomers = new ArrayList<Customer>();
        allIngredients = new ArrayList<Ingredient>();
        availableIngredients = new ArrayList<String>();
        currentPotion = new Potion();
        //populate availableIngredients from Ingredients class with ingredients available at the start of the game (everything except crowgroass)
        
        populateAllCustomers("res/allTextFiles/Customers");
        populateAvailableCustomers();
        populateAllIngredients();
        populateAvailableIngredients();

        
        for (Customer customer : allCustomers){
            customer.connections = customer.getConnections(customer.name + ".txt");
            String name = customer.name;
            allCustomerNames.add(name);
        }

    }

    //given the folder that the customer text files are in
    //populate and return an arrayList of all customer objects
    public static void populateAllCustomers(String folderName) {
        // ArrayList<Customer> customers = new ArrayList<Customer>();

        File customersFolder = new File(folderName);
        File[] listOfCustomers = customersFolder.listFiles();

        for (File file : listOfCustomers) {
            if (file.isFile()) {
                String fileName = file.getName();
                Customer customer = new Customer(fileName);
                allCustomers.add(customer);
            }
        }

        //return customers;
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

    //for each ingredient in ingredients folder, use the text file to create an ingredient object and add it to allIngredients
    public void populateAllIngredients() {
        //for each file in res/allTextFiles/Ingredients
        File ingredientsFolder = new File("res/allTextFiles/Ingredients");
        File[] listOfIngredients = ingredientsFolder.listFiles();
        for (File file : listOfIngredients) {
            if (file.isFile()) {
                String fileName = file.getName();
                Ingredient ingredient = new Ingredient(fileName);
                allIngredients.add(ingredient);
            }
        }
    }

    //populate availableIngredients with ingredients that are marked as available in allIngredients
    public void populateAvailableIngredients() {
        for (Ingredient ingredient : allIngredients) {
            if (ingredient.available) {
                availableIngredients.add(ingredient.name.toLowerCase());
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
        // runIntro();
        
        //user input to proceed to
        java.util.Scanner input = new java.util.Scanner(System.in);
            System.out.println("\nPress Enter to Continue...");
            input.nextLine();
        
        System.out.println("Here Comes Your First Customer! Good Luck!");

        while (game.availableCustomers.size() > 0){
            //print a randomcustomer from the list, then remove them from the list
            Customer currentCustomer = game.getRandomCustomer();
            ArrayList<String> dialogue = currentCustomer.dialogue;
            System.out.println(currentCustomer.cureRecipe);
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

                //if userCommand starts with "add ", add ingredient that follows to potion"
                else if (userCommand.toLowerCase().startsWith("add ")) {
                    String ingredient = userCommand.substring(4);
                    System.out.println("You added " + ingredient + " to the potion.");

                    game.currentPotion.add(ingredient);
                    
                }

                //remove ingredient from potion if userCommand starts with "remove "
                else if (userCommand.toLowerCase().startsWith("remove ")) {
                    String ingredient = userCommand.substring(7);
                    if (game.currentPotion.potionIng.keySet().contains(ingredient)) {
                        int currentQuantity = game.currentPotion.potionIng.get(ingredient);
                        if (currentQuantity > 1) {
                            game.currentPotion.potionIng.put(ingredient, currentQuantity - 1);
                        } else {
                            game.currentPotion.potionIng.remove(ingredient);
                        }
                        System.out.println("You removed one " + ingredient + " from the potion.");
                    } else {
                        System.out.println("Ingredient not found in the potion.");
                    }
                }

                //if userCommand is "potion", display current potion ingredients
                else if (userCommand.toLowerCase().equals("potion")) {
                    System.out.println("Current potion ingredients:");
                    for (String ingredient : game.currentPotion.potionIng.keySet()) {
                        int quantity = game.currentPotion.potionIng.get(ingredient);
                        System.out.println("- " + ingredient + ": " + quantity);
                    }
                }

                //if userCommand is "ingredients", display list of available ingredients
                else if (userCommand.toLowerCase().equals("ingredients")) {
                    System.out.println("Available ingredients:");
                    for (String ingredient : game.availableIngredients) {
                        System.out.println("- " + ingredient);
                    }
                }

                //if userCommand is an ingredient, display info about that ingredient
                else if (game.availableIngredients.contains(userCommand.toLowerCase())) {
                    for (Ingredient ingredient : game.allIngredients) {
                        if (ingredient.name.equalsIgnoreCase(userCommand)) {
                            System.out.println("Attributes: " + ingredient.attributes);
                        }
                    }
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

            //if customer aversion is in the potion, print their negative reaction, which is bindex 3 of their dialogue
            if (game.currentPotion.potionIng.keySet().contains(currentCustomer.aversions)){
                System.out.println(currentCustomer.dialogue.get(3));
                game.PlayerScore -= 3;
            }

            
            //if potion matches customers cure, print positive reaction
            else if (game.currentPotion.compare(currentCustomer)){
                System.out.println(currentCustomer.dialogue.get(1));
                currentCustomer.cureStatus = true;
                game.PlayerScore += 5;

                //if they have an ingredient to give, add it to the list of availableIngredients
                if (currentCustomer.ingredient != null){
                    System.out.println(currentCustomer.name + " has given you " + currentCustomer.ingredient.name + " as a reward!");
                    game.availableIngredients.add(currentCustomer.ingredient.name.toLowerCase());

                }

                //if they have connections to other customers, increment the visited status of customers they are connected to
                if (currentCustomer.connections != null){
                    for (Customer connection : currentCustomer.connections){
                        connection.numVisits += 1;
                    }

                }

            }
            
            else{
                System.out.println(currentCustomer.dialogue.get(2));  //if potion does not match customers cure, print neutral reaction

            }
          
            game.availableCustomers.remove(currentCustomer);

            //check if any customers can now be added to availableCustomers, and remove all ingredients from currentPotion
            game.currentPotion.clear();
            game.populateAvailableCustomers();
            

        }

    


}}

