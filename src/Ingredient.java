/*
 * This class represents one ingredient object as the ingredients name, its attribute description, and it's availability upon creation.
*/

public class Ingredient {
    public String name;
    public String attributes;
    public boolean available;

    public Ingredient(String filename){
        this.name = getName(filename);
        this.attributes = getAttributes(filename);
        this.available = isAvailable(filename);
    }

    //given a filename, open the file and read in the name of the ingredient
    public String getName(String filename){
        String name = "";

        try {
            java.io.File file = new java.io.File("res/allTextFiles/Ingredients/" + filename);
            java.util.Scanner input = new java.util.Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.startsWith("name:")) {
                    name = line.substring(5).trim();
                    break;
                }
            }
            input.close();

        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return name;
    }

    //given a filename, open the file and return the attributes of the ingredient
    public String getAttributes(String filename){
        String attributes = "";

        try {
            java.io.File file = new java.io.File("res/allTextFiles/Ingredients/" + filename);
            java.util.Scanner input = new java.util.Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.startsWith("attributes:")) {
                    attributes += line.substring(11).trim();
                }
            }
            input.close();

        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return attributes;
    }

    //given a filename, open the file and check if the ingredient is available
    public boolean isAvailable(String filename){
        boolean available = false;

        try {
            java.io.File file = new java.io.File("res/allTextFiles/Ingredients/" + filename);
            java.util.Scanner input = new java.util.Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.startsWith("available:")) {
                    String availString = line.substring(10).trim();
                    available = availString.equalsIgnoreCase("Y");
                    break;
                }
            }
            input.close();

        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return available;
    }

    
}