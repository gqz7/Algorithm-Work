package Account;

public class CheckingAccount extends BankAccount {

    private static final int WITHDRAW_FEE = 10_000;
    private static final int WD_LIMIT = 100;
    private int monthlyWithdraws = 0;

    CheckingAccount( String owner) {
        super(owner, "Checking");

    }

    @Override
    public void withdraw ( int amount ) {
        int totalWithdraw;
        if ( monthlyWithdraws+1 > WD_LIMIT ) {
            totalWithdraw = amount + WITHDRAW_FEE;
            System.out.println("Over monthly withdraw limit, you will be charged a withdraw fee.");
        } else totalWithdraw = amount;

        super.withdraw(totalWithdraw);
        monthlyWithdraws += 1;
    }
    @Override
    public void deposit ( int amount ) {
        super.deposit(amount);
    }

}
