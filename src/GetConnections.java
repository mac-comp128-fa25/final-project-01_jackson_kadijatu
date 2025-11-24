import java.util.ArrayList;

public class GetConnections {
    public ArrayList<Customer> getConnections(String fileName) {
        ArrayList<Customer> connections = new ArrayList<Customer>();

        try {
            java.io.File file = new java.io.File("res/allTextFiles/Customers/" + fileName);
            java.util.Scanner input = new java.util.Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.startsWith("Connections:")) {
                    String[] names = line.substring(12).trim().split(" ");

                    for (String name : names) {
                        Customer c = new Customer(name + ".txt");   
                        connections.add(c);
                    
                    }
            }
        }
        input.close();

        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return connections;
    }
}
