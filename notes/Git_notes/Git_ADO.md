Step-by-step **“ADO Repos”** and **“Project Set Up on ADO”** 

---

## 🔹 What is Azure DevOps (ADO)?

Azure DevOps is a cloud-based DevOps service from Microsoft that provides tools for:

* Source code management (Repos)
* CI/CD (Pipelines)
* Project tracking (Boards)
* Test management (Test Plans)
* Artifact storage (Artifacts)

---

## 🔸 PART 1: Project Set Up on ADO

### ✅ Step-by-Step: Creating a Project

1. **Go to Azure DevOps**

   * URL: [https://dev.azure.com](https://dev.azure.com)
   * Sign in with your Microsoft account.

2. **Create a New Organization (Optional)**

   * You may first create an *Organization* which groups your projects.
   * Example: `my-company-name`

3. **Create a New Project**

   * Click `New Project`
   * Fill:

     * **Project Name**: `MyWebApp`
     * **Visibility**: Private (or Public)
     * **Advanced Options**:

       * **Version control**: Git (default)
       * **Work item process**: Agile/Scrum/Basic

4. **Project Created**

   * You now have Boards, Repos, Pipelines, etc., available.

---

## 🔸 PART 2: ADO Repos

Azure Repos is a set of version control tools that you can use to manage your code.

### ✅ Step-by-Step: Using Repos (Git)

#### 1. **Clone Your Repo**

Go to `Repos → Files → Clone`

```bash
git clone https://dev.azure.com/your-org/your-project/_git/your-repo
cd your-repo
```

#### 2. **Add Files and Push**

```bash
echo "# MyApp" >> README.md
git add .
git commit -m "Initial commit"
git push origin main
```

#### 3. **Create a Branch**

```bash
git checkout -b feature/login
```

#### 4. **Push the Branch**

```bash
git push origin feature/login
```

#### 5. **Create Pull Request (PR)**

* Go to Azure DevOps → Repos → Pull Requests → `New PR`
* Select source: `feature/login`, target: `main`
* Add reviewers, title, and description
* Complete PR or wait for review

---

## 🔸 Advanced Concepts in ADO Repos

| Concept               | Description                                                                       | Example                                            |
| --------------------- | --------------------------------------------------------------------------------- | -------------------------------------------------- |
| **Branch Policies**   | Set rules before merging to main (e.g., code review required, pipeline must pass) | `Project Settings → Repos → Branches → Add Policy` |
| **Tagging**           | Use tags to mark releases                                                         | `git tag -a v1.0 -m "Release"`                     |
| **Rebasing**          | Keep history clean by rebasing your feature branch before merging                 | `git pull --rebase origin main`                    |
| **Forking Strategy**  | Contribute without access to main repo (used in open source)                      | Not supported in ADO but possible using clone + PR |
| **CI/CD Integration** | Auto-build/test code using Pipelines on each push/PR                              | Define `.yaml` pipeline config                     |
| **YAML Pipelines**    | Store build and deploy steps in code                                              | `azure-pipelines.yml`                              |

---

## 🔸 Recommended Flow for Teams

1. Developer clones ADO repo
2. Creates a new branch for their feature
3. Makes commits and pushes to that branch
4. Raises a PR for review
5. CI pipeline runs and passes
6. Code reviewed → PR approved → merged to `main`
7. Deployment pipeline triggers (optional)

---

## 🧠 Pro Tips for Real-Time Use

* Use **Work Items** (Boards → Work Items) to link commits, branches, and PRs to tasks.
* Enable **Branch protection** to prevent direct `main` pushes.
* Use **Personal Access Token (PAT)** if Git prompts for credentials.
* Use `git fetch --prune` to clean up stale remote branches locally.

