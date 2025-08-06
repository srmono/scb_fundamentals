# React Form Handling – Beginner Guide

---

## 1️⃣ **Fundamentals of Forms in React**

In React, forms are slightly different from regular HTML forms because React maintains its **own state**, and form fields are synced with state variables.

* **Controlled Components** → Form elements whose values are controlled via React `state`.
* **Uncontrolled Components** → Form elements managed by **Refs**, not React `state` (closer to traditional HTML form handling).

---

## 2️⃣ **Controlled Components**

### Key Idea: **State drives the input field's value.**

```jsx
import React, { useState } from 'react';

const ControlledForm = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: ''
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="firstName" value={formData.firstName} onChange={handleChange} placeholder="First Name" />
      <input name="lastName" value={formData.lastName} onChange={handleChange} placeholder="Last Name" />
      <input name="email" value={formData.email} onChange={handleChange} placeholder="Email" />
      <button type="submit">Submit</button>
    </form>
  );
};

export default ControlledForm;
```

---

## 3️⃣ **Uncontrolled Components**

### Key Idea: **Access form values directly via Refs.**

```jsx
import React, { useRef } from 'react';

const UncontrolledForm = () => {
  const firstNameRef = useRef(null);
  const lastNameRef = useRef(null);
  const emailRef = useRef(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(firstNameRef.current.value);
    console.log(lastNameRef.current.value);
    console.log(emailRef.current.value);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input ref={firstNameRef} placeholder="First Name" />
      <input ref={lastNameRef} placeholder="Last Name" />
      <input ref={emailRef} placeholder="Email" />
      <button type="submit">Submit</button>
    </form>
  );
};

export default UncontrolledForm;
```

---

## 4️⃣ **Form Validation with Error Messages & Dynamic Styling**

To style error messages dynamically, you can use the **classnames** package.

### Install classnames:

```bash
npm install classnames
```

### Example: Controlled Form with Validation & Styling

```jsx
import React, { useState } from 'react';
import classNames from 'classnames';
import './FormStyles.css';  // custom CSS

const FormWithValidation = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: ''
  });
  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const newErrors = {};
    if (!formData.firstName.trim()) newErrors.firstName = 'First Name can\'t be empty';
    if (!formData.lastName.trim()) newErrors.lastName = 'Last Name can\'t be empty';
    if (!formData.email.trim()) newErrors.email = 'Email can\'t be empty';

    setErrors(newErrors);

    if (Object.keys(newErrors).length === 0) {
      console.log('Form Submitted', formData);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <input
          name="firstName"
          value={formData.firstName}
          onChange={handleChange}
          placeholder="First Name"
          className={classNames({ 'has-error': errors.firstName })}
        />
        {errors.firstName && <div className="error-message">{errors.firstName}</div>}
      </div>

      <div>
        <input
          name="lastName"
          value={formData.lastName}
          onChange={handleChange}
          placeholder="Last Name"
          className={classNames({ 'has-error': errors.lastName })}
        />
        {errors.lastName && <div className="error-message">{errors.lastName}</div>}
      </div>

      <div>
        <input
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="Email"
          className={classNames({ 'has-error': errors.email })}
        />
        {errors.email && <div className="error-message">{errors.email}</div>}
      </div>

      <button type="submit">Submit</button>
    </form>
  );
};

export default FormWithValidation;
```

---

### Sample CSS (`FormStyles.css`)

```css
.has-error {
  border: 1px solid red;
}
.error-message {
  color: red;
  font-size: 0.8rem;
}
```

---

## 5️⃣ **Controlled vs Uncontrolled — Quick Difference**

| Aspect             | Controlled Components           | Uncontrolled Components                       |
| ------------------ | ------------------------------- | --------------------------------------------- |
| Value Management   | Controlled by React via `state` | Managed by the DOM, accessed via `refs`       |
| Data Source        | React State                     | DOM API                                       |
| Use Case           | Validation, Dynamic UI updates  | Simple forms, quick access without validation |
| Renders on Change? | Yes                             | No                                            |

---

## 🔑 **Key Takeaways**

* **Controlled** → React state is single source of truth.
* **Uncontrolled** → DOM handles values, React uses refs to read them.
* For **Validation + Dynamic Styling**, **classnames** package is handy.
* Clean UI feedback (errors, success) → enhances user experience.

---

