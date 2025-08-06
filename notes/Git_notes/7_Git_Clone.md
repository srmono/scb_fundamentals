### 7. Clone, Push, Pull, Remote – Working with GitHub

---

#### What is a Remote?

A remote is a version of your Git repository that’s hosted on the internet or a network (e.g., GitHub).
You work locally and then sync with the remote to collaborate with others.

---

#### Setting Up a Remote Repository (GitHub)

1. Go to [https://github.com](https://github.com)
2. Create a new repository (e.g., `git-practice`)
3. Do **not** initialize with README if you're pushing from local

You’ll see this on GitHub after repo creation:

```bash
git remote add origin https://github.com/your-username/git-practice.git
```

---

#### Push Local Repo to GitHub

If your local repo is ready (with commits), push it:

```bash
git remote add origin https://github.com/your-username/git-practice.git
git branch -M main
git push -u origin main
```

Explanation:

* `origin` = the name of the remote
* `-u` sets the upstream (link between local and remote)

Now your local `main` branch is connected to the remote `main`.

---

#### Cloning a Remote Repo

To get a copy of a remote repo (e.g., someone else’s):

```bash
git clone https://github.com/otheruser/someproject.git
```

This creates a new local folder with:

* `.git` config
* Full commit history
* Working directory

---

#### Making Changes and Pushing

After cloning or connecting:

1. Edit or add files
2. Stage and commit as usual:

```bash
git add .
git commit -m "Made some changes"
```

3. Push to GitHub:

```bash
git push
```

If multiple branches:

```bash
git push origin branch-name
```

---

#### Pulling Changes (Sync from Remote)

When someone else has pushed changes:

```bash
git pull
```

This will:

* Fetch new changes
* Merge them into your current branch

If you want to fetch only (without merging yet):

```bash
git fetch
```

Then:

```bash
git merge origin/main
```

---

#### View and Manage Remotes

List remotes:

```bash
git remote -v
```

Remove a remote:

```bash
git remote remove origin
```

Rename remote:

```bash
git remote rename origin upstream
```

---

#### Summary

* `git clone` creates a local copy of a remote repo
* `git remote add` connects your repo to GitHub
* `git push` sends changes to remote
* `git pull` brings changes from remote to local
* `origin` is just a default name—you can rename it

