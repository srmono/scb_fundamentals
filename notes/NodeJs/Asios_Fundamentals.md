Step-by-step, starting with **Axios basics** before moving into the React integration.

---

## **1. What is Axios?**

Axios is a **JavaScript library** for making HTTP requests from:

* The **browser** (frontend, like React)
* **Node.js** (backend)

Think of it as a more powerful alternative to the built-in `fetch()` function.
Why developers like Axios:

* ✅ Simpler syntax than `fetch`
* ✅ Supports **interceptors** (code that runs before/after every request)
* ✅ Supports **automatic JSON parsing**
* ✅ Supports request **cancellation**
* ✅ Built-in support for **timeout** and custom headers

---

## **2. Axios Basic Syntax**

**GET request**

```js
import axios from 'axios';

axios.get('https://jsonplaceholder.typicode.com/posts')
  .then(response => {
    console.log(response.data); // actual API data
  })
  .catch(error => {
    console.error(error);
  });
```

**POST request**

```js
axios.post('https://jsonplaceholder.typicode.com/posts', {
    title: 'Hello World',
    body: 'This is a new post',
    userId: 1
  })
  .then(response => {
    console.log(response.data); // created object
  })
  .catch(error => {
    console.error(error);
  });
```

---

## **3. Axios + React Example Project**

We’ll build a **Todo app** that can:

* **GET** todos
* **POST** new todos
* **PUT** to update todos
* **DELETE** todos

API: [https://jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com)

---

### **File 1 — `src/api/axios.js`**

Create a reusable Axios instance so you don’t repeat settings for every request.

```js
// src/api/axios.js
import axios from 'axios';

export default axios.create({
  baseURL: 'https://jsonplaceholder.typicode.com',
});
```

---

### **File 2 — `src/hooks/useTodos.js`**

Custom hook to handle fetching and updating todos.

```js
// src/hooks/useTodos.js
import { useState, useEffect } from 'react';
import api from '../api/axios';

export default function useTodos() {
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  // GET todos
  useEffect(() => {
    const fetchTodos = async () => {
      setLoading(true);
      try {
        const res = await api.get('/todos?_limit=5');
        setTodos(res.data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };
    fetchTodos();
  }, []);

  // POST new todo
  const addTodo = async (title) => {
    try {
      const res = await api.post('/todos', {
        title,
        completed: false,
      });
      setTodos([res.data, ...todos]);
    } catch (err) {
      console.error(err);
    }
  };

  // PUT (update todo)
  const toggleTodo = async (id) => {
    const todo = todos.find(t => t.id === id);
    try {
      const res = await api.put(`/todos/${id}`, {
        ...todo,
        completed: !todo.completed
      });
      setTodos(todos.map(t => t.id === id ? res.data : t));
    } catch (err) {
      console.error(err);
    }
  };

  // DELETE
  const deleteTodo = async (id) => {
    try {
      await api.delete(`/todos/${id}`);
      setTodos(todos.filter(t => t.id !== id));
    } catch (err) {
      console.error(err);
    }
  };

  return { todos, loading, error, addTodo, toggleTodo, deleteTodo };
}
```

---

### **File 3 — `src/components/TodoForm.jsx`**

```jsx
// src/components/TodoForm.jsx
import { useState } from 'react';

export default function TodoForm({ onAdd }) {
  const [text, setText] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!text.trim()) return;
    onAdd(text);
    setText('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="Enter todo..."
      />
      <button type="submit">Add</button>
    </form>
  );
}
```

---

### **File 4 — `src/components/TodoList.jsx`**

```jsx
// src/components/TodoList.jsx
export default function TodoList({ todos, onToggle, onDelete }) {
  return (
    <ul>
      {todos.map(todo => (
        <li key={todo.id}>
          <input
            type="checkbox"
            checked={todo.completed}
            onChange={() => onToggle(todo.id)}
          />
          {todo.title}
          <button onClick={() => onDelete(todo.id)}>Delete</button>
        </li>
      ))}
    </ul>
  );
}
```

---

### **File 5 — `src/App.jsx`**

```jsx
// src/App.jsx
import useTodos from './hooks/useTodos';
import TodoForm from './components/TodoForm';
import TodoList from './components/TodoList';

export default function App() {
  const { todos, loading, error, addTodo, toggleTodo, deleteTodo } = useTodos();

  return (
    <div style={{ padding: 20 }}>
      <h1>Axios + React Todo App</h1>

      <TodoForm onAdd={addTodo} />

      {loading && <p>Loading...</p>}
      {error && <p style={{ color: 'red' }}>{error}</p>}

      <TodoList todos={todos} onToggle={toggleTodo} onDelete={deleteTodo} />
    </div>
  );
}
```

---

## **4. How Axios fits into React**

* Axios replaces `fetch()` but with **easier syntax and extra features**.
* We can create a single `api` instance and use it **everywhere** in the app.
* It’s common to wrap API logic inside **custom hooks** so components stay clean.
* Axios’ `.get()`, `.post()`, `.put()`, `.delete()` map directly to HTTP methods.

---
# Axios Core Concepts

## **1. What is Axios?**

Axios is a **JavaScript HTTP client** — basically, it’s how your code talks to APIs over the internet.
It works both:

* **In the browser** (for frontend apps like React, Vue, plain JS)
* **In Node.js** (for backend scripts or servers)

It’s a bit like a **phone** for your app — you dial a URL, send a message, and get a reply.

---

## **2. Installing Axios**

In a Node.js or frontend project:

```bash
npm install axios
```

Or via CDN (browser without bundler):

```html
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
```

---

## **3. Basic Requests**

### **GET — fetch data**

```js
import axios from 'axios';

axios.get('https://jsonplaceholder.typicode.com/posts')
  .then(response => {
    console.log(response.data); // The real API data
  })
  .catch(error => {
    console.error(error.message);
  });
```

---

### **POST — send data**

```js
axios.post('https://jsonplaceholder.typicode.com/posts', {
    title: 'Hello World',
    body: 'This is a new post',
    userId: 1
  })
  .then(response => {
    console.log(response.data); // New object created
  })
  .catch(error => {
    console.error(error.message);
  });
```

---

### **PUT — replace data**

```js
axios.put('https://jsonplaceholder.typicode.com/posts/1', {
    id: 1,
    title: 'Updated Title',
    body: 'Updated body',
    userId: 1
  })
  .then(response => {
    console.log(response.data);
  });
```

---

### **PATCH — update part of data**

```js
axios.patch('https://jsonplaceholder.typicode.com/posts/1', {
    title: 'Only title updated'
  })
  .then(response => {
    console.log(response.data);
  });
```

---

### **DELETE — remove data**

```js
axios.delete('https://jsonplaceholder.typicode.com/posts/1')
  .then(() => {
    console.log('Deleted successfully');
  });
```

---

## **4. Async/Await Style**

Instead of `.then()` and `.catch()`, you can use async/await:

```js
import axios from 'axios';

async function getPosts() {
  try {
    const res = await axios.get('https://jsonplaceholder.typicode.com/posts');
    console.log(res.data);
  } catch (err) {
    console.error(err.message);
  }
}

getPosts();
```

---

## **5. Sending Query Parameters**

```js
axios.get('https://jsonplaceholder.typicode.com/posts', {
  params: { userId: 1 }
})
.then(res => console.log(res.data));
```

This sends:
`https://jsonplaceholder.typicode.com/posts?userId=1`

---

## **6. Custom Headers**

```js
axios.get('https://jsonplaceholder.typicode.com/posts', {
  headers: {
    'Authorization': 'Bearer my-token',
    'Content-Type': 'application/json'
  }
});
```

---

## **7. Axios Instance**

Instead of writing the base URL in every request, create a reusable instance:

```js
import axios from 'axios';

const api = axios.create({
  baseURL: 'https://jsonplaceholder.typicode.com',
  timeout: 5000, // 5 seconds
  headers: { 'Content-Type': 'application/json' }
});

api.get('/posts').then(res => console.log(res.data));
```

---

## **8. Interceptors**

Interceptors run code **before** a request is sent or **after** a response is received.

```js
api.interceptors.request.use(config => {
  console.log('Request sent at:', new Date());
  return config;
});

api.interceptors.response.use(response => {
  console.log('Response received with status:', response.status);
  return response;
});
```

---

## **9. Cancelling Requests**

If a request takes too long or the user navigates away, you can cancel it:

```js
const controller = new AbortController();

axios.get('https://jsonplaceholder.typicode.com/posts', {
  signal: controller.signal
}).catch(err => {
  if (err.name === 'CanceledError') {
    console.log('Request canceled');
  }
});

setTimeout(() => controller.abort(), 100); // cancel after 100ms
```

---

## **10. Error Handling**

Axios errors have three main parts:

```js
try {
  await axios.get('/wrong-url');
} catch (err) {
  if (err.response) {
    // Server responded with an error status
    console.log('Server Error:', err.response.status);
  } else if (err.request) {
    // No response was received
    console.log('Network Error:', err.message);
  } else {
    // Something else happened
    console.log('Error:', err.message);
  }
}
```

---

## **Key Points to Remember**

1. **Axios is promise-based** — you use `.then()`/`.catch()` or async/await.
2. Use **axios instances** to avoid repeating config.
3. Always handle **errors** gracefully.
4. Use **interceptors** for auth tokens or logging.
5. You can **cancel requests** to improve performance.

