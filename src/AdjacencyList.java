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
    //    Customer A = new Customer("adrien.txt");
    //    Customer B = new Customer("ava.txt");
    //    Customer C = new Customer("Dennis.txt");
    //    Customer D = new Customer("holly.txt");
    //    Customer E = new Customer("nova.txt");
    //    Customer F = new Customer("shawn.txt");


       ArrayList<Customer> customers = Main.populateAllCustomers("src/Customers");

       for(Customer c : customers){
        customerConnections.put(c, c.connections);
       }

       //java file interation instead of hardcode



       //Use the getConnections method once it is made instead of hardcoding the neighbors list



        //change to a loop when change file so this isnt hard coded

        // customerConnections.put(A, A.connections);
        // customerConnections.put(B, B.connections);
        // customerConnections.put(C, C.connections);
        // customerConnections.put(D, D.connections);
        // customerConnections.put(E, E.connections);
        // customerConnections.put(F, F.connections);
       


    }



    
}
