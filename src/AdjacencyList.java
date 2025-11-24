import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class AdjacencyList {

private int numCustomers;  // do we need this, since hashmap is a dynamic data structure?
private HashMap<Customer, ArrayList<Customer>> customerConnections;



    public AdjacencyList(int numCustomers){
        this.numCustomers = numCustomers;
        customerConnections = new HashMap<>(numCustomers);
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

       ArrayList<Customer> customers = Main.populateAllCustomers("src/Customers");

       for(Customer c : customers){
        customerConnections.put(c, c.connections);
       }


    }



    
}
