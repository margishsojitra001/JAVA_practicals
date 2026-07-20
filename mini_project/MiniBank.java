import java.util.Scanner;

record BankInfo(String name, String branch) {}

enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT
}

public class MiniBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("Mini Bank", "Main Branch");

        System.out.println(bank.name());
        System.out.println(bank.branch());

        boolean run = true;

        while (run) {

            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Open Account - To be implemented later.");
                case 2 -> System.out.println("Deposit - To be implemented later.");
                case 3 -> System.out.println("Withdraw - To be implemented later.");
                case 4 -> System.out.println("Transfer - To be implemented later.");
                case 5 -> {
                    System.out.println("Goodbye!");
                    run = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}