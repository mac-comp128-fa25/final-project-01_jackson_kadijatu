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
       Customer A = new Customer("adrien.txt");
       Customer B = new Customer("ava.txt");
       Customer C = new Customer("Dennis.txt");
       Customer D = new Customer("holly.txt");
       Customer E = new Customer("nova.txt");
       Customer F = new Customer("shawn.txt");



       //Use the getConnections method once it is made instead of hardcoding the neighbors list
       

       customerConnections.put(A, new ArrayList<Customer>(Arrays.asList(C)));
       customerConnections.put(B, new ArrayList<Customer>(Arrays.asList(E)));
       customerConnections.put(C, new ArrayList<Customer>(Arrays.asList(A, B)));
       customerConnections.put(D, new ArrayList<Customer>(Arrays.asList(C)));
       customerConnections.put(E, new ArrayList<Customer>());
       customerConnections.put(F, new ArrayList<Customer>());


        customers.put(A, A.getConnections());
        customers.put(B, B.getConnections());
        customers.put(C, C.getConnections());
        customers.put(D, D.getConnections());
        customers.put(E, E.getConnections());
        customerConnections.put(F, F.getConnections());

        customerConnections.put(A, A.connections);


    }



    
}
