### 9. Stash and Reflog – Temporary Storage and History Tracking

---

#### Git Stash – Temporarily Saving Uncommitted Work

Stash is used when you want to:

* Switch branches or pull changes
* But don’t want to commit your current changes yet

Instead of committing, you "stash" them—like putting your work into a drawer.

---

##### Example Workflow:

1. You’re working on something:

```bash
echo "Temporary update" >> app.js
```

2. You realize you need to switch branches or pull latest changes but can’t commit yet.

3. Stash your changes:

```bash
git stash
```

Now your working directory is clean, and the changes are saved in a temporary stack.

4. Switch branch or pull, then come back.

5. Reapply the changes:

```bash
git stash apply
```

If you have multiple stashes:

```bash
git stash list
git stash apply stash@{1}
```

To remove stash after applying:

```bash
git stash drop stash@{1}
```

Apply and delete in one shot:

```bash
git stash pop
```

---

##### Common Stash Scenarios

* Stash untracked files too:

```bash
git stash -u
```

* Stash with a message:

```bash
git stash push -m "WIP: login feature"
```

---

#### Git Reflog – Viewing All Git Actions (Even Dangling Commits)

Git’s reflog lets you track all local actions—commits, checkouts, resets, etc.

Even if a commit is no longer referenced by any branch, reflog knows about it.

---

##### Example: View Reflog

```bash
git reflog
```

Sample output:

```
a12c3f4 HEAD@{0}: commit: Fixed typo
b98d432 HEAD@{1}: checkout: moving from feature-1 to main
...
```

You can go back in time using:

```bash
git checkout HEAD@{1}
```

Or recover a commit that was deleted:

```bash
git checkout a12c3f4
```

---

##### Reflog vs Log

* `git log`: shows history of commits in your current branch
* `git reflog`: shows everything Git has tracked in your local repo, including actions that modified HEAD

---

#### Summary

* `git stash` temporarily shelves uncommitted work
* `git stash apply` restores it later; `pop` applies and deletes
* `git reflog` tracks all HEAD movements and helps recover lost commits
* Helpful when you reset, amend, or accidentally delete something
