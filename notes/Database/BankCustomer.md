## **PostgreSQL Tutorial – Bank Customer**

---

### **1. Setup (Windows)**

1. Download PostgreSQL from: [https://www.postgresql.org/download/windows/](https://www.postgresql.org/download/windows/)
2. Install with **pgAdmin**.
3. Note:

   * Port: `5432` (default)
   * Superuser: `postgres`
   * Password: **remember this**
4. Open **pgAdmin** or Command Prompt → `psql -U postgres`

---

### **2. Create Database & User**

```sql
CREATE DATABASE bank_db;
CREATE USER bank_admin WITH PASSWORD 'Bank@123';
GRANT ALL PRIVILEGES ON DATABASE bank_db TO bank_admin;
```

---

### **3. Create Tables (Banking Domain)**

#### **Customers**

```sql
CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    address TEXT,
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

#### **Accounts**

```sql
CREATE TABLE accounts (
    account_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers(customer_id),
    account_number VARCHAR(20) UNIQUE NOT NULL,
    account_type VARCHAR(20) CHECK (account_type IN ('Savings', 'Current', 'Fixed Deposit')),
    balance NUMERIC(15,2) DEFAULT 0.00,
    opened_date DATE DEFAULT CURRENT_DATE
);
```

#### **Transactions**

```sql
CREATE TABLE transactions (
    transaction_id SERIAL PRIMARY KEY,
    account_id INT REFERENCES accounts(account_id),
    transaction_type VARCHAR(10) CHECK (transaction_type IN ('Deposit', 'Withdrawal', 'Transfer')),
    amount NUMERIC(15,2) CHECK (amount > 0),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

### **4. Insert Data**

```sql
INSERT INTO customers (full_name, email, phone, address, date_of_birth)
VALUES
('Alice Johnson', 'alice@mail.com', '9876543210', '12 Park Ave', '1990-04-15'),
('Bob Smith', 'bob@mail.com', '9876543211', '45 Lake St', '1985-07-21');

INSERT INTO accounts (customer_id, account_number, account_type, balance)
VALUES
(1, 'SB1001', 'Savings', 5000.00),
(1, 'FD2001', 'Fixed Deposit', 25000.00),
(2, 'SB1002', 'Savings', 8000.00);
```

---

### **5. Select Queries**

```sql
SELECT * FROM customers;
SELECT full_name, email FROM customers WHERE date_of_birth < '1995-01-01';
SELECT * FROM accounts ORDER BY balance DESC LIMIT 2;
```

---

### **6. Update & Delete**

```sql
UPDATE accounts SET balance = balance + 2000 WHERE account_number = 'SB1001';
DELETE FROM accounts WHERE account_number = 'FD2001';
```

---

### **7. Joins**

```sql
SELECT c.full_name, a.account_number, a.balance
FROM customers c
JOIN accounts a ON c.customer_id = a.customer_id;
```

---

### **8. Aggregations**

```sql
SELECT account_type, COUNT(*) AS total_accounts, AVG(balance) AS avg_balance
FROM accounts
GROUP BY account_type;
```

---

### **9. Constraints**

Already demonstrated with:

* **PRIMARY KEY**
* **FOREIGN KEY**
* **CHECK**
* **UNIQUE**
* **NOT NULL**

---

### **10. JSON Example (KYC Data)**

```sql
CREATE TABLE kyc_details (
    kyc_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers(customer_id),
    kyc_data JSONB
);

INSERT INTO kyc_details (customer_id, kyc_data)
VALUES
(1, '{"id_type":"Aadhar","id_number":"XXXX-XXXX-XXXX","issued_by":"UIDAI"}');

SELECT kyc_data->>'id_type' AS id_type FROM kyc_details;
```

---

### **11. CTE (Find High Value Customers)**

```sql
WITH total_balances AS (
    SELECT c.customer_id, SUM(a.balance) AS total_balance
    FROM customers c
    JOIN accounts a ON c.customer_id = a.customer_id
    GROUP BY c.customer_id
)
SELECT * FROM total_balances WHERE total_balance > 10000;
```

---

### **12. Window Functions (Customer Rank by Balance)**

```sql
SELECT c.full_name, a.account_number, a.balance,
       RANK() OVER (PARTITION BY account_type ORDER BY balance DESC) AS rank_in_type
FROM customers c
JOIN accounts a ON c.customer_id = a.customer_id;
```

---

### **13. Sequences (Custom Account Numbers)**

```sql
CREATE SEQUENCE account_seq START 3000 INCREMENT 1;
SELECT nextval('account_seq');
```

---

### **14. Partitioning (Transactions by Year)**

```sql
CREATE TABLE yearly_transactions (
    transaction_id SERIAL,
    account_id INT,
    transaction_type VARCHAR(10),
    amount NUMERIC,
    transaction_date DATE NOT NULL
) PARTITION BY RANGE (transaction_date);

CREATE TABLE transactions_2024 PARTITION OF yearly_transactions
FOR VALUES FROM ('2024-01-01') TO ('2025-01-01');
```

---

### **15. Full Text Search (Search Complaints)**

```sql
CREATE TABLE complaints (
    complaint_id SERIAL PRIMARY KEY,
    description TEXT
);

INSERT INTO complaints (description) VALUES
('ATM did not dispense cash but account was debited'),
('Net banking login issue');

SELECT * FROM complaints
WHERE to_tsvector(description) @@ to_tsquery('ATM & cash');
```

---

### **16. Functions (Get Customer Balance)**

```sql
CREATE FUNCTION get_customer_total_balance(cust_id INT) RETURNS NUMERIC AS $$
BEGIN
    RETURN (SELECT SUM(balance) FROM accounts WHERE customer_id = cust_id);
END;
$$ LANGUAGE plpgsql;
```

---

### **17. Triggers (Log Transactions)**

```sql
CREATE TABLE transaction_logs (
    log_id SERIAL PRIMARY KEY,
    transaction_id INT,
    old_amount NUMERIC,
    new_amount NUMERIC,
    log_time TIMESTAMP
);

CREATE OR REPLACE FUNCTION log_transaction_update()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO transaction_logs(transaction_id, old_amount, new_amount, log_time)
    VALUES (OLD.transaction_id, OLD.amount, NEW.amount, NOW());
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER transaction_update_trigger
AFTER UPDATE OF amount ON transactions
FOR EACH ROW
EXECUTE FUNCTION log_transaction_update();
```

---

### **18. Backup & Restore (Windows)**

```powershell
pg_dump -U postgres bank_db > "C:\backup\bank_db.sql"
psql -U postgres -d bank_db < "C:\backup\bank_db.sql"
```

---

### **19. Security**

* Use **roles**:

```sql
CREATE ROLE teller LOGIN PASSWORD 'Teller@123';
GRANT SELECT, INSERT ON accounts, transactions TO teller;
```

* Restrict DROP/UPDATE for non-admins.
* Enable SSL in `postgresql.conf`.

---

### **20. Real-World Banking Project Flow**

1. **customers** → Store customer info
2. **accounts** → Link to customers, track balances
3. **transactions** → Log deposits, withdrawals, transfers
4. **kyc\_details** → Store compliance info (JSON)
5. **complaints** → Allow full-text search
6. **partitioned tables** → Speed up transaction queries by year
7. **functions** → Get total balance, generate reports
8. **triggers** → Maintain audit logs
9. **security roles** → Teller, Manager, Auditor

---

The reason is **execution order**.
Even though we *write* SQL in this order:

```sql
SELECT ...
FROM ...
WHERE ...
GROUP BY ...
HAVING ...
ORDER BY ...
```

PostgreSQL actually **executes** it in this logical sequence:

1. **FROM** → Pick the source tables
2. **WHERE** → Filter individual rows (before grouping)
3. **GROUP BY** → Group the remaining rows
4. **HAVING** → Filter the groups
5. **SELECT** → Output the final columns
6. **ORDER BY** → Sort the result

So, `HAVING` works **on groups**, not on individual rows.
If you try to use it before `GROUP BY`, PostgreSQL will throw a syntax error because there are no groups yet for it to filter.

---

### Example in a **banking** scenario

#### ❌ Wrong:

```sql
-- This will give a syntax error
SELECT account_type, AVG(balance)
FROM accounts
HAVING AVG(balance) > 10000
GROUP BY account_type;
```

#### ✅ Correct:

```sql
SELECT account_type, AVG(balance) AS avg_bal
FROM accounts
GROUP BY account_type
HAVING AVG(balance) > 10000;
```

**Explanation:**

* `GROUP BY` first creates a group for each `account_type`.
* `HAVING` then filters only those groups where `AVG(balance) > 10000`.

---

💡 **Tip:**

* Use `WHERE` when filtering **rows before grouping** (e.g., only consider savings accounts).
* Use `HAVING` when filtering **groups after grouping** (e.g., only account types with average balance > 10k).

