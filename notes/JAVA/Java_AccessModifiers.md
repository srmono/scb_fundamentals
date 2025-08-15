## **1. What Are Access Modifiers?**

Access modifiers in Java **control the visibility (accessibility)** of classes, methods, and variables.

Java has **4 levels of access**:

| Modifier                   | Class | Package | Subclass (diff pkg) | World (anywhere) |
| -------------------------- | ----- | ------- | ------------------- | ---------------- |
| **private**                | ✔     | ✖       | ✖                   | ✖                |
| **default** *(no keyword)* | ✔     | ✔       | ✖                   | ✖                |
| **protected**              | ✔     | ✔       | ✔                   | ✖                |
| **public**                 | ✔     | ✔       | ✔                   | ✔                |

---

## **2. The Four Access Modifiers**

### **1. `private`**

* Accessible **only** within the **same class**.
* Most restrictive.
* Used for **encapsulation** (hide internal details).

### **2. Default (package-private)**

* No keyword.
* Accessible **only within the same package**.

### **3. `protected`**

* Accessible:

  * Within the same package.
  * In subclasses (even in different packages).

### **4. `public`**

* Accessible from **anywhere**.

---

## **3. Real-Time Analogy**

Think of a **house**:

* `private` → Your bedroom (only you).
* default → Inside the house (only house members).
* `protected` → Friends/family with a spare key (subclass access).
* `public` → Front yard (anyone can enter).

---

## **4. Full Java Example — 3 Files in Different Packages**

**File 1: `src/pack1/Parent.java`**

```java
package pack1;

public class Parent {
    private String privateVar = "Private Var";
    String defaultVar = "Default Var";  // package-private
    protected String protectedVar = "Protected Var";
    public String publicVar = "Public Var";

    private void privateMethod() {
        System.out.println("Private Method");
    }
    void defaultMethod() {
        System.out.println("Default Method");
    }
    protected void protectedMethod() {
        System.out.println("Protected Method");
    }
    public void publicMethod() {
        System.out.println("Public Method");
    }

    public void accessWithinClass() {
        System.out.println(privateVar);
        System.out.println(defaultVar);
        System.out.println(protectedVar);
        System.out.println(publicVar);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }
}
```

---

**File 2: `src/pack1/SamePackageTest.java`**

```java
package pack1;

public class SamePackageTest {
    public static void main(String[] args) {
        Parent p = new Parent();

        // System.out.println(p.privateVar); // ❌ Not accessible
        System.out.println(p.defaultVar);     // ✔ Accessible (same package)
        System.out.println(p.protectedVar);   // ✔ Accessible (same package)
        System.out.println(p.publicVar);      // ✔ Accessible

        // p.privateMethod(); // ❌ Not accessible
        p.defaultMethod();    // ✔
        p.protectedMethod();  // ✔
        p.publicMethod();     // ✔
    }
}
```

---

**File 3: `src/pack2/DifferentPackageTest.java`**

```java
package pack2;

import pack1.Parent;

public class DifferentPackageTest {
    public static void main(String[] args) {
        Parent p = new Parent();

        // System.out.println(p.privateVar);   // ❌
        // System.out.println(p.defaultVar);   // ❌
        // System.out.println(p.protectedVar); // ❌ (not subclass)
        System.out.println(p.publicVar);       // ✔

        // p.privateMethod();  // ❌
        // p.defaultMethod();  // ❌
        // p.protectedMethod();// ❌
        p.publicMethod();      // ✔
    }
}
```

---

**File 4: `src/pack2/Child.java`**

```java
package pack2;

import pack1.Parent;

public class Child extends Parent {
    public static void main(String[] args) {
        Child c = new Child();

        // System.out.println(c.privateVar);  // ❌
        // System.out.println(c.defaultVar);  // ❌
        System.out.println(c.protectedVar);   // ✔ (subclass access)
        System.out.println(c.publicVar);      // ✔

        // c.privateMethod();  // ❌
        // c.defaultMethod();  // ❌
        c.protectedMethod();   // ✔
        c.publicMethod();      // ✔
    }
}
```

---

## **5. Output**

When running:

```
SamePackageTest
Default Var
Protected Var
Public Var
Default Method
Protected Method
Public Method

DifferentPackageTest
Public Var
Public Method

Child
Protected Var
Public Var
Protected Method
Public Method
```

---

## **6. Key Points**

* **private** → same class only.
* **default** → same package only.
* **protected** → same package + subclasses (even different packages).
* **public** → anywhere.


---

## **Java Access Modifiers + Static + Final Example (Single File)**

```java
public class ModifiersDemo {

    // Access Modifiers
    private String privateVar = "Private Variable";
    String defaultVar = "Default Variable";       // package-private
    protected String protectedVar = "Protected Variable";
    public String publicVar = "Public Variable";

    // Non-Access Modifiers
    public static final double PI = 3.14159; // Constant shared by all

    public static void main(String[] args) {

        ModifiersDemo obj = new ModifiersDemo();

        // Accessing variables within the same class
        System.out.println("Private: " + obj.privateVar);
        System.out.println("Default: " + obj.defaultVar);
        System.out.println("Protected: " + obj.protectedVar);
        System.out.println("Public: " + obj.publicVar);

        // Accessing static final constant
        System.out.println("Static Final Constant PI: " + PI);

        // Calling static method without object
        printHello();

        // Demonstrating final variable usage
        final int maxSpeed = 120;
        System.out.println("Final Variable (maxSpeed): " + maxSpeed);

        // Demonstrating final method
        obj.showMessage();

        // Demonstrating final class usage
        FinalClass finalObj = new FinalClass();
        finalObj.display();
    }

    // Static method example
    static void printHello() {
        System.out.println("Hello from static method!");
    }

    // Final method example
    public final void showMessage() {
        System.out.println("This is a final method and cannot be overridden.");
    }
}

// Final class example
final class FinalClass {
    public void display() {
        System.out.println("This is a final class and cannot be extended.");
    }
}
```

---

### **How to Run**

1. Save the file as **`ModifiersDemo.java`**.
2. Compile in terminal:

   ```bash
   javac ModifiersDemo.java
   ```
3. Run:

   ```bash
   java ModifiersDemo
   ```

---

### **Expected Output**

```
Private: Private Variable
Default: Default Variable
Protected: Protected Variable
Public: Public Variable
Static Final Constant PI: 3.14159
Hello from static method!
Final Variable (maxSpeed): 120
This is a final method and cannot be overridden.
This is a final class and cannot be extended.
```

