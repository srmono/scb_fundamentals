## 1. What Are Branches in Git?

Branches let you work on different versions of a project **without affecting the main code**. This is useful for testing new features or fixing bugs safely.

The default branch is usually called `main` or `master`.

---

## 🛠 2. Set Up Git (If You Haven't Already)

```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
```

---

## 📁 3. Start a New Git Project (or Clone One)

* To create a new repo:

```bash
mkdir my-project
cd my-project
git init
```

* To clone an existing repo:

```bash
git clone https://github.com/user/repo.git
cd repo
```

---

## 🌿 4. Create a New Branch

```bash
git checkout -b my-feature
```

This does two things:

1. **Creates** a new branch called `my-feature`
2. **Switches** you to that branch

---

## 🔄 5. Switch Between Branches

* To switch to an existing branch:

```bash
git checkout main
```

* To list all branches:

```bash
git branch
```

---

## ✍️ 6. Make Changes and Commit

Edit your files, then:

```bash
git add .
git commit -m "Add my new feature"
```

You're still working inside the `my-feature` branch. These changes won't affect `main` yet.

---

## 🔀 7. Merge the Branch into Main

1. Switch back to the main branch:

```bash
git checkout main
```

2. Merge your feature branch into main:

```bash
git merge my-feature
```

Now, your changes are part of the main codebase.

---

## 🧹 8. Delete the Old Branch (Optional)

Once merged, you can clean up:

```bash
git branch -d my-feature
```

---

## ⬆️ 9. Push to Remote (GitHub, etc.)

If you're using GitHub or a remote repo:

```bash
git push origin main
```

If you want to push a new branch:

```bash
git push origin my-feature
```

---

## 🎯 Quick Reference Cheat Sheet

| Task              | Command                                       |
| ----------------- | --------------------------------------------- |
| List branches     | `git branch`                                  |
| Create new branch | `git checkout -b branch-name`                 |
| Switch branches   | `git checkout branch-name`                    |
| Commit changes    | `git add .` → `git commit -m "msg"`           |
| Merge into main   | `git checkout main` → `git merge branch-name` |
| Delete a branch   | `git branch -d branch-name`                   |
| Push changes      | `git push origin branch-name`                 |

