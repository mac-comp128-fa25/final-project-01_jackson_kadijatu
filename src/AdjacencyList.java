import java.util.HashMap;
import java.util.List;

public class AdjacencyList {

private int numCustomers;
private HashMap<Customer, List<Customer>> customers;



    public AdjacencyList(int numCustomers){
        this.numCustomers = numCustomers;
        customers = new HashMap<>(numCustomers);
    }



    public void add(Customer customer, List<Customer> listCustomer){
        customers.put(customer, listCustomer);
    }


    public void initialSetup(){
       // customers.add()
    }



    
}
