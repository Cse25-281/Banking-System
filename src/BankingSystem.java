import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class BankingSystem {

    private static final String FILE = "data/customers.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank("Botswana Banking System");

        loadCustomers(bank);

        int choice;

        do {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Customer ID: ");
                    String id = input.nextLine();

                    System.out.print("Full Name: ");
                    String name = input.nextLine();

                    System.out.print("Phone: ");
                    String phone = input.nextLine();

                    System.out.print("Address: ");
                    String address = input.nextLine();

                    Customer customer = new Customer(id, name, phone, address);
                    bank.addCustomer(customer);
                    saveCustomers(bank);

                    System.out.println("Customer added and saved successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Customer List ---");

                    if (bank.getCustomers().isEmpty()) {
                        System.out.println("No customers found.");
                    } else {
                        for (Customer c : bank.getCustomers()) {
                            c.displayCustomer();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Customer ID to search: ");
                    String searchId = input.nextLine();

                    Customer found = bank.findCustomer(searchId);

                    if (found != null) {
                        System.out.println("Customer found:");
                        found.displayCustomer();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Banking System!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        input.close();
    }

    private static void saveCustomers(Bank bank) {
        try {
            File folder = new File("data");
            folder.mkdirs();

            PrintWriter writer = new PrintWriter(new FileWriter(FILE));

            for (Customer c : bank.getCustomers()) {
                writer.println(
                    c.getCustomerId() + "|" +
                    c.getName() + "|" +
                    c.getPhone() + "|" +
                    c.getAddress()
                );
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving customers.");
        }
    }

    private static void loadCustomers(Bank bank) {
        File file = new File(FILE);

        if (!file.exists()) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] details = line.split("\\|", -1);

                if (details.length == 4) {
                    Customer c = new Customer(
                        details[0], details[1],
                        details[2], details[3]
                    );

                    bank.addCustomer(c);
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading customers.");
        }
    }
}