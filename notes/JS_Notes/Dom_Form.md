## Goal 
✅ Creating and displaying an array of strings as a list
✅ Validating a name input field to allow **only alphabets**
✅ Showing an error message next to the input field if invalid

---

### ✅ What it does:

1. Displays an array of strings as a list on the page.
2. Takes user input in a textbox (for name).
3. Validates if the name has only alphabets.
4. If not, shows the error message “please enter only alphabets”.

---

### ✅ Full Code (HTML + JavaScript)

```html
<!DOCTYPE html>
<html>
<head>
  <title>DOM and Form Validation</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 30px;
    }
    .error {
      color: red;
      font-size: 14px;
    }
    ul {
      margin-top: 10px;
    }
  </style>
</head>
<body>

  <h2>String List Display and Name Validation</h2>

  <!-- Part 1: Display Array of Strings -->
  <h3>Fruits List</h3>
  <ul id="stringList"></ul>

  <!-- Part 2: Form Input for Name Validation -->
  <h3>Enter Your Name</h3>
  <form onsubmit="return validateNameInput()">
    <input type="text" id="nameInput" placeholder="Enter name" />
    <span id="nameError" class="error"></span><br><br>
    <button type="submit">Submit</button>
  </form>

  <script>
    // Display array of strings in list format
    var fruits = ["Apple", "Banana", "Mango", "Orange", "Grapes"];
    var listElement = document.getElementById("stringList");

    for (var i = 0; i < fruits.length; i++) {
      var li = document.createElement("li");
      li.textContent = fruits[i];
      listElement.appendChild(li);
    }

    // Validate name input to allow only alphabets
    function validateNameInput() {
      var nameField = document.getElementById("nameInput");
      var errorField = document.getElementById("nameError");
      var nameValue = nameField.value;

      var alphabetOnlyRegex = /^[A-Za-z]+$/;

      if (!alphabetOnlyRegex.test(nameValue)) {
        errorField.textContent = "Please enter only alphabets";
        return false; // prevent form submission
      } else {
        errorField.textContent = ""; // clear error
        alert("Name is valid: " + nameValue);
        return true; // allow form submission
      }
    }
  </script>

</body>
</html>
```

---

### 📌 Notes:

* **No ES6**: This uses only `var`, basic loops, and simple functions.
* **Validation logic**: Regex `/^[A-Za-z]+$/` checks that only letters are entered.
* **DOM usage**: Uses `createElement`, `appendChild`, `getElementById` for manipulation.


---

## Goal With ES6

✅ Creating and displaying an array of strings as a list
✅ Validating a name input field to allow **only alphabets**
✅ Showing an error message next to the input field if invalid

---

### ✅ Full Code: DOM and Form Validation Hands-on

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>DOM and Form Validation Hands-on</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }
    .error {
      color: red;
      margin-left: 10px;
    }
  </style>
</head>
<body>

  <h2>DOM and Form Validation Hands-on</h2>

  <!-- Part 1: Display array as list -->
  <h3>Fruits List</h3>
  <ul id="fruitList"></ul>

  <!-- Part 2: Name validation -->
  <h3>Enter Your Name</h3>
  <form id="nameForm" onsubmit="return validateNameInput()">
    <label for="nameInput">Name:</label>
    <input type="text" id="nameInput" name="nameInput">
    <span id="nameError" class="error"></span>
    <br><br>
    <button type="submit">Submit</button>
  </form>

  <script>
    // Part 1: Create an array of strings and display as list
    const fruits = ["Apple", "Banana", "Mango", "Orange", "Pineapple"];
    const fruitListElement = document.getElementById("fruitList");

    fruits.forEach(fruit => {
      const listItem = document.createElement("li");
      listItem.textContent = fruit;
      fruitListElement.appendChild(listItem);
    });

    // Part 2: Validate input for alphabets only
    function validateNameInput() {
      const nameField = document.getElementById("nameInput");
      const errorField = document.getElementById("nameError");
      const nameValue = nameField.value.trim();

      const alphaRegex = /^[A-Za-z]+$/;

      if (!alphaRegex.test(nameValue)) {
        errorField.textContent = "Please enter only alphabets";
        return false;
      }

      errorField.textContent = "";
      alert("Name submitted successfully: " + nameValue);
      return true;
    }
  </script>

</body>
</html>
```

---

### 🔍 Breakdown

| Part                   | Purpose                                                                  |
| ---------------------- | ------------------------------------------------------------------------ |
| `fruits` array         | Stores list of strings to display                                        |
| `forEach` with DOM API | Adds each fruit to the `<ul>` as `<li>` elements dynamically             |
| `validateNameInput()`  | Validates that input is **only alphabets** using RegEx (`/^[A-Za-z]+$/`) |
| Error `<span>`         | Dynamically displays an error message if input is invalid                |

