* Create a **fake service file** (`customerService.js`)
* Store your `customers` array in a module variable there
* Each axios method (`get`, `post`, `put`, `delete`) will return a `Promise` that resolves after a short delay (so it *feels* like a real API call)
* You still import and call `axios.get("/customers")`, but it’s actually your fake axios wrapper that operates on local data.

---

## **1. Fake Axios Setup**

**customerService.js**

```javascript
// customerService.js
import axios from 'axios';

// Fake in-memory DB
let customers = [
  { id: 1, firstName: 'Sundar', lastName: 'Pichai', email: 'sundar.pichai@google.com', phone: '', accounts: [{ accountNo: '1001999', type: 'SAVINGS_ACCOUNT', branch: 'Bellandur', balance: 1000 }, { accountNo: '1001888', type: 'SAVINGS_ACCOUNT', branch: 'Indira Nagar', balance: 2000 }] },
  { id: 2, firstName: 'Jeff', lastName: 'Bezos', email: 'jeff.bezos@amazon.com', phone: '', accounts: [] },
  { id: 3, firstName: 'Satya', lastName: 'Nadella', email: 'satya.nadella@microsoft.com', phone: '', accounts: [] },
  { id: 4, firstName: 'Sergey', lastName: 'Brin', email: 'sergey.brin@google.com', phone: '', accounts: [] },
  { id: 5, firstName: 'Larry', lastName: 'Page', email: 'larry.page@google.com', phone: '', accounts: [] }
];

// Simulate delay
const delay = (ms) => new Promise(res => setTimeout(res, ms));

// Simulated GET
export const getCustomers = async () => {
  await delay(300);
  return { data: [...customers] };
};

// Simulated POST
export const createCustomer = async (customer) => {
  await delay(300);
  const newCustomer = { ...customer, id: customers.length + 1, accounts: [] };
  customers.push(newCustomer);
  return { data: newCustomer };
};

// Simulated PUT
export const updateCustomer = async (id, updatedCustomer) => {
  await delay(300);
  customers = customers.map(c => (c.id === id ? { ...updatedCustomer, id } : c));
  return { data: customers.find(c => c.id === id) };
};

// Simulated DELETE
export const deleteCustomer = async (id) => {
  await delay(300);
  customers = customers.filter(c => c.id !== id);
  return { data: true };
};

// Simulated GET by ID
export const getCustomerById = async (id) => {
  await delay(300);
  return { data: customers.find(c => c.id === id) || null };
};
```

---

## **2. Update App to Use These "API" Calls**

In `App.jsx`, instead of keeping state hardcoded at the start, load it from our service.

```jsx
import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import CustomersList from './newcustomer/CustomersList';
import CustomerForm from './newcustomer/CustomerForm';
import CustomerDetails from './newcustomer/CustomerDetails';
import { getCustomers, createCustomer, updateCustomer, deleteCustomer as apiDeleteCustomer } from './services/customerService';

function App() {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    getCustomers().then(res => setCustomers(res.data));
  }, []);

  const addCustomer = (customer) => {
    createCustomer(customer).then(res => {
      setCustomers(prev => [...prev, res.data]);
    });
  };

  const editCustomer = (updatedCustomer) => {
    updateCustomer(updatedCustomer.id, updatedCustomer).then(res => {
      setCustomers(prev => prev.map(c => c.id === updatedCustomer.id ? res.data : c));
    });
  };

  const removeCustomer = (id) => {
    apiDeleteCustomer(id).then(() => {
      setCustomers(prev => prev.filter(c => c.id !== id));
    });
  };

  return (
    <Router>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-3">
        <Link to="/home" className="navbar-brand me-3">Home</Link>
        <Link to="/customers" className="nav-link text-white me-3">Customers</Link>
        <Link to="/about" className="nav-link text-white">About</Link>
      </nav>
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/customers" element={<CustomersList customers={customers} onDelete={removeCustomer} />} />
        <Route path="/customers/new" element={<CustomerForm onCreate={addCustomer} customers={customers} />} />
        <Route path="/customers/:id/edit" element={<CustomerForm onUpdate={editCustomer} customers={customers} />} />
        <Route path="/customers/:id" element={<CustomerDetails customers={customers} onDelete={removeCustomer} />} />
      </Routes>
    </Router>
  );
}

export default App;
```

---

## **3. Why This Works**

* No JSON Server
* No external API
* Feels like `axios` calls because they **return promises** and `.then()` works exactly like real HTTP calls.
* You can later replace these with *real* API calls without changing your component logic — only change the service file.

