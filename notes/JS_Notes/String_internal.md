
### ✅ Code Concept: Convert Strings in an Array to Uppercase

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Array String Uppercase Example</title>
</head>
<body>
  <h2>Hands on Array, String and Object</h2>
  <p>Original array: <span id="original"></span></p>
  <p>Uppercase array: <span id="converted"></span></p>

  <script>
    // Step 1: Original array with mixed-case strings
    const words = ["sTandarD", "CharTered", "banK"];
    document.getElementById("original").textContent = JSON.stringify(words);

    // Step 2: Convert each word to uppercase
    const upperWords = words.map(word => word.toUpperCase());

    // Step 3: Display the result
    document.getElementById("converted").textContent = JSON.stringify(upperWords);
  </script>
</body>
</html>
```

---

### 🧠 Explanation:

* `map()` is used to iterate through the array and apply `toUpperCase()` to each element.
* `JSON.stringify()` is used to display the array in a readable format on the webpage.

---

---

### Using `for` Loop (Beginner-Friendly)

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Array to Uppercase (No Map)</title>
</head>
<body>
  <h2>Convert Array of Strings to Uppercase (Using Loop)</h2>
  <p>Original array: <span id="original"></span></p>
  <p>Uppercase array: <span id="converted"></span></p>

  <script>
    // Step 1: Declare the original array
    var originalWords = ["sTandarD", "CharTered", "banK"];
    document.getElementById("original").textContent = JSON.stringify(originalWords);

    // Step 2: Create a new array to store uppercase values
    var uppercaseWords = [];

    // Step 3: Loop through the original array and convert each element
    for (var i = 0; i < originalWords.length; i++) {
      var upper = originalWords[i].toUpperCase();  // convert to uppercase
      uppercaseWords.push(upper);                  // add to new array
    }

    // Step 4: Show the result
    document.getElementById("converted").textContent = JSON.stringify(uppercaseWords);
  </script>
</body>
</html>
```

---

### 🧠 What's Happening:

* We use a `for` loop to go through each string.
* `toUpperCase()` changes it to uppercase.
* `push()` adds the converted string to a new array.

