import java.util.Scanner;

record BankInfo(String name, String branch) {
}

enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT
}

public class MiniBank {

    public static class Customer implements Cloneable {

        private String name;
        private Address address;

        public Customer(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public Address getAddress() {
            return address;
        }

        public static class Address {

            private String line;
            private String city;
            private String pincode;

            public Address(String line, String city, String pincode) {
                this.line = line;
                this.city = city;
                this.pincode = pincode;
            }

            public String getLine() {
                return line;
            }

            public String getCity() {
                return city;
            }

            public String getPincode() {
                return pincode;
            }
        }

        @Override
        public Customer clone() {
            try {
                return (Customer) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
    }

    public static class Account {

        private int accountNumber;
        private String ownerName;
        private double balance;

        public Account(int accountNumber, String ownerName, double balance) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public double getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return "Account Number: " + accountNumber +
                    ", Owner Name: " + ownerName +
                    ", Balance: " + balance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;

            if (!(o instanceof Account))
                return false;

            Account a = (Account) o;
            return accountNumber == a.accountNumber;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(accountNumber);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank", "Main Branch");


        System.out.println(bank.name());
        System.out.println(bank.branch());


        Customer.Address address = new Customer.Address(
                "12 MG Road",
                "Vadodara",
                "390001");

        Customer customer = new Customer("Margish", address);
        Customer copy = customer.clone();

        Account account1 = new Account(101, "Margish", 5000);
        Account account2 = new Account(101, "Rahul", 8000);
        Account account3 = new Account(102, "Amit", 7000);

        System.out.println("\nUsing toString()");
        System.out.println(account1);
        System.out.println(account3);

        System.out.println("\nUsing equals()");
        System.out.println("Account1 == Account2 : " + account1.equals(account2));
        System.out.println("Account1 == Account3 : " + account1.equals(account3));

        System.out.println("\nCustomer Details");
        System.out.println("Name : " + customer.getName());
        System.out.println("Address : " + customer.getAddress().getLine());
        System.out.println("City : " + customer.getAddress().getCity());
        System.out.println("Pincode : " + customer.getAddress().getPincode());

        System.out.println("\nCloned Customer");
        System.out.println("Name : " + copy.getName());

        System.out.println("\nUsing instanceof");
        if (account1 instanceof Account) {
            System.out.println("account1 is an Account object.");
        }

        if (customer instanceof Customer) {
            System.out.println("customer is a Customer object.");
        }

        int choice;

        do {
            System.out.println("\n----- MiniBank Menu -----");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            String message = switch (choice) {
                case 1 -> "Open Account - To be implemented in later lab.";
                case 2 -> "Deposit - To be implemented in later lab.";
                case 3 -> "Withdraw - To be implemented in later lab.";
                case 4 -> "Transfer - To be implemented in later lab.";
                case 5 -> "Thank you for using MiniBank.";
                default -> "Invalid Choice.";
            };

            System.out.println(message);

        } while (choice != 5);

        sc.close();
    }
}