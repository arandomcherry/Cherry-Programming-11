import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        name = "";
        accountNumber = 0;
        checkBalance = 0.0;
        savingBalance = 0.0;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit, ArrayList<Deposit> deposits, ArrayList <Withdraw> withdraws){
        this.name = name;
        this.accountNumber = accountNumber;
        checkBalance = checkDeposit;
        savingBalance = savingDeposit;
        this.deposits = deposits;
        this.withdraws = withdraws;

    }

    //Requires: double, Date, String
    //Modifies: this, deposits
    //Effects: creates a Deposit object based on the information entered, deposit the double amount into either the checking balance or the saving balance depending on the String account name the user entered, then returns the double amount entered
    public double deposit(double amt, Date date, String account){
        if(account.equals(CHECKING)){
            checkBalance += amt;
            deposits.add(new Deposit(amt, date, account)); //only adds to arraylist when either required condition is met
        }else if(account.equals(SAVING)){
            savingBalance += amt;
            deposits.add(new Deposit(amt, date, account));
        }
        return amt;
    }

    //Requires: double, Date, String
    //Modifies: this, withdraws
    //Effects: creates a Withdraw object based on the information entered, if the withdraw amount is within the overdraft range, withdraw/subtract the double amount from either the checking balance or the saving balance depending on the String account name the user entered, then returns the double amount entered
    public double withdraw(double amt, Date date, String account){

        if(!checkOverdraft(amt, account)) {
            if (account.equals(CHECKING)) {
                checkBalance -= amt;
                withdraws.add(new Withdraw(amt, date, account));
            } else if (account.equals(SAVING)) {
                savingBalance -= amt;
                withdraws.add(new Withdraw(amt, date, account));
            }
        }else{
            System.out.println("Overdraft");
        }
        return amt;
    }

    //Requires: double, String
    //Modifies: nothing
    //Effects: Checks to see if the withdraw amount is within the overdraft limit for either the checking balance or the saving balance depending on the String account name the user entered
    private boolean checkOverdraft(double amt, String account){

        if(account.equals(CHECKING)){
            return (checkBalance - amt) < OVERDRAFT;
        }else if(account.equals(SAVING)){
            return (savingBalance - amt) < OVERDRAFT;
        }
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    double getCheckBalance(){ return checkBalance; }

    double getSavingBalance(){ return savingBalance; }

    ArrayList<Deposit> getDeposits(){ return deposits; }

    ArrayList<Withdraw> getWithdraws(){ return withdraws; }


}
