# 🧾 HTML Forms Cheat Sheet (Complete Guide)

---

## 🔹 1. **Basic Form Structure**

```html
<form action="/submit" method="POST">
  <!-- form elements go here -->
</form>
```

* `action`: URL where form data is sent.
* `method`: GET (URL params) or POST (request body).
* `enctype`: Encoding for file upload (`multipart/form-data`).

---

## 🔹 2. **Form Elements**

### **Text Inputs**

```html
<input type="text" name="username" id="username">
```

### **Password**

```html
<input type="password" name="password">
```

### **Email / URL / Tel**

```html
<input type="email" name="email" required>
<input type="url" name="website">
<input type="tel" name="phone">
```

### **Search**

```html
<input type="search" name="query">
```

### **Number / Range**

```html
<input type="number" name="age" min="18" max="100" step="1">
<input type="range" name="volume" min="0" max="100">
```

### **Date and Time Inputs**

```html
<input type="date" name="birthdate">
<input type="time" name="appointment_time">
<input type="datetime-local" name="meeting">
<input type="month" name="bdaymonth">
<input type="week" name="week">
```

### **Color Picker**

```html
<input type="color" name="color">
```

---

## 🔹 3. **Check Boxes & Radio Buttons**

```html
<!-- Checkbox -->
<input type="checkbox" name="subscribe" checked>

<!-- Radio Buttons -->
<input type="radio" name="gender" value="male" checked>
<input type="radio" name="gender" value="female">
```

> Use the same `name` for a group of radio buttons to select one.

---

## 🔹 4. **File Upload**

```html
<input type="file" name="resume" accept=".pdf,.docx">
<input type="file" name="images" multiple>
```

> Set `enctype="multipart/form-data"` in `<form>` when uploading files.

---

## 🔹 5. **Select Dropdown**

```html
<select name="country" required>
  <option value="">--Select--</option>
  <option value="us">USA</option>
  <option value="in">India</option>
</select>
```

### **Multiple Select**

```html
<select name="colors" multiple>
  <option value="red">Red</option>
  <option value="blue">Blue</option>
</select>
```

---

## 🔹 6. **Textarea**

```html
<textarea name="message" rows="4" cols="50" placeholder="Type here..."></textarea>
```

---

## 🔹 7. **Buttons**

```html
<button type="submit">Submit</button>
<button type="reset">Reset</button>
<button type="button" onclick="alert('Hello')">Click Me</button>
```

---

## 🔹 8. **Form Attributes**

### `<form>` Attributes

| Attribute      | Description                               |
| -------------- | ----------------------------------------- |
| `action`       | URL to send form data                     |
| `method`       | GET or POST                               |
| `enctype`      | Data encoding (e.g., file uploads)        |
| `target`       | Where to display response (`_blank`, etc) |
| `autocomplete` | Enable/disable browser autocomplete       |
| `novalidate`   | Skip built-in validation                  |

---

## 🔹 9. **Input Attributes**

| Attribute      | Description                             |
| -------------- | --------------------------------------- |
| `type`         | Defines input type                      |
| `name`         | Key name for submission                 |
| `value`        | Predefined value                        |
| `id`           | Unique identifier                       |
| `placeholder`  | Hint text                               |
| `required`     | Makes input mandatory                   |
| `readonly`     | Prevents editing                        |
| `disabled`     | Disables input                          |
| `maxlength`    | Max character length                    |
| `min`, `max`   | For number/date fields                  |
| `step`         | Increment steps for numeric fields      |
| `pattern`      | Regex for validation                    |
| `autofocus`    | Focus on load                           |
| `autocomplete` | Override browser autocomplete           |
| `multiple`     | Allow multiple files/emails             |
| `checked`      | Pre-check checkboxes or radios          |
| `list`         | Links to a `<datalist>` for suggestions |

---

## 🔹 10. **Labels**

```html
<label for="email">Email:</label>
<input type="email" id="email" name="email">
```

* Use `for` attribute to link label to input by `id`.

---

## 🔹 11. **Fieldset & Legend**

```html
<fieldset>
  <legend>Personal Info</legend>
  <label>Name: <input type="text" name="name"></label>
</fieldset>
```

* Useful for grouping related inputs.

---

## 🔹 12. **Datalist (Input Suggestions)**

```html
<input list="browsers" name="browser">
<datalist id="browsers">
  <option value="Chrome">
  <option value="Firefox">
  <option value="Safari">
</datalist>
```

---

## 🔹 13. **Hidden Input**

```html
<input type="hidden" name="token" value="12345">
```

> Used to pass data behind the scenes.

---

## 🔹 14. **Form Validation**

### Built-in Validation

* `required`
* `pattern="[A-Za-z]{3,}"`
* `type="email"` for format check
* `min`, `max`, `maxlength`

### Custom Validation (JavaScript)

```html
<input type="text" id="username" required>
<span id="error"></span>

<script>
  const input = document.getElementById("username");
  input.addEventListener("input", () => {
    if (!input.validity.valid) {
      input.setCustomValidity("Username is required!");
    } else {
      input.setCustomValidity("");
    }
  });
</script>
```

---

## 🔹 15. **Accessibility Best Practices**

* Always pair `<label>` with inputs.
* Use `aria-label` or `aria-describedby` where needed.
* Add `tabindex` for keyboard navigation.
* Use `role="form"` on complex forms.

---

## 🔹 16. **Form Submission Techniques**

* **Standard HTML POST/GET**
* **AJAX Submission**
* **Fetch API with JavaScript**

```javascript
const form = document.querySelector("form");
form.addEventListener("submit", async (e) => {
  e.preventDefault();
  const data = new FormData(form);
  const res = await fetch("/submit", {
    method: "POST",
    body: data,
  });
});
```

---

## 🔹 17. **Common Pitfalls to Avoid**

* Forgetting `name` attributes (data won't submit).
* Using `id` without linking it to `label`.
* Submitting file inputs without setting `enctype`.
* Not validating user inputs (security risk).
* Overusing `<br>` for layout instead of CSS.

---

## 🔹 **HTML Input Validation Using `pattern` Attribute**

The `pattern` attribute allows you to specify a **regular expression** (regex) that the input value must match to be considered valid.

> Works with `<input type="text">`, `email`, `tel`, `search`, `password`, etc.

---

### ✅ **Basic Syntax**

```html
<input type="text" pattern="[A-Za-z]{3,}" title="At least 3 letters">
```

* `pattern`: Regex to match the input.
* `title`: Tooltip shown when pattern fails.

---

### 🔹 **Common `pattern` Examples**

#### 1. **Alphabet Only (3+ letters)**

```html
<input type="text" pattern="[A-Za-z]{3,}" title="Only letters, minimum 3 characters">
```

#### 2. **Username (letters, numbers, underscores, 3–15 chars)**

```html
<input type="text" pattern="^[a-zA-Z0-9_]{3,15}$" title="3-15 letters, numbers, or underscores">
```

#### 3. **Email (basic)**

```html
<input type="email" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Enter a valid email">
```

#### 4. **Phone Number (US 10 digits)**

```html
<input type="tel" pattern="^\d{10}$" title="Enter 10 digit phone number">
```

#### 5. **Strong Password (min 8 chars, 1 digit, 1 letter)**

```html
<input type="password" pattern="(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}" title="At least 8 characters, including a number and a letter">
```

#### 6. **ZIP Code (US - 5 digits or ZIP+4)**

```html
<input type="text" pattern="^\d{5}(-\d{4})?$" title="Enter valid ZIP (e.g. 12345 or 12345-6789)">
```

#### 7. **Hex Color Code**

```html
<input type="text" pattern="^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$" title="Valid hex color (e.g. #FFF or #ffffff)">
```

---

### ❗ Important Notes

* **Browsers do not show pattern errors unless the field is required or failed validation.**
* **Use `title`** to guide users with meaningful messages.
* For complex rules or cross-field checks, use JavaScript.

---

### 💡 Example: Full Pattern Validation Input

```html
<form>
  <label for="username">Username (3-15 chars, letters/numbers):</label>
  <input type="text" id="username" name="username"
         pattern="^[a-zA-Z0-9]{3,15}$"
         title="Only letters or numbers, 3 to 15 characters" required>
  <button type="submit">Submit</button>
</form>
```

