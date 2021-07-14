import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer testCustomer;
    Deposit testDeposit;
    Withdraw testWithdraw;

    @Before

    //String name, int accountNumber, double checkDeposit, double savingDeposit
    public void setUp(){
        ArrayList <Deposit> deposits = new ArrayList<>();
        ArrayList<Withdraw> withdraws = new ArrayList<>();
        testCustomer = new Customer("Emma", 1322980, 1000.0, 1000.0, deposits, withdraws);
        Date d1 = new Date(121, 6, 6);
        Date d2 = new Date(121, 4, 23);
        testDeposit = new Deposit(800, d1, "Saving");
        testWithdraw = new Withdraw(200, d2, "Checking");
    }

    @Test
    public void testToString(){

        assertEquals(testDeposit.toString(), "Deposit of: $800.0 Date: Tue Jul 06 00:00:00 PDT 2021 into account: Saving");
        assertEquals(testWithdraw.toString(), "Withdraw of: $200.0 Date: Sun May 23 00:00:00 PDT 2021 into account: Checking");
    }

    @Test
    public void testDeposit(){

        Date da = new Date();
        testCustomer.deposit(200.0, da, "Saving");
        assertEquals(testCustomer.getSavingBalance(), 1200.0, 0);
        testCustomer.deposit(200.0, da, "Checking" );
        assertEquals(testCustomer.getCheckBalance(), 1200.0, 0 );

        testCustomer.deposit(100.0, da, "CHECKING");
        assertEquals(testCustomer.getCheckBalance(), 1200.0, 0); //check nothing will happens if incorrect account name is put in

        assertEquals(testCustomer.getDeposits().size(), 2); //check that there were 2 deposits that happened

    }

    @Test
    public void testWithdraw(){
        Date da = new Date();

        testCustomer.withdraw(300.0, da, "Saving");
        assertEquals(testCustomer.getSavingBalance(), 700, 0);
        testCustomer.withdraw(300.0, da, "Checking");
        assertEquals(testCustomer.getCheckBalance(), 700.0, 0);

        testCustomer.withdraw(801, da, "Saving"); //check for overdraft, when < -100 it won't withdraw anything
        assertEquals(testCustomer.getSavingBalance(), 700.0, 0);

        testCustomer.withdraw(200.0, da, "SAVING");
        assertEquals(testCustomer.getSavingBalance(), 700.0, 0); //check nothing will happen if incorrect account name is put in

        assertEquals(testCustomer.getWithdraws().size(), 2); //check that there were 2 total withdraws that happened

    }


}
