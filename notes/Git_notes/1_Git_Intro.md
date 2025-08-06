###  **1. Introduction, History of SCM (Source Control Management)**

---

#### **What is Source Control Management (SCM)?**

SCM is the practice of tracking and managing changes to code, documents, or other sets of files over time.

#### 🔍 **Why is it needed?**

* Collaboration: Multiple developers can work together.
* Versioning: Track who changed what and when.
* Backup: Easily revert to a previous stable version.
* Audit: Review history for debugging or compliance.

---

### 🕰️ **A Brief History of SCM**

| Era            | Tools              | Notes                                             |
| -------------- | ------------------ | ------------------------------------------------- |
| 1970s–80s      | SCCS, RCS          | Very basic, single-file based                     |
| 1990s          | CVS, Perforce      | Centralized SCMs begin, multi-user support        |
| 2000s          | Subversion (SVN)   | Centralized but more advanced                     |
| **Mid-2000s+** | **Git, Mercurial** | Distributed Version Control Systems (DVCS) emerge |

---

### 🚀 **What is Git?**

Git is a **Distributed Version Control System (DVCS)** created by **Linus Torvalds** (creator of Linux) in **2005**. It tracks changes to source code and allows multiple developers to work on the same project **independently and offline**.

---

### 📦 Centralized vs Distributed SCM

| Feature             | Centralized (e.g., SVN)     | Distributed (e.g., Git)    |
| ------------------- | --------------------------- | -------------------------- |
| Repository Location | Central server only         | Each user has full copy    |
| Work Offline        | ❌                           |                           |
| Speed               | Slower (network)            | Faster (local)             |
| Risk                | Server downtime = no access | Users still have full repo |

---

###    Real-World Analogy:

> Imagine a group working on a story.
>
> * In SVN: There’s one **master copy** in a library. You must go there to read or update.
> * In Git: Each member has a **photocopy** of the story. They make edits and then sync changes with others.

