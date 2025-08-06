## 1. What is an Event in the Web?

An **event** is an action or occurrence that happens in the browser, such as:

* Clicking a button (`click`)
* Moving the mouse (`mousemove`)
* Submitting a form (`submit`)
* Typing in a field (`keydown`, `keyup`)
* Loading a page (`load`)

---

## 🔧 2. Ways to Handle Events

### ✅ A. Inline HTML Attribute (Not Recommended)

```html
<button onclick="alert('Clicked!')">Click Me</button>
```

* **Pros**: Easy and quick for small tasks.
* **Cons**: Mixes HTML with JavaScript. Harder to maintain and scale.

---

### ✅ B. DOM Property

```html
<button id="btn">Click</button>
<script>
  document.getElementById('btn').onclick = function() {
    alert('Clicked via DOM property!');
  };
</script>
```

* Only **one handler per event**. Overwrites if reassigned.

---

### ✅ C. `addEventListener` (Recommended)

```html
<button id="btn">Click</button>
<script>
  const btn = document.getElementById('btn');
  btn.addEventListener('click', function () {
    alert('Clicked with addEventListener!');
  });
</script>
```

### 🔁 You can add **multiple listeners**:

```js
btn.addEventListener('click', () => console.log('Handler 1'));
btn.addEventListener('click', () => console.log('Handler 2'));
```

---

## 📚 3. Event Object

When an event occurs, an `event` object is passed to the handler.

```js
btn.addEventListener('click', function(event) {
  console.log(event.target); // The element clicked
});
```

---

## 🧠 4. Event Propagation: Bubbling vs Capturing

### A. Bubbling (default):

Events bubble **from child to parent**.

```html
<div id="parent">
  <button id="child">Click</button>
</div>
<script>
  document.getElementById('parent').addEventListener('click', () => {
    console.log('Parent clicked');
  });
  document.getElementById('child').addEventListener('click', () => {
    console.log('Child clicked');
  });
</script>
```

**Output:**

```
Child clicked
Parent clicked
```

### B. Capturing:

Use third parameter `true` to listen during **capture phase**.

```js
element.addEventListener('click', handler, true);
```

---

## 🧹 5. Removing Event Listeners

```js
function sayHi() {
  alert('Hi');
}
btn.addEventListener('click', sayHi);
btn.removeEventListener('click', sayHi); // Must be same reference
```

---

## 🌱 6. Event Delegation

Instead of attaching handlers to **many child elements**, attach one handler to the **common parent**.

### Example:

```html
<ul id="list">
  <li>Item 1</li>
  <li>Item 2</li>
</ul>
<script>
  document.getElementById('list').addEventListener('click', function(event) {
    if (event.target.tagName === 'LI') {
      alert('Clicked: ' + event.target.textContent);
    }
  });
</script>
```

**Why use delegation?**

* Fewer event listeners = better performance
* Works with dynamically added items

---

## 🎯 7. `this` vs `event.target`

```js
btn.addEventListener('click', function(e) {
  console.log(this);         // The element the listener is attached to
  console.log(e.target);     // The actual element that was clicked
});
```

If you use arrow functions, `this` does not refer to the element:

```js
btn.addEventListener('click', (e) => {
  console.log(this); // likely window
});
```

---

## 🔒 8. Prevent Default Behavior

```js
document.querySelector('a').addEventListener('click', function(event) {
  event.preventDefault(); // Stops navigation
});
```

---

## ⛔ 9. Stop Event Propagation

* `event.stopPropagation()` → stops bubbling
* `event.stopImmediatePropagation()` → stops all other listeners too

---

## 🧪 10. Examples for Common Events

### A. Mouse Events

```js
element.addEventListener('mouseover', () => {});
element.addEventListener('mouseout', () => {});
```

### B. Keyboard Events

```js
document.addEventListener('keydown', (e) => {
  console.log(e.key); // e.g. "Enter"
});
```

### C. Form Events

```js
form.addEventListener('submit', (e) => {
  e.preventDefault();
  console.log('Form submitted');
});
```

---

## 🧵 11. Summary

| Concept             | Use Case                            | Syntax Example                           |
| ------------------- | ----------------------------------- | ---------------------------------------- |
| Inline `onclick`    | Simple but not recommended          | `<button onclick="fn()">`                |
| DOM Property        | Only one handler allowed            | `el.onclick = fn`                        |
| `addEventListener`  | Best practice, allows multiple      | `el.addEventListener('click', fn)`       |
| Event Object        | Get details like target, key, etc   | `fn(event)`                              |
| Delegation          | Efficient for many/dynamic elements | `parent.addEventListener()`              |
| Bubbling/Capturing  | Control event flow                  | `el.addEventListener('click', fn, true)` |
| `preventDefault()`  | Stop form submit or link follow     | `event.preventDefault()`                 |
| `stopPropagation()` | Stop bubbling to parent             | `event.stopPropagation()`                |

