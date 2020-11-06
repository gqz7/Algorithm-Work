package BankTools;

import Account.CheckingAccount;
import Account.SavingsAccount;

import java.util.Calendar;
import java.util.List;

public class DebitCard {
    
    private final String pin;
    private CheckingAccount primary;
    private String securityCode;
    private String cardNum;
    private Calendar expData;
    private List< CheckingAccount > checkingAccounts;
    private List<SavingsAccount> savingsAccounts;

    public DebitCard( String pin ) {
        this.pin = pin;
    }

    public boolean charge( int amt, String pin) {
        if (this.pin.equals(pin) && primary.getBalance() >= amt) {
            primary.withdraw(amt);
            return true;
        }
        return false;
    }
}
