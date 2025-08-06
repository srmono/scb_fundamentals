###  Basic Git Command Reference Table (With Flags & Explanation)

| **Command / Flag**       | **Type**   | **Meaning / Use**                                         | **Example**                                  |
| ------------------------ | ---------- | --------------------------------------------------------- | -------------------------------------------- |
| `git`                    | Command    | Base command to invoke Git                                | `git init`                                   |
| `init`                   | Subcommand | Creates a new empty Git repository                        | `git init`                                   |
| `add`                    | Subcommand | Stages changes for the next commit                        | `git add file.txt`                           |
| `.`                      | Argument   | Shortcut to stage all modified files                      | `git add .`                                  |
| `-A`                     | Flag       | Stages all changes (new, modified, deleted)               | `git add -A`                                 |
| `commit`                 | Subcommand | Creates a snapshot of staged changes                      | `git commit -m "message"`                    |
| `-m`                     | Flag       | Adds a commit message inline                              | `git commit -m "Initial commit"`             |
| `-a`                     | Flag       | Automatically stages tracked files before commit          | `git commit -a -m "Quick commit"`            |
| `status`                 | Subcommand | Shows the current status of working directory and staging | `git status`                                 |
| `log`                    | Subcommand | Displays commit history                                   | `git log`                                    |
| `--oneline`              | Flag       | Shows condensed one-line logs                             | `git log --oneline`                          |
| `--graph`                | Flag       | Shows commit history with a graph                         | `git log --oneline --graph`                  |
| `clone`                  | Subcommand | Copies a remote repository locally                        | `git clone https://github.com/user/repo.git` |
| `pull`                   | Subcommand | Fetches and merges from remote repo                       | `git pull origin main`                       |
| `push`                   | Subcommand | Sends your commits to the remote repository               | `git push origin main`                       |
| `-u` or `--set-upstream` | Flag       | Sets the default upstream for future push/pull            | `git push -u origin main`                    |
| `branch`                 | Subcommand | Lists, creates, or deletes branches                       | `git branch`                                 |
| `-d`                     | Flag       | Deletes a branch                                          | `git branch -d feature-x`                    |
| `checkout`               | Subcommand | Switches between branches or restores files               | `git checkout dev`                           |
| `-b`                     | Flag       | Creates and switches to a new branch                      | `git checkout -b feature-x`                  |
| `merge`                  | Subcommand | Merges another branch into current                        | `git merge feature-x`                        |
| `rebase`                 | Subcommand | Re-applies commits on top of another base tip             | `git rebase main`                            |
| `reset`                  | Subcommand | Unstages changes or rewinds commits                       | `git reset file.txt`                         |
| `--hard`                 | Flag       | Removes all changes and resets HEAD                       | `git reset --hard HEAD`                      |
| `--soft`                 | Flag       | Keeps changes in working directory, only rewinds commit   | `git reset --soft HEAD~1`                    |
| `stash`                  | Subcommand | Temporarily shelves changes                               | `git stash`                                  |
| `stash apply`            | Subcommand | Re-applies latest stashed changes                         | `git stash apply`                            |
| `remote`                 | Subcommand | Manages connections to remote repos                       | `git remote -v`                              |
| `add` (under remote)     | Subcommand | Adds a new remote                                         | `git remote add origin <url>`                |
| `fetch`                  | Subcommand | Downloads remote changes but doesn't merge                | `git fetch origin`                           |
| `tag`                    | Subcommand | Tags a specific commit                                    | `git tag -a v1.0 -m "Release"`               |
| `-a` (under tag)         | Flag       | Annotated tag (includes message, metadata)                | `git tag -a v1.0`                            |
| `-m` (under tag)         | Flag       | Tag message                                               | `git tag -a v1.0 -m "First stable version"`  |
| `show`                   | Subcommand | Shows details about commits, tags, etc.                   | `git show v1.0`                              |
| `diff`                   | Subcommand | Shows code differences between commits, branches, etc.    | `git diff HEAD`                              |
| `config`                 | Subcommand | Configures Git settings                                   | `git config --global user.name "Alice"`      |
| `--global`               | Flag       | Applies configuration to all Git projects                 | `git config --global user.email "..."`       |
| `clean`                  | Subcommand | Removes untracked files                                   | `git clean -f`                               |
| `-f`                     | Flag       | Force clean (required for safety)                         | `git clean -f`                               |
| `revert`                 | Subcommand | Creates a new commit that undoes a previous one           | `git revert <commit-id>`                     |

