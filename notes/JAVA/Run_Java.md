1. A tiny `Welcome` Java program.
2. How to **save**, **compile** and **run** it manually using `javac` + `java` (commands for Windows & mac/linux).
3. How to do the same inside an editor (VS Code and IntelliJ quick steps).
4. A plain explanation of the execution hierarchy: source → compiler → bytecode → JVM → machine code (with a small analogy).

# 1) The tiny program (save as `Welcome.java`)

```java
public class Welcome {
    public static void main(String[] args) {
        System.out.println("Welcome to Java!");
    }
}
```

Save exactly as `Welcome.java` (file name must match the `public class` name).

---

# 2) Compile & run manually (terminal / command-line)

## Step A — Check Java is installed

Open a terminal (mac/linux) or Command Prompt / PowerShell (Windows) and run:

```
javac -version
java -version
```

If both print versions (e.g. `javac 17.0.x` / `java 17.0.x`), you are ready. If not, install a JDK first.

## Step B — Save the file

Put `Welcome.java` in a folder you can reach from the terminal. Example:

* On Windows: `C:\Users\You\java-demo\Welcome.java`
* On mac/linux: `/home/you/java-demo/Welcome.java`

Open terminal and `cd` into that folder:

```
cd path/to/java-demo
```

## Step C — Compile with `javac`

```
javac Welcome.java
```

What this does: `javac` translates `Welcome.java` into bytecode and writes a file `Welcome.class` in the same folder.

If there are errors (typos, missing semicolon, wrong class name), `javac` will print messages referencing line numbers. Fix the errors in the `.java` file and `javac` again.

## Step D — Run with `java`

```
java Welcome
```

Important: run with the class name **without** `.class`. Output should be:

```
Welcome to Java!
```

### Quick Windows example

```
C:\> cd C:\Users\You\java-demo
C:\Users\You\java-demo> javac Welcome.java
C:\Users\You\java-demo> dir
 Welcome.class
 Welcome.java
C:\Users\You\java-demo> java Welcome
Welcome to Java!
```

### Quick mac/linux example

```
$ cd ~/java-demo
$ javac Welcome.java
$ ls
Welcome.class  Welcome.java
$ java Welcome
Welcome to Java!
```

---

# 3) Run inside an editor (two simple options)

## Option A — VS Code (plain steps)

1. Install VS Code and the **Extension: "Java Extension Pack"** (provides language support & Run button).
2. Open the folder containing `Welcome.java` (`File → Open Folder`).
3. Create `Welcome.java` and paste code.
4. Press \*\*Ctrl+`** to open terminal (or `Terminal → New Terminal\`).
5. Run the same commands: `javac Welcome.java` then `java Welcome`.

   * Or click the green **Run** icon that appears above the `main` method if the Java extension is active.

## Option B — IntelliJ IDEA (Community)

1. New Project → Java → Create project.
2. Right-click `src` → New → Java Class → name `Welcome`.
3. Paste the code into the editor.
4. Click the green **Run** ▶︎ next to `main` method. IntelliJ compiles and runs automatically.

> Both editors ultimately call `javac` and `java` behind the scenes (or their own build tool), but as a beginner it’s fine to use the terminal commands — they make the steps clear.

---

# 4) What happens under the hood — simple hierarchy (analogy + short flow)

**Analogy:** writing a recipe in English → translating to a universal recipe format → a chef reads it and converts to local steps for the local kitchen.

1. **Java source** (`.java`) — the human-readable code you write (the recipe in English).
2. **Java compiler (`javac`)** — translates `.java` → `.class` (bytecode). Bytecode is a portable, intermediate representation (a universal recipe).

   * After `javac Welcome.java` you get `Welcome.class`.
3. **Bytecode (`.class`)** — platform-independent instructions. You can move this `.class` file to another OS and run it with a compatible JVM.
4. **JVM (Java Virtual Machine)** — the runtime (the chef). The JVM **loads** your `.class`, **verifies** it, **interprets** and/or **JIT-compiles** hot parts into native machine code for the CPU.

   * So JVM turns bytecode into actual machine instructions that the CPU executes.
5. **Machine code** — CPU-executable native code the OS runs (the local steps the chef uses in this kitchen).

**Short flow (commands → artifacts):**

```
Welcome.java  --(javac)-->  Welcome.class  --(java / JVM)--> machine code & program runs
```

**Parts you should know:**

* **JDK** (Java Development Kit) includes `javac` (compiler) + tools + `java` launcher.
* **JRE** (Java Runtime Environment) contains the JVM and libraries (used to run programs).
* `javac` is only in JDK. `java` (JVM) is in both.

---

# 5) Common beginner pitfalls & fixes

* **Class name and file name mismatch**
  `public class Welcome` must be in `Welcome.java`. Otherwise `javac` error.
* **Running with `.class`**
  Use `java Welcome` **not** `java Welcome.class`.
* **"Could not find or load main class"**
  Usually you are in the wrong directory or used packages (see below) — make sure you run from the project root and use the fully qualified class name if package is present.
* **Using `package` statement**
  If you add `package com.myapp;` at the top, the file must be in `com/myapp/Welcome.java` and run with `java com.myapp.Welcome` from the parent folder.
* **Typing letters when `java` expects a number** — not relevant for this program, but use `try-catch` for robust input (we added that earlier for your bank app).

---

# 6) Small extra: package example (if/when you want it)

If your file starts with:

```java
package com.example;
public class Welcome { ... }
```

Then:

* Save at `com/example/Welcome.java`.
* Compile from project root:

  ```
  javac com/example/Welcome.java
  ```
* Run:

  ```
  java com.example.Welcome
  ```

---

Let’s dissect your Java code and make sure you understand **exactly what each part means and why it’s there**.

Here’s the code:

```java
public class Welcome {
    public static void main(String[] args) {
        System.out.println("Welcome to Java!");
    }
}
```

---

## **1. `public`**

* **Type:** **Access Modifier** (a keyword in Java)
* **Meaning:** Says **who can access** this class or method.
* Here it means:

  * **This class** (and later the `main` method) is visible to **all other classes** anywhere.
  * The Java Virtual Machine (JVM) **must** be able to access the `main` method from outside your class to run it, so it must be `public`.

---

## **2. `class`**

* **Type:** **Keyword**
* **Meaning:** Used to define a **class**, which is a blueprint for creating objects.
* In Java, **everything** must be inside a class (except package and import statements).
* The **class name** follows it.

---

## **3. `Welcome`**

* **Type:** **Identifier** (name you give to the class)
* **Rules:**

  * Must start with a letter, `_` (underscore), or `$` sign.
  * Cannot start with a number.
  * Cannot be a Java keyword.
* **Convention:** Class names use **PascalCase** (first letter of each word capitalized).
* In this example:

  * The file **must** be named `Welcome.java` because the class is `public`.

---

## **4. `{ ... }` (Curly Braces)**

* **Meaning:** Marks the **start** `{` and **end** `}` of:

  * Class body
  * Method body
  * Loops, if-else, etc.
* Everything inside `{ }` is part of that structure.

---

## **5. `public static void main`**

This is **the method that Java looks for first** when running a program.

### a) `public`

* JVM needs to call this method **from outside** the class, so it must be public.

### b) `static`

* Means the method **belongs to the class** itself, **not** to an object.
* JVM can call it **without creating an object** of the class.
* Example:

  ```java
  Welcome w = new Welcome(); // not required for main
  w.main(...); // we don’t do this
  ```

  Instead, JVM calls it directly as:

  ```java
  Welcome.main(...);
  ```

### c) `void`

* **Return type**: Says the method **does not return any value**.
* `main` just runs code — it doesn’t give anything back to whoever called it.

### d) `main`

* This is **the method name**.
* It must be exactly `main` (lowercase) — otherwise JVM won’t recognize it as the entry point.

---

## **6. `(String[] args)`**

* **Parameter list** for the `main` method.
* `String[]` → An **array of Strings**.
* `args` → The **name** of the parameter (you can change it, but convention is `args`).
* Purpose:

  * Lets you pass arguments from the **command line** into your program.
  * Example:

    ```bash
    java Welcome Hello World
    ```

    * `args[0]` = `"Hello"`
    * `args[1]` = `"World"`

---

## **7. `System.out.println`**

* **`System`** → A built-in Java class in `java.lang` package.
* **`out`** → A **static variable** inside `System` that refers to the **standard output stream** (usually your console).
* **`println`** → A method of `PrintStream` class (the type of `System.out`).

  * Prints the given text **followed by a new line**.
  * `print` → Same but without new line.

---

## **8. `"Welcome to Java!"`**

* **String literal** — sequence of characters inside double quotes.
* Stored as a `String` object in Java.

---

## **9. `;` (Semicolon)**

* Marks the **end of a statement** in Java.

---

## **10. Execution Flow**

1. You compile:

   ```bash
   javac Welcome.java
   ```

   → Produces `Welcome.class` (bytecode).
2. You run:

   ```bash
   java Welcome
   ```

   → JVM loads `Welcome.class`.
3. JVM searches for:

   ```java
   public static void main(String[] args)
   ```
4. Executes code inside `main`:

   * Calls `System.out.println("Welcome to Java!")`
   * Prints text and moves to a new line.
5. Program ends.

