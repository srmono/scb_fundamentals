Let's go learn **JDBC fundamentals** 

---

## **1. What is JDBC?**

**JDBC** (Java Database Connectivity) is a Java API that allows Java applications to connect and interact with relational databases (like MySQL, PostgreSQL, Oracle, SQL Server).
It’s part of the Java Standard Edition (java.sql package).

---

## **2. JDBC Architecture**

JDBC follows a **two-tier architecture**:

1. **Java Application Layer** – Your Java program that issues SQL commands.
2. **JDBC Driver Layer** – Translates Java calls into database-specific calls.

It uses **DriverManager** or **DataSource** to manage connections.

---

## **3. JDBC Components**

Core JDBC packages:

* **`java.sql`** – Main JDBC classes/interfaces.
* **`javax.sql`** – Optional extension for advanced features like connection pooling.

---

### **Key Interfaces**

1. **Driver** – Implemented by database vendors (e.g., MySQL’s `com.mysql.cj.jdbc.Driver`).
2. **Connection** – Represents a database connection.
3. **Statement** – Executes SQL queries.
4. **PreparedStatement** – Precompiled SQL statement (avoids SQL injection).
5. **CallableStatement** – Calls stored procedures.
6. **ResultSet** – Holds the results of a query.
7. **ResultSetMetaData** – Info about columns in a `ResultSet`.
8. **DatabaseMetaData** – Info about the database itself.

---

## **4. JDBC Workflow**

**Typical Steps to Connect and Query:**

1. **Load the Driver** (optional in JDBC 4.0+, as it's auto-loaded if on classpath)

   ```java
   Class.forName("com.mysql.cj.jdbc.Driver");
   ```

2. **Establish Connection**

   ```java
   Connection con = DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/dbname", "user", "password"
   );
   ```

3. **Create Statement**

   ```java
   Statement stmt = con.createStatement();
   ```

4. **Execute Query**

   ```java
   ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
   ```

5. **Process Results**

   ```java
   while (rs.next()) {
       System.out.println(rs.getString("name"));
   }
   ```

6. **Close Resources**

   ```java
   rs.close();
   stmt.close();
   con.close();
   ```

---

## **5. Types of JDBC Statements**

1. **Statement** – Static SQL queries.
2. **PreparedStatement** – Parameterized queries, faster & safer.
3. **CallableStatement** – Executes stored procedures.

---

## **6. ResultSet Types**

* **TYPE\_FORWARD\_ONLY** – Move only forward.
* **TYPE\_SCROLL\_INSENSITIVE** – Scrollable but not updated with DB changes.
* **TYPE\_SCROLL\_SENSITIVE** – Scrollable and reflects DB changes.

**Concurrency Modes**:

* **CONCUR\_READ\_ONLY** – Read-only.
* **CONCUR\_UPDATABLE** – Allows updates.

---

## **7. JDBC Driver Types**

1. **Type 1** – JDBC-ODBC Bridge (obsolete).
2. **Type 2** – Native API, partly Java, partly native code.
3. **Type 3** – Network Protocol driver.
4. **Type 4** – Pure Java driver (most common today).

---

## **8. Transactions in JDBC**

JDBC supports transactions with `Connection` methods:

```java
con.setAutoCommit(false); // Start transaction
// execute SQL statements
con.commit(); // Commit changes
con.rollback(); // Rollback on error
```

---

## **9. Batch Processing**

Execute multiple SQL statements together:

```java
PreparedStatement ps = con.prepareStatement("INSERT INTO employees VALUES (?, ?)");
ps.setInt(1, 1);
ps.setString(2, "John");
ps.addBatch();

ps.setInt(1, 2);
ps.setString(2, "Jane");
ps.addBatch();

ps.executeBatch();
```

---

## **10. Connection Pooling**

Instead of creating a new DB connection every time (which is expensive), pooling reuses existing connections using libraries like **HikariCP**, **C3P0**, or `javax.sql.DataSource`.

---

## **11. Handling Exceptions**

Most JDBC operations throw **`SQLException`**.
Always log errors and close resources in a **finally block** or use **try-with-resources**:

```java
try (Connection con = DriverManager.getConnection(...);
     Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT ...")) {
    // process
} catch (SQLException e) {
    e.printStackTrace();
}
```

---

## **12. Best Practices**

* Use **PreparedStatement** to avoid SQL injection.
* Always **close resources** in the reverse order you opened them.
* Use **connection pooling** in production.
* Keep transactions **short**.
* Log SQL exceptions with **error codes and SQL states**.

