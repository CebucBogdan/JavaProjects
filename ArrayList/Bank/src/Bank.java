import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
    public boolean addBranch(String nameOfBranch){
        if(findBranch(nameOfBranch) == null){
            branches.add(new Branch(nameOfBranch));
            return true;
        }
        return false;

    }
    public boolean addCustomer(String nameOfBranch,String nameOfCustomer, double initialTransaction){
        Branch branch = findBranch(nameOfBranch);
        if(branch != null){
            return branch.newCustomer(nameOfCustomer, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transactionAmount){
        Branch branch = findBranch(nameOfBranch);
        if(branch != null){
            return branch.addCustomerTransaction(nameOfCustomer, transactionAmount);
        }
        return false;

    }

    private Branch findBranch(String nameOfBranch){
            for(int i=0; branches .size()>i; i++){
               Branch checkedBranches = branches.get(i);
                if(checkedBranches.getName().equals(nameOfBranch)){
                    return checkedBranches;
                }
            }
            return null;
        }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i=0; i<branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j=0; j<transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "]  Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
