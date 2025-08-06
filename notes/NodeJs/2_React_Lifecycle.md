## 🚦 **React Component Lifecycle with Hooks**

Traditionally, React Class components had lifecycle methods like:

* `componentDidMount`
* `componentDidUpdate`
* `componentWillUnmount`

In **functional components**, **React Hooks** like `useEffect` allow us to handle these lifecycle events.

---

## 🧩 **Lifecycle Mapping (Class Component → Functional Component with Hooks)**

| **Lifecycle Phase**          | **Class Component Method** | **Functional Component Hook**                  |
| ---------------------------- | -------------------------- | ---------------------------------------------- |
| Mounting (Component Created) | `componentDidMount`        | `useEffect(() => {...}, [])`                   |
| Updating (on props/state)    | `componentDidUpdate`       | `useEffect(() => {...}, [dependency])`         |
| Unmounting (Cleanup)         | `componentWillUnmount`     | `useEffect(() => { return () => {...} }, [])`  |
| On every render              | (No specific method)       | `useEffect(() => {...})` (no dependency array) |

---

1. **Mounting (componentDidMount)**
2. **Updating (componentDidUpdate)**
3. **Unmounting with Cleanup (componentWillUnmount)**

I’ll use a **realistic example** where:

* We **set up a timer on mount**.
* We **update state every second**.
* We **clear the timer on unmount** to prevent memory leaks.

---

## 🧑‍💻 **React Lifecycle with Cleanup using Hooks Example**

```jsx
import React, { useState, useEffect } from 'react';

const TimerComponent = () => {
  const [seconds, setSeconds] = useState(0);

  // Runs on Mount and Cleanup on Unmount
  useEffect(() => {
    console.log('Component Mounted. Timer Started.');

    const timer = setInterval(() => {
      setSeconds((prev) => prev + 1);
    }, 1000);

    // Cleanup function (componentWillUnmount)
    return () => {
      clearInterval(timer);
      console.log('Component Unmounted. Timer Cleared.');
    };
  }, []);  // Empty dependency array → runs only on mount and unmount

  // Runs on every seconds update (componentDidUpdate)
  useEffect(() => {
    console.log(`Seconds Updated: ${seconds}`);
  }, [seconds]);

  return (
    <div>
      <h2>Timer: {seconds} seconds</h2>
    </div>
  );
};

export default TimerComponent;
```

---

## 🧠 **What’s Happening?**

| Part                                    | Description                                                            |
| --------------------------------------- | ---------------------------------------------------------------------- |
| `useEffect(() => { ... }, [])`          | Runs **once when mounted**, sets up the timer.                         |
| `return () => { clearInterval(timer) }` | Runs **when component unmounts**, clears the timer (cleanup).          |
| `useEffect(() => { ... }, [seconds])`   | Runs **every time seconds state updates** (like `componentDidUpdate`). |

---

## 🧪 **Test Unmounting Cleanup**

You can test this by conditionally rendering the component:

```jsx
import React, { useState } from 'react';
import TimerComponent from './TimerComponent';

const App = () => {
  const [showTimer, setShowTimer] = useState(true);

  return (
    <div>
      <button onClick={() => setShowTimer(!showTimer)}>
        {showTimer ? 'Stop Timer' : 'Start Timer'}
      </button>
      {showTimer && <TimerComponent />}
    </div>
  );
};

export default App;
```

* Click **Stop Timer** → You should see `Component Unmounted. Timer Cleared.` in console.
* Click **Start Timer** → Timer starts again.

---

## 🟢 Summary of Lifecycle with Hooks + Cleanup:

| Lifecycle Phase          | Hook Usage                                      |
| ------------------------ | ----------------------------------------------- |
| Mounting                 | `useEffect(() => { ... }, [])`                  |
| Updating (on state/prop) | `useEffect(() => { ... }, [dependency])`        |
| Unmounting (Cleanup)     | `useEffect(() => { return () => { ... } }, [])` |

---
