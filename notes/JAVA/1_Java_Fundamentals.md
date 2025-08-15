## **1. What is Java?**

Java is a **high-level, object-oriented programming language** known for:

* **Platform independence** (write once, run anywhere — thanks to the Java Virtual Machine, JVM).
* **Strongly typed** (you must declare the type of variables).
* **Widely used** (web apps, Android apps, enterprise systems, etc.).

---

## **2. Basic Structure of a Java Program**

Every Java program has:

1. A **class** — the basic building block.
2. A **`main` method** — where the program starts running.
3. Statements inside `{ }` braces.

**Example:**

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Explanation:**

* `public class HelloWorld` → Creates a class named `HelloWorld`.
* `public static void main(String[] args)` → The main method where execution starts.
* `System.out.println()` → Prints text to the console.

---

## **3. Variables and Data Types**

Variables store data. In Java, you must declare their type.

| Type      | Example    | Description            |
| --------- | ---------- | ---------------------- |
| `int`     | 10         | Integer numbers        |
| `double`  | 5.99       | Decimal numbers        |
| `char`    | 'A'        | Single character       |
| `String`  | "Hello"    | Sequence of characters |
| `boolean` | true/false | True or false values   |

**Example:**

```java
public class VariablesExample {
    public static void main(String[] args) {
        int age = 25;
        double price = 19.99;
        char grade = 'A';
        String name = "Alice";
        boolean isStudent = true;

        System.out.println(name + " is " + age + " years old.");
    }
}
```

---

## **4. Operators**

Java has:

* Arithmetic: `+ - * / %`
* Comparison: `== != > < >= <=`
* Logical: `&& || !`

**Example:**

```java
int a = 5, b = 3;
System.out.println(a + b);  // 8
System.out.println(a > b);  // true
System.out.println(a == 5 && b == 3); // true
```

---

## **5. Control Statements**

These change the flow of a program.

### **If-Else**

```java
if (age >= 18) {
    System.out.println("You are an adult.");
} else {
    System.out.println("You are a minor.");
}
```

### **Switch**

```java
switch (day) {
    case 1: System.out.println("Monday"); break;
    case 2: System.out.println("Tuesday"); break;
    default: System.out.println("Unknown day");
}
```

### **Loops**

* **For loop**

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

* **While loop**

```java
int count = 1;
while (count <= 5) {
    System.out.println(count);
    count++;
}
```

---

## **6. Methods**

Methods are blocks of code you can reuse.

```java
public class MethodsExample {
    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        greet("Alice");
        greet("Bob");
    }
}
```

---

## **7. Object-Oriented Basics**

Java is built on **classes** and **objects**.

### Class and Object Example:

```java
class Car {
    String color;
    int year;

    void drive() {
        System.out.println("The car is driving.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car(); // Create an object
        myCar.color = "Red";
        myCar.year = 2022;

        System.out.println("Color: " + myCar.color);
        myCar.drive();
    }
}
```

---

## **8. Important Points for Beginners**

* Java files have `.java` extension.
* Class name must match the filename.
* Every program starts in `main()` method.
* Case-sensitive (`Hello` ≠ `hello`).
* You must compile (`javac`) before running (`java`).

