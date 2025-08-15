### Example — React CRUD with Axios + Public API (JSONPlaceholder)

#### `CustomerService.js`

```javascript
import axios from "axios";

const API_URL = "https://jsonplaceholder.typicode.com/users";

export const getCustomers = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

export const getCustomerById = async (id) => {
  const response = await axios.get(`${API_URL}/${id}`);
  return response.data;
};

export const createCustomer = async (customer) => {
  const response = await axios.post(API_URL, customer);
  return response.data;
};

export const updateCustomer = async (id, customer) => {
  const response = await axios.put(`${API_URL}/${id}`, customer);
  return response.data;
};

export const deleteCustomer = async (id) => {
  await axios.delete(`${API_URL}/${id}`);
  return id;
};
```

---

#### `App.js`

```javascript
import React, { useEffect, useState } from "react";
import {
  getCustomers,
  createCustomer,
  updateCustomer,
  deleteCustomer,
} from "./CustomerService";

export default function App() {
  const [customers, setCustomers] = useState([]);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [selectedId, setSelectedId] = useState(null);

  // Load customers on mount
  useEffect(() => {
    fetchCustomers();
  }, []);

  const fetchCustomers = async () => {
    const data = await getCustomers();
    setCustomers(data);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (selectedId) {
      const updated = await updateCustomer(selectedId, { name, email });
      setCustomers((prev) =>
        prev.map((c) => (c.id === selectedId ? updated : c))
      );
      setSelectedId(null);
    } else {
      const created = await createCustomer({ name, email });
      setCustomers((prev) => [...prev, created]);
    }
    setName("");
    setEmail("");
  };

  const handleEdit = (customer) => {
    setSelectedId(customer.id);
    setName(customer.name);
    setEmail(customer.email);
  };

  const handleDelete = async (id) => {
    await deleteCustomer(id);
    setCustomers((prev) => prev.filter((c) => c.id !== id));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Customer CRUD with Public API</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Name"
          value={name}
          required
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="email"
          placeholder="Email"
          value={email}
          required
          onChange={(e) => setEmail(e.target.value)}
        />
        <button type="submit">{selectedId ? "Update" : "Add"}</button>
      </form>

      <ul>
        {customers.map((c) => (
          <li key={c.id}>
            {c.name} ({c.email})
            <button onClick={() => handleEdit(c)}>Edit</button>
            <button onClick={() => handleDelete(c.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
```

---

### How This Works

1. **GET** – `getCustomers()` fetches all users from the API.
2. **POST** – `createCustomer()` adds a new fake user (JSONPlaceholder won’t store it permanently, but returns a simulated result).
3. **PUT** – `updateCustomer()` updates a user’s details.
4. **DELETE** – `deleteCustomer()` removes a user.

💡 This code works exactly like a normal backend API, so later you can swap `API_URL` with your **real API** without changing the rest of the code.



---

# Customer Simulation
Alright, let’s do this — I’ll take your **existing local-data React CRUD** setup and simply swap the data layer to use **Axios with a public API**, so your component logic stays almost the same.

We’ll use [JSONPlaceholder](https://jsonplaceholder.typicode.com/) because:

* It’s free and doesn’t need authentication.
* It supports `GET`, `POST`, `PUT`, `DELETE`.
* It returns realistic fake data for demo purposes.

---

## **Updated Structure**

We’ll just modify your `customerService.js` to call the API instead of your local array.
The rest of your components (App, CustomerList, CustomerForm, etc.) will still work as before.

---

### **customerService.js**

```javascript
// customerService.js
import axios from "axios";

const API_URL = "https://jsonplaceholder.typicode.com/users"; // public API

// GET all customers
export const getCustomers = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// GET a single customer by ID
export const getCustomerById = async (id) => {
  const response = await axios.get(`${API_URL}/${id}`);
  return response.data;
};

// ADD a new customer
export const addCustomer = async (customer) => {
  const response = await axios.post(API_URL, customer);
  return response.data;
};

// UPDATE customer
export const updateCustomer = async (id, updatedCustomer) => {
  const response = await axios.put(`${API_URL}/${id}`, updatedCustomer);
  return response.data;
};

// DELETE customer
export const deleteCustomer = async (id) => {
  const response = await axios.delete(`${API_URL}/${id}`);
  return response.data;
};
```

---

### **Example usage in CustomerList.js**

```javascript
import React, { useEffect, useState } from "react";
import { getCustomers, deleteCustomer } from "./customerService";

function CustomerList({ onSelectCustomer }) {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    loadCustomers();
  }, []);

  const loadCustomers = async () => {
    const data = await getCustomers();
    setCustomers(data);
  };

  const handleDelete = async (id) => {
    await deleteCustomer(id);
    setCustomers(customers.filter((c) => c.id !== id));
  };

  return (
    <div>
      <h3>Customer List</h3>
      <ul>
        {customers.map((customer) => (
          <li key={customer.id}>
            {customer.name} - {customer.email}
            <button onClick={() => onSelectCustomer(customer)}>View</button>
            <button onClick={() => handleDelete(customer.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CustomerList;
```

---

### **Example usage in CustomerForm.js**

```javascript
import React, { useState } from "react";
import { addCustomer } from "./customerService";

function CustomerForm({ onCustomerAdded }) {
  const [formData, setFormData] = useState({ name: "", email: "" });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newCustomer = await addCustomer(formData);
    onCustomerAdded(newCustomer);
    setFormData({ name: "", email: "" });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        name="name"
        placeholder="Name"
        value={formData.name}
        onChange={handleChange}
      />
      <input
        name="email"
        placeholder="Email"
        value={formData.email}
        onChange={handleChange}
      />
      <button type="submit">Add Customer</button>
    </form>
  );
}

export default CustomerForm;
```

---

✅ **What Changed?**

* You were using a **local array** → now replaced with Axios calls.
* The **component logic** is still the same.
* JSONPlaceholder won’t actually store changes permanently (it’s a mock API), but it will return the new/updated data so your UI updates instantly.

