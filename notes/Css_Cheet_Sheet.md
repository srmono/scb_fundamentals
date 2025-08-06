# CSS Cheat Sheet (Basic to Advanced)

---

##  1. **Basic Syntax**

```css
selector {
  property: value;
}
```

---

##  2. **Selectors**

### **Basic Selectors**

```css
*             /* Universal */
div           /* Type selector */
.class        /* Class selector */
#id           /* ID selector */
```

### **Combinators**

```css
div p         /* Descendant */
div > p       /* Child */
div + p       /* Adjacent sibling */
div ~ p       /* General sibling */
```

### **Attribute Selectors**

```css
input[type="text"]
a[href^="https"]
img[alt~="logo"]
```

---

##  3. **Colors**

```css
color: red;
color: #ff0000;
color: rgb(255, 0, 0);
color: rgba(255, 0, 0, 0.5);
background-color: transparent;
```

---

##  4. **Text Styling**

```css
color: #333;
font-size: 16px;
font-family: Arial, sans-serif;
font-weight: bold;
font-style: italic;
text-align: center;
text-decoration: underline;
text-transform: uppercase;
letter-spacing: 1px;
line-height: 1.5;
```

---

##  5. **Box Model**

```css
width: 100px;
height: 100px;
margin: 10px;
padding: 20px;
border: 1px solid black;
box-sizing: border-box;  /* Includes padding & border in size */
```

---

##  6. **Display & Positioning**

```css
display: block;
display: inline;
display: inline-block;
display: flex;
display: grid;
display: none;

position: static;
position: relative;
position: absolute;
position: fixed;
position: sticky;

top: 10px; right: 10px; bottom: 10px; left: 10px;
z-index: 100;
```

---

##  7. **Flexbox**

```css
display: flex;
flex-direction: row | column;
justify-content: flex-start | center | space-between;
align-items: stretch | center | flex-start;
flex-wrap: wrap;
gap: 10px;
```

---

##  8. **CSS Grid**

```css
display: grid;
grid-template-columns: 1fr 1fr;
grid-template-rows: auto 100px;
grid-gap: 10px;
grid-column: 1 / 3;
grid-row: 2 / 4;
place-items: center;
```

---

##  9. **Backgrounds**

```css
background-color: #f0f0f0;
background-image: url('image.jpg');
background-repeat: no-repeat;
background-size: cover | contain;
background-position: center center;
background-attachment: fixed;
```

---

##  10. **Borders & Outlines**

```css
border: 1px solid #000;
border-radius: 10px;
border-top: 2px dashed red;

outline: 2px dotted blue;
outline-offset: 5px;
```

---

##  11. **Transitions & Animations**

### Transitions

```css
transition: all 0.3s ease-in-out;
transition-property: background-color, transform;
```

### Animations

```css
@keyframes fade {
  from { opacity: 0; }
  to { opacity: 1; }
}

.element {
  animation: fade 2s infinite alternate;
}
```

---

##  12. **Transformations**

```css
transform: translateX(100px);
transform: rotate(45deg);
transform: scale(1.5);
transform: skew(10deg, 20deg);
```

---

##  13. **Opacity & Visibility**

```css
opacity: 0.5;
visibility: hidden;
display: none;
```

---

##  14. **Media Queries (Responsive Design)**

```css
@media (max-width: 768px) {
  body {
    font-size: 14px;
  }
}
```

---

##  15. **CSS Variables (Custom Properties)**

```css
:root {
  --main-color: #333;
  --padding: 20px;
}

div {
  color: var(--main-color);
  padding: var(--padding);
}
```

---

##  16. **Pseudo-Classes**

```css
a:hover          /* When mouse hovers */
input:focus      /* On focus */
li:first-child   /* First item */
li:last-child    /* Last item */
li:nth-child(2)  /* 2nd item */
:checked, :disabled, :required
```

---

##  17. **Pseudo-Elements**

```css
p::before {
  content: "Note: ";
}
p::after {
  content: " ✔";
}
h1::first-letter {
  font-size: 200%;
}
```

---

##  18. **Shorthand Properties**

```css
margin: 10px 20px;          /* top-bottom left-right */
padding: 10px 15px 5px 0;   /* top right bottom left */
border: 1px solid black;
font: italic bold 14px/1.5 Arial, sans-serif;
background: #fff url('bg.png') no-repeat center;
```

---

##  19. **Advanced Techniques**

* **Object Fit / Position** (for images):

  ```css
  img {
    object-fit: cover;
    object-position: center;
  }
  ```

* **Clamp for Fluid Font Sizes:**

  ```css
  font-size: clamp(14px, 2vw, 20px);
  ```

* **Scroll Snap:**

  ```css
  scroll-snap-type: x mandatory;
  scroll-snap-align: start;
  ```

---

##  20. **Best Practices**

* Keep CSS modular and maintainable.
* Use semantic class names (e.g., `.btn-primary`).
* Use external stylesheets for large projects.
* Avoid overusing `!important`.
* Normalize styles with `reset.css` or `normalize.css`.
* Always comment complex logic for future you/team.

## **Reference Links**

* https://webdesign.tutsplus.com/the-30-css-selectors-you-must-memorize--net-16048t
* https://css-tricks.com/css-selectors/
* https://learn.shayhowe.com/advanced-html-css/complex-selectors/ 
