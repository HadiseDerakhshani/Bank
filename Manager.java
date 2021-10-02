package bank;

public class Manager {
    private static int indexCustomer = 0;
    Customer[] customers = new Customer[100];

    public Manager() {
    }
    /* public Manager() {
        for (int i = 0; i < 100; i++)
            customers[i] = new Customer();
    }
*/


    public int addCustomer(String name, String family, int id) {
        int idCustomer=0;
        if (indexCustomer > 0) {
            for (int i = 0; i < indexCustomer; i++)
                if (customers[i].getName().equals(name) && customers[i].getFamily().equals(family)) {
                           idCustomer=customers[i].getId();
                } else {
                    customers[indexCustomer] = new Customer(name, family, id);
                    idCustomer = id;
                    indexCustomer++;
                    System.out.println(indexCustomer);
                }
        } else {
            customers[indexCustomer] = new Customer(name, family, id);
             idCustomer = id;
            indexCustomer++;
            System.out.println(indexCustomer);

        }
        return idCustomer;
    }
    public static void setIndexCustomer(int indexCustomer) {
        Manager.indexCustomer = indexCustomer;
    }

    public static int getIndexCustomer() {
        return indexCustomer;
    }

    public boolean search(int idCustomer) {
        boolean checkExisting = true;
        if (customers[indexCustomer].getId() == idCustomer)
            checkExisting = false;


        return checkExisting;
    }
    public void addAccount(int choice, int idCustomer,double amount,String date) {
        for (int i = 0; i < indexCustomer; i++) {
            if (customers[i].getId() == idCustomer)
                customers[i].addAccount(choice, idCustomer, amount,date);
        }
    }
    public void viewTrance(int numberAccount){
        for (int i = 0; i < indexCustomer; i++) {
           Account account=customers[i].findAccount(numberAccount);
           if (account!=null){
           //    System.out.println(Arrays.toString(account.getTransactions()));
               account.showTrance();
           }
        }
    }

public void viewAccounts(String name,String family){
    System.out.println(customers[0].getName());
    for (int i = 0; i < indexCustomer; i++) {
       if (customers[i].getName().equals(name) && customers[i].getFamily().equals(family)){
           int numberAccount=customers[i].getId();
       Account account=customers[i].findAccount(numberAccount);
      if (account!=null) {
          System.out.println(account.toString());
          account.showTrance();
        }
        }
    }
}

   public void calcInterest(int choice,int numberAccount) {
        choice+=1;
       for (int i = 0; i < indexCustomer; i++) {
           Account account = customers[i].findAccount(numberAccount);
           if (account != null) {
             if (choice==AccountType.SAVING.getAccountType() && account instanceof SavingAccount){
                 SavingAccount savingAccount = (SavingAccount) account;
                 savingAccount.calcMonthlyProfit();
             }else
             if (choice==AccountType.LOAN.getAccountType() && account instanceof LoanAccount){
                 LoanAccount loanAccount = (LoanAccount) account;
             }

           }
       }

   }
public void withdraw(int numberAccount,double amount) {
    for (int i = 0; i < indexCustomer; i++) {
        Account account = customers[i].findAccount(numberAccount);
        if (account != null) {
               account.withdraw(amount);
        }
    }
}

    public void deposit(int numberAccount,double amount) {
        for (int i = 0; i < indexCustomer; i++) {
            Account account = customers[i].findAccount(numberAccount);
            if (account != null) {
                    account.deposit(amount);
            }
        }
    }

}
