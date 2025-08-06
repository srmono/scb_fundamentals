## 🌐 HTML Cheat Sheet (Basic to Advanced)

```html
<!-- 🧱 Basic HTML Structure -->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="HTML Cheat Sheet">
  <title>HTML Cheat Sheet</title>
</head>
<body>
  <h1>Hello World</h1>
</body>
</html>
```

---

### 📄 Document Metadata

```html
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Page description">
<meta name="keywords" content="HTML, cheat sheet, tags">
<meta name="author" content="Your Name">
<link rel="icon" href="favicon.ico">
```

---

### 🧱 Structural Elements

```html
<header></header>      <!-- Top of the page -->
<nav></nav>            <!-- Navigation links -->
<main></main>          <!-- Main content -->
<article></article>    <!-- Independent content -->
<section></section>    <!-- Thematic content -->
<aside></aside>        <!-- Sidebar content -->
<footer></footer>      <!-- Footer content -->
```

---

###  Text Formatting

```html
<h1>Heading 1</h1>
<p>This is a paragraph.</p>
<strong>Bold text</strong>
<em>Italic text</em>
<mark>Highlighted</mark>
<del>Deleted text</del>
<ins>Inserted text</ins>
<sub>Subscript</sub>
<sup>Superscript</sup>
<br> <!-- Line break -->
<hr> <!-- Horizontal rule -->
```

---

### 🔗 Links & Anchors

```html
<a href="https://example.com">Visit Site</a>
<a href="#section1">Jump to Section</a>
<a href="mailto:email@example.com">Send Email</a>
<a href="tel:+1234567890">Call Now</a>
```

---

### 📷 Media Embedding

```html
<img src="image.jpg" alt="Description" width="300">
<video controls width="400">
  <source src="video.mp4" type="video/mp4">
</video>
<audio controls>
  <source src="audio.mp3" type="audio/mp3">
</audio>
<iframe src="https://example.com" width="600" height="400"></iframe>
```

---

###  Lists

```html
<!-- Unordered List -->
<ul>
  <li>Item 1</li>
</ul>

<!-- Ordered List -->
<ol>
  <li>Step 1</li>
</ol>

<!-- Description List -->
<dl>
  <dt>Term</dt>
  <dd>Definition</dd>
</dl>
```

---

### 📊 Tables

```html
<table>
  <thead>
    <tr><th>Name</th><th>Age</th></tr>
  </thead>
  <tbody>
    <tr><td>Alice</td><td>30</td></tr>
  </tbody>
  <tfoot>
    <tr><td colspan="2">Footer</td></tr>
  </tfoot>
</table>
```

---

### 🧮 Forms & Inputs

```html
<form action="/submit" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required>

  <input type="email" name="email">
  <input type="password" name="password">
  <input type="checkbox" name="subscribe">
  <input type="radio" name="gender" value="male">
  <input type="date" name="dob">
  <select name="country">
    <option value="us">USA</option>
  </select>

  <textarea name="message"></textarea>
  <button type="submit">Submit</button>
</form>
```

---

###  Semantic HTML5

```html
<figure>
  <img src="img.jpg" alt="">
  <figcaption>Caption here</figcaption>
</figure>
<details>
  <summary>Click to Expand</summary>
  Hidden content here.
</details>
<time datetime="2025-07-29">Today</time>
<progress value="70" max="100"></progress>
<meter value="0.7">70%</meter>
```

---

### 🧩 Input Types (HTML5)

```html
<input type="text">
<input type="number">
<input type="range" min="0" max="100">
<input type="color">
<input type="file">
<input type="url">
<input type="tel">
<input type="search">
<input type="datetime-local">
```

---

### 🌐 Multimedia & Embeds

```html
<embed src="file.swf">
<object data="file.pdf" type="application/pdf" width="400" height="500"></object>
<canvas id="myCanvas"></canvas>
<svg width="100" height="100">
  <circle cx="50" cy="50" r="40" stroke="black" fill="red" />
</svg>
```

---

### 🏷️ Global Attributes

```html
id=""            <!-- Unique identifier -->
class=""         <!-- CSS class -->
style=""         <!-- Inline CSS -->
title=""         <!-- Tooltip text -->
hidden           <!-- Hides the element -->
draggable="true" <!-- Enable drag and drop -->
data-*=""        <!-- Custom data attribute -->
```

---

### ⚠️ Accessibility (ARIA)

```html
<button aria-label="Close">X</button>
<div role="alert">Warning!</div>
<input aria-describedby="desc">
```

---

###  Advanced: Custom Elements (Web Components)

```html
<my-custom-element></my-custom-element>
<script>
  class MyElement extends HTMLElement {
    connectedCallback() {
      this.innerHTML = "<p>Hello from custom element</p>";
    }
  }
  customElements.define("my-custom-element", MyElement);
</script>
```

---

### 🛠️ Modern HTML Best Practices

*  Use semantic tags for structure (`<main>`, `<nav>`, etc.)
*  Always include `alt` attributes for images.
*  Use `label` tags for all form controls.
*  Include `<meta name="viewport">` for responsive design.
*  Use `aria-*` and roles for accessibility.

