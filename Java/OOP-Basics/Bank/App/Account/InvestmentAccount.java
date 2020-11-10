package Account;

public class InvestmentAccount extends BankAccount {

    private final static int investmentWithdrawFee = 1000;

    private int period = 3; //represent the time of investment in months
    private int interest; //how much you gain from your investment every period

    public InvestmentAccount( String owner, int interest ) {
        super (owner, "Investing");
        this.interest = interest;

    }

    public InvestmentAccount( String owner, int interest, String type ) {
        super (owner, type);
        this.interest = interest;

    }

    public void applyInvestment() {
        balance += (int) ((balance * interest) / 100);
    }

    @Override
    public void withdraw (int amount ){
        super.withdraw( amount + investmentWithdrawFee);
    }

}
