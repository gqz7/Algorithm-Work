package Account;

import java.text.NumberFormat;
import java.text.MessageFormat;
import java.util.ArrayList;


public class BankAccount {

    private static final int ACCOUNT_CHAR_LIMIT = 1_000_000_000;
    private static final int ACC_LENGTH = 10;

    private String accountHolderName;
    private String accountNumber;
    private String routingNumber;
    private String type;
    protected int balance;

    private static ArrayList<String>  allAccountNum = new ArrayList<>();
    private static ArrayList<String>  allRouteNum = new ArrayList<>();

    BankAccount ( String owner, String type ) {
        accountHolderName = owner;
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
