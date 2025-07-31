## Ways to create functions  **Function Declaration** and **Function Expression**

---

## ✅ 1. **Function Declaration (`function greetUser() {}`)**

### 🔷 Definition:

A **function declaration** creates a function with a name that can be called anywhere in its scope — **even before it's defined**, thanks to hoisting.

### 🔷 Example:

```js
greetUser();  // ✅ This works due to hoisting

function greetUser() {
  console.log("Welcome to our website!");
}
```

### 🔷 Use Case:

When you want to define a **reusable function** like showing a welcome message, calculating total price, etc., and want it accessible throughout the scope.

---

## ✅ 2. **Function Expression (`var calculateTotal = function() {}`)**

### 🔷 Definition:

A **function expression** defines a function and assigns it to a variable. Only the variable name is hoisted, **not the function** — so you can’t call it before it’s defined.

### 🔷 Example:

```js
calculateTotal();  // ❌ Error: calculateTotal is not a function

var calculateTotal = function() {
  console.log("Calculating total cost of cart items...");
};
```

### 🔷 Use Case:

Useful when you want to define a function conditionally, pass it as an argument, or keep it scoped more tightly. Common in **event handlers** or **callbacks**.

---

## ⚠️ Difference in Hoisting — Side by Side

```js
// Function Declaration
console.log(addNumbers(10, 5));  // ✅ Works

function addNumbers(a, b) {
  return a + b;
}

// Function Expression
// console.log(subtractNumbers(10, 5)); // ❌ Error: subtractNumbers is not a function

var subtractNumbers = function(a, b) {
  return a - b;
};
```

---

## ✅ Summary (Updated with Real Use Names)

| Feature            | `function greetUser() {}`                            | `var calculateTotal = function() {}`                 |
| ------------------ | ---------------------------------------------------- | ---------------------------------------------------- |
| Hoisting           | ✅ Fully hoisted (can call before defined)            | ❌ Not hoisted with function body                     |
| Name               | Fixed name (`greetUser`)                             | Variable can be renamed or reassigned                |
| Use Before Declare | ✅ Yes                                                | ❌ No                                                 |
| Real Use Case      | Utility methods like `validateForm()`, `showAlert()` | Event handlers, callbacks like `onClick`, `onSubmit` |
| Stack Traces       | Clear function name shows in debugger                | Shows as anonymous unless named explicitly           |

