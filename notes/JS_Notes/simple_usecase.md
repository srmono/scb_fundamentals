✅ A form with Name and Email
✅ JavaScript `async`/`await` style
✅ Data stored in `localStorage`
✅ Displayed in a table
✅ Full validation:

* Required fields
* Name must contain only letters
* Email format check (via browser)
* Duplicate email prevention

---

### ✅ Copy & paste this into a `.html` file and open it in a browser:

```html
<!DOCTYPE html>
<html>
<head>
  <title>Form with localStorage and Validation</title>
  <style>
    body { font-family: Arial, sans-serif; padding: 20px; max-width: 600px; margin: auto; }
    input { padding: 8px; margin: 5px 0; width: 100%; }
    button { padding: 10px 15px; }
    table { border-collapse: collapse; width: 100%; margin-top: 20px; }
    th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
    th { background-color: #f9f9f9; }
    .error { color: red; font-size: 0.9em; margin-bottom: 10px; }
  </style>
</head>
<body>

  <h2>User Form</h2>
  <form id="userForm" novalidate>
    <div class="error" id="errorMsg"></div>
    <label>
      Name:
      <input type="text" name="name" id="name" required>
    </label><br>
    <label>
      Email:
      <input type="email" name="email" id="email" required>
    </label><br>
    <button type="submit">Submit</button>
  </form>

  <h3>Submitted Users</h3>
  <table id="userTable">
    <thead>
      <tr><th>Name</th><th>Email</th></tr>
    </thead>
    <tbody></tbody>
  </table>

  <script>
    const form = document.getElementById("userForm");
    const tableBody = document.querySelector("#userTable tbody");
    const errorMsg = document.getElementById("errorMsg");

    const users = JSON.parse(localStorage.getItem("users")) || [];

    // Load any existing users
    displayUsers(users);

    form.addEventListener("submit", async function(event) {
      event.preventDefault();
      errorMsg.textContent = "";

      const nameInput = document.getElementById("name").value.trim();
      const emailInput = document.getElementById("email").value.trim();

      // --- Validation ---
      if (nameInput.length < 2) {
        errorMsg.textContent = "Name must be at least 2 characters.";
        return;
      }

      if (!/^[a-zA-Z\s]+$/.test(nameInput)) {
        errorMsg.textContent = "Name must contain only letters and spaces.";
        return;
      }

      if (!emailInput) {
        errorMsg.textContent = "Email is required.";
        return;
      }

      if (users.some(user => user.email.toLowerCase() === emailInput.toLowerCase())) {
        errorMsg.textContent = "This email has already been submitted.";
        return;
      }

      // --- Simulate async save ---
      await addUser({ name: nameInput, email: emailInput });

      form.reset();
    });

    async function addUser(user) {
      users.push(user);
      localStorage.setItem("users", JSON.stringify(users));
      displayUsers(users);
    }

    function displayUsers(userList) {
      tableBody.innerHTML = "";
      userList.forEach(user => {
        const row = document.createElement("tr");
        row.innerHTML = `<td>${user.name}</td><td>${user.email}</td>`;
        tableBody.appendChild(row);
      });
    }
  </script>

</body>
</html>
```

---

### 🧪 You can test:

* Submitting a valid name/email ✅
* Trying to reuse the same email ❌
* Leaving fields empty ❌
* Using numbers in the name ❌

