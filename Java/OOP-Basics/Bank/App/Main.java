package App;

import Account.InvestmentAccount;
import Account.SavingsAccount;

public class Main {

    public static void main(String[] args) {
        //TESTING UNIQUE ACCOUNT NUMBER GENERATION
//        for (int i = 0; i < 10; i++) {
//            String fName = Integer.toString(i);
//            String lName = Integer.toString(i+1);
//            var myAccount = new BankAccount(fName, lName);
//        }
//
//        BankAccount.showAllNumbers();
//            var myAccount = new BankAccount("Test first", "Test last");
//            myAccount.getAccountBalance();

//        var mySavings = new SavingsAccount("bill", 3);
//        mySavings.deposit(100_000_000);
//        for (int i = 0; i < 7; i++) {
//            mySavings.withdraw(115);
//            mySavings.getAccountBalance();
//            System.out.println(mySavings.getBalance());
//        }
        var myInvestment = new InvestmentAccount("Gavin");
        myInvestment.deposit(10000);
        myInvestment.applyInvestment();
        System.out.println(myInvestment);

    }
}
