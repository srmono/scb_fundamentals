# ✅ JavaScript `Number` – All Properties & Methods with Real-Time Examples, Definitions, and Use Cases

---

## 🔹 `Number.MAX_VALUE`

**Definition:**
The largest number you can represent in JavaScript before getting `Infinity`.

**Use Case:**
Preventing overflow in mathematical calculations.

**Example:**

```js
let huge = 1e309;
console.log(huge); // Infinity
console.log(huge > Number.MAX_VALUE); // true
```

---

## 🔹 `Number.MIN_VALUE`

**Definition:**
The smallest positive number (close to zero, not negative).

**Use Case:**
Precision checks in scientific calculations or detecting underflow.

**Example:**

```js
let minCheck = Number.MIN_VALUE / 2;
console.log(minCheck); // 0
console.log(Number.MIN_VALUE); // 5e-324
```

---

## 🔹 `Number.POSITIVE_INFINITY`

**Definition:**
Returned when a number exceeds `MAX_VALUE` or `1 / 0`.

**Use Case:**
Graceful handling of divide-by-zero or overflow cases.

**Example:**

```js
let inf = 1 / 0;
console.log(inf); // Infinity
console.log(inf === Number.POSITIVE_INFINITY); // true
```

---

## 🔹 `Number.NEGATIVE_INFINITY`

**Definition:**
Returned on negative overflow or `-1 / 0`.

**Use Case:**
Detecting edge-case calculations in scientific or sensor data.

**Example:**

```js
let negInf = -1 / 0;
console.log(negInf); // -Infinity
```

---

## 🔹 `Number.NaN`

**Definition:**
"Not a Number" — occurs when a numeric operation fails.

**Use Case:**
Validating input or calculations that result in non-numbers.

**Example:**

```js
let badMath = 0 / "hello";
console.log(Number.isNaN(badMath)); // true
```

---

## 🔹 `Number.EPSILON`

**Definition:**
Smallest possible difference between two numbers. Used to compare floating-point values.

**Use Case:**
Accurate floating point comparisons in finance or measurement apps.

**Example:**

```js
let a = 0.1 + 0.2;
let b = 0.3;
console.log(a === b); // false
console.log(Math.abs(a - b) < Number.EPSILON); // true ✅
```

---

## 🔹 `Number.MAX_SAFE_INTEGER`

**Definition:**
The maximum integer value JavaScript can safely represent (2^53 - 1).

**Use Case:**
Preventing bugs from large number rounding (e.g., order IDs, financial data).

**Example:**

```js
let id = Number.MAX_SAFE_INTEGER + 1;
console.log(Number.isSafeInteger(id)); // false
```

---

## 🔹 `Number.MIN_SAFE_INTEGER`

**Definition:**
The minimum safe integer in JavaScript (-(2^53 - 1)).

**Use Case:**
Handling large negative values safely (e.g., logs, counters).

**Example:**

```js
let value = -9007199254740992;
console.log(Number.isSafeInteger(value)); // false
```

---

# 🛠️ Number Static Methods

---

## 🔹 `Number.isNaN(value)`

**Definition:**
Checks whether a value is exactly `NaN`.

**Use Case:**
Safer than `isNaN()` which coerces types.

**Example:**

```js
console.log(Number.isNaN("hello")); // false
console.log(Number.isNaN(NaN)); // true
```

---

## 🔹 `Number.isFinite(value)`

**Definition:**
Returns true if value is a number and not `Infinity`/`NaN`.

**Use Case:**
Validating numerical input before performing math.

**Example:**

```js
console.log(Number.isFinite(100)); // true
console.log(Number.isFinite(Infinity)); // false
```

---

## 🔹 `Number.isInteger(value)`

**Definition:**
Checks whether the value is an integer.

**Use Case:**
Input validation for whole-number-only fields.

**Example:**

```js
console.log(Number.isInteger(10)); // true
console.log(Number.isInteger(10.5)); // false
```

---

## 🔹 `Number.isSafeInteger(value)`

**Definition:**
Checks if value is within safe integer range.

**Use Case:**
Ensuring large numbers won't lose precision.

**Example:**

```js
let unsafe = Number.MAX_SAFE_INTEGER + 10;
console.log(Number.isSafeInteger(unsafe)); // false
```

---

## 🔹 `Number.parseInt(string)`

**Definition:**
Parses a string and returns an integer.

**Use Case:**
Extract numbers from strings like `"42px"`.

**Example:**

```js
let size = "42px";
console.log(Number.parseInt(size)); // 42
```

---

## 🔹 `Number.parseFloat(string)`

**Definition:**
Parses and returns a floating-point number.

**Use Case:**
Converting string inputs into decimal numbers.

**Example:**

```js
let price = "199.99 USD";
console.log(Number.parseFloat(price)); // 199.99
```

---

# 🧠 Number Instance Methods

---

## 🔹 `.toFixed(digits)`

**Definition:**
Formats a number using fixed decimals.

**Use Case:**
Showing prices or ratings.

**Example:**

```js
let price = 1234.567;
console.log(price.toFixed(2)); // "1234.57"
```

---

## 🔹 `.toExponential(digits)`

**Definition:**
Returns exponential (scientific) notation.

**Use Case:**
Showing very large or very small numbers in compact form.

**Example:**

```js
let big = 1234567;
console.log(big.toExponential()); // "1.234567e+6"
```

---

## 🔹 `.toPrecision(digits)`

**Definition:**
Formats number to specified total number of digits.

**Use Case:**
Engineering values where significant digits matter.

**Example:**

```js
let val = 99.123456;
console.log(val.toPrecision(4)); // "99.12"
```

---

## 🔹 `.toLocaleString(locale, options)`

**Definition:**
Returns locale-specific string (like currency).

**Use Case:**
Displaying numbers formatted per region.

**Example:**

```js
let money = 1234567.89;
console.log(money.toLocaleString("en-IN")); // "12,34,567.89"
```

---

## 🔹 `.toString(radix)`

**Definition:**
Converts a number to a string in given base.

**Use Case:**
Binary, octal, hexadecimal conversions.

**Example:**

```js
let n = 255;
console.log(n.toString(16)); // "ff" (hex)
console.log(n.toString(2));  // "11111111" (binary)
```

---

## 🔹 `.valueOf()`

**Definition:**
Returns the primitive value of a number object.

**Use Case:**
Rarely used directly—internal use by JS engine.

**Example:**

```js
let x = new Number(42);
console.log(x.valueOf()); // 42
```

---

# 🔁 Bonus Utility Pattern Examples

---

### ✅ Float Comparison

```js
function areEqual(a, b) {
  return Math.abs(a - b) < Number.EPSILON;
}
```

---

### ✅ Safe Division

```js
function safeDivide(a, b) {
  return b === 0 ? Number.POSITIVE_INFINITY : a / b;
}
```

---

### ✅ Input Validation

```js
function isValidNumber(val) {
  let n = Number(val);
  return Number.isFinite(n) && !Number.isNaN(n);
}
```


---

## 🟦 **JavaScript Number Properties**

| **Property**               | **Description**                                                |
| -------------------------- | -------------------------------------------------------------- |
| `Number.MAX_VALUE`         | The largest possible number in JavaScript (\~1.79e+308).       |
| `Number.MIN_VALUE`         | The smallest **positive** number in JavaScript (\~5e-324).     |
| `Number.POSITIVE_INFINITY` | Returned on overflow when numbers exceed `MAX_VALUE`.          |
| `Number.NEGATIVE_INFINITY` | Returned on underflow or `-1 * POSITIVE_INFINITY`.             |
| `Number.NaN`               | Represents a value that is “Not-a-Number”.                     |
| `Number.EPSILON`           | The smallest interval between two representable numbers (> 1). |
| `Number.MAX_SAFE_INTEGER`  | Maximum safe integer in JavaScript (2^53 - 1).                 |
| `Number.MIN_SAFE_INTEGER`  | Minimum safe integer in JavaScript (-(2^53 - 1)).              |

---

## 🟩 **JavaScript Number Methods**

| **Method**                    | **Description / Use Case**                                                                |
| ----------------------------- | ----------------------------------------------------------------------------------------- |
| `Number.isNaN(value)`         | Checks if a value is **exactly** `NaN`.                                                   |
| `Number.isFinite(value)`      | Returns `true` if the value is a finite number (not `Infinity`, `-Infinity`, or `NaN`).   |
| `Number.isInteger(value)`     | Checks whether the value is an integer.                                                   |
| `Number.isSafeInteger(value)` | Checks if the value is a **safe integer** (within 2^53 - 1).                              |
| `Number.parseFloat(value)`    | Parses a string and returns a floating-point number.                                      |
| `Number.parseInt(value)`      | Parses a string and returns an integer.                                                   |
| `toFixed(n)`                  | Converts number to a string, keeping `n` decimal places (for display or formatting).      |
| `toPrecision(n)`              | Returns a string with the number formatted to a specified length.                         |
| `toExponential(n)`            | Converts number to exponential notation string.                                           |
| `valueOf()`                   | Returns the primitive value of a `Number` object (mostly used internally).                |
| `toString(radix)`             | Converts a number to a string using a base (e.g., binary, octal, hex).                    |
| `toLocaleString()`            | Returns a string with a language-sensitive format of the number (e.g., currency, commas). |

---

### ✅ **Real-Time Examples**

Here are **quick snippets** for real-world usage:

#### 1. **Format money**

```js
let price = 1234.567;
console.log(price.toFixed(2)); // "1234.57"
```

#### 2. **Parse user input**

```js
let input = "42px";
let intVal = Number.parseInt(input); // 42
```

#### 3. **Safe integer check**

```js
let id = 9007199254740991;
console.log(Number.isSafeInteger(id)); // true
```

#### 4. **Validate input**

```js
let result = Number("abc");
console.log(Number.isNaN(result)); // true
```

#### 5. **Display binary**

```js
let num = 10;
console.log(num.toString(2)); // "1010"
```

## Quick Reference Note

```js
console.log(Number.MAX_VALUE);          // 1.7976931348623157e+308
console.log(Number.MIN_VALUE);          // 5e-324
console.log(Number.POSITIVE_INFINITY);  // Infinity
console.log(Number.NEGATIVE_INFINITY);  // -Infinity
console.log(Number.NaN);                // NaN
console.log(Number.EPSILON);            // 2.220446049250313e-16
console.log(Number.MAX_SAFE_INTEGER);   // 9007199254740991
console.log(Number.MIN_SAFE_INTEGER);   // -9007199254740991
```

## Summary Table

| Use Case                   | Code Example                       |
| -------------------------- | ---------------------------------- |
| Format money               | `price.toFixed(2)`                 |
| Parse pixel input          | `Number.parseInt("42px")`          |
| Validate safe integer      | `Number.isSafeInteger(id)`         |
| Handle invalid input       | `Number.isNaN(Number("abc"))`      |
| Show binary representation | `(10).toString(2)`                 |
| Float comparison           | `Math.abs(a - b) < Number.EPSILON` |
| Prevent divide-by-zero     | `1 / 0 => Infinity`                |
| Convert to hex color       | `(255).toString(16)`               |
| Exponential form           | `big.toExponential()`              |
| Localized string           | `num.toLocaleString("en-IN")`      |
