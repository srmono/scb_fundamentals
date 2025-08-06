### But if you want to use **Bootstrap directly**, here’s what you can do:

---

### 1️⃣ Install Bootstrap and classnames:

```bash
npm install bootstrap
```

```bash
npm install classnames
```

### 2️⃣ Import Bootstrap in `index.js` or `App.js`:

```js
import 'bootstrap/dist/css/bootstrap.min.css';
```

---

### 3️⃣ Update the Form Code (Bootstrap Classes):

```jsx
import React, { useState } from 'react';
import classNames from 'classnames';

const AddCustomerForm = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    phone: ''
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const validate = () => {
    const newErrors = {};
    if (!formData.firstName.trim()) newErrors.firstName = 'First Name can\'t be empty';
    if (!formData.lastName.trim()) newErrors.lastName = 'Last Name can\'t be empty';
    if (!formData.email.trim()) newErrors.email = 'Email can\'t be empty';
    return newErrors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const validationErrors = validate();
    setErrors(validationErrors);

    if (Object.keys(validationErrors).length === 0) {
      alert('Form submitted successfully!');
      console.log(formData);
      setFormData({ firstName: '', lastName: '', email: '', phone: '' });
    }
  };

  return (
    <div className="container mt-4">
      <h2>Add Customer</h2>
      <form onSubmit={handleSubmit} noValidate>
        <div className="mb-3">
          <label className="form-label">First Name</label>
          <input
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
            className={classNames('form-control', { 'is-invalid': errors.firstName })}
          />
          {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>}
        </div>

        <div className="mb-3">
          <label className="form-label">Last Name</label>
          <input
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
            className={classNames('form-control', { 'is-invalid': errors.lastName })}
          />
          {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>}
        </div>

        <div className="mb-3">
          <label className="form-label">Email</label>
          <input
            name="email"
            value={formData.email}
            onChange={handleChange}
            className={classNames('form-control', { 'is-invalid': errors.email })}
          />
          {errors.email && <div className="invalid-feedback">{errors.email}</div>}
        </div>

        <div className="mb-3">
          <label className="form-label">Phone</label>
          <input
            name="phone"
            value={formData.phone}
            onChange={handleChange}
            className="form-control"
          />
        </div>

        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
};

export default AddCustomerForm;
```

---

### Bootstrap Classes I Used:

| Field                  | Class Applied                        | Purpose                         |
| ---------------------- | ------------------------------------ | ------------------------------- |
| `.form-control`        | Input fields                         | Bootstrap input styling         |
| `.is-invalid`          | Input fields when error exists       | Highlights in red               |
| `.invalid-feedback`    | Error message block                  | Bootstrap error message styling |
| `.form-label`, `.mb-3` | For proper spacing and label styling |                                 |

---

### Result:

* It will look **exactly like Bootstrap’s validation form**.
* No custom CSS needed, Bootstrap handles borders, margins, and error styles.

