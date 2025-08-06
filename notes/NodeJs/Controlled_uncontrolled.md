
# **Controlled vs Uncontrolled Components in React (Simple Explanation + Code)**

---

## **Controlled Component = "You (React) Are In Control"**

### Analogy:

Think of a **remote-controlled car**.

* You press buttons to make it move.
* Every move is **under your control**.

Similarly, in React:

* The **input field's value is controlled by React state**.
* React always knows the **current value**.

### Full Example Code:

```jsx
import React, { useState } from 'react';

function ControlledInput() {
  const [name, setName] = useState("");

  const handleChange = (e) => {
    setName(e.target.value);
  };

  const handleSubmit = () => {
    alert(`You entered: ${name}`);
  };

  return (
    <div>
      <h2>Controlled Component</h2>
      <input type="text" value={name} onChange={handleChange} />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default ControlledInput;
```

### Key Points:

* **value={name}** → React controls the value.
* **onChange={handleChange}** → Every keystroke updates React state.
* React always knows what’s inside the input.

---

## 🔵 **Uncontrolled Component = "It Does Its Own Thing"**

### Analogy:

Think of a **wind-up toy car**.

* You wind it up and let it go.
* You don't control its every move.

Similarly, in React:

* The **input manages its own value**.
* React only checks the value **when needed** (e.g., on button click) using **ref**.

### Full Example Code:

```jsx
import React, { useRef } from 'react';

function UncontrolledInput() {
  const inputRef = useRef();

  const handleSubmit = () => {
    alert(`You entered: ${inputRef.current.value}`);
  };

  return (
    <div>
      <h2>Uncontrolled Component</h2>
      <input type="text" ref={inputRef} />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default UncontrolledInput;
```

### Key Points:

* No `value` or `onChange`.
* The input keeps its own value (just like plain HTML).
* React accesses the value **using a ref when it needs it**.

---

## ⚖️ **Controlled vs Uncontrolled — The Difference**

| Aspect                      | Controlled Component                           | Uncontrolled Component                      |
| --------------------------- | ---------------------------------------------- | ------------------------------------------- |
| **Who controls the value?** | React (using state)                            | The DOM (browser input keeps its own value) |
| **How to access value?**    | Always in React state                          | Accessed via `ref` when needed              |
| **onChange handler?**       | Required (to update React state)               | Not needed                                  |
| **Use case**                | You need to validate, format, or control input | Simple forms, read value only when needed   |

---

## 🧠 **Super Simple Analogy Recap:**

| Scenario                  | Controlled                                        | Uncontrolled                                   |
| ------------------------- | ------------------------------------------------- | ---------------------------------------------- |
| **Remote-controlled car** | You press buttons for every move (React controls) | Wind-up toy car moves on its own               |
| **Input box in React**    | React tracks every keystroke via state            | React checks input value only when it needs it |

