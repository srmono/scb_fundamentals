### ✅ **Parent to Child** communication using **Props**

### ✅ **Child to Parent** communication using a **Callback Function**

---

## 🧠 Concept Recap

* **Parent to Child (Props):**

  * The parent component sends data down using props.

* **Child to Parent (Callback):**

  * The child calls a function passed by the parent to send data back up.

---

## 🔧 Example: `App` ➝ `MessageSender` ➝ `App`

### 📝 What We’ll Build

A parent component (`App`) sends a **username** to a child component (`MessageSender`), and the child sends back a **message** to the parent.

---

### 📄 `App.jsx` (Parent Component)

```jsx
import React, { useState } from 'react';
import MessageSender from './MessageSender';

function App() {
  const [message, setMessage] = useState('');

  const username = 'John Doe'; // Parent to child

  // This function will be passed to child
  const handleMessageFromChild = (msg) => {
    setMessage(msg); // Child to parent
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h1>React Communication</h1>

      {/* Display message from child */}
      <h2>Message from Child: {message}</h2>

      {/* Pass data and callback */}
      <MessageSender user={username} onSendMessage={handleMessageFromChild} />
    </div>
  );
}

export default App;
```

---

### 📄 `MessageSender.jsx` (Child Component)

```jsx
import React, { useState } from 'react';

function MessageSender({ user, onSendMessage }) {
  const [input, setInput] = useState('');

  const handleClick = () => {
    onSendMessage(input); // Send message to parent
    setInput(''); // Clear after sending
  };

  return (
    <div>
      <h3>Hello, {user} 👋</h3>
      <input
        type="text"
        value={input}
        onChange={(e) => setInput(e.target.value)}
        placeholder="Type your message"
      />
      <button onClick={handleClick} style={{ marginLeft: '10px' }}>
        Send to Parent
      </button>
    </div>
  );
}

export default MessageSender;
```

---

### 🔄 Communication Flow Summary

| Direction       | What Happens                                                    |
| --------------- | --------------------------------------------------------------- |
| Parent ➝ Child  | `App` sends `user` and `onSendMessage` props to `MessageSender` |
| Child ➝ Parent  | `MessageSender` uses `onSendMessage(input)` to send data up     |
| State in Parent | Message is stored in parent state (`message`)                   |
| State in Child  | Input field value managed in child state (`input`)              |

---

### ✅ Output Example

```
React Communication
Message from Child: Hello, React!

Hello, John Doe 👋
[ Hello, React! ] [Send to Parent]
```

---

### 💡 How to Run

1. Create a new React project or open an existing one.
2. Create `App.jsx` and `MessageSender.jsx` files inside `src/`.
3. Make sure `App.jsx` imports and uses `MessageSender`.
4. Run:

```bash
npm start
```

