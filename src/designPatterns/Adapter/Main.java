package designPatterns.Adapter;

public class Main {
    public static void main(String[] args) {
        BankAPIAdapter bankAPIAdapter = new AxisBankAdapter();
        PhonePe phonePe = new PhonePe(bankAPIAdapter);
        //phonePe.transferMoney();
    }
}
