## Common Git Errors & Solutions (with examples)

This section covers **real-world Git errors** beginners often face and explains **why** they happen, along with **how to fix them step-by-step**.

---

### 1. **`fatal: not a git repository`**

**When it happens:**
Trying to run Git commands in a folder where Git is not initialized.

**Example:**

```bash
git status
```

Error:

```
fatal: not a git repository (or any of the parent directories): .git
```

**Solution:**
Initialize Git first:

```bash
git init
```

---

### 2. **`nothing to commit, working tree clean`**

**When it happens:**
You try to commit but haven't changed or staged any files.

**Solution:**
Make changes to tracked files or add new files, then:

```bash
git add .
git commit -m "your message"
```

---

### 3. **`fatal: origin does not appear to be a git repository`**

**When it happens:**
Pushing to a remote repository without adding the remote URL.

**Solution:**
Add remote:

```bash
git remote add origin https://github.com/yourusername/your-repo.git
```

Then push:

```bash
git push -u origin main
```

---

### 4. **Merge Conflict**

**When it happens:**
Two users edited the same file and Git can't auto-merge.

**Solution:**

1. Git marks conflicts in the file like:

   ```text
   <<<<<<< HEAD
   your local change
   =======
   incoming change
   >>>>>>> origin/main
   ```

2. Manually edit and resolve.

3. Then:

   ```bash
   git add conflicted-file.txt
   git commit -m "Resolved conflict"
   ```

---

### 5. **`fatal: could not read from remote repository`**

**When it happens:**
Usually due to SSH misconfig or no access to repo.

**Solutions:**

* Check your internet
* If using SSH:

  ```bash
  ssh -T git@github.com
  ```
* If no access, ask repo owner to grant permissions.

---

### 6. **`Updates were rejected because the remote contains work that you do not have`**

**When it happens:**
Remote repo has new commits that are not in your local repo.

**Solution:**
First pull and then push:

```bash
git pull origin main --rebase
git push origin main
```

