import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AdjacencyList {

private int numCustomers;
private HashMap<Customer, ArrayList<Customer>> customers;



    public AdjacencyList(int numCustomers){
        this.numCustomers = numCustomers;
        customers = new HashMap<>(numCustomers);
    }


    public void add(Customer customer, ArrayList<Customer> listCustomer){
        customers.put(customer, listCustomer);
    }

    public void add(Customer customer, Customer connection){
        ArrayList<Customer> temp = new ArrayList<>();
        temp.add(connection);
        customers.put(customer, temp);
    }


    public ArrayList<String> getConnections(Customer customer){
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<Customer> target = customers.get(customer);

        if(target != null){

            for(Customer c: target){
                temp.add(c.getName());
            }
            
            return temp;
        }
        else{
            return null;
        }
        
    }


    public void initialSetup(){
       Customer A = new Customer("adrien.txt");
       Customer B = new Customer("ava.txt");
       Customer C = new Customer("Dennis.txt");
       Customer D = new Customer("holly.txt");
       Customer E = new Customer("nova.txt");
       Customer F = new Customer("shawn.txt");

       //Use the getConnections method once it is made instead of hardcoding the neighbors list
       //Ex put(A, A.getConnections())

       customers.put(A, new ArrayList<Customer>(Arrays.asList(C)));
       customers.put(B, new ArrayList<Customer>(Arrays.asList(E)));
       customers.put(C, new ArrayList<Customer>(Arrays.asList(A, B)));
       customers.put(D, new ArrayList<Customer>(Arrays.asList(C)));
       customers.put(E, new ArrayList<Customer>());
       customers.put(F, new ArrayList<Customer>());

    }



    
}
