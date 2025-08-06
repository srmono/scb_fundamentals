##  Goal:

* Create a basic JavaScript app
* Push it to GitHub
* Automatically run it using **GitHub Actions** on **Windows**

---

##  Step 1: Create a Simple JS Project Locally

### Create a folder structure:

```
my-js-app/
│
├── .github/
│   └── workflows/
│       └── windows-run.yml
├── index.js
├── package.json
```

---

##  Step 2: `index.js`

```js
// index.js
function sayHello(name) {
  return `Hello, ${name}!`;
}

console.log(sayHello("Windows User"));
```

---

##  Step 3: `package.json`

```json
{
  "name": "windows-js-test",
  "version": "1.0.0",
  "description": "Test GitHub Actions on Windows",
  "main": "index.js",
  "scripts": {
    "start": "node index.js"
  },
  "author": "YourName",
  "license": "MIT"
}
```

---

##  Step 4: `.github/workflows/windows-run.yml`

```yaml
# This GitHub Actions workflow runs on a Windows machine and executes your JS code

name: Run JS on Windows

on: [push]

jobs:
  run-js:
    runs-on: windows-latest

    steps:
      - name: Checkout Code
        uses: actions/checkout@v3

      - name: Setup Node.js
        uses: actions/setup-node@v3
        with:
          node-version: '18'

      - name: Install Dependencies
        run: npm install

      - name: Run the JS App
        run: npm start
```

---

##  Step 5: Push to GitHub

```bash
git init
git remote add origin https://github.com/your-username/your-repo-name.git
git add .
git commit -m "Initial commit for Windows JS test"
git push -u origin main
```

---

##  What Happens:

Once you push:

* GitHub will detect the `.github/workflows/windows-run.yml` file
* It spins up a **Windows** runner
* Installs Node.js
* Installs dependencies (`npm install`)
* Runs your script (`npm start`)

