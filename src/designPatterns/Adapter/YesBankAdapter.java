package designPatterns.Adapter;

public class YesBankAdapter implements BankAPIAdapter{

    private YesBankAPILib yesBankAPILib;

    public YesBankAdapter() {
        this.yesBankAPILib = new YesBankAPILib();
    }

    @Override
    public double checkBalance(User user) {
        long balance = yesBankAPILib.getBalance(user.getUserName(), user.getPassword());
        double result = balance;
        return result;
    }

    @Override
    public int doTransaction(User fromUser, User toUser, double amount) {
        char result = yesBankAPILib.doTransaction(fromUser.getUserName(), toUser.getUserName(), fromUser.getPassword(), amount);
        if(result == 'y'){
            return 1; // success
        } else if(result == 'n'){
            return 0; // failure
        } else {
            return 2; // in-progress
        }
    }

    @Override
    public boolean addBankDetails(BankDetails bankDetails) {
        int result = yesBankAPILib.createBankConnection(bankDetails);
        if(result == 1){
            return true;
        } else {
            return false;
        }
    }
}
