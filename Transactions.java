package bank;

public class Transactions {
    private int numberAccount;
    private String date;
    private TranceType type;
  private double balance;
    private double amount;

    public Transactions(int numberAccount, String date, TranceType type, double balance, double amount) {
        this.numberAccount = numberAccount;
        this.date = date;
        this.type = type;
        this.balance = balance;
        this.amount = amount;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public TranceType getType() {
        return type;
    }

    public void setType(TranceType type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public Transactions() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "numberAccount=" + numberAccount +
                ", date='" + date + '\'' +
                ", type=" + type +
                ", balance=" + balance +
                ", amount=" + amount +
                '}';
    }
}
