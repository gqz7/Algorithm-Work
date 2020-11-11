package BankTools;

import Account.Account;
import Account.CheckingAccount;
import Account.SavingsAccount;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DebitCard extends Card {
    
    private final String pin;
    private final Client holder;
    private CheckingAccount primary;
    private String securityCode;
    private String cardNum;
    private Calendar expData;
    private List<Account> atmAccounts = new ArrayList<>();

    public DebitCard( String pin, Client holder ) {
        this.pin = pin;
        this.holder = holder;
    }

    public boolean charge( int amt, String pin) {
        if (this.pin.equals(pin) && primary.getBalance() >= amt) {
            primary.withdraw(amt);
            return true;
        }
        return false;
    }

    public void addAtmAccounts(Account account ) {
        atmAccounts.add( account );
    }

    public void displayAccounts() {
        for (var account: atmAccounts) {
            System.out.println(account);
        }
    }

}
