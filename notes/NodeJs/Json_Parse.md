### ✅ Features:

* Bootstrap-styled input form.
* `Submit` button pushes form data to a JSON array.
* `Display JSON Data` button shows the accumulated JSON.

---

### ✅ Full Code:

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>JSON Use Case</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container mt-5">
    <h3 class="mb-4">Presenting the Use Case on JSON</h3>
    
    <div class="mb-3 row">
      <label for="firstName" class="col-sm-2 col-form-label fw-bold">First Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="firstName" placeholder="Enter First Name">
      </div>
    </div>
    
    <div class="mb-3 row">
      <label for="lastName" class="col-sm-2 col-form-label fw-bold">Second Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="lastName" placeholder="Enter Second Name">
      </div>
    </div>
    
    <div class="mb-3">
      <button class="btn btn-primary me-2" onclick="submitData()">Submit</button>
      <button class="btn btn-info text-white" onclick="displayJSON()">Display JSON Data</button>
    </div>
    
    <div id="jsonOutput" class="mt-3 text-break border p-2 bg-light"></div>
  </div>

  <script>
    let jsonArray = [];

    function submitData() {
      const firstName = document.getElementById("firstName").value.trim();
      const lastName = document.getElementById("lastName").value.trim();

      if (firstName && lastName) {
        jsonArray.push({
          FirstName: firstName,
          LastName: lastName
        });
        
        // Clear input fields
        document.getElementById("firstName").value = '';
        document.getElementById("lastName").value = '';
      } else {
        alert("Please enter both names.");
      }
    }

    function displayJSON() {
      document.getElementById("jsonOutput").innerText = JSON.stringify(jsonArray);
    }
  </script>
</body>
</html>
```

---

### 📝 How It Works:

* **Input Fields**: Two Bootstrap inputs for first and second name.
* **Submit Button**: Adds input to `jsonArray`.
* **Display Button**: Renders the JSON array below.
* **Output**: Styled using Bootstrap with a light background.


---

## With Node

Great! Let's address your **three requests** in detail:

---

## ✅ 1. **Validation Error Highlights**

We'll add red borders and error messages if the fields are left blank.

## ✅ 2. **Pretty JSON Formatting**

We’ll format the JSON with indentation using `JSON.stringify(..., null, 2)`.

## ✅ 3. **Node + Bootstrap from `package.json`**

Yes, you *can absolutely* use Bootstrap by installing it via `npm` and serving it using a minimal static server in Node.js (like `express`). I'll provide both the **HTML/JS version** and **Node.js setup** at the end.

---

### ✅ Updated HTML + Bootstrap + JS (with validation + pretty JSON)

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>JSON Form Use Case</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .is-invalid {
      border-color: #dc3545;
    }
    .error-text {
      color: #dc3545;
      font-size: 0.875em;
    }
  </style>
</head>
<body>
  <div class="container mt-5">
    <h3 class="mb-4">Presenting the Use Case on JSON</h3>

    <div class="mb-3 row">
      <label for="firstName" class="col-sm-2 col-form-label fw-bold">First Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="firstName" placeholder="Enter First Name">
        <div id="firstNameError" class="error-text"></div>
      </div>
    </div>

    <div class="mb-3 row">
      <label for="lastName" class="col-sm-2 col-form-label fw-bold">Second Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="lastName" placeholder="Enter Second Name">
        <div id="lastNameError" class="error-text"></div>
      </div>
    </div>

    <div class="mb-3">
      <button class="btn btn-primary me-2" onclick="submitData()">Submit</button>
      <button class="btn btn-info text-white" onclick="displayJSON()">Display JSON Data</button>
    </div>

    <pre id="jsonOutput" class="mt-3 p-3 bg-light border"></pre>
  </div>

  <script>
    let jsonArray = [];

    function clearErrors() {
      document.getElementById("firstNameError").innerText = '';
      document.getElementById("lastNameError").innerText = '';
      document.getElementById("firstName").classList.remove('is-invalid');
      document.getElementById("lastName").classList.remove('is-invalid');
    }

    function submitData() {
      clearErrors();
      const firstName = document.getElementById("firstName").value.trim();
      const lastName = document.getElementById("lastName").value.trim();

      let valid = true;

      if (!firstName) {
        document.getElementById("firstNameError").innerText = "First name is required";
        document.getElementById("firstName").classList.add("is-invalid");
        valid = false;
      }

      if (!lastName) {
        document.getElementById("lastNameError").innerText = "Second name is required";
        document.getElementById("lastName").classList.add("is-invalid");
        valid = false;
      }

      if (!valid) return;

      jsonArray.push({ FirstName: firstName, LastName: lastName });
      document.getElementById("firstName").value = '';
      document.getElementById("lastName").value = '';
    }

    function displayJSON() {
      const jsonOutput = document.getElementById("jsonOutput");
      jsonOutput.innerText = JSON.stringify(jsonArray, null, 2);
    }
  </script>
</body>
</html>
```

---

## ✅ Node.js with `package.json` and Bootstrap

You can create a **simple Node.js server** using `express`, serve HTML + Bootstrap installed from NPM, like this:

### 1. 📦 Create `package.json`

```bash
npm init -y
npm install express bootstrap
```

---

### 2. 📁 Folder structure:

```
your-project/
├── public/
│   └── index.html   <-- your HTML file
├── node_modules/
├── server.js
└── package.json
```

---

### 3. 🖥️ `server.js` file:

```js
const express = require('express');
const path = require('path');
const app = express();

app.use('/bootstrap', express.static(path.join(__dirname, 'node_modules/bootstrap/dist')));
app.use(express.static(path.join(__dirname, 'public')));

app.listen(3000, () => {
  console.log("Server running at http://localhost:3000");
});
```

---

### 4. ✨ In your `index.html`, link Bootstrap locally:

```html
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/bootstrap/js/bootstrap.bundle.min.js"></script>
```

---

### ✅ To Run:

```bash
node server.js
```

Visit: `http://localhost:3000`

