import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;


    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: returns the Deposit object in a specific format in the order double, Date, String
    public String toString(){ //check overdraft
        return "Withdraw of: $" +amount + " Date: "+date.toString()+" into account: "+account;
    }
}
