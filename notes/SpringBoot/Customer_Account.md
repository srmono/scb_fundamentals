
* Proper **1 → N (Customer → Accounts)** mapping
* **Customer CRUD** and **Account CRUD**
* **Nested APIs** that pick **customer\_id from the URL** (no manual account/customer IDs in the body)
* JSON payloads you can drop into **Postman**
* Matches your column names (snake\_case) in DB

---

# ✅ Entities

## `src/main/java/com/scb/bankapp/model/Customer.java`

```java
package com.scb.bankapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "customers",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_customers_email", columnNames = "email")
        },
        indexes = {
                @Index(name = "idx_customer_first_name", columnList = "first_name"),
                @Index(name = "idx_customer_last_name", columnList = "last_name")
        }
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 90)
    private String lastName;

    @Column(name = "email", length = 160, unique = true)
    private String email;

    @Column(name = "phone", length = 32)
    private String phone;

    @Column(name = "active", nullable = false, length = 8)
    private String active; // "Y" / "N"

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "role", length = 50)
    private String role;
}
```

## `src/main/java/com/scb/bankapp/model/Account.java`

```java
package com.scb.bankapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "accounts",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_account_number", columnNames = "account_number")
        },
        indexes = {
                @Index(name = "idx_account_type", columnList = "account_type"),
                @Index(name = "idx_account_branch", columnList = "account_branch")
        }
)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Matches spec: account_type - number
    @Column(name = "account_type", nullable = false)
    private Integer accountType;

    @Column(name = "account_number", nullable = false, length = 32)
    private String accountNumber;

    @Column(name = "account_branch", nullable = false, length = 100)
    private String accountBranch;

    @Column(name = "account_balance", nullable = false, precision = 15, scale = 2)
    private BigDecimal accountBalance;

    // FK: customer_id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_accounts_customer"))
    @JsonIgnore // avoid recursion; we expose customer_id via DTOs
    private Customer customer;
}
```

---

# ✅ DTOs (clean JSON without recursion, with `customer_id`)

## `src/main/java/com/scb/bankapp/dto/AccountRequest.java`

```java
package com.scb.bankapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequest {
    @JsonProperty("account_type")
    private Integer accountType;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("account_branch")
    private String accountBranch;

    @JsonProperty("account_balance")
    private BigDecimal accountBalance;
}
```

## `src/main/java/com/scb/bankapp/dto/AccountResponse.java`

```java
package com.scb.bankapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class AccountResponse {
    private Integer id;

    @JsonProperty("account_type")
    private Integer accountType;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("account_branch")
    private String accountBranch;

    @JsonProperty("account_balance")
    private BigDecimal accountBalance;

    @JsonProperty("customer_id")
    private Integer customerId;
}
```

---

# ✅ Repositories

> Note: package name kept as `respository` to match your project.

## `src/main/java/com/scb/bankapp/respository/CustomerRepository.java`

```java
package com.scb.bankapp.respository;

import com.scb.bankapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);

    // one example custom query (JPQL)
    @Query("SELECT c FROM Customer c WHERE c.active = :active")
    java.util.List<Customer> findByActive(String active);
}
```

## `src/main/java/com/scb/bankapp/respository/AccountRepository.java`

```java
package com.scb.bankapp.respository;

import com.scb.bankapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByCustomer_Id(Integer customerId);
}
```

---

# ✅ Exceptions (compatible with your existing handler style)

## `src/main/java/com/scb/bankapp/exception/AccountNotFoundException.java`

```java
package com.scb.bankapp.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
```

> Your existing `GlobalExceptionHandler` and `CustomerNotFoundException` are fine.
> (Optional) add one more handler in `GlobalExceptionHandler`:

```java
@ExceptionHandler(AccountNotFoundException.class)
public ResponseEntity<Object> handleAccountNotFound(AccountNotFoundException ex, WebRequest request) {
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", HttpStatus.NOT_FOUND.value());
    body.put("error", "Account Not Found");
    body.put("message", ex.getMessage());
    body.put("path", request.getDescription(false).replace("uri=", ""));
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
}
```

---

# ✅ Services

## `src/main/java/com/scb/bankapp/service/CustomerService.java`

```java
package com.scb.bankapp.service;

import com.scb.bankapp.exception.CustomerNotFoundException;
import com.scb.bankapp.model.Customer;
import com.scb.bankapp.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository crepo;

    public List<Customer> getAllCustomers(){
        return crepo.findAll();
    }

    public Customer getCustomerById(int id){
        return crepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));
    }

    @Transactional
    public Customer addCustomer(Customer customer){
        crepo.findByEmail(customer.getEmail()).ifPresent(c -> {
            throw new IllegalArgumentException("Email already exists: " + c.getEmail());
        });
        return crepo.save(customer);
    }

    public void deleteCustomer(int id){
        if(!crepo.existsById(id)){
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        crepo.deleteById(id);
    }

    @Transactional
    public Customer updateCustomer(int id, Customer updated){
        Customer existing = crepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));

        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        existing.setActive(updated.getActive());
        existing.setPassword(updated.getPassword());
        existing.setRole(updated.getRole());

        return crepo.save(existing);
    }
}
```

## `src/main/java/com/scb/bankapp/service/AccountService.java`

```java
package com.scb.bankapp.service;

import com.scb.bankapp.dto.AccountRequest;
import com.scb.bankapp.dto.AccountResponse;
import com.scb.bankapp.exception.AccountNotFoundException;
import com.scb.bankapp.exception.CustomerNotFoundException;
import com.scb.bankapp.model.Account;
import com.scb.bankapp.model.Customer;
import com.scb.bankapp.respository.AccountRepository;
import com.scb.bankapp.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Mapper helpers
    private AccountResponse toResponse(Account a) {
        return new AccountResponse(
                a.getId(),
                a.getAccountType(),
                a.getAccountNumber(),
                a.getAccountBranch(),
                a.getAccountBalance(),
                a.getCustomer().getId()
        );
    }

    public List<AccountResponse> getAccountsByCustomerId(int customerId) {
        // verify customer exists
        customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found"));

        return accountRepository.findByCustomer_Id(customerId)
                .stream().map(this::toResponse).toList();
    }

    public AccountResponse getAccountById(int accountId) {
        Account acc = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account with ID " + accountId + " not found"));
        return toResponse(acc);
    }

    // Create under /customers/{id}/accounts — customer_id comes from URL
    public AccountResponse createForCustomer(int customerId, AccountRequest req) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found"));

        Account a = new Account();
        a.setAccountType(req.getAccountType());
        a.setAccountNumber(req.getAccountNumber());
        a.setAccountBranch(req.getAccountBranch());
        a.setAccountBalance(req.getAccountBalance());
        a.setCustomer(customer);

        return toResponse(accountRepository.save(a));
    }

    // Plain CRUD for /accounts
    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll().stream().map(this::toResponse).toList();
    }

    public AccountResponse updateAccount(int accountId, AccountRequest req) {
        Account existing = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account with ID " + accountId + " not found"));

        existing.setAccountType(req.getAccountType());
        existing.setAccountNumber(req.getAccountNumber());
        existing.setAccountBranch(req.getAccountBranch());
        existing.setAccountBalance(req.getAccountBalance());

        return toResponse(accountRepository.save(existing));
    }

    public void deleteAccount(int accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new AccountNotFoundException("Account with ID " + accountId + " not found");
        }
        accountRepository.deleteById(accountId);
    }
}
```

---

# ✅ Controllers

## `src/main/java/com/scb/bankapp/controller/CustomerController.java`

```java
package com.scb.bankapp.controller;

import com.scb.bankapp.dto.AccountRequest;
import com.scb.bankapp.dto.AccountResponse;
import com.scb.bankapp.model.Customer;
import com.scb.bankapp.service.AccountService;
import com.scb.bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    // ---- Customer CRUD ----
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }

    // ---- JOIN APIs (Customer → Accounts) ----

    // GET /customers/{id}/accounts : list accounts for a customer
    @GetMapping("/{id}/accounts")
    public List<AccountResponse> getCustomerAccounts(@PathVariable int id) {
        return accountService.getAccountsByCustomerId(id);
    }

    // POST /customers/{id}/accounts : create account for that customer (customer_id from URL)
    @PostMapping("/{id}/accounts")
    public AccountResponse createAccountForCustomer(@PathVariable int id, @RequestBody AccountRequest req) {
        return accountService.createForCustomer(id, req);
    }
}
```

## `src/main/java/com/scb/bankapp/controller/AccountController.java`

```java
package com.scb.bankapp.controller;

import com.scb.bankapp.dto.AccountRequest;
import com.scb.bankapp.dto.AccountResponse;
import com.scb.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Plain CRUD for accounts (not nested)
    @GetMapping
    public List<AccountResponse> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    public AccountResponse updateAccount(@PathVariable int id, @RequestBody AccountRequest req) {
        return accountService.updateAccount(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
    }
}
```

---

# ✅ Postman — Ready-to-use Samples

## 1) Create Customer

**POST** `http://localhost:8080/customers`

```json
{
  "firstName": "Ravi",
  "lastName": "Kumar",
  "email": "ravi.kumar@example.com",
  "phone": "9876543210",
  "active": "Y",
  "password": "SecurePass123",
  "role": "USER"
}
```

Another customer:

```json
{
  "firstName": "Anita",
  "lastName": "Sharma",
  "email": "anita.sharma@example.com",
  "phone": "9123456780",
  "active": "Y",
  "password": "MySecret456",
  "role": "ADMIN"
}
```

## 2) Get all Customers

**GET** `http://localhost:8080/customers`

## 3) Get Customer by ID

**GET** `http://localhost:8080/customers/1`

## 4) Update Customer

**PUT** `http://localhost:8080/customers/1`

```json
{
  "firstName": "Ravi",
  "lastName": "Kumar",
  "email": "ravi.kumar@newmail.com",
  "phone": "9811111111",
  "active": "Y",
  "password": "SecurePass123",
  "role": "USER"
}
```

## 5) Delete Customer

**DELETE** `http://localhost:8080/customers/1`

---

## 6) Create Account for a Customer (customer\_id from URL)

**POST** `http://localhost:8080/customers/1/accounts`

```json
{
  "account_type": 1,
  "account_number": "ACC10001",
  "account_branch": "Hyderabad-Main",
  "account_balance": 15000.75
}
```

Another account for same customer:

```json
{
  "account_type": 2,
  "account_number": "ACC10002",
  "account_branch": "Hyderabad-Main",
  "account_balance": 5200.00
}
```

## 7) Get Accounts of a Customer

**GET** `http://localhost:8080/customers/1/accounts`

**Sample response**

```json
[
  {
    "id": 1,
    "account_type": 1,
    "account_number": "ACC10001",
    "account_branch": "Hyderabad-Main",
    "account_balance": 15000.75,
    "customer_id": 1
  },
  {
    "id": 2,
    "account_type": 2,
    "account_number": "ACC10002",
    "account_branch": "Hyderabad-Main",
    "account_balance": 5200.0,
    "customer_id": 1
  }
]
```

---

## 8) Accounts — Plain CRUD (optional)

* **GET** `http://localhost:8080/accounts`
* **GET** `http://localhost:8080/accounts/2`
* **PUT** `http://localhost:8080/accounts/2`

```json
{
  "account_type": 2,
  "account_number": "ACC10002",
  "account_branch": "Hyderabad-Begumpet",
  "account_balance": 7300.50
}
```

* **DELETE** `http://localhost:8080/accounts/2`

---

# Notes

* `accountId` and `customerId` are **auto-generated**; you **never** send them in the request.
* `customer_id` is inferred from the **URL** when creating an account via `/customers/{id}/accounts`.
* Column names in DB use **snake\_case** as per your spec; JSON is shaped via DTOs to include `customer_id`.

