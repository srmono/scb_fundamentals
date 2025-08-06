### Fetch Data with Core JS , HTML, CSS

### What we implement

1. **Click a button**
2. **Trigger an API call**
3. **Fetch and process the data using async/await**
4. **Render the result in a grid**

We’ll use the public API from [https://jsonplaceholder.typicode.com/users](https://jsonplaceholder.typicode.com/users) for user data.

---

###  Complete HTML + JavaScript Example:

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Fetch Users and Display Grid</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      padding: 20px;
    }
    button {
      padding: 10px 20px;
      margin-bottom: 20px;
      font-size: 16px;
      cursor: pointer;
    }
    .grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
      gap: 16px;
    }
    .card {
      border: 1px solid #ccc;
      padding: 15px;
      border-radius: 8px;
      background-color: #f9f9f9;
    }
    .card h3 {
      margin: 0 0 10px;
    }
  </style>
</head>
<body>

  <button id="loadUsersBtn">Load Users</button>
  <div id="userGrid" class="grid"></div>

  <script>
    const button = document.getElementById('loadUsersBtn');
    const grid = document.getElementById('userGrid');

    button.addEventListener('click', async () => {
      try {
        const users = await fetchUsers();
        displayUsers(users);
      } catch (error) {
        console.error('Error fetching users:', error);
        grid.innerHTML = `<p style="color:red;">Failed to load users. Try again later.</p>`;
      }
    });

    async function fetchUsers() {
      const response = await fetch('https://jsonplaceholder.typicode.com/users');
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return await response.json();
    }

    function displayUsers(users) {
      grid.innerHTML = ''; // Clear existing content
      users.forEach(user => {
        const card = document.createElement('div');
        card.className = 'card';
        card.innerHTML = `
          <h3>${user.name}</h3>
          <p><strong>Email:</strong> ${user.email}</p>
          <p><strong>City:</strong> ${user.address.city}</p>
          <p><strong>Company:</strong> ${user.company.name}</p>
        `;
        grid.appendChild(card);
      });
    }
  </script>
</body>
</html>
```

---

###  Highlights:

* **Core JS** only: No libraries.
* Uses `async/await` for clean asynchronous code.
* Renders user data in a responsive **CSS grid**.
* Graceful error handling.


---

### Fetch Data with Bootstrap + Core JS

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Bootstrap API Grid</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap 5 CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-4">

  <div class="container">
    <h1 class="mb-4">User List</h1>
    <button id="loadUsersBtn" class="btn btn-primary mb-4">Load Users</button>
    
    <div id="userGrid" class="row g-4"></div>
  </div>

  <script>
    const button = document.getElementById('loadUsersBtn');
    const grid = document.getElementById('userGrid');

    button.addEventListener('click', async () => {
      try {
        const users = await fetchUsers();
        displayUsers(users);
      } catch (error) {
        console.error('Fetch error:', error);
        grid.innerHTML = `<div class="alert alert-danger">Failed to load users. Please try again.</div>`;
      }
    });

    async function fetchUsers() {
      const response = await fetch('https://jsonplaceholder.typicode.com/users');
      if (!response.ok) throw new Error('Network response was not ok');
      return await response.json();
    }

    function displayUsers(users) {
      grid.innerHTML = '';
      users.forEach(user => {
        const col = document.createElement('div');
        col.className = 'col-md-4 col-lg-3';

        col.innerHTML = `
          <div class="card h-100 shadow-sm">
            <div class="card-body">
              <h5 class="card-title">${user.name}</h5>
              <p class="card-text"><strong>Email:</strong> ${user.email}</p>
              <p class="card-text"><strong>City:</strong> ${user.address.city}</p>
              <p class="card-text"><strong>Company:</strong> ${user.company.name}</p>
            </div>
          </div>
        `;

        grid.appendChild(col);
      });
    }
  </script>

</body>
</html>
```

---

### 🔧 Features:

* **Responsive grid**: Automatically adjusts columns across screen sizes
* **Cards**: Clean and consistent display of user info
* **Bootstrap alerts**: Error feedback
* **Minimal JS**: No frameworks, just `async/await` and DOM manipulation
