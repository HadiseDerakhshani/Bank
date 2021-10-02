package bank;

public class CheckingAccount extends Account {
    private final static double maxWithdraw=2000000;
    private final static double fee=700;

    public CheckingAccount() {
    }

    public CheckingAccount(double amountAccount, int numberAccount, AccountType typeAccount, String date) {
        super(amountAccount, numberAccount, typeAccount, date);
    }

    @Override
    public void withdraw(double amount) {
        if(amount<maxWithdraw){
            super.withdraw(amount+fee);
        }else
            System.out.println("amount most be less than 2000000");
    }



}
