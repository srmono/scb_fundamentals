ES6 concept with simple and practical use cases:

---

###  1. `let` and `const` Keywords

```js
let age = 25;        // can be reassigned
age = 26;

const name = "Amit"; // cannot be reassigned
// name = "Ravi"; ❌ Error

console.log(`Name: ${name}, Age: ${age}`);
```

---

###  2. Arrow Functions

```js
// Traditional function
function greet(name) {
  return `Hello, ${name}`;
}

// Arrow function
const greetUser = (name) => `Hello, ${name}`;

console.log(greetUser("Hamsika"));
```

---

###  3. Class and Object

```js
class Car {
  constructor(brand, model) {
    this.brand = brand;
    this.model = model;
  }

  start() {
    return `${this.brand} ${this.model} is starting...`;
  }
}

const myCar = new Car("Toyota", "Innova");
console.log(myCar.start());
```

---

###  4. Destructuring

```js
const user = {
  username: "john123",
  age: 30,
  country: "India"
};

const { username, age } = user; // extracting properties
console.log(`Username: ${username}, Age: ${age}`);
```

---

###  5. Spread Operator

```js
const fruits = ["apple", "banana"];
const moreFruits = ["orange", ...fruits, "grape"];

console.log(moreFruits);
// Output: ["orange", "apple", "banana", "grape"]
```

---

###  6. Promises

```js
const fetchData = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Data fetched successfully!");
    }, 2000);
  });
};

fetchData().then((msg) => console.log(msg));
```

---

###  7. The Fetch API

```js
// Simple GET request
fetch("https://jsonplaceholder.typicode.com/posts/1")
  .then((response) => response.json())
  .then((data) => console.log("Post Title:", data.title))
  .catch((error) => console.error("Error:", error));
```

---

###  8. Import and Export

**mathUtils.js**

```js
// Exporting function
export const add = (a, b) => a + b;
```

**main.js**

```js
// Importing from another file
import { add } from './mathUtils.js';

console.log(add(5, 3)); // Output: 8
```

>  Make sure to use `type="module"` in HTML or a bundler like Webpack/Vite for import/export.


---

**complete HTML file** with all 8 core ES6 concepts demoed in one place. Just copy-paste this into an `.html` file and open it in your browser.

---

###  **`es6-demo.html`**

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>ES6 Concepts Demo</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    pre { background: #f0f0f0; padding: 10px; border-left: 4px solid #4CAF50; }
  </style>
</head>
<body>

  <h1>🔰 JavaScript ES6 Concepts</h1>

  <h2>1. let and const</h2>
  <pre id="letConst"></pre>

  <h2>2. Arrow Functions</h2>
  <pre id="arrowFunc"></pre>

  <h2>3. Classes and Objects</h2>
  <pre id="classObj"></pre>

  <h2>4. Destructuring</h2>
  <pre id="destructuring"></pre>

  <h2>5. Spread Operator</h2>
  <pre id="spreadOp"></pre>

  <h2>6. Promises</h2>
  <pre id="promiseOut">Loading promise result...</pre>

  <h2>7. Fetch API</h2>
  <pre id="fetchApi">Fetching post title...</pre>

  <h2>8. Modules (Code shown only, not runnable here)</h2>
  <pre>
  // mathUtils.js
  export const add = (a, b) => a + b;

  // main.js
  import { add } from './mathUtils.js';
  console.log(add(5, 3));
  </pre>

  <script>
    // 1. let and const
    let age = 30;
    const name = "Hamsika";
    age = 31;
    document.getElementById("letConst").textContent = `Name: ${name}, Age: ${age}`;

    // 2. Arrow Functions
    const greet = (user) => `Hello, ${user}!`;
    document.getElementById("arrowFunc").textContent = greet("Developer");

    // 3. Class and Object
    class Car {
      constructor(brand, model) {
        this.brand = brand;
        this.model = model;
      }
      start() {
        return `${this.brand} ${this.model} is starting...`;
      }
    }
    const myCar = new Car("Mahindra", "XUV700");
    document.getElementById("classObj").textContent = myCar.start();

    // 4. Destructuring
    const user = { username: "john_doe", age: 28, city: "Mumbai" };
    const { username, age: userAge } = user;
    document.getElementById("destructuring").textContent = `User: ${username}, Age: ${userAge}`;

    // 5. Spread Operator
    const nums1 = [1, 2];
    const nums2 = [3, 4];
    const combined = [...nums1, ...nums2];
    document.getElementById("spreadOp").textContent = `Combined: ${combined.join(", ")}`;

    // 6. Promises
    const getData = () => {
      return new Promise((resolve) => {
        setTimeout(() => {
          resolve(" Promise resolved after 2 sec");
        }, 2000);
      });
    };
    getData().then(data => {
      document.getElementById("promiseOut").textContent = data;
    });

    // 7. Fetch API
    fetch("https://jsonplaceholder.typicode.com/posts/1")
      .then(res => res.json())
      .then(post => {
        document.getElementById("fetchApi").textContent = `Post Title: ${post.title}`;
      })
      .catch(err => {
        document.getElementById("fetchApi").textContent = "❌ Error fetching post";
      });
  </script>

</body>
</html>
```

