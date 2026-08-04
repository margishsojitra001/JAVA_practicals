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

    public static class Account {
        private final String accountNumber;
        private String ownerName;
        private long balance;
        private boolean active;

        private static long accountCounter = 1;

        private static String generateAccountNumber() {
            return String.format("AC%04d", accountCounter++);
        }

        public Account(String ownerName, long balance) {
            this.accountNumber = generateAccountNumber();
            this.ownerName = ownerName;
            this.balance = balance;
            this.active = true;
        }

        public Account(String ownerName) {
            this(ownerName, 0);
        }

        public void deposit(long amount) {
            balance += amount;
        }

        public boolean withdraw(long amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public long getBalance() {
            return balance;
        }

        public boolean isActive() {
            return active;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("Mini Bank", "Main Branch");

        System.out.println(bank.name());
        System.out.println(bank.branch());

        Account[] accounts = new Account[3];

        accounts[0] = new Account("Margish", 1000);
        accounts[1] = new Account("Rahul", 500);
        accounts[2] = new Account("Priya");

        accounts[0].deposit(500);
        accounts[0].withdraw(300);

        accounts[1].deposit(1000);
        accounts[1].withdraw(2000);

        accounts[2].deposit(700);
        accounts[2].withdraw(200);

        System.out.println("\nAccount Details:");

        for (Account account : accounts) {
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Owner Name     : " + account.getOwnerName());
            System.out.println("Balance        : ₹" + account.getBalance());
            System.out.println("Active         : " + account.isActive());
            System.out.println();
        }

        boolean run = true;

        while (run) {

            System.out.println("1. Open Account");
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