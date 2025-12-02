import java.util.HashMap;

/**
 * This class represents a potion in the system. A Potion is defined as
 * a mix of various ingredients. This class will handle adding together
 * different ingredients and their interations with customers.
 */

public class Potion {
    HashMap<String,Integer> potionIng = new HashMap<>();


    public void add(String Ingredient){
        if(potionIng.keySet().contains(Ingredient)){
            int temp = potionIng.get(Ingredient);
            potionIng.put(Ingredient, temp+1);
        }
        else{
            potionIng.put(Ingredient, 1);
        }
    }

    public boolean compare(Customer customer){
        if(customer.getCureRecipe().equals(potionIng)){
            return true;
        }
        else{
            return false;
        }
    }
    
}
