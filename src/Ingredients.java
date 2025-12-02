import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * This class represents an ingredient used in recipes.
 */

public class Ingredients {
    
    HashMap<String, ArrayList<String>> Definitions = new HashMap<>();
    ArrayList<String> availableIngredients;


    //Precondition of file structure: Last attibute for a given ingredient precedes a period.
    public Ingredients(String fileName){

        String ingredient = "";
        ArrayList<String> attributes = new ArrayList<>();
        try {
            java.io.File file = new java.io.File("res/allTextFiles/" + fileName);
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains("-")) {
                    attributes.add(line);
                }
                else{
                    ingredient = line;
                }

                if(line.contains(".")){
                    Definitions.put(ingredient, attributes);
                    attributes = new ArrayList<>();
                }
                
            }
            input.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }


    }

    public Set<String> getNames(){
        return Definitions.keySet();
    }

    public ArrayList<String> getAttributes(String ingredient){
        return Definitions.get(ingredient);
    }

    
    
}
