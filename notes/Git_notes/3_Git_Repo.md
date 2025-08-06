###  **3. Create Repo, Add Files, Commit, .gitignore**

---

## 🧱 Step-by-Step Guide: Creating a Local Git Repository

---

###  **Step 1: Create a New Project Folder**

```bash
mkdir git-demo-project
cd git-demo-project
```

###  **Step 2: Initialize Git**

```bash
git init
```

 This creates a hidden `.git/` folder. Git starts tracking changes **inside this folder only**.

---

##  Step 3: Create Files

Let’s create a couple of files:

```bash
echo "Welcome to Git learning!" > README.md
echo "console.log('Hello World!');" > app.js
```

---

##  Step 4: Check Git Status

```bash
git status
```

You will see something like:

```
Untracked files:
  app.js
  README.md
```

That means Git sees these files, but isn't tracking them yet.

---

##  Step 5: Stage Files

```bash
git add README.md app.js
```

This moves files to the **staging area**.

You can also add everything:

```bash
git add .
```

---

##  Step 6: Commit Files

```bash
git commit -m "Initial commit with README and app.js"
```

Now these files are saved in the local Git **repository** (not just in the folder).

---

## 🙈 Step 7: .gitignore File

Sometimes you don’t want Git to track certain files or folders (e.g., logs, temp files, secrets, or node\_modules).

Create a `.gitignore` file:

```bash
touch .gitignore
```

Edit it:

```
# Ignore all log files
*.log

# Ignore node_modules folder
node_modules/

# Ignore env secrets
.env
```

Now check:

```bash
git status
```

Git will ignore the files/folders listed in `.gitignore`.

 Note: Add `.gitignore` before staging unwanted files, or you must unstage them first.

---

## 🚨 Common Mistake

If you added something you didn’t want to:

```bash
git reset <filename>     # Unstage
```

If committed already:

```bash
git rm --cached <filename>   # Remove from repo but not from local folder
```

---

##  Recap:

* You can start Git tracking with `git init`
* Use `git add` to stage files, `git commit` to save them
* `.gitignore` protects you from accidentally committing sensitive or bulky files

