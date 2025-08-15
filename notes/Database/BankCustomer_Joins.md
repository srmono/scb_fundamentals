## **Step 1 – Insert More Data**

```sql
-- Customers
INSERT INTO customers (full_name, email, phone, address, date_of_birth) VALUES
('Charlie Davis', 'charlie@mail.com', '9876543212', '78 River Rd', '1992-11-05'),
('Diana Prince', 'diana@mail.com', '9876543213', '15 Hill Top', '1988-03-12');

INSERT INTO customers (full_name, email, phone, address, date_of_birth) VALUES
('Venkat Davis', 'venkat@mail.com', '9876543216', '78 River Rd', '1992-11-05'),


-- Accounts
INSERT INTO accounts (customer_id, account_number, account_type, balance) VALUES
(3, 'SB1003', 'Savings', 15000.00),
(3, 'CU3001', 'Current', 5000.00),
(4, 'SB1004', 'Savings', 22000.00);

-- Transactions
INSERT INTO transactions (account_id, transaction_type, amount) VALUES
(1, 'Deposit', 2000.00),
(1, 'Withdrawal', 500.00),
(2, 'Deposit', 5000.00),
(3, 'Withdrawal', 1000.00),
(4, 'Deposit', 7000.00),
(5, 'Deposit', 3000.00);
```

---

## **Step 2 – Practical Join Queries**

---

### **1. INNER JOIN – Show each customer with their accounts**

```sql
SELECT c.full_name, a.account_number, a.account_type, a.balance
FROM customers c
INNER JOIN accounts a
    ON c.customer_id = a.customer_id;
```

💡 **Explanation:**

* **INNER JOIN** returns only rows where the customer has at least one account.
* If a customer doesn’t have an account, they are excluded.

---

### **2. LEFT JOIN – Show all customers, even without accounts**

```sql
SELECT c.full_name, a.account_number, a.account_type
FROM customers c
LEFT JOIN accounts a
    ON c.customer_id = a.customer_id;
```

💡 **Explanation:**

* **LEFT JOIN** returns **all customers**, and account details if available.
* Customers with no account will have `NULL` for account fields.

---

### **3. RIGHT JOIN – Show all accounts, even if customer data is missing**

```sql
SELECT c.full_name, a.account_number, a.account_type
FROM customers c
RIGHT JOIN accounts a
    ON c.customer_id = a.customer_id;
```

💡 **Explanation:**

* **RIGHT JOIN** returns **all accounts**, and customer details if available.
* If an account has no matching customer, customer fields will be `NULL`.

---

### **4. FULL OUTER JOIN – Show all customers and accounts (matched or not)**

```sql
SELECT c.full_name, a.account_number, a.account_type
FROM customers c
FULL OUTER JOIN accounts a
    ON c.customer_id = a.customer_id;
```

💡 **Explanation:**

* **FULL OUTER JOIN** combines results of LEFT and RIGHT joins.
* Useful for finding **unmatched records** on both sides.

---

### **5. JOIN with Multiple Tables – Show customer transactions**

```sql
SELECT c.full_name, a.account_number, t.transaction_type, t.amount, t.transaction_date
FROM customers c
INNER JOIN accounts a ON c.customer_id = a.customer_id
INNER JOIN transactions t ON a.account_id = t.account_id
ORDER BY t.transaction_date DESC;
```

💡 **Explanation:**

* We join **three tables** to get the customer’s name, their account number, and recent transactions.

---

### **6. SELF JOIN – Find customers with the same birth year**

```sql
SELECT c1.full_name AS customer1, c2.full_name AS customer2, c1.date_of_birth
FROM customers c1
JOIN customers c2
    ON EXTRACT(YEAR FROM c1.date_of_birth) = EXTRACT(YEAR FROM c2.date_of_birth)
    AND c1.customer_id < c2.customer_id;
```

💡 **Explanation:**

* **SELF JOIN** matches a table with itself.
* We find customers who were born in the same year (avoiding duplicates).

---

### **7. CROSS JOIN – Generate combinations of customers and account types**

```sql
SELECT c.full_name, a_type.type_name
FROM customers c
CROSS JOIN (VALUES ('Savings'), ('Current'), ('Fixed Deposit')) AS a_type(type_name);
```

💡 **Explanation:**

* **CROSS JOIN** produces every possible combination.
* Useful for generating reports where all combinations are needed.

---

### **8. JOIN + Aggregation – Total deposits per customer**

```sql
SELECT c.full_name, SUM(t.amount) AS total_deposits
FROM customers c
JOIN accounts a ON c.customer_id = a.customer_id
JOIN transactions t ON a.account_id = t.account_id
WHERE t.transaction_type = 'Deposit'
GROUP BY c.full_name
ORDER BY total_deposits DESC;
```

💡 **Explanation:**

* We join **customers → accounts → transactions**, filter only `Deposit` type, then group by customer.

