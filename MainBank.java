package bank;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class MainBank {
  public static   Manager manager = new Manager();
    public static void main(String[] args) {

        mainMnu();

    }

    public static void mainMnu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("what do you do ? \n1. Add new account " +
                " \n 2. View accounts   \n3. Withdraw   \n 4. Deposit  " +
                " \n 5. Calculate interests \n 6. View Transactions \n 7. Exit ");
        String input = scanner.next();
        if (isNumber(input)) {
            int choice = Integer.parseInt(input);
            selectItem(choice);
        }


    }

    public static boolean isNumber(String choice) {
        for (int i = 0; i < choice.length(); i++) {
            if (!Character.isDigit(choice.charAt(i))) {
                return false;
            }
        }
        return true;

    }

    public static void selectItem(int choice) {
        Scanner scanner = new Scanner(System.in);
       // Manager manager = new Manager();
        Random random = new Random();
        String dateToday;
        dateToday = calcDate();
        int idCustomer;
        switch (choice) {
            case 1:
                int rand = 100000 + random.nextInt(900000);
                System.out.println("enter name & family  of customer  :");
               idCustomer=manager.addCustomer(scanner.next(), scanner.next(), rand);
                System.out.println(rand);
               if (idCustomer==0)
                   System.out.println("There is customer");
                System.out.println("select account for open \n1.Checking Account \n2.Saving Account \n3.Loan Account");
                choice = scanner.nextInt();
                System.out.println("amount for open account :");
                manager.addAccount(choice,rand, (double) scanner.nextLong(), dateToday);
                mainMnu();
                break;
            case 2:
                System.out.println("enter name & family of customer:");
                manager.viewAccounts(scanner.next(), scanner.next());
                mainMnu();
                break;
            case 3:
                System.out.println("enter ID Account & amount for Withdraw : ");
                manager.withdraw(scanner.nextInt(), (double) scanner.nextLong());
                mainMnu();
                break;
            case 4:
                System.out.println("enter ID Account & amount for Deposit : ");
                manager.deposit(scanner.nextInt(), (double) scanner.nextLong());
                mainMnu();
                break;
            case 5:
                System.out.println("enter ID Account : ");
                idCustomer = scanner.nextInt();
                System.out.println("which Account \n1.Saving Account   2.Loan Account");
                manager.calcInterest(scanner.nextInt(), idCustomer);
                mainMnu();
                break;
            case 6:
                System.out.println("enter ID Account : ");
                manager.viewTrance(scanner.nextInt());
                mainMnu();
                break;
            case 7:
                break;

        }

    }

    public static String calcDate() {
        Date date = new Date();
        SimpleDateFormat form = new SimpleDateFormat("yyyy MM dd");
        String formatDate = form.format(date);
        return formatDate;
    }
}
