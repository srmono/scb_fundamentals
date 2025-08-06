### 6. Branching, Merging, and Tags

---

#### What is a Git Branch?

A branch in Git is like a pointer to a specific commit. It allows you to create isolated lines of development without affecting the main project.

By default, Git creates a `main` (or `master`) branch.

You can create new branches to:

* Develop features
* Fix bugs
* Test experiments

---

#### Creating a New Branch

```bash
git branch feature-1
```

This creates a new branch, but you're still on the current branch (`main`).

Switch to it:

```bash
git checkout feature-1
```

Or combine both:

```bash
git checkout -b feature-1
```

---

#### Making Changes in a Branch

Let’s simulate:

1. Create a new file:

```bash
echo "Feature 1 content" > feature.txt
```

2. Add and commit:

```bash
git add feature.txt
git commit -m "Add feature 1"
```

Now, `feature-1` has this commit. `main` does not.

---

#### Viewing Branches

```bash
git branch
```

Current branch is marked with `*`.

---

#### Merging Branches

Suppose you're done with `feature-1` and want to merge it into `main`.

1. Switch back to `main`:

```bash
git checkout main
```

2. Merge:

```bash
git merge feature-1
```

This brings changes from `feature-1` into `main`.

---

#### Fast-Forward vs Merge Commit

* If `main` has not changed since `feature-1` was created, Git performs a **fast-forward** merge (no extra commit).
* If there were commits on both branches, Git creates a **merge commit** to combine them.

---

#### Merge Conflicts

If the same line of a file was changed in both branches, Git will show a conflict:

```bash
CONFLICT (content): Merge conflict in filename
```

Git marks the conflict inside the file. You must:

* Manually fix the file
* Then run:

```bash
git add filename
git commit
```

---

#### Deleting a Merged Branch

Once merged:

```bash
git branch -d feature-1
```

Use `-D` (force delete) if not merged.

---

#### Creating and Using Tags

Tags are used to mark specific points in history—typically for releases.

Create a lightweight tag:

```bash
git tag v1.0
```

Create an annotated tag:

```bash
git tag -a v1.0 -m "First release"
```

List tags:

```bash
git tag
```

Push tags to remote:

```bash
git push origin v1.0
```

Or push all tags:

```bash
git push --tags
```

---

#### Summary

* Branches let you work independently on features
* Merging brings those changes back into main
* Tags mark important points like release versions
* Conflicts occur when overlapping changes happen—resolve manually

