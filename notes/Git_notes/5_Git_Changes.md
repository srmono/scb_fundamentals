### 5. Editing Files, Amending, and Reverting Changes in Git

---

#### Scenario 1: Editing a Tracked File

If you edit a file that’s already tracked (committed earlier):

1. Modify `app.js`:

```js
console.log('Hello Git Learner!');
```

2. Check status:

```bash
git status
```

You’ll see:

```
modified: app.js
```

3. Stage the change:

```bash
git add app.js
```

4. Commit the change:

```bash
git commit -m "Updated greeting message in app.js"
```

---

#### Scenario 2: Amend the Last Commit (Fix Message or Add Missed File)

Let’s say you forgot to include a file or made a typo in the last commit message.

1. Add missing file or make changes:

```bash
echo "new content" > extra.txt
git add extra.txt
```

2. Amend the previous commit:

```bash
git commit --amend
```

It opens the editor to change the commit message if needed. If you only want to update staged files (not message), use:

```bash
git commit --amend --no-edit
```

Note:

* Avoid `amend` after you’ve pushed to a remote.
* It rewrites commit history.

---

#### Scenario 3: Revert File Changes (before commit)

You modified a file and want to discard the changes:

```bash
git checkout -- app.js
```

This restores the file to the last committed version.

If it was staged (added), unstage it first:

```bash
git reset app.js
git checkout -- app.js
```

---

#### Scenario 4: Revert a Committed Change

Let’s say a commit caused a bug and you want to undo it (but keep history).

1. Find the SHA:

```bash
git log --oneline
```

2. Revert it:

```bash
git revert <sha-id>
```

This creates a new commit that undoes the previous one.

---

#### Scenario 5: Resetting to a Previous Commit (Destructive)

If you want to **go back in time** and delete commits (use with caution):

```bash
git reset --hard <sha-id>
```

This will:

* Remove all commits after that SHA
* Overwrite working directory too

If you want to keep changes in working directory:

```bash
git reset --soft <sha-id>
```

Use `--mixed` to reset staging but keep file changes:

```bash
git reset --mixed <sha-id>
```

---

#### Summary

* Use `git commit --amend` to fix the last commit
* Use `git checkout -- filename` to discard uncommitted changes
* Use `git revert <sha>` to undo commits safely
* Use `git reset` carefully to move backward in history

