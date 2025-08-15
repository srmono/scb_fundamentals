
* Starts from **installation**
* Covers **all basic to advanced concepts**
* Includes **Windows commands** (PowerShell / CMD)
* Has **real examples** and **enterprise-level features**
* Fills in what I missed earlier (JSON, CTEs, Window Functions, Partitioning, Sequences, Full Text Search, etc.)

---

## **PostgreSQL Full Tutorial – Windows Edition**

---

### **1. Installing PostgreSQL on Windows**

1. Go to [https://www.postgresql.org/download/windows/](https://www.postgresql.org/download/windows/)
2. Download **EnterpriseDB installer** (includes pgAdmin).
3. Run installer → Select:

   * Components: PostgreSQL Server + pgAdmin
   * Data Directory (default: `C:\Program Files\PostgreSQL\16\data`)
   * Superuser Password → Remember this
   * Port: `5432` (default)
4. Finish installation.

---

### **2. Accessing PostgreSQL**

**Option 1 – pgAdmin** (GUI)

* Open **pgAdmin 4** from Start menu.
* Log in with your password.

**Option 2 – Command Line**

```powershell
cd "C:\Program Files\PostgreSQL\16\bin"
psql -U postgres
```

Exit:

```sql
\q
```

---

### **3. Basic Commands**

Inside `psql`:

```sql
\l     -- List databases
\c mydb -- Connect to database
\dt    -- List tables
\d tablename -- Describe table
\q     -- Quit
```

---

### **4. Database & User Management**

```sql
CREATE DATABASE company_db;
CREATE USER hr_admin WITH PASSWORD 'Secret@123';
GRANT ALL PRIVILEGES ON DATABASE company_db TO hr_admin;
```

---

### **5. Table Creation**

```sql
CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department VARCHAR(50),
    salary NUMERIC(10,2) CHECK (salary >= 0),
    joining_date DATE DEFAULT CURRENT_DATE
);
```

---

### **6. Inserting Data**

```sql
INSERT INTO employees (name, email, department, salary)
VALUES ('Alice', 'alice@corp.com', 'HR', 55000.00),
       ('Bob', 'bob@corp.com', 'IT', 65000.50);
```

---

### **7. Querying Data**

```sql
SELECT * FROM employees;
SELECT name, salary FROM employees WHERE salary > 60000;
SELECT * FROM employees ORDER BY salary DESC LIMIT 5;
```

---

### **8. Updating & Deleting**

```sql
UPDATE employees SET salary = 70000 WHERE name = 'Alice';
DELETE FROM employees WHERE id = 2;
```

---

### **9. Joins**

```sql
CREATE TABLE departments (
    dept_id SERIAL PRIMARY KEY,
    dept_name VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO departments (dept_name) VALUES ('HR'), ('IT');

SELECT e.name, d.dept_name
FROM employees e
JOIN departments d ON e.department = d.dept_name;
```

---

### **10. Aggregations**

```sql
SELECT department, AVG(salary) AS avg_salary
FROM employees
GROUP BY department;
```

---

### **11. JSON Support**

```sql
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    order_data JSONB
);

INSERT INTO orders (order_data) VALUES
('{"customer":"John","items":[{"product":"Laptop","qty":1}]}');

SELECT order_data->>'customer' AS customer FROM orders;
```

---

### **12. Common Table Expressions (CTE)**

```sql
WITH high_salary AS (
    SELECT * FROM employees WHERE salary > 60000
)
SELECT name FROM high_salary;
```

---

### **13. Window Functions**

```sql
SELECT name, department, salary,
       RANK() OVER (PARTITION BY department ORDER BY salary DESC) AS rank_in_dept
FROM employees;
```

---

### **14. Sequences**

```sql
CREATE SEQUENCE emp_seq START 1000 INCREMENT 1;
SELECT nextval('emp_seq');
```

---

### **15. Partitioning**

```sql
CREATE TABLE sales (
    id SERIAL,
    sale_date DATE NOT NULL,
    amount NUMERIC
) PARTITION BY RANGE (sale_date);

CREATE TABLE sales_2024 PARTITION OF sales
FOR VALUES FROM ('2024-01-01') TO ('2025-01-01');
```

---

### **16. Full Text Search**

```sql
CREATE TABLE articles (
    id SERIAL PRIMARY KEY,
    content TEXT
);

INSERT INTO articles (content) VALUES ('PostgreSQL is a powerful database system.');

SELECT * FROM articles
WHERE to_tsvector(content) @@ to_tsquery('database & system');
```

---

### **17. Functions**

```sql
CREATE FUNCTION get_total_employees() RETURNS INT AS $$
BEGIN
    RETURN (SELECT COUNT(*) FROM employees);
END;
$$ LANGUAGE plpgsql;
```

---

### **18. Triggers**

```sql
CREATE TABLE salary_logs (
    id SERIAL PRIMARY KEY,
    emp_id INT,
    old_salary NUMERIC,
    new_salary NUMERIC,
    change_date TIMESTAMP
);

CREATE OR REPLACE FUNCTION log_salary_change()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO salary_logs(emp_id, old_salary, new_salary, change_date)
    VALUES (OLD.id, OLD.salary, NEW.salary, NOW());
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER salary_update
AFTER UPDATE OF salary ON employees
FOR EACH ROW
EXECUTE FUNCTION log_salary_change();
```

---

### **19. Backup & Restore (Windows)**

```powershell
# Backup
pg_dump -U postgres company_db > "C:\backup\company_db.sql"

# Restore
psql -U postgres -d company_db < "C:\backup\company_db.sql"
```

---

### **20. Security Best Practices**

* Use **role-based access**
* Enforce **password complexity**
* Enable **SSL/TLS**
* Regular **backups**
* Use `REVOKE` to remove unused permissions

