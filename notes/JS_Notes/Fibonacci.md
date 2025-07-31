
### ✅ Task 1: Display the first 10 Fibonacci numbers

### ✅ Task 2: Display the multiplication table of 8

---

### 💻 Full Working Code (Copy & Run)

```html
<!DOCTYPE html>
<html>
<head>
  <title>Fibonacci & Table of 8</title>
</head>
<body>
  <h2>Hands-on: Variables and Functions</h2>

  <h3>Fibonacci Series (First 10 Numbers)</h3>
  <button onclick="generateFibonacci()">Show Fibonacci Series</button>
  <p id="fibonacciOutput"></p>

  <h3>Multiplication Table of 8</h3>
  <button onclick="generateTableOfEight()">Show Table of 8</button>
  <ul id="tableOutput"></ul>

  <script>
    // Function to display the first 10 Fibonacci numbers
    function generateFibonacci() {
      var fib1 = 0;
      var fib2 = 1;
      var nextTerm;
      var result = fib1 + ", " + fib2;

      for (var i = 3; i <= 10; i++) {
        nextTerm = fib1 + fib2;
        result += ", " + nextTerm;
        fib1 = fib2;
        fib2 = nextTerm;
      }

      document.getElementById("fibonacciOutput").innerText = result;
    }

    // Function to display the multiplication table of 8
    function generateTableOfEight() {
      var tableList = document.getElementById("tableOutput");
      tableList.innerHTML = ""; // Clear previous results

      for (var i = 1; i <= 10; i++) {
        var result = 8 * i;
        var listItem = document.createElement("li");
        listItem.textContent = "8 x " + i + " = " + result;
        tableList.appendChild(listItem);
      }
    }
  </script>
</body>
</html>
```

---

### 🧠 Explanation

* **No ES6 or map** is used — only basic loops, variables, and DOM manipulation.
* Functions:

  * `generateFibonacci()`: Uses a `for` loop to calculate 10 Fibonacci numbers.
  * `generateTableOfEight()`: Displays a table of 8 using a loop and `<ul>`.

