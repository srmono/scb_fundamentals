CSS **combinator selectors** allow you to target elements based on the relationship between them. There are **four main combinators** in CSS:

---

### 1. **Descendant Selector (`space`)**

**Selector:** `A B`
**Meaning:** Selects **all B elements** that are **inside A**, at **any level**.

```css
div p {
  color: blue;
}
```

✔️ This applies to all `<p>` tags **inside** a `<div>`, regardless of how deeply nested.

---

### 2. **Child Selector (`>`)**

**Selector:** `A > B`
**Meaning:** Selects **only B elements** that are **direct children** of A.

```css
ul > li {
  list-style: none;
}
```

✔️ This targets only `<li>` elements that are **direct children** of a `<ul>`, not nested `<li>`s inside other elements.

---

### 3. **Adjacent Sibling Selector (`+`)**

**Selector:** `A + B`
**Meaning:** Selects the **B element immediately following** A (both must share the same parent).

```css
h2 + p {
  margin-top: 0;
}
```

✔️ This affects the **first `<p>` right after an `<h2>`**, but not others that follow later.

---

### 4. **General Sibling Selector (`~`)**

**Selector:** `A ~ B`
**Meaning:** Selects **all B siblings** that come **after A**, sharing the same parent.

```css
h2 ~ p {
  color: gray;
}
```

✔️ This targets **all `<p>` tags that follow an `<h2>`**, not just the first one.

---

### Summary Table

| Combinator | Example   | Meaning                            |
| ---------- | --------- | ---------------------------------- |
| `A B`      | `div p`   | All `<p>` inside `<div>`           |
| `A > B`    | `ul > li` | Direct `<li>` children of `<ul>`   |
| `A + B`    | `h2 + p`  | First `<p>` after `<h2>`           |
| `A ~ B`    | `h2 ~ p`  | All `<p>`s after `<h2>` (siblings) |

