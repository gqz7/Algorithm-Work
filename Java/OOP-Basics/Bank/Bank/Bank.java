package Bank;

import BankTools.Client;

import java.util.HashSet;
import java.util.Set;

public class Bank {

    private static final Set<Client> allClients = new HashSet<>();

    private static void addClient ( Client newClient ) {
        allClients.add(newClient);
    }

    private static void printAllClients () {
        for ( Client c : allClients ) {
            System.out.println(c);
        }
    }

}
