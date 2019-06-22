import java.util.Scanner;

public class ATM {
    private static boolean isLoggedIn = false;

    public static void displayMenu() {
        System.out.println("0 - create user");
        System.out.println("1 - login");
        System.out.println("2 - withdraw");
        System.out.println("3 - deposit");
        System.out.println("4 - logout");
    }

    public static void main(String[] args) {
        Banking bank = new Banking();

        bank.addUser("bob",
                "1234 bobby vill",
                500,
                "12345");

        bank.addUser("bob",
                "1234 bobby vill",
                500,
                "12345");

        bank.addUser("bob",
                "1234 bobby vill",
                500,
                "12345");

        Scanner scanner = new Scanner(System.in);
        int opt = 0;

        while(opt != 4) {
            displayMenu();
            opt = scanner.nextInt();
            scanner.nextLine();

            switch(opt) {
                case 0: {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter your address: ");
                    String address = scanner.nextLine();

                    System.out.print("Money to deposit ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter your pin: ");
                    String pin = scanner.nextLine();
                    bank.addUser(name, address, amount, pin);
                } break;

                case 1: {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter your pin: ");
                    String pin = scanner.nextLine();

                    if(bank.login(name, pin)) {
                        isLoggedIn = true;
                    }
                } break;

                case 2: {
                    if(isLoggedIn) {
                        System.out.print("Withdraw amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        double result = bank.withdraw(amount);
                        if(result < 0) {
                            System.out.println("Not enough money!");
                        } else {
                            System.out.println("Withdrew $" + amount);
                        }
                    } else {
                        System.out.println("You must be logged In");
                    }
                } break;

                case 3: {
                    if(isLoggedIn) {
                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        bank.deposit(amount);
                        System.out.println("Deposited $" + amount);
                    } else {
                        System.out.println("You must be logged In");
                    }
                } break;

                case 4: {
                    bank.logout();
                    isLoggedIn = false;
                    System.out.println("Logged Out");
                } break;

                default: {
                    System.out.println(opt + " is not a valid option");
                } break;
            }

        }
    }
}
