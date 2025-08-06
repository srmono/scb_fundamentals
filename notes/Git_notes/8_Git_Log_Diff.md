### 8. Git Log and Git Diff – Understanding Changes Over Time

---

#### Git Log – Viewing Commit History

The `git log` command shows the full history of your project, including commit messages, authors, and SHA IDs.

Basic command:

```bash
git log
```

Sample output:

```
commit 3f8bdb3c1e5...
Author: Hamsika B <you@example.com>
Date:   Fri Aug 2 11:00 2025

    Added login page functionality
```

Use `q` to exit the log viewer.

---

#### Customizing Git Log Output

Make it more readable:

```bash
git log --oneline
```

Output:

```
3f8bdb3 Added login page functionality
f14f234 Initial commit with README
```

Other useful options:

* Show graph and branches:

  ```bash
  git log --oneline --graph --all
  ```
* Show logs by a specific author:

  ```bash
  git log --author="Hamsika"
  ```

---

#### Git Diff – Comparing Changes

`git diff` shows the actual line-by-line differences in files.

---

##### 1. View unstaged changes (files modified but not yet added)

```bash
git diff
```

This compares your working directory with the staging area.

---

##### 2. View staged changes (what will go into next commit)

```bash
git diff --cached
```

---

##### 3. Compare two commits

Find two SHA IDs using `git log`, then:

```bash
git diff <sha1> <sha2>
```

Example:

```bash
git diff a47c3f8 3f8bdb3
```

---

##### 4. Compare branches

```bash
git diff main feature-1
```

This shows the difference between the two branches.

---

#### Git Show – Inspect a Specific Commit

To view details of a specific commit:

```bash
git show <sha>
```

You’ll see:

* Commit message
* Author/date
* File changes

---

#### Summary

* `git log` shows commit history
* `git diff` shows what has changed between versions
* `git show` provides details of a single commit
* These tools help you track and debug your work over time

