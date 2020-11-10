package Account;

public class CDInvestment extends InvestmentAccount {
    final static int cdInvestmentRate = 3;
    private int timeFrameMonths;
    public CDInvestment(String owner, int timeFrameMonths) {
        super(owner, cdInvestmentRate, "Certificate of Deposit");
        this.timeFrameMonths = timeFrameMonths;
    }

    public void checkIfInterest(int time) {
        if (time <= timeFrameMonths && balance > 0) {
            applyInvestment();
        } else {
            System.out.println("You can not collect, all interest has been applied");
        }
    }

    @Override
    public void withdraw(int amt) {
        System.out.println("You can not withdraw from a CD account");
        return;
    }

}
