### 🔄 **JPA Entity Lifecycle States**

JPA entities can be in one of the following four states:

---

### 🟧 1. **Transient**

* **Definition:** The entity is **not associated with any persistence context** and **not stored in the database**.
* **How it gets here:**

  * When you **create a new instance** of an entity using `new`.
* **Transition to Managed:**

  * `persist(entity)`: Makes it managed (and inserts it into the DB).
  * `merge(entity)`: Returns a managed copy.
* **Key Properties:**

  * No persistence context tracking.
  * Not yet persisted or removed.

---

### 🟩 2. **Managed**

* **Definition:** The entity is **associated with a persistence context**.
* **How it gets here:**

  * By calling:

    * `persist(entity)`
    * `find()`
    * `getReference()`
    * Queries like `em.createQuery(...)`
    * `merge()` (returns a **new managed copy**)
* **Transition to:**

  * **Removed** via `remove(entity)`
  * **Detached** via:

    * `detach(entity)`
    * `clear()` (for all entities in context)
    * `close()` (for all entities in context)
* **Key Properties:**

  * Tracked by persistence context.
  * Automatically synchronized with the DB at commit/flush.

---

### 🟥 3. **Removed**

* **Definition:** The entity is marked for deletion in the persistence context.
* **How it gets here:**

  * From **Managed** via `remove(entity)`
* **Transition back to Managed:**

  * `persist(entity)` (undoes removal if within same context before flush)
* **Final state after commit:**

  * The entity is **deleted from the DB**.

---

### 🟫 4. **Detached**

* **Definition:** The entity was once managed but is now **disconnected** from the persistence context.
* **How it gets here:**

  * `detach(entity)`
  * `clear()`
  * `close()`
* **Transition to Managed:**

  * `merge(entity)` returns a **new managed instance**.

    * Original stays detached.
* **Key Properties:**

  * No tracking.
  * Changes to it won’t be saved unless merged.

---

### 🔁 Transitions Summary (with methods):

| From → To           | Method                              | Notes                                                   |
| ------------------- | ----------------------------------- | ------------------------------------------------------- |
| Transient → Managed | `persist(entity)`                   | Entity becomes managed, inserted to DB.                 |
| Transient → Managed | `merge(entity)`                     | Returns a new managed copy, original remains transient. |
| Managed → Removed   | `remove(entity)`                    | Marks entity for deletion.                              |
| Removed → Managed   | `persist(entity)`                   | Cancels deletion if still in context.                   |
| Managed → Detached  | `detach(entity)`                    | Entity is no longer managed.                            |
| Managed → Detached  | `clear()` or `close()`              | Applies to **all entities** in context.                 |
| Detached → Managed  | `merge(entity)`                     | Returns a new managed instance.                         |
| Any → Managed       | `find()`, `getReference()`, queries | Retrieves entity from DB and manages it.                |
| Managed → Managed   | `refresh(entity)`                   | Reloads the entity from DB.                             |

---

### ⭐ Footnotes in Diagram:

* `*` indicates the method affects **all entities** in the persistence context (`clear()`, `close()`).
* `**` indicates `merge()` **returns a new managed instance**, and the **original remains in its current state** (e.g., transient or detached).

---

