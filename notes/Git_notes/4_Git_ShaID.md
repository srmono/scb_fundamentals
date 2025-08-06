### 4. Understanding SHA ID in Git

---

#### What is a SHA ID?

In Git, every commit you make is identified by a unique SHA-1 hash. This is a 40-character string that acts like a fingerprint for that specific commit.

Example:

```
a47c3f8bd87f97d17b34f4b8917ac4c5a9d4e13a
```

This SHA ID uniquely identifies the entire snapshot of the project at the time of the commit.

---

#### Why is SHA ID important?

* You can refer to a specific commit using its SHA ID.
* Useful for reverting, checking out, or comparing previous versions.
* Helps in collaborative workflows (e.g., reviewing or cherry-picking changes).

---

#### What does the SHA ID represent?

It’s calculated based on:

* Contents of all files in the commit
* Author and timestamp
* Commit message
* Parent commit reference(s)

That means even a small change (e.g., a different author name or a space in a message) will result in a completely different SHA.

---

#### How to see the SHA IDs?

After a commit, run:

```
git log
```

Sample output:

```
commit a47c3f8bd87f97d17b34f4b8917ac4c5a9d4e13a
Author: Hamsika B <you@example.com>
Date:   Thu Aug 1 10:15:20 2025 +0530

    Initial commit with README and app.js
```

The first line is the full SHA ID of that commit.

You can also run:

```
git log --oneline
```

This gives a shortened SHA:

```
a47c3f8 Initial commit with README and app.js
```

---

#### Can we refer to short SHAs?

Yes. Git allows you to use the first few (usually 7) characters of the SHA as long as they are unique.

Example:

```
git checkout a47c3f8
```

---

#### How to use SHA in practice

1. View details of a past commit:

```
git show a47c3f8
```

2. Revert to a commit (without erasing history):

```
git revert a47c3f8
```

3. See file version at a specific commit:

```
git checkout a47c3f8 -- filename
```

---

#### Summary

* Git uses SHA-1 hash to uniquely identify each commit
* It ensures integrity and traceability of changes
* You can use SHA IDs to reference, inspect, or revert changes

