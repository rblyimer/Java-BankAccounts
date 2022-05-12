import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain {
    public static int input;
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public static void main(String[] args) {
        bankAccounts.add(new BankAccount("Matt", 3000, 0));
        bankAccounts.add(new BankAccount("Julian", 4000, 1));
        bankAccounts.add(new BankAccount("Hector", 5000, 2));
        System.out.println("Hello world! Welcome to the bank of Matt!");
        System.out.println("Are you an existing customer? (-1 exit)");
        System.out.println("1. Yes");
        System.out.println("2. No");

        while (true) {
            try {
                input = Integer.parseInt(in.nextLine());
                if (input != 1 &&
                        input != 2 &&
                        input != -1) {
                    System.out.println("invalid input: Please only enter '1' for Yes, '2' for No, or '-1' to exit.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("invalid input: Please only enter '1' for Yes, '2' for No, or '-1' to exit.");
            }
        }
        if (input == 1) {
            System.out.println("Great, What is your account number?");
            double accountNum;
            accountNum = Integer.parseInt(in.nextLine());
            if (accountNum < 0 ||
                    accountNum > bankAccounts.size() - 1) {
                System.out.println("Sorry, we couldn't find your account number.");
            } else {
                mainMenu(bankAccounts.get((int) accountNum));
            }

        } else if (input == 2) {
            System.out.println("Let's make a new account!");
            BankAccount newAcc = new BankAccount();

            bankAccounts.add(newAcc);
            newAcc.setAccNumber(bankAccounts.size() - 1);

            System.out.println("What is the name for the account?");
            newAcc.setName(in.nextLine());

            System.out.println("What is the beginning balance for the account?");
            newAcc.setBalance(Integer.parseInt(in.nextLine()));
            mainMenu(newAcc);
        }
    }

    public static void mainMenu(BankAccount menu) {
        boolean dataBase = true;
        System.out.println("Hello " + menu.getName());
        System.out.println("Welcome to the Main Menu, what would you like to do today?");
        while (dataBase) {
            System.out.println("1. To check account balance");
            System.out.println("2. To make a withdraw");
            System.out.println("3. To make a deposit");
            System.out.println("4. To make a transfer to another account");
            System.out.println("0. To exit");
            while (true) {
                try {
                    input = Integer.parseInt(in.nextLine());
                    if (input != 1 &&
                            input != 2 &&
                            input != 3 &&
                            input != 4 &&
                            input != 0) {
                        System.out.println("invalid input: please try again ");
                    } else if (input == 0) {
                        dataBase = false;
                        break;
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("invalid input: please try again ");
                }
            }
            switch (input) {
                case 1:
                    System.out.println("The name on the account is: " + menu.getName() + " and they have a balance of $"
                            + menu.getBalance());
                    break;
                case 2:
                    System.out.println("Please enter the amount to withdraw?");
                    double withdrawalAmt;
                    while (true) {
                        try {
                            withdrawalAmt = Integer.parseInt(in.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("invalid input: please try again");
                        }
                    }
                    menu.withdrawal(withdrawalAmt);
                    System.out.println("You have successfully withdrawn $" + withdrawalAmt + ", your new balance is: $"
                            + menu.getBalance());
                    break;
                case 3:
                    System.out.println("Please enter the amount to deposit");
                    double depositAmt;
                    while (true) {
                        try {
                            depositAmt = Integer.parseInt(in.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("invalid input: please try again");
                        }
                    }
                    menu.deposit(depositAmt);
                    System.out.println("You have successfully Deposited $" + depositAmt + ", your new balance is: $"
                            + menu.getBalance());
                    break;
                case 4:
                    System.out.println("Please enter the account number to transfer to:");
                    int accountNum;
                    double transferAmt;
                    while (true) {
                        try {
                            accountNum = Integer.parseInt(in.nextLine());
                            if (accountNum < 0 || accountNum > bankAccounts.size() - 1) {
                                System.out.println("Account doesn't exist");
                                break;
                            }
                            System.out.println("Please enter the amount to transfer");
                            while (true) {
                                try {
                                    transferAmt = Double.parseDouble(in.nextLine());
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Please try again");
                                }
                            }
                            menu.transfer(bankAccounts.get(accountNum), transferAmt);
                            System.out.println("The name on the account is: " + bankAccounts.get(accountNum).getName()
                                    + " and they have a new balance of $" + bankAccounts.get(accountNum).getBalance());
                            break;
                        } catch (Exception e) {
                            System.out.println("Please try again");
                        }
                    }
                case 0:
                    break;
            }
        }
    }

}