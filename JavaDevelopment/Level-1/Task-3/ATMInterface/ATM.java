import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private Bank bank;
    private ArrayList<Transaction> history = new ArrayList<>();

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);
        Account acc = bank.getAccount();

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("Enter User ID: ");
            String id = sc.next();

            System.out.print("Enter PIN: ");
            String pin = sc.next();

            if (id.equals(acc.getUserId()) && pin.equals(acc.getPin())) {

                int choice;

                do {

                    System.out.println("\n===== ATM MENU =====");
                    System.out.println("1. Transaction History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");

                    System.out.print("Enter Choice: ");
                    choice = sc.nextInt();

                    switch (choice) {

                    case 1:

                        if (history.isEmpty()) {
                            System.out.println("No Transactions.");
                        } else {
                            for (Transaction t : history) {
                                System.out.println(t.getDetails());
                            }
                        }
                        break;

                    case 2:

                        System.out.print("Enter Amount: ");
                        double w = sc.nextDouble();

                        if (acc.withdraw(w)) {
                            history.add(new Transaction("Withdraw : " + w));
                            System.out.println("Withdraw Successful");
                            System.out.println("Balance : " + acc.getBalance());
                        } else {
                            System.out.println("Insufficient Funds");
                        }

                        break;

                    case 3:

                        System.out.print("Enter Amount: ");
                        double d = sc.nextDouble();

                        acc.deposit(d);
                        history.add(new Transaction("Deposit : " + d));

                        System.out.println("Deposit Successful");
                        System.out.println("Balance : " + acc.getBalance());

                        break;

                    case 4:

                        System.out.print("Enter Receiver Account ID: ");
                        sc.next();

                        System.out.print("Enter Amount: ");
                        double t = sc.nextDouble();

                        if (acc.withdraw(t)) {
                            history.add(new Transaction("Transfer : " + t));
                            System.out.println("Transfer Successful");
                            System.out.println("Balance : " + acc.getBalance());
                        } else {
                            System.out.println("Insufficient Funds");
                        }

                        break;

                    case 5:

                        System.out.println("Thank You!");
                        break;

                    default:

                        System.out.println("Invalid Choice");
                    }

                } while (choice != 5);

                return;
            } else {
                attempts++;
                System.out.println("Invalid User ID or PIN");
            }
        }

        System.out.println("Access Denied");
    }
}