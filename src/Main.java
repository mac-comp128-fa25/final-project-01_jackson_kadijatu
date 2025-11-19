import java.util.ArrayList;
import java.lang.Thread;

/**
 * This is the main class for the game
 */

public class Main {
    public ArrayList<Customer> allCustomers;
    public ArrayList<Customer> availableCustomers;

    //initialize list of all customers in game
    //initialize list of available customers
    //initialize directed graph for customer connections

    //initial game text, gives introduction to rules, objectives, and controls
    // ie. "Welcome to your Apothecary! Your goal is to cure as many customers 
    // as possible by creating the right recipes for their ailments. You don't
    // have to cure them all, but the more you cure, the better your score!
    // When a customer comes in, pay attention to what they say - How they describe
    // their symptoms will help you figure out what ingredients you need to use,and in
    // what quantities. Be careful, cause if you get it wrong,you could hurt them!
    // If you ever need to know what ingredients you have, type "Ingredients" into
    // the console. To see what each ingredient does, type the nameof the ingredient.
    //To make a recipe, type "Make" followed by the ingredient names.

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
