import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents an ingredient used in recipes.
 */

public class Ingredient {
    
    HashMap<String, ArrayList<String>> Definitions = new HashMap<>();


    //Precondition of file structure: Last attibute for a given ingredient precedes a period.
    public Ingredient(String fileName){

        String ingredient = "";
        ArrayList<String> attributes = new ArrayList<>();
        try {
            java.io.File file = new java.io.File("src/ingredients/" + fileName);
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
    
}
