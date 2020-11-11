package Account;

import BankTools.Client;

import java.text.NumberFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class BankAccount implements Account{

    private static final int ACCOUNT_CHAR_LIMIT = 1_000_000_000;
    private static final int ACC_LENGTH = 10;

    private final String accountHolderName;
    private final String accountNumber;
    private final String routingNumber;
    private final String type;
    private final Client holder;
    protected int balance;

    private static final Set<String> allAccountNum = new HashSet<>();
    private static final Set<String>  allRouteNum = new HashSet<>();

    BankAccount ( Client client, String type ) {
        accountHolderName = client.getClientFullName();
        holder = client;

        this.type = type;

        accountNumber = BankAccount.genAccountNumber();
        routingNumber = BankAccount.genRoutingNumber();

        balance = 0;
    }

    public int getBalance () {
        return balance;
    }

    private static String genAccountNumber () {
        //Ensure there are no repeats by comparing to list of all account numbers
        String randomNumber = formatAccountNumber(Integer.toString((int) Math.round(Math.random() * ACCOUNT_CHAR_LIMIT)));
        while (allAccountNum.contains(randomNumber)) {
            randomNumber = formatAccountNumber(Integer.toString((int) Math.round(Math.random() * ACCOUNT_CHAR_LIMIT)));
        }
//        System.out.println(randomNumber);
        allAccountNum.add(randomNumber);
        return randomNumber;
    }

    public void deposit ( int amount ) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw ( int amount ) {
        if (amount > 0 && balance - amount >= 0) {
            balance -= amount;
        }
    }

    private static String genRoutingNumber () {
        String randomNumber = formatAccountNumber(Integer.toString((int) Math.round(Math.random() * ACCOUNT_CHAR_LIMIT)));
        while (allRouteNum.contains(randomNumber)) {
            randomNumber = formatAccountNumber(Integer.toString((int) Math.round(Math.random() * ACCOUNT_CHAR_LIMIT)));
        }
//        System.out.println(randomNumber);
        allRouteNum.add(randomNumber);
        return randomNumber;
    }

    public String getAccountBalance () {
        return NumberFormat.getCurrencyInstance().format((double) (balance)/100);
    }

    public static void showAllNumbers () {
        System.out.println(allAccountNum.toString());
        System.out.println(allRouteNum.toString());
    }

    public static String formatAccountNumber ( String accountNumber ) {
        int missingZeros = ACC_LENGTH - accountNumber.length();
        return "0".repeat(missingZeros) + accountNumber;
    }

    public static String formatBalance ( int balance ) {
        int dollar = balance / 100;
        int cents = balance % 100;
        return "$" + dollar + "." + cents;
    }

    @Override
    public String toString() {
        String lineBreak = "\n____________________\n";
        String formattedBalance = getAccountBalance();

        return MessageFormat.format(
                "Account Info;{0}Owner Name: {1}\nAccount Type: {2}\nAccount Balance: {3}\nAccount Number: {4}\nRouting Number: {5}\n",
                lineBreak, accountHolderName, type, formattedBalance, accountNumber, routingNumber
        );
    }
}
