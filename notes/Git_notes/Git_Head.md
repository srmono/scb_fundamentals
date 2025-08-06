* **What the command is**
* **What it does**
* **When it is used**
* **Syntax example**
* **Explanation of each part**

---

### 🔹 **1. `git checkout`**

#### 🔸 What it is:

The `git checkout` command is used to **switch branches** or **restore files** to a previous state.

#### 🔸 What it does:

* Switches to a different branch.
* Restores files from a previous commit.

#### 🔸 When to use:

* When needing to work on a different branch.
* When reverting a file to an older version.

#### 🔸 Example:

```bash
git checkout main
```

#### 🔸 Breakdown:

* `git` = the Git version control command.
* `checkout` = action to switch or restore.
* `main` = the branch to switch to.

---

### 🔹 **2. `git reset HEAD`**

#### 🔸 What it is:

The `git reset HEAD` command is used to **unstage** changes that were added with `git add`.

#### 🔸 What it does:

Removes files from the staging area but **does not delete changes** in the file.

#### 🔸 When to use:

* After mistakenly running `git add`.
* To correct what is staged before committing.

#### 🔸 Example:

```bash
git reset HEAD app.js
```

#### 🔸 Breakdown:

* `git` = Git command.
* `reset` = action to move staged files back to unstaged.
* `HEAD` = reference to the last commit.
* `app.js` = the file to unstage.

---

### 🔹 **3. `git commit --amend`**

#### 🔸 What it is:

The `git commit --amend` command **modifies the most recent commit**.

#### 🔸 What it does:

* Updates the last commit with new changes.
* Optionally edits the commit message.

#### 🔸 When to use:

* To add forgotten changes to the last commit.
* To correct a commit message.

#### 🔸 Example:

```bash
git commit --amend
```

#### 🔸 Breakdown:

* `git` = Git command.
* `commit` = create or edit a commit.
* `--amend` = modify the last commit.

---

### 🔹 **4. `git checkout <SHA> -- <filename>`**

#### 🔸 What it is:

Restores a file from a **specific past commit**.

#### 🔸 What it does:

Replaces the current version of the file with the version from the given commit.

#### 🔸 When to use:

* To recover a file as it was in an earlier commit.
* To undo recent changes to a file.

#### 🔸 Example:

```bash
git checkout 3f1b2c7 -- app.js
```

#### 🔸 Breakdown:

* `3f1b2c7` = commit SHA (unique ID of a commit).
* `--` = separates the commit SHA from the file name.
* `app.js` = file to restore.

---

### 🔹 **5. `git revert <SHA>`**

#### 🔸 What it is:

Creates a new commit that **undoes the changes** made in the specified commit.

#### 🔸 What it does:

Reverts the effect of a past commit without removing any history.

#### 🔸 When to use:

* To fix a bug caused by a past commit.
* To safely undo changes in shared repositories.

#### 🔸 Example:

```bash
git revert 3f1b2c7
```

#### 🔸 Breakdown:

* `revert` = tells Git to undo the commit.
* `3f1b2c7` = SHA of the commit to reverse.

---

### 🔚 Summary Table

| Command                        | Purpose                         | Safe for Team Use | Rewrites History |
| ------------------------------ | ------------------------------- | ----------------- | ---------------- |
| `git checkout`                 | Switch branches or restore file | ✔️                | ❌                |
| `git reset HEAD`               | Unstage file                    | ✔️                | ❌                |
| `git commit --amend`           | Edit last commit                | ❌ (if pushed)     | ✔️               |
| `git checkout <SHA> -- <file>` | Restore old version of file     | ✔️                | ❌                |
| `git revert <SHA>`             | Reverse commit safely           | ✔️                | ❌                |

