**React Router v6+**, along with clear explanations and examples where useful.

---

# 🧩 Core Components

### 1. **`<BrowserRouter>`**

* Wraps your entire app.
* Uses the HTML5 History API to manage the URL.
* Suitable for most web applications.

```jsx
<BrowserRouter>
  <App />
</BrowserRouter>
```

---

### 2. **`<HashRouter>`**

* Uses the URL hash (`#`) to simulate different paths.
* Useful for static sites (e.g., GitHub Pages).

```jsx
<HashRouter>
  <App />
</HashRouter>
```

---

### 3. **`<MemoryRouter>`**

* Keeps routing in memory, not in the address bar.
* Ideal for testing or non-browser environments.

```jsx
<MemoryRouter>
  <App />
</MemoryRouter>
```

---

### 4. **`<Routes>`**

* Container for all your `<Route>`s.
* Replaces the older `<Switch>` from v5.

```jsx
<Routes>
  <Route path="/" element={<Home />} />
  <Route path="/about" element={<About />} />
</Routes>
```

---

### 5. **`<Route>`**

* Defines a route mapping a `path` to a `component` (element).
* Can also have **nested routes**.

```jsx
<Route path="/login" element={<Login />} />
```

---

### 6. **`<Link>`**

* Used for navigation without reloading the page.
* Replaces anchor (`<a>`) tags.

```jsx
<Link to="/about">Go to About</Link>
```

---

### 7. **`<NavLink>`**

* Like `<Link>`, but with styling options when the link is active.

```jsx
<NavLink to="/about" className={({ isActive }) => isActive ? 'active' : ''}>
  About
</NavLink>
```

---

### 8. **`<Navigate>`**

* Redirects programmatically to another route.

```jsx
<Navigate to="/dashboard" replace />
```

---

### 9. **`<Outlet>`**

* Placeholder for nested child routes.

```jsx
function Dashboard() {
  return (
    <div>
      <h1>Dashboard</h1>
      <Outlet />
    </div>
  );
}
```

---

# 🪝 React Router Hooks

### 1. **`useNavigate()`**

* Imperatively navigate to different routes in your code (e.g., after login).

```jsx
const navigate = useNavigate();
navigate('/home');
```

---

### 2. **`useParams()`**

* Get dynamic URL parameters from the route.

```jsx
const { id } = useParams();
```

For a route like `/user/:id`, you can read `id`.

---

### 3. **`useLocation()`**

* Gives access to the current location object (`pathname`, `search`, etc.).

```jsx
const location = useLocation();
console.log(location.pathname);
```

---

### 4. **`useSearchParams()`**

* Read and modify the query string (`?key=value`) in the URL.

```jsx
const [searchParams, setSearchParams] = useSearchParams();
const category = searchParams.get('category');
```

---

### 5. **`useMatch()`**

* Matches the current URL to a specific pattern.

```jsx
const match = useMatch('/product/:id');
```

---

### 6. **`useOutlet()`**

* Access the element rendered by a child route in a nested route.

```jsx
const outlet = useOutlet();
```

---

### 7. **`useRoutes()`**

* Declaratively define routes using objects (alternative to `<Routes>` and `<Route>`).

```jsx
const routes = useRoutes([
  { path: '/', element: <Home /> },
  { path: 'about', element: <About /> }
]);
```

---

# 🧠 Advanced Router APIs (v6.4+)

### 1. **`createBrowserRouter()`**

* Part of the new Data APIs (React Router v6.4+).
* Lets you define loaders, actions, and error boundaries.

```jsx
const router = createBrowserRouter([
  { path: '/', element: <Root />, children: [...] }
]);
```

---

### 2. **`createRoutesFromElements()`**

* Converts JSX `<Route>`s to route objects.

```jsx
createRoutesFromElements(
  <Route path="/" element={<App />}>
    <Route path="about" element={<About />} />
  </Route>
)
```

---

### 3. **`RouterProvider`**

* Replaces `<BrowserRouter>` in Data API setup.

```jsx
<RouterProvider router={router} />
```

---

# ✅ Summary: What You Need When

| Use Case                       | Component/Hook                           |
| ------------------------------ | ---------------------------------------- |
| Basic Routing                  | `<BrowserRouter>`, `<Routes>`, `<Route>` |
| Navigation                     | `<Link>`, `<NavLink>`, `useNavigate()`   |
| Nested Routes                  | `<Outlet>`, nested `<Route>`             |
| Route Parameters               | `useParams()`                            |
| Redirect                       | `<Navigate>`, `useNavigate()`            |
| Access Query Strings           | `useSearchParams()`                      |
| Get Current Location           | `useLocation()`                          |
| Static Routing (GH Pages)      | `<HashRouter>`                           |
| Testing or In-Memory Routing   | `<MemoryRouter>`                         |
| Declarative Routing (Advanced) | `useRoutes()`, `createBrowserRouter()`   |

