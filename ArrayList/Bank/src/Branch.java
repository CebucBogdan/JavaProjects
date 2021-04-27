import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String nameOfCustomer, double initialTransaction){
        if(findCustomer(nameOfCustomer) == null){
            customers.add(new Customer(nameOfCustomer, initialTransaction));
            return true;
        }
        return false;
    }
    public boolean addCustomerTransaction(String nameOfCustomer, double transaction){
        Customer existingCustomer = findCustomer(nameOfCustomer);
        if(existingCustomer != null){
            existingCustomer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String nameOfCustomer){
        for(int i=0; customers.size()>i; i++){
            Customer checkedCustomer = customers.get(i);
            if(customers.get(i).getName().equals(nameOfCustomer)){
                return checkedCustomer;
            }
        }
        return null;
    }


}