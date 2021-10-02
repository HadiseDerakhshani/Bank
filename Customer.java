package bank;

public class Customer {
    private String name;
    private String family;
    private int id;
    private double amount;
    private static int indexAccount = 0;
    private Account[] accounts = new Account[20];

    public Customer() {
    }
    /*
    public Customer() {
        for (int i = 0; i < 20; i++)
            accounts[i] = new Account();
    }*/



    public Customer(String name, String family, int id) {
        this.name = name;
        this.family = family;
        this.id = id;
    }

    public void addAccount(int choice, int idCustomer, double amount,String date) {
        switch (choice) {
            case 1:
                accounts[indexAccount] = new CheckingAccount(amount,idCustomer,AccountType.CHECKING,date);
                indexAccount++;
                break;
            case 2:

                accounts[indexAccount] = new SavingAccount(amount,idCustomer,AccountType.SAVING,date);
                indexAccount++;
                break;
            case 3:
                accounts[indexAccount] = new LoanAccount(amount,idCustomer,AccountType.LOAN,date);
                indexAccount++;
                break;
        }
    }

    public static int getIndexAccount() {
        return indexAccount;
    }

    public static void setIndexAccount(int indexAccount) {
        Customer.indexAccount = indexAccount;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public Account findAccount(int numberAccount) {
        for (int i = 0; i < indexAccount; i++) {
            if (accounts[i].getNumberAccount()==numberAccount){
                return accounts[i];
            }
        }
        return null;
    }

}
