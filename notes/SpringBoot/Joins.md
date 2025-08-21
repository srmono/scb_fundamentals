# 🔹 JPA Relationships Tutorial (with Annotations)

In databases, we often have **relationships** between tables.
In **JPA/Hibernate**, we represent those relationships using **annotations**.

## Types of Relationships in JPA

1. **@OneToOne** → One entity relates to exactly one entity.
   Example: **Customer ↔ Address**

2. **@OneToMany** → One entity relates to many entities.
   Example: **Customer ↔ Accounts**

3. **@ManyToOne** → Many entities relate to one entity.
   Example: **Accounts ↔ Customer**

4. **@ManyToMany** → Many entities relate to many entities.
   Example: **Customer ↔ Branch** (a customer can access many branches, a branch serves many customers)

---

# 1️⃣ **@OneToOne Example (Customer ↔ Address)**

### 📌 Customer Entity

```java
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String role;
    private String active;

    // One customer has one address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
```

### 📌 Address Entity

```java
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipcode;

    // Optional: If you want bidirectional mapping
    @OneToOne(mappedBy = "address")
    private Customer customer;
}
```

✅ Description:

* `@OneToOne` → defines one-to-one relationship.
* `@JoinColumn(name="address_id")` → creates a foreign key in `Customer` table referencing `Address(id)`.
* `cascade = CascadeType.ALL` → when customer is saved/deleted, address also gets saved/deleted.
* `mappedBy = "address"` → tells Hibernate that **Customer** owns the relationship.

---

# 2️⃣ **@OneToMany and @ManyToOne (Customer ↔ Accounts)**

### 📌 Customer Entity

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String role;
    private String active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    // One customer has many accounts
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();
}
```

### 📌 Account Entity

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String accountType;
    private String accountBranch;
    private Double accountBalance;

    // Many accounts belong to one customer
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
```

✅ Description:

* **Customer** → `@OneToMany(mappedBy="customer")`
  Means: one customer can have multiple accounts.
  `mappedBy` → tells Hibernate that **Account** owns the relationship.
* **Account** → `@ManyToOne` with `@JoinColumn("customer_id")`
  Creates a foreign key in **Account** table referencing **Customer(id)**.
* `fetch = FetchType.LAZY` → loads accounts **only when needed** (better performance).

---

# 3️⃣ **@ManyToMany (Customer ↔ Branch)**

Let’s say a **Customer** can use services from **multiple Branches**, and a **Branch** serves many customers.

### 📌 Customer Entity

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    @ManyToMany
    @JoinTable(
        name = "customer_branch",
        joinColumns = @JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name = "branch_id")
    )
    private List<Branch> branches = new ArrayList<>();
}
```

### 📌 Branch Entity

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchName;
    private String branchCode;

    @ManyToMany(mappedBy = "branches")
    private List<Customer> customers = new ArrayList<>();
}
```

✅ Description:

* `@ManyToMany` → relationship between customers & branches.
* `@JoinTable` → creates a new join table (`customer_branch`) with `customer_id` and `branch_id`.
* `mappedBy = "branches"` → branch entity does not own the relationship (customer does).

---

# 🔑 Key Parameters of JPA Annotations

* `cascade = CascadeType.ALL` → Apply operations (save, delete, update) to related entities.
* `fetch = FetchType.LAZY` → Load only when accessed (better for performance).
* `fetch = FetchType.EAGER` → Always load relationship (use carefully).
* `mappedBy` → Tells which entity owns the relationship (used on the **inverse side**).
* `@JoinColumn` → Defines foreign key column.
* `@JoinTable` → Defines a join table for `@ManyToMany`.

---

# 🚀 Quick Recap with Your Entities

* **Customer ↔ Address** → `@OneToOne`
* **Customer ↔ Accounts** → `@OneToMany` + `@ManyToOne`
* **Customer ↔ Branch** → `@ManyToMany`

