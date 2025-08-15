# React Router Tutorial: Beginner to Advanced (Step-by-Step Guide)

React Router is a powerful library that helps you add routing to your React applications. It enables navigation among views of various components in a React Application, supports browser history features, and allows you to implement dynamic and nested routing.

---

## 1. What is Routing?

Routing is the process of keeping the UI in sync with the URL. In a React app, this means displaying different components/pages based on the current path.

---

## 2. Installation

To get started with React Router:

```bash
npm install react-router-dom
```

---

## 3. Basic Setup

### App.js:

```jsx
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import About from './About';

function App() {
  return (
    <BrowserRouter>
      <nav>
        <Link to="/">Home</Link>
        <Link to="/about">About</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App;
```

### Home.js:

```jsx
function Home() {
  return <h1>Home Page</h1>;
}
export default Home;
```

### About.js:

```jsx
function About() {
  return <h1>About Page</h1>;
}
export default About;
```

---

## 4. Routing Concepts

### a. `BrowserRouter`

It uses the HTML5 history API (pushState, popState) to keep your UI in sync with the URL.

### b. `Routes` and `Route`

`Routes` is a container for `Route` components. Each `Route` maps a path to a component.

### c. `Link`

Replaces anchor tags and prevents page reload. Used for navigation.

### d. `Navigate`

Used to redirect users programmatically.

---

## 5. Dynamic Routing with `useParams`

### Example:

```jsx
<Route path="/user/:id" element={<User />} />
```

```jsx
import { useParams } from 'react-router-dom';
function User() {
  const { id } = useParams();
  return <h1>User ID: {id}</h1>;
}
```

---

## 6. Nested Routes

```jsx
<Route path="/dashboard" element={<Dashboard />}>
  <Route path="profile" element={<Profile />} />
  <Route path="settings" element={<Settings />} />
</Route>
```

In `Dashboard.js`:

```jsx
import { Outlet, Link } from 'react-router-dom';
function Dashboard() {
  return (
    <div>
      <nav>
        <Link to="profile">Profile</Link>
        <Link to="settings">Settings</Link>
      </nav>
      <Outlet />
    </div>
  );
}
```

---

## 7. Programmatic Navigation

### `useNavigate()` Hook:

```jsx
import { useNavigate } from 'react-router-dom';
function Login() {
  const navigate = useNavigate();
  const handleLogin = () => {
    navigate('/dashboard');
  };
  return <button onClick={handleLogin}>Login</button>;
}
```

---

## 8. 404 Not Found Page

```jsx
<Route path="*" element={<NotFound />} />
```

---

## 9. Protected Routes (Authentication)

### `ProtectedRoute.js`

```jsx
import { Navigate } from 'react-router-dom';
function ProtectedRoute({ isAuthenticated, children }) {
  if (!isAuthenticated) {
    return <Navigate to="/login" />;
  }
  return children;
}
export default ProtectedRoute;
```

### Usage:

```jsx
<Route path="/dashboard" element={
  <ProtectedRoute isAuthenticated={userLoggedIn}>
    <Dashboard />
  </ProtectedRoute>
} />
```

---

## 10. `useLocation()`

Gives access to the current location object.

```jsx
import { useLocation } from 'react-router-dom';
function ShowLocation() {
  const location = useLocation();
  return <p>Current URL: {location.pathname}</p>;
}
```

---

## 11. URL Query Parameters

```jsx
import { useSearchParams } from 'react-router-dom';
function Products() {
  const [searchParams] = useSearchParams();
  const category = searchParams.get('category');
  return <div>Category: {category}</div>;
}
```

Navigate with:

```jsx
<Link to="/products?category=books">Books</Link>
```

---

## 12. Lazy Loading Routes

```jsx
import { lazy, Suspense } from 'react';
const About = lazy(() => import('./About'));

<Route path="/about" element={
  <Suspense fallback={<div>Loading...</div>}>
    <About />
  </Suspense>
} />
```

---

## 13. Scroll to Top on Route Change

```jsx
import { useEffect } from 'react';
import { useLocation } from 'react-router-dom';

function ScrollToTop() {
  const { pathname } = useLocation();

  useEffect(() => {
    window.scrollTo(0, 0);
  }, [pathname]);

  return null;
}
```

Use this inside your `App` component:

```jsx
<BrowserRouter>
  <ScrollToTop />
  {/* routes here */}
</BrowserRouter>
```

---

## 14. Summary

React Router is essential for creating modern SPAs with React. With support for dynamic routes, nested routes, programmatic navigation, lazy loading, and protection mechanisms, it gives you the tools to build robust applications.

