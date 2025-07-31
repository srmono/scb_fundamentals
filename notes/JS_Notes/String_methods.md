Here are **10 practical real-time examples** of commonly used **JavaScript string methods** with scenarios that are useful in **real-world applications**:

---

### 1. **`trim()`**

**Removes whitespace** from both ends of a string.

📘 **Use case**: Cleaning user input before saving or comparing.

```js
let username = "   Hamsika   ";
let cleanUsername = username.trim();
// Result: "Hamsika"
```

---

### 2. **`toLowerCase()` / `toUpperCase()`**

**Converts string** to lower or upper case.

📘 **Use case**: Case-insensitive login or search functionality.

```js
let emailInput = "USER@Example.com";
let savedEmail = "user@example.com";

if (emailInput.toLowerCase() === savedEmail.toLowerCase()) {
    console.log("Email matched");
}
```

---

### 3. **`includes()`**

**Checks if a substring exists** within a string.

📘 **Use case**: Filter or validate presence of a keyword.

```js
let bio = "Frontend developer with Angular and React experience";
if (bio.includes("React")) {
    console.log("React experience found!");
}
```

---

### 4. **`startsWith()` / `endsWith()`**

Checks if a string starts or ends with a specific substring.

📘 **Use case**: Validate file extension or domain.

```js
let fileName = "report.pdf";
if (fileName.endsWith(".pdf")) {
    console.log("PDF file accepted");
}
```

---

### 5. **`replace()`**

**Replaces** part of the string with another.

📘 **Use case**: Mask sensitive data or format input.

```js
let card = "1234 5678 9012 3456";
let masked = card.replace(/\d{12}(\d{4})/, "************$1");
// Result: "************3456"
```

---

### 6. **`split()`**

**Splits** a string into an array based on a delimiter.

📘 **Use case**: Convert CSV or input list into array.

```js
let tags = "javascript,html,css,react";
let tagArray = tags.split(",");
// Result: ['javascript', 'html', 'css', 'react']
```

---

### 7. **`substring()` / `slice()`**

Extracts a portion of the string.

📘 **Use case**: Display preview or truncate long titles.

```js
let desc = "This is a long product description for display";
let shortDesc = desc.substring(0, 30) + "...";
// Result: "This is a long product descript..."
```

---

### 8. **`indexOf()` / `lastIndexOf()`**

Returns position of first/last match.

📘 **Use case**: Locate a character (like `@` in email validation).

```js
let email = "contact@example.com";
let atIndex = email.indexOf("@");
// Result: 7
```

---

### 9. **`match()`**

Returns matches based on a **regex pattern**.

📘 **Use case**: Extract phone numbers, emails, etc.

```js
let text = "Contact me at 9876543210 or test@example.com";
let phone = text.match(/\d{10}/);
// Result: ['9876543210']
```

---

### 10. **`concat()`**

**Joins multiple strings**.

📘 **Use case**: Building dynamic messages.

```js
let fname = "Hamsika";
let lname = "B";
let fullName = fname.concat(" ", lname);
// Result: "Hamsika B"
```

---

### Bonus: **`padStart()` / `padEnd()`**

Pads a string to desired length.

📘 **Use case**: Display invoice numbers or fixed-width output.

```js
let invoiceId = "45";
let padded = invoiceId.padStart(6, "0");
// Result: "000045"
```

