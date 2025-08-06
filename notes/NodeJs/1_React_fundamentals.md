## 📚 **React Fundamentals Examples for Beginners**

### 1. **Hello World Component (Very Basic Component)**

```jsx
const HelloWorld = () => {
  return <h1>Hello World</h1>;
};

export default HelloWorld;
```



---

### 2. **Props Basics (Single & Multiple Props)**

```jsx
const Greeting = ({ name, message = "Hi, Hello!" }) => {
  return <p>Message from {name}: {message}</p>;
};

// Usage:
<Greeting name="Euler" />    // message prop missing (uses default)
<Greeting name="Ramanujam" message="I got this in my dreams" />
```

---

### 3. **State & Counter Example**

```jsx
import React, { useState, useEffect } from 'react';

const Counter = () => {
  const [seconds, setSeconds] = useState(0);

  useEffect(() => {
    const timer = setInterval(() => setSeconds((prev) => prev + 1), 1000);
    return () => clearInterval(timer);
  }, []);

  return <h2>Time Elapsed: {seconds}</h2>;
};

export default Counter;
```

## 🔍 **What is Virtual DOM in React?**

* The **DOM (Document Object Model)** represents the UI of your web application.
* **Manipulating the real DOM** (adding elements, updating content, etc.) is **slow and costly**, especially when you’re making frequent changes.
* **React introduces a Virtual DOM**, which is a **lightweight JavaScript representation of the Real DOM**.
* When state/props change:

  1. React **updates the Virtual DOM first**.
  2. It **compares (diffing)** the new Virtual DOM with the previous version.
  3. It then updates the **real DOM efficiently (reconciliation)** by making **minimal changes**.

---

## 🧠 **Key Points:**

| Virtual DOM                      | Real DOM                            |
| -------------------------------- | ----------------------------------- |
| In-memory copy of UI (JS Object) | Actual elements rendered in browser |
| Fast to update                   | Slower to update                    |
| React diffs & batches updates    | Direct manipulation per change      |

---

## 🧑‍💻 **Simple Example to "See" Virtual DOM in Action**

Here's a **Counter Example** which triggers **state changes frequently** — React will **update Virtual DOM first and then update Real DOM smartly**.

```jsx
import React, { useState } from 'react';
import ReactDOM from 'react-dom';

const VirtualDOMExample = () => {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(count + 1);
  };

  console.log('Virtual DOM re-rendering...');

  return (
    <div>
      <h2>Counter: {count}</h2>
      <button onClick={increment}>Increment</button>
    </div>
  );
};

ReactDOM.render(<VirtualDOMExample />, document.getElementById('root'));
```

### Explanation:

* Every time you click **Increment**, React:

  1. Updates the **Virtual DOM**.
  2. Compares with the previous Virtual DOM snapshot.
  3. Updates only the changed part in the **Real DOM** (in this case, the counter number).

You’ll notice that **console.log** runs on each re-render, but React only touches what’s necessary in the **real DOM** — thanks to the **Virtual DOM diffing & reconciliation process**.

---

## 🛠️ **How to See Virtual DOM in DevTools?**

1. Install **React Developer Tools** browser extension.
2. Inspect React Components tree.
3. You can see the **component re-rendering in the virtual component tree**.
4. React efficiently syncs those changes to the **real DOM**.

---

## 🌟 Summary:

* **Virtual DOM** is an optimization technique.
* It allows React to **batch updates, diff efficiently, and minimize direct DOM operations**.
* This results in **fast UI updates** even when underlying data changes frequently.

---


---

### 4. **Event Handling (Button Click Alert)**

```jsx
const AlertButton = () => {
  const showAlert = () => {
    alert("React is a great UI library");
  };

  return <button onClick={showAlert}>Click Me Please</button>;
};

export default AlertButton;
```

---

### 5. **Conditional Rendering**

```jsx
const UserGreeting = ({ isLoggedIn }) => {
  return (
    <>
      {isLoggedIn ? <h2>Welcome Back!</h2> : <h2>Please Log In</h2>}
    </>
  );
};
```

---

### 6. **List Rendering with `map`**

```jsx
const FruitsList = () => {
  const fruits = ['Apple', 'Banana', 'Cherry'];

  return (
    <ul>
      {fruits.map((fruit, index) => (
        <li key={index}>{fruit}</li>
      ))}
    </ul>
  );
};
```

---

### 7. **Form Handling (Controlled Components)**

```jsx
const SimpleForm = () => {
  const [input, setInput] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`You typed: ${input}`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input value={input} onChange={(e) => setInput(e.target.value)} />
      <button type="submit">Submit</button>
    </form>
  );
};
```

---

### 8. **Two-Way Binding (Real-time Input Reflection)**

```jsx
const MirrorInput = () => {
  const [text, setText] = useState('');

  return (
    <>
      <input value={text} onChange={(e) => setText(e.target.value)} />
      <p>You typed: {text}</p>
    </>
  );
};
```

---

### 9. **Parent-Child Component Communication**

```jsx
const Child = ({ onGreet }) => {
  return <button onClick={onGreet}>Greet Parent</button>;
};

const Parent = () => {
  const greet = () => {
    alert("Hello from Child to Parent!");
  };

  return <Child onGreet={greet} />;
};
```

---

### 10. **Component Composition (Children Props)**

```jsx
const Card = ({ children }) => {
  return <div style={{ border: '1px solid black', padding: '10px' }}>{children}</div>;
};

// Usage:
<Card>
  <h2>This is inside a Card!</h2>
</Card>
```

---

### 11. **useEffect with API Call Simulation**

```jsx
import React, { useState, useEffect } from 'react';

const FetchData = () => {
  const [data, setData] = useState('Loading...');

  useEffect(() => {
    setTimeout(() => {
      setData('Fetched Data from API!');
    }, 2000);
  }, []);

  return <p>{data}</p>;
};
```

---

### 12. **Lifting State Up**

```jsx
const ChildInput = ({ onInputChange }) => (
  <input onChange={(e) => onInputChange(e.target.value)} />
);

const ParentComponent = () => {
  const [data, setData] = useState('');
  return (
    <>
      <ChildInput onInputChange={setData} />
      <p>Child typed: {data}</p>
    </>
  );
};
```

---

### 13. **Basic Conditional Component (Show/Hide Toggle)**

```jsx
const ToggleComponent = () => {
  const [show, setShow] = useState(true);

  return (
    <>
      <button onClick={() => setShow(!show)}>
        {show ? "Hide" : "Show"} Text
      </button>
      {show && <p>This text will toggle visibility</p>}
    </>
  );
};
```

---

## This covers:

✅ Functional Components
✅ Props (defaultProps, multiple props)
✅ State (`useState`)
✅ Effects (`useEffect`)
✅ Event Handling
✅ Conditional Rendering
✅ List Rendering
✅ Forms (Controlled Inputs)
✅ Parent-Child Communication
✅ Component Composition
✅ Lifting State Up

