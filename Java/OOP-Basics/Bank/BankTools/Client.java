package BankTools;

import Account.Account;

import java.util.HashSet;
import java.util.Set;

public class Client {

    private static final Set<String> allClientIds = new HashSet<>();
    private static final int ID_MULTIPLIER = 1_000_000_000;
    private static final int ID_LENGTH = 10;

    private final Set<Account> accounts;

    private final String firstName;
    private final String lastName;

    private final String clientId;

    public Client (String firstName, String lastName) {
        accounts = new HashSet<>();

        this.firstName = firstName;
        this.lastName = lastName;

        clientId = createClientId();
    }

    private static String createClientId() {
        String randomNumber = formatClientId(Integer.toString((int) Math.round(Math.random() * ID_MULTIPLIER)));
        while (allClientIds.contains(randomNumber)) {
            randomNumber = formatClientId(Integer.toString((int) Math.round(Math.random() * ID_MULTIPLIER)));
        }
        allClientIds.add(randomNumber);
        return randomNumber;
    }

    public void displayClientAccounts () {
        for ( Account acc : accounts ) {
            System.out.println(acc);
        }
    }

    public static String formatClientId ( String accountNumber ) {
        int missingZeros = ID_LENGTH - accountNumber.length();
        return "0".repeat(missingZeros) + accountNumber;
    }

    public String getClientFullName () {
        return firstName + " " + lastName;
    }
    public String getClientId() {
        return clientId;
    }
}
