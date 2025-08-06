## What are `async` and `await` in JavaScript?

* `async` makes a function return a **Promise**.
* `await` pauses the function **until the Promise is resolved**, without blocking the rest of the code.
* Great for writing cleaner and more readable **asynchronous code** (like fetching data from an API).

---

## Step-by-step Explanation with Examples

---

### Step 1: Normal (synchronous) function

```js
function greet() {
  console.log("Hello");
  console.log("World");
}

greet();
```

**Output:**

```
Hello
World
```

---

###  Step 2: Simulating a delay using `setTimeout` (callback style)

```js
function greet() {
  console.log("Hello");
  setTimeout(() => {
    console.log("Waited 2 seconds");
  }, 2000);
  console.log("World");
}

greet();
```

**Output:**

```
Hello
World
Waited 2 seconds
```

This is hard to read and gets worse with **nested callbacks** (called "callback hell").

---

###  Step 3: Same logic using `Promise`

```js
function waitTwoSeconds() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve("Waited 2 seconds");
    }, 2000);
  });
}

waitTwoSeconds().then(msg => {
  console.log(msg);
});
```

---

###  Step 4: Using `async` and `await`

```js
function waitTwoSeconds() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve("Waited 2 seconds");
    }, 2000);
  });
}

async function greet() {
  console.log("Hello");
  const message = await waitTwoSeconds(); // Pause here until promise is resolved
  console.log(message);
  console.log("World");
}

greet();
```

**Output:**

```
Hello
(wait 2 seconds)
Waited 2 seconds
World
```

🎯 Much cleaner and easier to read than `.then()`!

---

###  Step 5: Run multiple async tasks

```js
function delay(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

async function task(name, time) {
  console.log(`${name} started`);
  await delay(time);
  console.log(`${name} finished after ${time}ms`);
}

async function runTasks() {
  await Promise.all([
    task("Task 1", 2000),
    task("Task 2", 3000),
  ]);
  console.log("All tasks done");
}

runTasks();
```

**Output:**

```
Task 1 started
Task 2 started
Task 1 finished after 2000ms
Task 2 finished after 3000ms
All tasks done
```

---

##  Summary

| Keyword        | What it does                                                        |
| -------------- | ------------------------------------------------------------------- |
| `async`        | Marks a function as asynchronous (returns a Promise)                |
| `await`        | Pauses the async function until the Promise resolves                |
| `Promise`      | An object that represents future completion/failure of an operation |
| `setTimeout()` | Delays code execution (simulated async task)                        |

---

##  When to use

* Fetching data from an API (`fetch`)
* Timers or delays
* Reading files in Node.js
* Any async operation where you’d use `.then()` or callbacks

