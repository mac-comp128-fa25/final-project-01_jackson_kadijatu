import java.util.ArrayList;
import java.lang.Thread;
import java.io.File;

/**
 * This is the main class for the game
 */

public class Main {
    public ArrayList<Customer> allCustomers;
    public ArrayList<Customer> availableCustomers;
    public ArrayList<String> customerConnections;

    //initial setup
    public Main() {
        allCustomers = populateAllCustomers("res/allTextFiles/Customers");
        availableCustomers = new ArrayList<Customer>();
        populateAvailableCustomers();


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
            System.out.println("\n" + currentCustomer.name.toUpperCase() + " enters the shop!\n");
            
            
            game.availableCustomers.remove(currentCustomer);

        }
        
    }

    

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
