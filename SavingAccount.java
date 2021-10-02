package bank;

public class SavingAccount extends Account {
    private boolean isInterestCalc = false;
     private final static double interest=0.01;
    public boolean isInterestCalc() {
        return isInterestCalc;
    }

    public SavingAccount(double amountAccount, int numberAccount, AccountType typeAccount, String date) {
        super(amountAccount, numberAccount, typeAccount, date);
    }

    public SavingAccount() {
    }


    public void calcMonthlyProfit() {
        if (isInterestCalc == false) {
            double dayProfit;
            dayProfit=(getAmountAccount()*interest*super.calcNumberDay())/36500;
            super.addNewTransaction(dayProfit, TranceType.INTEREST);
            isInterestCalc = true;
        } else
            System.out.println("this account calculate interest");
    }
    }
