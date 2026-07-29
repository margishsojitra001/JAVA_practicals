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

    public static class Customer {
        private String name;
        private String email;
        private String mobile;
        private final String customerId;

        private static long customerCounter = 101;

        private static String generateCustomerId() {
            return "CUST" + customerCounter++;
        }

        public Customer(String name, String email, String mobile) {
            this.name = name;
            this.email = email;
            this.mobile = mobile;
            this.customerId = generateCustomerId();
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getMobile() {
            return mobile;
        }

        public String getCustomerId() {
            return customerId;
        }
    }

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