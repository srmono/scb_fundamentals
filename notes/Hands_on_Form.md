### ✅ Pure HTML5 Features:

* Only alphabet input using `pattern`
* 10-digit phone number using `pattern`
* Email validated using `type="email"`
* All fields are `required`
* Form submits to a new page (`welcome.html`)
* Uses `GET` or `POST` method (you can switch as needed)

---

### 🧾 `index.html` (Form Page)

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>HTML5 Form</title>
  <style>
    input:invalid {
      background-color: yellow;
    }
  </style>
</head>
<body>
  <h2>Registration Form</h2>
  <form action="welcome.html" method="get">
    First Name:
    <input type="text" name="firstName" required pattern="[A-Za-z]+" placeholder="Please enter your first name"><br><br>

    Last Name:
    <input type="text" name="lastName" required pattern="[A-Za-z]+" placeholder="Please enter your last name"><br><br>

    Gender:
    <input type="radio" name="gender" value="Male" required>Male
    <input type="radio" name="gender" value="Female">Female
    <input type="radio" name="gender" value="Others">Others<br><br>

    Languages known:
    <input type="checkbox" name="lang" value="HTML">HTML
    <input type="checkbox" name="lang" value="CSS">CSS
    <input type="checkbox" name="lang" value="JS">JS<br><br>

    Address:<br>
    <textarea name="address" required></textarea><br><br>

    Cities lived in:<br>
    <select name="cities" multiple required>
      <option value="Bangalore">Bangalore</option>
      <option value="Mysore">Mysore</option>
      <option value="Kerala">Kerala</option>
      <option value="Chennai">Chennai</option>
    </select><br><br>

    Contact Number:
    <input type="tel" name="contact" required pattern="\d{10}" placeholder="10-digit number"><br><br>

    My favorite color is:
    <input type="color" name="favcolor"><br><br>

    Date is:
    <input type="date" name="date" required><br><br>

    Birthday is:
    <input type="datetime-local" name="bdaytime" required><br><br>

    Time is:
    <input type="time" name="time" required><br><br>

    Week is:
    <input type="week" name="week" required><br><br>

    Month is:
    <input type="month" name="month" required><br><br>

    Email ID:
    <input type="email" name="email" required><br><br>

    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
  </form>
</body>
</html>
```

---

### 🖼 `welcome.html` (Output Page)

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Welcome</title>
</head>
<body>
  <h1>Welcome User</h1>
</body>
</html>
```

---

### 🔁 To test both `GET` and `POST`:

* Just change `method="get"` to `method="post"` in the `<form>` tag.


----

## With Js Validation

Here's a complete HTML5 form based on the requirements and the example shown in your screenshot:

### ✅ Features Covered:

* First/Last name: Only alphabets
* Contact: 10 digits only
* Email: HTML5 validation
* All fields marked as required
* Submission opens a new page that says “Welcome User”
* Demonstrates both `GET` and `POST` methods

---

### 🧾 HTML Code (with JavaScript for extra validation):

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>User Form</title>
  <style>
    input[type="text"]:invalid,
    input[type="email"]:invalid {
      background-color: yellow;
    }
  </style>
  <script>
    function validateForm() {
      const nameRegex = /^[A-Za-z]+$/;
      const phoneRegex = /^\d{10}$/;

      const firstName = document.forms["userForm"]["firstName"].value;
      const lastName = document.forms["userForm"]["lastName"].value;
      const contact = document.forms["userForm"]["contact"].value;

      if (!nameRegex.test(firstName)) {
        alert("First name should contain only letters.");
        return false;
      }

      if (!nameRegex.test(lastName)) {
        alert("Last name should contain only letters.");
        return false;
      }

      if (!phoneRegex.test(contact)) {
        alert("Contact number must be 10 digits.");
        return false;
      }

      window.open("welcome.html", "_blank");
      return true;
    }
  </script>
</head>
<body>
  <h2>Registration Form</h2>
  <form name="userForm" action="welcome.html" method="post" onsubmit="return validateForm();">
    First Name: <input type="text" name="firstName" required placeholder="Please enter your first name"><br><br>
    Last Name: <input type="text" name="lastName" required placeholder="Please enter your last name"><br><br>
    
    Gender:
    <input type="radio" name="gender" value="Male" required>Male
    <input type="radio" name="gender" value="Female">Female
    <input type="radio" name="gender" value="Others">Others<br><br>
    
    Languages known:
    <input type="checkbox" name="lang" value="HTML">HTML
    <input type="checkbox" name="lang" value="CSS">CSS
    <input type="checkbox" name="lang" value="JS">JS<br><br>

    Address:<br>
    <textarea name="address" required></textarea><br><br>

    Cities lived in:<br>
    <select name="cities" multiple required>
      <option>Bangalore</option>
      <option>Mysore</option>
      <option>Kerala</option>
      <option>Chennai</option>
    </select><br><br>

    Contact Number:
    <input type="text" name="contact" required><br><br>

    My favorite color is: <input type="color" name="favcolor"><br><br>

    Date is: <input type="date" name="date" required><br><br>
    Birthday is: <input type="datetime-local" name="bdaytime" required><br><br>
    Time is: <input type="time" name="time" required><br><br>
    Week is: <input type="week" name="week" required><br><br>
    Month is: <input type="month" name="month" required><br><br>

    Email id is: <input type="email" name="email" required><br><br>

    <button type="button" onclick="alert('Clicked')">Click Me</button>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
  </form>
</body>
</html>
```

---

### 🖼 `welcome.html`

```html
<!DOCTYPE html>
<html>
<head>
  <title>Welcome</title>
</head>
<body>
  <h1>Welcome User</h1>
</body>
</html>
```

