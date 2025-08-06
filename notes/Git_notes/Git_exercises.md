## Git Exercises for Practice (With Expected Output)

These exercises are designed for beginners who want **hands-on practice** with Git. You can do this on your **local system only**, without GitHub or internet.

---

###  Prerequisites:

* Git installed (`git --version`)
* A folder created for testing Git (e.g., `mkdir git-practice && cd git-practice`)
* Initialize with `git init`

---

###  Exercise 1: Basic Git Workflow

**Task:** Create a file, track it with Git, and make your first commit.

**Steps:**

```bash
echo "Hello Git" > hello.txt
git init
git add hello.txt
git commit -m "Initial commit"
```

**Expected Output:**

* `git status` should be clean
* `git log` shows one commit with your message

---

###  Exercise 2: Modifying and Staging Files

**Task:** Make changes and stage them step-by-step.

**Steps:**

```bash
echo "Adding new line" >> hello.txt
git status
git add hello.txt
git commit -m "Added a new line to hello.txt"
```

**Expected Output:**

* `git log` now shows 2 commits
* `git diff` shows no changes

---

###  Exercise 3: Unstaged vs Staged Diff

**Task:** Understand `git diff` and `git diff --cached`.

**Steps:**

```bash
echo "Third line" >> hello.txt
git diff                # Shows diff of modified (not staged)
git add hello.txt
git diff                # Should show nothing now
git diff --cached       # Shows what's staged
```

---

###  Exercise 4: Using .gitignore

**Task:** Ignore log files.

**Steps:**

```bash
echo "*.log" > .gitignore
echo "error log" > app.log
git status              # app.log should not appear
```

---

###  Exercise 5: Create and Switch Branches

**Task:** Create a new branch and switch.

**Steps:**

```bash
git branch feature-a
git checkout feature-a
echo "This is feature A" > feature.txt
git add .
git commit -m "Feature A added"
```

---

###  Exercise 6: Merge Branches

**Task:** Merge a feature into main.

**Steps:**

```bash
git checkout main
git merge feature-a
```

**Expected Output:**

* Merged successfully with new commit
* `feature.txt` appears in `main`

---

###  Exercise 7: Reset and Revert

**Task:** Undo changes using `reset` and `revert`

```bash
echo "Bad content" >> hello.txt
git add .
git commit -m "Bad commit"
git revert HEAD       # Reverts bad commit
```

Try reset (careful!):

```bash
git reset --hard HEAD~1  # Removes last commit and changes
```

---

###  Exercise 8: Stashing

**Task:** Use stash to save uncommitted work.

**Steps:**

```bash
echo "Temp line" >> hello.txt
git stash
git stash apply
```

---

###  Exercise 9: Tags

```bash
git tag v1.0 -m "Release v1.0"
git show v1.0
```

---

###  Exercise 10: Log & Reflog

```bash
git log --oneline
git reflog
```

