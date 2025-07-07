package designPatterns.Adapter;

public class ICICIBankAPILib {
    public double checkBalance(String userToken) {
        return 1000;
    }

    public int transferMoney(String fromUserToken, String toUserToken, double amount){
        return 1;
    }

    public boolean addBankAccount(String accountNumber, String ifsc, String phone, int pin){
        return true;
    }
}
