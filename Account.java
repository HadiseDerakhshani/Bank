package bank;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Account {
    private static int indexTrance = 0;
    private double amountAccount;
    private int numberAccount;
    private AccountType typeAccount;
    private String date;
    private Transactions[] transactions = new Transactions[100];


    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public static int getIndexTrance() {
        return indexTrance;
    }

    public Transactions[] getTransactions() {
        return transactions;
    }

    public static void setIndexTrance(int indexTrance) {
        Account.indexTrance = indexTrance;
    }

    public void setTransactions(Transactions[] transactions) {
        this.transactions = transactions;
    }

    public Account() {
    }

    public Account(double amountAccount, int numberAccount, AccountType typeAccount, String date) {
        this.amountAccount = amountAccount;
        this.numberAccount = numberAccount;
        this.typeAccount = typeAccount;
        this.date = date;
    }

    public AccountType getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(AccountType typeAccount) {
        this.typeAccount = typeAccount;
    }

    public double getAmountAccount() {
        return amountAccount;
    }


    public void setAmountAccount(double amountAccount) {
        this.amountAccount = amountAccount;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void withdraw(double amount) {
        if (amount < amountAccount) {
            setAmountAccount(amountAccount - amount);
            addNewTransaction(amount, TranceType.WITHDRAW);
        } else
            System.out.println("amount is not enough");


    }

    public void deposit(double amount) {
        this.amountAccount = amountAccount
                + amount;
        addNewTransaction(amount, TranceType.DEPOSIT);

    }


    public int calcNumberDay(){
       String date=dateToday();
        String[] splitDate = date.split(" ");
        int mon=Integer.parseInt(splitDate[1]);
        int day=0;
        if (mon >= 1 && mon <= 6)
            day=31;
         else if (mon > 6 && mon < 12)
                 day=30;
         else if (mon == 12)
           day=29;

        return day;

    }
   /* public int calcNumberMonth() {
        int numberMonth = 0;

        Date dateToday = new Date();
        SimpleDateFormat form = new SimpleDateFormat("yyyy MM dd");
        String formatDateToday = form.format(dateToday);
        String[] splitDateToday = formatDateToday.split(" ");
        String formatDate = form.format(date);
        String[] splitDate = formatDate.split(" ");

        if (splitDate[0].equals(splitDateToday[0]) && splitDate[2].equals(splitDateToday[2])) {
            numberMonth = Integer.parseInt(splitDateToday[1]) - Integer.parseInt(splitDate[1]);
        } else if (Integer.parseInt(splitDateToday[0]) > Integer.parseInt(splitDate[0]) && splitDate[2].equals(splitDateToday[2])) {
            numberMonth = (12 - Integer.parseInt(splitDate[1])) + Integer.parseInt(splitDateToday[1]);
        }

        return numberMonth;
    }*/

    public String dateToday() {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy MM dd");
        String formatDate = ft.format(date);
        return formatDate;
    }

    public void addNewTransaction(double amount, TranceType trnType) {
        transactions[indexTrance++] = new Transactions(numberAccount,dateToday(), trnType,amountAccount, amount);

    }



    public void showTrance(){
        for (int i = 0; i < indexTrance; i++) {
            System.out.println(transactions[i].toString());
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "amountAccount=" + amountAccount +
                ", numberAccount=" + numberAccount +
                ", typeAccount=" + typeAccount +
                ", date='" + date + '\'' +
                ", transactions=" +Arrays.toString(transactions) +
                '}';
    }
}
