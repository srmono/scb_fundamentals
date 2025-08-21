CREATE TABLE customers (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(80) NOT NULL,
  last_name  VARCHAR(90) NOT NULL,
  email VARCHAR(160) UNIQUE,
  phone VARCHAR(32),
  active VARCHAR(8) NOT NULL,
  password VARCHAR(200),
  role VARCHAR(50)
);

CREATE UNIQUE INDEX uk_customers_email ON customers(email);
CREATE INDEX idx_customer_first_name ON customers(first_name);
CREATE INDEX idx_customer_last_name ON customers(last_name);

CREATE TABLE accounts (
  id SERIAL PRIMARY KEY,
  account_type INTEGER NOT NULL,
  account_number VARCHAR(32) NOT NULL UNIQUE,
  account_branch VARCHAR(100) NOT NULL,
  account_balance NUMERIC(15,2) NOT NULL,
  customer_id INTEGER NOT NULL REFERENCES customers(id)
);

CREATE UNIQUE INDEX uk_account_number ON accounts(account_number);
CREATE INDEX idx_account_type ON accounts(account_type);
CREATE INDEX idx_account_branch ON accounts(account_branch);


---


GET /customers/1 → customer payload.

GET /customers/1/accounts → list of Account for that customer (JOIN via FK).

POST /customers → create customer.

POST /accounts (if you later add this) → create account; set customer with { "id": <customerId> }.

GET /customers?lastNamePart=... (if you expose the custom query later) using the repo method findActiveByLastNameLike.

--------------------


{
  "firstName": "Ravi",
  "lastName": "Kumar",
  "email": "ravi.kumar@example.com",
  "phone": "9876543210",
  "active": "Y",
  "password": "securePass123",
  "role": "USER"
}


{
  "firstName": "Anita",
  "lastName": "Sharma",
  "email": "anita.sharma@example.com",
  "phone": "9123456780",
  "active": "Y",
  "password": "mySecret456",
  "role": "ADMIN"
}


{
  "accountNumber": "ACC123456",
  "accountType": "SAVINGS",
  "balance": 15000.75,
  "customer": {
    "id": 1
  }
}


{
  "accountNumber": "ACC987654",
  "accountType": "CURRENT",
  "balance": 55000.00,
  "customer": {
    "id": 1
  }
}



{
  "accountNumber": "ACC456789",
  "accountType": "SAVINGS",
  "balance": 2500.00,
  "customer": {
    "id": 2
  }
}



Verify with GET APIs

Get all customers → GET /customers

Get single customer → GET /customers/1

Get customer’s accounts → GET /customers/1/accounts

