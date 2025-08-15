##  Bank App Customer Console App

* **OOP** principles (`Customer` class)
* **Collections** (`ArrayList`)
* **StringBuffer** for building output efficiently
* **Exception handling** for safe inputs
* **Validations** (name, email, contact, account type)
* **Menu-driven program**

You can just **copy-paste this into `BankApp.java`** and run directly.

---

## **BankApp.java**

```java
import java.util.*;
import java.util.regex.*;

class Customer {
    private int customerId;
    private String name;
    private String email;
    private String contact;
    private String accountType;

    public Customer(int customerId, String name, String email, String contact, String accountType) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.accountType = accountType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return "Customer Id = " + customerId +
               ", Name = " + name +
               ", Email = " + email +
               ", Contact = " + contact +
               ", Account Type = " + accountType;
    }
}

public class BankApp {
    private static List<Customer> customers = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            printMenu();
            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addCustomer(sc);
                        break;
                    case 2:
                        displayCustomers();
                        break;
                    case 3:
                        searchCustomer(sc);
                        break;
                    case 4:
                        deleteCustomer(sc);
                        break;
                    case 5:
                        System.out.println("Exiting application. Goodbye!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nWelcome to Standard Chartered Bank");
        System.out.println("Please enter your choice:");
        System.out.println("1 - Add New Customer");
        System.out.println("2 - Display Customers");
        System.out.println("3 - Search Customer");
        System.out.println("4 - Delete Customer");
        System.out.println("5 - Exit");
        System.out.print("Choice: ");
    }

    private static void addCustomer(Scanner sc) {
        try {
            System.out.println("Enter customer details:");

            System.out.print("Name: ");
            String name = sc.nextLine();
            if (!name.matches("[a-zA-Z ]+")) {
                throw new IllegalArgumentException("Invalid name. Only alphabets allowed.");
            }

            System.out.print("Email: ");
            String email = sc.nextLine();
            if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
                throw new IllegalArgumentException("Invalid email format.");
            }

            System.out.print("Contact (10 digits): ");
            String contact = sc.nextLine();
            if (!contact.matches("\\d{10}")) {
                throw new IllegalArgumentException("Invalid contact number. Must be 10 digits.");
            }

            System.out.print("Account type (Savings or Current): ");
            String accountType = sc.nextLine();
            if (!(accountType.equalsIgnoreCase("Savings") || accountType.equalsIgnoreCase("Current"))) {
                throw new IllegalArgumentException("Invalid account type. Must be Savings or Current.");
            }

            int customerId = 1000 + random.nextInt(9000); // Auto-generate ID
            customers.add(new Customer(customerId, name, email, contact, accountType));
            System.out.println("Customer added successfully with ID: " + customerId);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        StringBuffer sb = new StringBuffer();
        for (Customer c : customers) {
            sb.append(c.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void searchCustomer(Scanner sc) {
        try {
            System.out.print("Enter customer ID to search: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Customer c : customers) {
                if (c.getCustomerId() == id) {
                    StringBuffer sb = new StringBuffer();
                    sb.append("Customer Found:\n")
                      .append("ID: ").append(c.getCustomerId()).append("\n")
                      .append("Name: ").append(c.getName()).append("\n")
                      .append("Email: ").append(c.getEmail()).append("\n")
                      .append("Contact: ").append(c.getContact()).append("\n")
                      .append("Account Type: ").append(c.getAccountType());
                    System.out.println(sb.toString());
                    return;
                }
            }
            System.out.println("Customer not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric customer ID.");
        }
    }

    private static void deleteCustomer(Scanner sc) {
        try {
            System.out.print("Enter customer ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());

            Iterator<Customer> iterator = customers.iterator();
            while (iterator.hasNext()) {
                Customer c = iterator.next();
                if (c.getCustomerId() == id) {
                    iterator.remove();
                    System.out.println("Deleted customer with ID: " + id);
                    return;
                }
            }
            System.out.println("Customer not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric customer ID.");
        }
    }
}
```

---

### **How this works**

* **OOP**: `Customer` is a model class with private fields and getters.
* **Collections**: `ArrayList<Customer>` stores all customers.
* **StringBuffer**: Used in `displayCustomers()` and `searchCustomer()` to efficiently build output.
* **Validations**: Regex patterns check for valid name, email, contact, and account type.
* **Exception Handling**: Prevents crashes from invalid input.
* **Menu Driven**: Runs in a loop until the user chooses exit.

---

### **Run Instructions**

```bash
javac BankApp.java
java BankApp
```

