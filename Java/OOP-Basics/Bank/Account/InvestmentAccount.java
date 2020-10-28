package Account;

public class InvestmentAccount extends BankAccount {

    private int period = 3; //represent the time of investment in months
    private int interest = 5; //how much you gain from your investment every period

    public InvestmentAccount( String owner ) {
        super (owner, "Investing");

    }

    public void applyInvestment() {
        balance += (int) ((balance * interest) / 100);
    }

}
