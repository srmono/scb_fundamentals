# Console Based App with h2 db

## 1️⃣ What we are changing

Right now:

* Your app stores customers in a `List<Customer>` in memory.
* When the app closes, data is lost.

After change:

* We’ll use **H2 Database** (lightweight, no server needed).
* Customers will be stored permanently in a `.mv.db` file in your project folder.
* We’ll **replace the ArrayList logic with JDBC database code**.

---

## 2️⃣ Prepare the H2 setup (No Maven)

### Step 1: Download H2

* Go to: [https://h2database.com/html/download.html](https://h2database.com/html/download.html)
* Download the latest **Platform-independent zip**.
* Extract it somewhere, e.g. `C:\h2db`.
* Inside you’ll see `h2-2.x.x.jar` — that’s our JDBC driver.

### Step 2: Add H2 jar to IntelliJ

* IntelliJ → **File** → **Project Structure** → **Modules** → **Dependencies** → **+** → *JARs or Directories* → select `h2-2.x.x.jar` from your folder.
* Click **OK**.

---

## 3️⃣ New Database Helper

We’ll make a helper class `DbUtil` that:

* Connects to the database.
* Creates the `CUSTOMER` table if it doesn’t exist.

**DbUtil.java**

```java
package customerdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
    // Database file will be saved inside ./data/bankdb.mv.db
    private static final String URL = "jdbc:h2:file:./data/bankdb;AUTO_SERVER=TRUE";
    private static final String USER = "sa"; // default user
    private static final String PASS = "";   // default password

    // Get a connection to H2 database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Create CUSTOMER table if not exists
    public static void initDatabase() {
        String sql = """
            CREATE TABLE IF NOT EXISTS CUSTOMER (
                CUSTOMER_ID INT PRIMARY KEY,
                NAME VARCHAR(50),
                EMAIL VARCHAR(100),
                CONTACT VARCHAR(15),
                ACCOUNT_TYPE VARCHAR(20)
            );
            """;
        try (Connection con = getConnection();
             Statement st = con.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 4️⃣ Database DAO (Data Access Object)

Instead of storing customers in `List`, we’ll use SQL queries.


**InvalidInputException.java**

```java
package customerdemo;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

```

**Customer.java**

```java
package customerdemo;

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

**CustomerDao.java**

```java
package customerdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    // Insert a new customer
    public void addCustomer(Customer c) {
        String sql = "INSERT INTO CUSTOMER (CUSTOMER_ID, NAME, EMAIL, CONTACT, ACCOUNT_TYPE) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getCustomerId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getContact());
            ps.setString(5, c.getAccountType());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMER";
        try (Connection con = DbUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("CUSTOMER_ID"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL"),
                        rs.getString("CONTACT"),
                        rs.getString("ACCOUNT_TYPE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Search by ID
    public Customer findById(int id) {
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                            rs.getInt("CUSTOMER_ID"),
                            rs.getString("NAME"),
                            rs.getString("EMAIL"),
                            rs.getString("CONTACT"),
                            rs.getString("ACCOUNT_TYPE")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // not found
    }

    // Delete customer
    public boolean deleteCustomer(int id) {
        String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
```

---

## 5️⃣ Updated Main Application

Now we **remove the ArrayList** from `BankApp` and use `CustomerDao` instead.

**BankApp.java**

```java
package customerdemo;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankApp {
    private static final Random random = new Random();
    private static final CustomerDao dao = new CustomerDao();

    public static void main(String[] args) {
        // Create DB & table if not exist
        DbUtil.initDatabase();

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
                case 1 -> addCustomer(sc);
                case 2 -> displayCustomers();
                case 3 -> searchCustomer(sc);
                case 4 -> deleteCustomer(sc);
                case 5 -> {
                    System.out.println("Exiting application...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addCustomer(Scanner sc) {
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            if (!name.matches("[a-zA-Z]+"))
                throw new InvalidInputException("Name must contain only alphabets.");

            System.out.print("Enter email: ");
            String email = sc.nextLine();
            if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email))
                throw new InvalidInputException("Invalid email format.");

            System.out.print("Enter contact (10 digits): ");
            String contact = sc.nextLine();
            if (!contact.matches("\\d{10}"))
                throw new InvalidInputException("Contact must be exactly 10 digits.");

            System.out.print("Enter account type (Savings/Current): ");
            String accountType = sc.nextLine();
            if (!(accountType.equalsIgnoreCase("Savings") || accountType.equalsIgnoreCase("Current")))
                throw new InvalidInputException("Account type must be Savings or Current.");

            int id = random.nextInt(9000) + 1000; // random 4-digit ID
            dao.addCustomer(new Customer(id, name, email, contact, accountType));

            System.out.println("Customer added successfully with ID: " + id);

        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayCustomers() {
        List<Customer> list = dao.getAllCustomers();
        if (list.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            list.forEach(System.out::println);
        }
    }

    private static void searchCustomer(Scanner sc) {
        System.out.print("Enter customer ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();
        Customer c = dao.findById(id);
        if (c != null) {
            System.out.println(c);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void deleteCustomer(Scanner sc) {
        System.out.print("Enter customer ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (dao.deleteCustomer(id)) {
            System.out.println("Deleted customer with ID: " + id);
        } else {
            System.out.println("Customer not found.");
        }
    }
}
```

---

## 6️⃣ How it works now

1. **When the program starts**:

   * `DbUtil.initDatabase()` creates the table if it doesn’t exist.

2. **When you add a customer**:

   * Data is inserted into H2 DB, not in a List.

3. **When you display/search/delete**:

   * SQL queries run to get/update/delete data from the DB.

4. **Data persists**:

   * Even if you close the program, records stay in the `./data/bankdb.mv.db` file.

