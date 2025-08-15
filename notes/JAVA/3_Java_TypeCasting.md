Let’s go through **Type Casting in Java** 

---

## **What is Type Casting in Java?**

Type casting is **converting one data type into another**.
In Java, this happens in two main ways:

---

## **1. Widening Casting (Implicit Conversion)**

* **Smaller type → Larger type**
* Happens automatically (no data loss, safe conversion).
* Example order:
  `byte → short → int → long → float → double`
* Also called **upcasting**.

**Example:**

```java
public class WideningExample {
    public static void main(String[] args) {
        int myInt = 9;
        double myDouble = myInt;  // Automatic casting: int → double

        System.out.println("Int value: " + myInt);
        System.out.println("Double value: " + myDouble);
    }
}
```

**Output:**

```
Int value: 9
Double value: 9.0
```

---

## **2. Narrowing Casting (Explicit Conversion)**

* **Larger type → Smaller type**
* Must be done manually (may lose data).
* Example order:
  `double → float → long → int → short → byte`
* Also called **downcasting**.

**Example:**

```java
public class NarrowingExample {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble;  // Manual casting: double → int

        System.out.println("Double value: " + myDouble);
        System.out.println("Int value: " + myInt);
    }
}
```

**Output:**

```
Double value: 9.78
Int value: 9
```

---

## **3. Type Casting with Non-Primitive Types**

* Works with inheritance: **casting objects** from one type to another.
* Two forms:

  * **Upcasting** (child → parent) – automatic.
  * **Downcasting** (parent → child) – needs explicit cast.

**Example:**

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class ObjectCastingExample {
    public static void main(String[] args) {
        Animal a = new Dog(); // Upcasting
        a.sound();

        Dog d = (Dog) a; // Downcasting
        d.sound();
    }
}
```

---

## **Key Points**

* **Widening** is safe and automatic.
* **Narrowing** needs explicit syntax `(type)`.
* When **downcasting objects**, ensure the type is actually the subclass to avoid `ClassCastException`.
