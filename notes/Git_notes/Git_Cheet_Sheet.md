## Git Cheat Sheet (Beginner + Concepts)

Below is the complete **Git Cheat Sheet** covering everything we discussed in the 10 blocks.

Once you review it, I can provide it as a downloadable **PDF or Markdown file** too.

---

###  Git from Scratch – Beginner-Friendly Conceptual Cheat Sheet

---

#### 1. **SCM & Git Basics**

* **SCM (Source Control Management):** Tracks and manages file changes.
* **Centralized vs Distributed SCM:**

  * Centralized (SVN): One central copy
  * Distributed (Git): Each user has the full repo
* Git created by Linus Torvalds in 2005.

---

#### 2. **Git Architecture – The 3 Trees**

* **Working Directory:** Your local files.
* **Staging Area (Index):** Temporary area to prepare commits.
* **Local Repository (HEAD):** Final saved commit history.

Flow:
`Working Directory` → `git add` → `Staging` → `git commit` → `Repository`

---

#### 3. **Git Basics**

```bash
git init                      # Start a new local Git repo
git add <file>               # Stage file for commit
git commit -m "message"      # Commit staged changes
git status                   # Show current status
git log                      # Show commit history
```

---

#### 4. **.gitignore**

* Add patterns to ignore files from being tracked.
  Example:

```
node_modules/
*.log
.env
```

---

#### 5. **SHA ID**

* Every commit has a unique 40-character hash.

```bash
git log              # Full SHA
git log --oneline    # Short SHA
git show <sha>       # Commit details
```

---

#### 6. **Amend / Revert / Reset**

```bash
git commit --amend            # Change last commit
git revert <sha>              # Undo a commit safely
git reset --soft <sha>        # Undo commit, keep staging
git reset --mixed <sha>       # Undo commit, unstage
git reset --hard <sha>        # Undo and delete changes
```

---

#### 7. **Branching and Merging**

```bash
git branch new-feature        # Create a branch
git checkout new-feature      # Switch to it
git checkout -b feature2      # Create and switch
git merge new-feature         # Merge into current branch
git branch -d new-feature     # Delete after merge
```

---

#### 8. **Tagging Releases**

```bash
git tag v1.0                  # Lightweight tag
git tag -a v1.0 -m "v1.0"     # Annotated tag
git push origin v1.0          # Push specific tag
git push --tags               # Push all tags
```

---

#### 9. **Working with GitHub (Remote)**

```bash
git remote add origin <url>   # Link remote repo
git push -u origin main       # Push to GitHub
git pull                      # Fetch and merge
git clone <url>               # Copy remote repo
```

---

#### 10. **Git Diff, Log, Show**

```bash
git diff                      # Compare unstaged
git diff --cached             # Compare staged
git diff <sha1> <sha2>        # Compare commits
git show <sha>                # Full details of commit
```

---

#### 11. **Stash & Reflog**

```bash
git stash                     # Save uncommitted changes
git stash apply               # Restore stash
git stash pop                 # Apply and delete stash
git reflog                    # Show history of HEAD changes
```

---

#### 12. **Cherry-pick**

```bash
git cherry-pick <sha>         # Apply specific commit
```

