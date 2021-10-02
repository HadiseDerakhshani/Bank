package bank;

public class LoanAccount extends Account {
    private static double interest = 0.15;
    private double loanAmount = calcLoans();
    private boolean isInterestCalc=false;

    public boolean isInterestCalc() {
        return isInterestCalc;
    }

    public LoanAccount(double amountAccount, int numberAccount, AccountType typeAccount, String date) {
        super(amountAccount, numberAccount, typeAccount, date);
    }

    public LoanAccount() {
    }

    public static double getInterest() {
        return interest;
    }

    public double calcLoans() {
        return getAmountAccount() * 2;
    }


    public void withdrawInstallments() {
        if(isInterestCalc==false){
            double installments = loanAmount*interest*super.calcNumberDay() / 36500;
            setAmountAccount(getAmountAccount() - installments);
            super.addNewTransaction(installments,TranceType.LOAN_FEE);
            isInterestCalc=true;}
        else
            System.out.println("this account calculate interest");
    }
}
