package designPatterns.Adapter;

public class ICICIBankAdapter implements BankAPIAdapter{

    private ICICIBankAPILib iciciBankAPILib;

    public ICICIBankAdapter() {
        this.iciciBankAPILib = new ICICIBankAPILib();
    }

    @Override
    public double checkBalance(User user) {
        return iciciBankAPILib.checkBalance(user.getUserToken());
    }

    @Override
    public int doTransaction(User fromUser, User toUser, double amount) {
        int result = iciciBankAPILib.transferMoney(fromUser.getUserToken(), toUser.getUserToken(), amount);
        return result;
    }

    @Override
    public boolean addBankDetails(BankDetails bankDetails) {
        boolean result = iciciBankAPILib.addBankAccount(bankDetails.getAccountNumber(), bankDetails.getIfsc(), bankDetails.getPhoneNumber(), bankDetails.getPin());
        return result;
    }
}
