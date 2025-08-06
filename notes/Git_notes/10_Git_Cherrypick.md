### 10. Cherry-pick and Reset – Selective and Targeted History Control

---

#### Git Cherry-pick – Copy Specific Commit(s) to Another Branch

Cherry-pick is used when you want to apply a commit from one branch to another without merging the entire branch.

---

##### Scenario:

You’re on `main` and want to apply one commit from `feature-1`.

1. View the commit in `feature-1`:

```bash
git checkout feature-1
git log --oneline
```

Suppose the commit you want is:

```
a1b2c3d Add validation to login form
```

2. Go back to `main`:

```bash
git checkout main
```

3. Apply the commit:

```bash
git cherry-pick a1b2c3d
```

This replays that exact commit on `main`, as a new commit.

---

##### Cherry-pick Multiple Commits

```bash
git cherry-pick commit1 commit2 commit3
```

For a range:

```bash
git cherry-pick A..B
```

This includes all commits after A up to and including B.

---

##### If conflicts occur:

Git will stop and ask you to resolve conflicts.

* After resolving:

```bash
git add .
git cherry-pick --continue
```

To abort the operation:

```bash
git cherry-pick --abort
```

---

#### Git Reset – Rewriting History

Reset is used to **move your current branch’s HEAD** to another commit. There are three modes:

---

##### 1. `--soft`: Move HEAD only

* Keeps all changes staged (index)
* Used to undo a commit but keep files ready to re-commit

```bash
git reset --soft HEAD~1
```

Now the last commit is undone, but files are still staged.

---

##### 2. `--mixed`: Move HEAD and unstage changes

* Default if no option is given
* Keeps file content, but removes from staging area

```bash
git reset HEAD~1
```

Files are uncommitted and also unstaged.

---

##### 3. `--hard`: Move HEAD and discard everything

* Dangerous. Removes commit and changes in working directory.

```bash
git reset --hard HEAD~1
```

This deletes the last commit and all file changes. Only use if you’re sure.

---

##### Reset to Specific Commit

You can also reset to a specific commit:

```bash
git reset --hard a1b2c3d
```

---

##### Recovering a Reset Commit

If you reset by mistake, use:

```bash
git reflog
```

Find the lost commit and checkout:

```bash
git checkout <sha>
```

Or recover:

```bash
git reset --hard <sha>
```

---

#### Summary

* `cherry-pick` lets you apply individual commits across branches
* `reset` moves your branch pointer to an earlier state
* `soft`, `mixed`, and `hard` give different levels of control
* Use `reflog` to recover accidentally lost commits

