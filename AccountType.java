package bank;

public enum AccountType {
    CHECKING(1),
    SAVING(2),
    LOAN(3);
    private  int accountType;

    AccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getAccountType() {
        return accountType;
    }
}
