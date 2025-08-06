**JavaScript Regular Expressions (Regex)** 

---

## 🌱 What is a Regular Expression?

A **regular expression** is a **pattern** used to match character combinations in strings.

In JavaScript, regex is often used with:

* `match()` – to find matches
* `test()` – to test if a string matches
* `replace()` – to replace matched parts

---

##  Step-by-Step: Basic Components

### 1. **Creating a Regular Expression**

```js
let pattern = /abc/; // literal notation
let pattern2 = new RegExp("abc"); // constructor notation
```

---

### 2. **Matching Simple Text**

```js
let str = "abcdef";
let result = /abc/.test(str);  // true
```

`test()` returns `true` if the pattern is found.

---

### 3. **Special Characters (Metacharacters)**

| Symbol | Meaning                        | Example                             |
| ------ | ------------------------------ | ----------------------------------- |
| `.`    | Any single character           | `/a.c/` matches `abc`, `acc`, `a-c` |
| `^`    | Start of string                | `/^Hello/` matches `Hello world`    |
| `$`    | End of string                  | `/world$/` matches `Hello world`    |
| `*`    | 0 or more of the previous item | `/lo*/` matches `l`, `lo`, `loo`    |
| `+`    | 1 or more                      | `/lo+/` matches `lo`, `loo`         |
| `?`    | 0 or 1                         | `/lo?/` matches `l`, `lo`           |
| `\`    | Escape special characters      | `/\./` matches `.`                  |
| `[]`   | Character set                  | `/[aeiou]/` matches any vowel       |
| `[^]`  | Negated character set          | `/[^aeiou]/` matches non-vowels     |

---

### 4. **Quantifiers**

| Pattern | Matches               |
| ------- | --------------------- |
| `{n}`   | Exactly n times       |
| `{n,}`  | At least n times      |
| `{n,m}` | Between n and m times |

Example:

```js
let re = /a{2,4}/;
console.log(re.test("aaa"));  // true (3 times)
```

---

### 5. **Grouping & Capturing**

```js
let re = /(ha)+/;
console.log(re.test("hahaha")); // true
```

---

### 6. **Common Flags**

| Flag | Description             |
| ---- | ----------------------- |
| `g`  | Global match (find all) |
| `i`  | Case-insensitive        |
| `m`  | Multi-line mode         |

Example:

```js
let str = "Hello hello";
let re = /hello/gi;
console.log(str.match(re)); // ["Hello", "hello"]
```

---

##  Real-Time Examples

### Example 1: **Check if email is valid**

```js
let email = "test@example.com";
let pattern = /^[\w.-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
console.log(pattern.test(email)); // true
```

### Example 2: **Extract numbers from a string**

```js
let str = "The price is 42 dollars";
let result = str.match(/\d+/g);
console.log(result); // ["42"]
```

### Example 3: **Replace all spaces with hyphens**

```js
let title = "JavaScript Regular Expressions";
let slug = title.replace(/\s+/g, "-").toLowerCase();
console.log(slug); // javascript-regular-expressions
```

### Example 4: **Test if a string is a phone number**

```js
let phone = "123-456-7890";
let re = /^\d{3}-\d{3}-\d{4}$/;
console.log(re.test(phone)); // true
```

---

---

# JavaScript Regular Expression Examples (with Explanation + Code)

---

### 1. **Check if a string contains only letters**

```js
//  Explanation: ^[a-zA-Z]+$ means start to end must be letters only (no digits, no spaces)
let str = "HelloWorld";
let re = /^[a-zA-Z]+$/;
console.log(re.test(str)); // true
```

---

### 2. **Check if a string contains only numbers**

```js
//  Explanation: ^\d+$ means all digits from start to end
let str = "123456";
let re = /^\d+$/;
console.log(re.test(str)); // true
```

---

### 3. **Check if a string is alphanumeric**

```js
//  Explanation: allows letters and digits only (no spaces or special characters)
let str = "User123";
let re = /^[a-zA-Z0-9]+$/;
console.log(re.test(str)); // true
```

---

### 4. **Match all words in a sentence**

```js
//  Explanation: \b\w+\b means word boundary + one or more word characters
let sentence = "I love JavaScript!";
let words = sentence.match(/\b\w+\b/g);
console.log(words); // ["I", "love", "JavaScript"]
```

---

### 5. **Match all numbers (including decimals)**

```js
//  Explanation: \d+(\.\d+)? matches integers and decimals
let data = "Price: 45.99 and 100 and 3.5";
let nums = data.match(/\d+(\.\d+)?/g);
console.log(nums); // ["45.99", "100", "3.5"]
```

---

### 6. **Validate a simple username (3–15 chars, letters, digits, underscore)**

```js
//  Explanation: ^\w{3,15}$ = word characters, 3 to 15 long
let username = "user_123";
let re = /^\w{3,15}$/;
console.log(re.test(username)); // true
```

---

### 7. **Match all capitalized words**

```js
//  Explanation: \b[A-Z][a-z]* matches words starting with capital letter
let str = "Alice and Bob went to New York";
let result = str.match(/\b[A-Z][a-z]*/g);
console.log(result); // ["Alice", "Bob", "New", "York"]
```

---

### 8. **Find duplicate words (like “the the”)**

```js
//  Explanation: \b(\w+)\s+\1\b uses backreference to detect repetition
let str = "It was the the best day.";
let re = /\b(\w+)\s+\1\b/;
console.log(re.test(str)); // true
```

---

### 9. **Validate Hex Color Code**

```js
//  Explanation: starts with # and then 3 or 6 hex digits
let color = "#FF5733";
let re = /^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$/;
console.log(re.test(color)); // true
```

---

### 10. **Extract domain name from URL**

```js
//  Explanation: looks for the domain after https?:// and before /
let url = "https://www.example.com/page";
let match = url.match(/^https?:\/\/([^\/]+)/);
console.log(match[1]); // "www.example.com"
```

---

### 11. **Replace all multiple spaces with one**

```js
//  Explanation: \s+ means 1 or more whitespace → replace with single space
let messy = "This   has   too   many   spaces.";
let clean = messy.replace(/\s+/g, " ");
console.log(clean); // "This has too many spaces."
```

---

### 12. **Mask Credit Card Numbers (show only last 4)**

```js
//  Explanation: \d(?=\d{4}) matches all digits except the last 4
let card = "1234567812345678";
let masked = card.replace(/\d(?=\d{4})/g, "*");
console.log(masked); // "************5678"
```

---

### 13. **Find file extensions**

```js
//  Explanation: \.\w+$ matches last dot and word characters
let file = "report.pdf";
let ext = file.match(/\.\w+$/);
console.log(ext[0]); // ".pdf"
```

---

### 14. **Validate IPv4 Address**

```js
//  Explanation: Checks for 4 groups of 1–3 digits, separated by .
let ip = "192.168.1.1";
let re = /^(25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)(\.(?!$)){3}(25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)$/;
console.log(re.test(ip)); // true
```

---

### 15. **Extract YouTube video ID from URL**

```js
//  Explanation: Captures ID from standard or short YouTube URLs
let url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
let match = url.match(/(?:v=|\/)([0-9A-Za-z_-]{11})/);
console.log(match[1]); // "dQw4w9WgXcQ"
```

---

### 16. **Count number of vowels in a sentence**

```js
//  Explanation: Match all vowels globally and count them
let text = "Hello World!";
let vowels = text.match(/[aeiou]/gi);
console.log(vowels.length); // 3
```

---

### 17. **Remove all non-letter characters**

```js
//  Explanation: [^a-zA-Z] matches anything that's not a letter
let dirty = "Hi! I'm #1.";
let cleaned = dirty.replace(/[^a-zA-Z]/g, "");
console.log(cleaned); // "HiIm"
```

---

### 18. **Check if a string ends with .jpg or .png**

```js
//  Explanation: use $ to anchor the end
let filename = "image.jpg";
let re = /\.(jpg|png)$/i;
console.log(re.test(filename)); // true
```

---

### 19. **Split sentence into words (ignore punctuation)**

```js
//  Explanation: Match all words only
let sentence = "Wow! This is amazing, right?";
let words = sentence.match(/\b\w+\b/g);
console.log(words); // ["Wow", "This", "is", "amazing", "right"]
```

---

### 20. **Escape special regex characters in a string**

```js
//  Explanation: replace all regex symbols with escaped versions
let input = "This is a (test).";
let escaped = input.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
console.log(escaped); // "This is a \(test\)\."
```

---

##  That's 20 Regex Examples (Each With Purpose + Code)

These cover:

* Validation (email, username, IP)
* Extraction (domains, hashtags, IDs)
* Transformation (masking, replacing, formatting)
* Matching (words, numbers, special patterns)



##    Tips for Beginners

1. **Start simple**: Use `.test()` to experiment.
2. **Use online tools**: Like [regex101.com](https://regex101.com/) – shows matches, explanations.
3. **Break patterns into parts**: Understand character by character.
4. **Use comments**: Write what each part means.


---