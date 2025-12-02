import java.util.ArrayList;
import java.util.HashMap;


public class AdjacencyList {

private HashMap<Customer, ArrayList<Customer>> customerConnections;
private ArrayList<Customer> connections; 



    public AdjacencyList(){
        customerConnections = new HashMap<>();
        connections = new ArrayList<>();
        
    }

    
    public void add(Customer customer, ArrayList<Customer> listCustomer){
        customerConnections.put(customer, listCustomer);
    }

    public void add(Customer customer, Customer connection){
        ArrayList<Customer> temp = new ArrayList<>();
        temp.add(connection);
        customerConnections.put(customer, temp);
    }


    


    // public ArrayList<String> getConnections(Customer customer){
    //     ArrayList<String> temp = new ArrayList<>();
    //     ArrayList<Customer> target = customers.get(customer);

    //     if(target != null){

    //         for(Customer c: target){
    //             temp.add(c.getName());
    //         }
            
    //         return temp;
    //     }
    //     else{
    //         return null;
    //     }
        
    // }


    public void initialSetup(){
        Main main = new Main();
        ArrayList<Customer> customers = main.allCustomers;

       for(Customer c : customers){
        customerConnections.put(c, c.connections);
       }


    }





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
        this.connections = connections;
        return connections;
    }



    public ArrayList<Customer> getConnections(){
        return connections;
    }
}

    

