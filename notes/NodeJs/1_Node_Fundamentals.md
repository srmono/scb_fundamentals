# **Node.js Fundamentals (Step-by-Step Guide for Beginners)**

---

## **1. What is Node.js?**

* **Node.js** is a **runtime environment** that allows you to run **JavaScript on the server-side**.
* It's built on **Chrome's V8 JavaScript engine**.
* It allows you to build **scalable network applications**.

---

## **2. Install Node.js**

* Go to [https://nodejs.org/](https://nodejs.org/)
* Download the **LTS version** (Long-Term Support).
* After installation:

  ```bash
  node -v     # Check Node.js version
  npm -v      # Check npm (Node Package Manager) version
  ```

---

## **3. Your First Node.js Program**

* Create a file called `app.js`:

  ```js
  console.log("Hello, Node.js!");
  ```
* Run it in the terminal:

  ```bash
  node app.js
  ```

---

## **4. Node.js Core Modules**

Node.js comes with built-in modules. Example: `fs`, `http`, `path`, etc.

### Example: Read a file using `fs` module

```js
const fs = require('fs');

fs.readFile('example.txt', 'utf8', (err, data) => {
  if (err) throw err;
  console.log(data);
});
```

---

## **5. Create a Simple Web Server**

```js
const http = require('http');

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello World\n');
});

server.listen(3000, () => {
  console.log('Server running at http://localhost:3000/');
});
```

* Run:

  ```bash
  node app.js
  ```
* Visit: [http://localhost:3000](http://localhost:3000)

---

## **6. Understanding npm (Node Package Manager)**

* Initialize a project:

  ```bash
  npm init -y
  ```
* Install a package:

  ```bash
  npm install moment
  ```
* Use it in your project:

  ```js
  const moment = require('moment');
  console.log(moment().format('MMMM Do YYYY, h:mm:ss a'));
  ```

---

## **7. Exporting & Importing Modules**

### Create your own module:

**math.js**

```js
function add(a, b) {
  return a + b;
}

module.exports = add;
```

**app.js**

```js
const add = require('./math');
console.log(add(5, 3));
```

---

## **8. Introduction to Express.js (Mini Framework on Node.js)**

* Install Express:

  ```bash
  npm install express
  ```
* Basic Express Server:

  ```js
  const express = require('express');
  const app = express();

  app.get('/', (req, res) => {
    res.send('Hello Express!');
  });

  app.listen(3000, () => {
    console.log('Server running on port 3000');
  });
  ```

---

## **9. Understanding Asynchronous Nature**

Node.js is **non-blocking** and uses **callbacks, promises, and async/await**.

### Example with Promises:

```js
const fs = require('fs').promises;

async function readFile() {
  try {
    const data = await fs.readFile('example.txt', 'utf8');
    console.log(data);
  } catch (err) {
    console.error(err);
  }
}

readFile();
```

---

## **10. Basic Folder Structure for a Node.js App**

```
my-app/
│
├── node_modules/
├── routes/
│   └── userRoutes.js
├── app.js
├── package.json
└── README.md
```

---

## **Next Steps After Fundamentals**

* Learn **Middleware in Express**.
* Learn how to work with **APIs (REST API)**.
* Understand **MongoDB** integration (MERN Stack).
* Learn about **Environment Variables (dotenv)**.


