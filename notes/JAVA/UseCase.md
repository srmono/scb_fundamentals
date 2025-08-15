### Updated `BankApp.java` with Exception Handling

```java
import java.util.*;

public class BankApp {
    static List<Customer> customers = new ArrayList<>();
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                // Menu
                System.out.println("\nWelcome to Standard Chartered Bank");
                System.out.println("Please enter your choice");
                System.out.println("1 for Add new Customer");
                System.out.println("2 for Display Customers");
                System.out.println("3 for Search Customer");
                System.out.println("4 for Delete Customer");
                System.out.println("5 for Exit the bank application");

                int choice = Integer.parseInt(sc.nextLine()); // safer than nextInt()

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
                        System.out.println("Exiting application...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number from the menu.");
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }

    static void addCustomer(Scanner sc) {
        try {
            System.out.println("Please enter customer details :");

            // Name
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            if (!name.matches("[a-zA-Z]+")) {
                System.out.println("Invalid name! Only alphabets allowed.");
                return;
            }

            // Email
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                System.out.println("Invalid email format!");
                return;
            }

            // Contact
            System.out.print("Enter contact: ");
            String contact = sc.nextLine();
            if (!contact.matches("\\d{10}")) {
                System.out.println("Invalid contact! Must be exactly 10 digits.");
                return;
            }

            // Account type
            System.out.print("Enter account type (Savings or Current): ");
            String accountType = sc.nextLine();
            if (!(accountType.equalsIgnoreCase("Savings") || accountType.equalsIgnoreCase("Current"))) {
                System.out.println("Invalid account type!");
                return;
            }

            // Auto-generate customer ID
            int customerId = 1000 + random.nextInt(9000);

            // Add to list
            customers.add(new Customer(customerId, name, email, contact, accountType));
            System.out.println("Customer added successfully with customer id " + customerId);

        } catch (Exception e) {
            System.out.println("Error while adding customer: " + e.getMessage());
        }
    }

    static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers to display.");
            return;
        }
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    static void searchCustomer(Scanner sc) {
        try {
            System.out.print("Please enter customer id: ");
            int id = Integer.parseInt(sc.nextLine());
            for (Customer c : customers) {
                if (c.customerId == id) {
                    System.out.println(c);
                    return;
                }
            }
            System.out.println("Customer with id " + id + " not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID! Please enter a number.");
        }
    }

    static void deleteCustomer(Scanner sc) {
        try {
            System.out.print("Please enter customer id to be deleted: ");
            int id = Integer.parseInt(sc.nextLine());
            Iterator<Customer> it = customers.iterator();
            while (it.hasNext()) {
                Customer c = it.next();
                if (c.customerId == id) {
                    it.remove();
                    System.out.println("Deleted customer with id = " + id);
                    return;
                }
            }
            System.out.println("Customer with id " + id + " not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID! Please enter a number.");
        }
    }
}
```

---

### What’s New

* **No `nextInt()`** — replaced with `Integer.parseInt(sc.nextLine())` so it won’t get stuck if the user types non-numbers.
* **Try–catch blocks**:

  * Around **main menu** → handles invalid menu input.
  * Around **search & delete** → catches invalid ID input.
  * Around **addCustomer** → handles unexpected errors.
* **User-friendly error messages** instead of crash stack traces.

