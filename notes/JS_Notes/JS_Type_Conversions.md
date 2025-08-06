## 🔄 JavaScript Type Conversions: Overview

JavaScript is **dynamically typed**, which means variables can change types. Type conversion can be:

* **Implicit (Type Coercion)** — done automatically by JS.
* **Explicit (Type Casting)** — done manually using built-in functions.

---

## 1. **String Conversion**

###  Definition:

Converting other data types (Number, Boolean, null, etc.) into a string.

###  Real-time Use Case:

When you want to **display data** to the user or **concatenate strings** in UI (e.g., `Hello, your score is 90`).

###  Explicit Conversion:

```js
String(123);        // "123"
(123).toString();   // "123"
true.toString();    // "true"
null + ""           // "null"
```

###  Implicit Conversion:

```js
"User: " + 42        // "User: 42"
"Answer: " + true    // "Answer: true"
```

---

## 2. **Number Conversion**

###  Definition:

Convert strings or other values into numbers.

###  Real-time Use Case:

When taking user input via a form, it's **usually a string**, but you want to **calculate totals or comparisons**.

###  Explicit Conversion:

```js
Number("123");     // 123
parseInt("123px"); // 123
parseFloat("12.5") // 12.5
+"123"             // 123 (Unary + operator)
```

###  Implicit Conversion:

```js
"10" * 2     // 20
"5" - 1      // 4
true + 1     // 2
null + 5     // 5
```

---

## 3. **Boolean Conversion**

###  Definition:

Convert any value to `true` or `false`.

###  Real-time Use Case:

To evaluate **form validations**, **login status**, or **conditions in `if` blocks**.

###  Falsy Values (convert to `false`):

* `0`
* `""` (empty string)
* `null`
* `undefined`
* `NaN`
* `false`

###  Examples:

```js
Boolean(0);           // false
Boolean("hello");     // true
!!"text"              // true
!!null                // false
if ("user") { ... }   // executes because "user" is truthy
```

---

## 4. **Object to Primitive Conversion**

###  Definition:

When objects are used in string/number contexts, JavaScript tries to convert them to primitive values using:

* `valueOf()`
* `toString()`

###  Real-time Use Case:

When **logging or alerting object info**, or doing math with custom objects.

###  Example:

```js
let user = {
  name: "Alex",
  toString() {
    return this.name;
  }
};

alert(user); // "Alex"

let amount = {
  valueOf() {
    return 500;
  }
};

console.log(amount + 100); // 600
```

---

## 5. **Symbol Conversion**

###  Note:

Symbols **cannot be implicitly converted** to strings or numbers.

###  Example:

```js
let sym = Symbol("id");

String(sym); // "Symbol(id)"
// alert(sym); // ❌ TypeError: Cannot convert a Symbol value to a string
```

---

## 6. **Date Conversion**

###  Definition:

Dates can be converted to strings or numbers.

###  Real-time Use Case:

To **display dates in readable format** or to **compare timestamps**.

###  Example:

```js
let date = new Date();

console.log(String(date));   // "Wed Jul 30 2025 12:00:00 GMT+0530"
console.log(+date);          //  timestamp in milliseconds
```

---

## Summary: Conversion Matrix

| From → To       | Conversion Technique      | Example                    |
| --------------- | ------------------------- | -------------------------- |
| String → Number | `Number()`, `parseInt()`  | `Number("12") → 12`        |
| Number → String | `String()`, `.toString()` | `String(99) → "99"`        |
| Any → Boolean   | `Boolean()`, `!!`         | `Boolean("") → false`      |
| Object → String | `toString()`              | `({}).toString()`          |
| Object → Number | `valueOf()`               | `+{ valueOf:()=>10 } → 10` |

