package designPatterns.Adapter;

public class AxisBankAdapter implements BankAPIAdapter{
    private AxisBankAPILib axisBankAPILib;

    public AxisBankAdapter() {
        this.axisBankAPILib = new AxisBankAPILib();
    }

    @Override
    public double checkBalance(User user) {
        return 0;
    }

    @Override
    public int doTransaction(User fromUser, User toUser, double amount) {
        return 0;
    }

    @Override
    public boolean addBankDetails(BankDetails bankDetails) {
        return false;
    }
}
