
### ✅ Structure Overview

You will have:

```
src/
├── App.js
├── components/
│   ├── Home.js
│   ├── About.js
│   ├── CustomersList.js
│   ├── CustomerForm.js
│   └── CustomerDetails.js
├── index.js
```

---

## ✅ 1. `index.js`

```jsx
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
```

---

## ✅ 2. `App.js`

```jsx
import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import CustomersList from './components/CustomersList';
import CustomerForm from './components/CustomerForm';
import CustomerDetails from './components/CustomerDetails';

const App = () => {
  const [customers, setCustomers] = useState([
    { id: 1, firstName: 'Sundar', lastName: 'Pichai', email: 'sundar.pichai@google.com', phone: '', accounts: [{ accountNo: '1001999', type: 'SAVINGS_ACCOUNT', branch: 'Bellandur', balance: 1000 }, { accountNo: '1001888', type: 'SAVINGS_ACCOUNT', branch: 'Indira Nagar', balance: 2000 }] },
    { id: 2, firstName: 'Jeff', lastName: 'Bezos', email: 'jeff.bezos@amazon.com', phone: '', accounts: [] },
    { id: 3, firstName: 'Satya', lastName: 'Nadella', email: 'satya.nadella@microsoft.com', phone: '', accounts: [] },
    { id: 4, firstName: 'Sergey', lastName: 'Brin', email: 'sergey.brin@google.com', phone: '', accounts: [] },
    { id: 5, firstName: 'Larry', lastName: 'Page', email: 'larry.page@google.com', phone: '', accounts: [] }
  ]);

  const addCustomer = (customer) => {
    setCustomers([...customers, { ...customer, id: customers.length + 1, accounts: [] }]);
  };

  const deleteCustomer = (id) => {
    if (window.confirm("Are you sure to delete this customer?")) {
      setCustomers(customers.filter(c => c.id !== id));
    }
  };

  return (
    <Router>
      <nav style={{ background: '#2c2c2c', padding: '1rem' }}>
        <Link to="/home" style={{ color: 'white', marginRight: 20 }}>Home</Link>
        <Link to="/customers" style={{ color: 'white', marginRight: 20 }}>Customers</Link>
        <Link to="/about" style={{ color: 'white' }}>About</Link>
      </nav>
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/customers" element={<CustomersList customers={customers} onDelete={deleteCustomer} />} />
        <Route path="/customers/new" element={<CustomerForm onCreate={addCustomer} />} />
        <Route path="/customers/:id" element={<CustomerDetails customers={customers} />} />
      </Routes>
    </Router>
  );
};

export default App;
```

---

## ✅ 3. `components/Home.js`

```jsx
import React from 'react';

const Home = () => (
  <div style={{ padding: 20 }}>
    <h2>Welcome to TopGuns Bank</h2>
    <p>This application manages customer data and their accounts.</p>
  </div>
);

export default Home;
```

---

## ✅ 4. `components/About.js`

```jsx
import React from 'react';

const About = () => (
  <div style={{ padding: 20 }}>
    <h2>About TopGuns Bank</h2>
    <p>This app is used by TopGuns Bank staff to manage customer records, create new accounts, and view customer details.</p>
  </div>
);

export default About;
```

---

## ✅ 5. `components/CustomersList.js`

```jsx
import React from 'react';
import { Link } from 'react-router-dom';

const CustomersList = ({ customers, onDelete }) => (
  <div style={{ padding: 20 }}>
    <Link to="/customers/new">Create new customer</Link>
    <h2>Customers List</h2>
    <table border="1" cellPadding="10">
      <thead>
        <tr>
          <th>Id</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {customers.map(c => (
          <tr key={c.id}>
            <td>{c.id}</td>
            <td>{c.firstName}</td>
            <td>{c.lastName}</td>
            <td>{c.email}</td>
            <td>
              <Link to={`/customers/${c.id}`}>Show</Link> | <Link to="/customers/new">Edit</Link> | <button onClick={() => onDelete(c.id)}>Delete</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  </div>
);

export default CustomersList;
```

---

## ✅ 6. `components/CustomerForm.js`

```jsx
import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';

const CustomerForm = ({ onCreate }) => {
  const [form, setForm] = useState({ firstName: '', lastName: '', email: '', phone: '' });
  const navigate = useNavigate();

  const handleChange = e => setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = e => {
    e.preventDefault();
    onCreate(form);
    navigate('/customers');
  };

  return (
    <div style={{ padding: 20 }}>
      <Link to="/customers">{'< Back to Customers List'}</Link>
      <h2>Add Customer</h2>
      <form onSubmit={handleSubmit}>
        <div><input name="firstName" placeholder="Please enter first name" value={form.firstName} onChange={handleChange} /></div>
        <div><input name="lastName" placeholder="Please enter last name" value={form.lastName} onChange={handleChange} /></div>
        <div><input name="email" placeholder="Please enter email details" value={form.email} onChange={handleChange} /></div>
        <div><input name="phone" placeholder="Please enter phone no" value={form.phone} onChange={handleChange} /></div>
        <button type="submit">Create Customer</button>
      </form>
    </div>
  );
};

export default CustomerForm;
```

---

## ✅ 7. `components/CustomerDetails.js`

```jsx
import React from 'react';
import { useParams, Link } from 'react-router-dom';

const CustomerDetails = ({ customers }) => {
  const { id } = useParams();
  const customer = customers.find(c => c.id === parseInt(id));

  if (!customer) return <div>Customer not found</div>;

  return (
    <div style={{ padding: 20 }}>
      <Link to="/customers">{'< Back to Customers List'}</Link>
      <h2>Customer Details</h2>
      <p><strong>ID:</strong> {customer.id}</p>
      <p><strong>First Name:</strong> {customer.firstName}</p>
      <p><strong>Last Name:</strong> {customer.lastName}</p>
      <p><strong>Email:</strong> {customer.email}</p>
      <p><strong>Phone:</strong> {customer.phone}</p>

      <h3>List of Accounts</h3>
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Account No</th>
            <th>Type</th>
            <th>Branch</th>
            <th>Balance</th>
          </tr>
        </thead>
        <tbody>
          {customer.accounts.map((acc, idx) => (
            <tr key={idx}>
              <td>{acc.accountNo}</td>
              <td>{acc.type}</td>
              <td>{acc.branch}</td>
              <td>{acc.balance}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CustomerDetails;
```

---

### 🛠 Notes:

* All data is stored in the **local state** in `App.js`.
* Navigation is handled using **React Router v6**.
* No backend or external libraries used.

