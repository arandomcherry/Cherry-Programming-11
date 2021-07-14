import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;


    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: returns the Deposit object in a specific format in the order double, Date, String
    public String toString(){
        return "Deposit of: $" +amount + " Date: "+date.toString()+" into account: "+account;
    }
}
