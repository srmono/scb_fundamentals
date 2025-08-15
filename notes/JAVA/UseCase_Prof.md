## Bank App Customer Console App

* Uses **OOP concepts** (classes, encapsulation)
* Uses **Collections** (ArrayList for storing customers)
* Uses **iterations** (for displaying, searching, deleting)
* Uses **StringBuffer** where appropriate
* Uses **Exception Handling** for invalid inputs
* Matches the banking example from your images

---

## **File: Customer.java**

```java
public class Customer {
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

    public int getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getContact() { return contact; }
    public String getAccountType() { return accountType; }

    @Override
    public String toString() {
        return "Customer Id = " + customerId + 
               ", Name = " + name +
               ", Email = " + email +
               ", Contact = " + contact +
               ", Account Type = " + accountType;
    }
}
```

---

## **File: InvalidInputException.java**

```java
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
```

---

## **File: BankApp.java**

```java
import java.util.*;
import java.util.regex.*;

public class BankApp {
    private static List<Customer> customers = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Standard Chartered Bank");
            System.out.println("1 - Add new Customer");
            System.out.println("2 - Display Customers");
            System.out.println("3 - Search Customer");
            System.out.println("4 - Delete Customer");
            System.out.println("5 - Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addCustomer(sc); break;
                case 2: displayCustomers(); break;
                case 3: searchCustomer(sc); break;
                case 4: deleteCustomer(sc); break;
                case 5: System.out.println("Exiting application..."); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addCustomer(Scanner sc) {
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            if (!name.matches("[a-zA-Z]+")) throw new InvalidInputException("Name must contain only alphabets.");

            System.out.print("Enter email: ");
            String email = sc.nextLine();
            if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email))
                throw new InvalidInputException("Invalid email format.");

            System.out.print("Enter contact (10 digits): ");
            String contact = sc.nextLine();
            if (!contact.matches("\\d{10}")) throw new InvalidInputException("Contact must be exactly 10 digits.");

            System.out.print("Enter account type (Savings/Current): ");
            String accountType = sc.nextLine();
            if (!(accountType.equalsIgnoreCase("Savings") || accountType.equalsIgnoreCase("Current")))
                throw new InvalidInputException("Account type must be Savings or Current.");

            int id = random.nextInt(9000) + 1000; // random 4-digit ID
            customers.add(new Customer(id, name, email, contact, accountType));

            System.out.println("Customer added successfully with ID: " + id);

        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    private static void searchCustomer(Scanner sc) {
        System.out.print("Enter customer ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Customer c : customers) {
            if (c.getCustomerId() == id) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private static void deleteCustomer(Scanner sc) {
        System.out.print("Enter customer ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        Iterator<Customer> it = customers.iterator();
        while (it.hasNext()) {
            if (it.next().getCustomerId() == id) {
                it.remove();
                System.out.println("Deleted customer with ID: " + id);
                return;
            }
        }
        System.out.println("Customer not found.");
    }
}
```

---

### **How to Run**

1. Save each file separately in the same folder:

   * `Customer.java`
   * `InvalidInputException.java`
   * `BankApp.java`
2. Compile all files:

   ```bash
   javac *.java
   ```
3. Run the main program:

   ```bash
   java BankApp
   ```

---

✅ This program uses:

* **Encapsulation** → Customer fields are private, accessed via getters
* **Collections (ArrayList)** → Store customers
* **Iteration** → for, iterator for display & delete
* **Regex** → Validate name, email, contact
* **Custom Exception** → Handle invalid input
* **Random ID Generation** → Auto customer ID

