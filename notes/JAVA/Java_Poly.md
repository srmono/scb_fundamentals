## **1. What is Polymorphism?**

* **Polymorphism** means *"many forms"* — the same action behaves differently depending on the object.
* In Java, it allows **one interface** to be used for **different underlying forms (implementations)**.

---

## **2. Compile-Time Polymorphism** (Static Binding)

* Achieved via **method overloading** or **operator overloading** (Java doesn’t support custom operator overloading).
* Method call is resolved **at compile time**.

**Example:** `Calculator.java`

```java
class Calculator {
    // Method Overloading
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    String add(String a, String b) {
        return a + b;
    }
}

public class CompileTimePolymorphism {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println(calc.add(2, 3));           // int version
        System.out.println(calc.add(2.5, 3.5));       // double version
        System.out.println(calc.add("Hello ", "Java")); // string version
    }
}
```

**Run:**

```bash
javac CompileTimePolymorphism.java
java CompileTimePolymorphism
```

**Output:**

```
5
6.0
Hello Java
```

💡 Here, **the compiler** decides which method to call based on parameter types.

---

## **3. Runtime Polymorphism** (Dynamic Binding)

* Achieved via **method overriding**.
* Method call is resolved **at runtime** based on the actual object type.

**Example:** `AnimalExample.java`

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class RuntimePolymorphism {
    public static void main(String[] args) {
        Animal a;

        a = new Dog(); // Upcasting
        a.sound();     // Dog's sound

        a = new Cat(); // Upcasting
        a.sound();     // Cat's sound
    }
}
```

**Run:**

```bash
javac RuntimePolymorphism.java
java RuntimePolymorphism
```

**Output:**

```
Dog barks
Cat meows
```

💡 Here, **the JVM at runtime** decides which method to call based on the object’s actual class.

---

## **4. Combined Real-Time Example**

Imagine a **Payment System**:

* **Compile-time polymorphism** → Same method name `pay()` but different arguments for cash, card, and online payment.
* **Runtime polymorphism** → `pay()` behaves differently depending on the payment object passed at runtime.

```java
abstract class Payment {
    abstract void pay(double amount);
}

class CashPayment extends Payment {
    void pay(double amount) {
        System.out.println("Paid $" + amount + " in cash.");
    }
}

class CardPayment extends Payment {
    void pay(double amount) {
        System.out.println("Paid $" + amount + " using card.");
    }
}

class PaymentProcessor {
    // Compile-time polymorphism: Overloading
    void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount);
    }

    void processPayment(String cardNumber, double amount) {
        System.out.println("Processing card payment of $" + amount + " for card " + cardNumber);
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        // Compile-time
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(100.0);
        processor.processPayment("1234-5678-9876-5432", 200.0);

        // Runtime
        Payment p;
        p = new CashPayment();
        p.pay(150.0);

        p = new CardPayment();
        p.pay(300.0);
    }
}
```

**Output:**

```
Processing cash payment of $100.0
Processing card payment of $200.0 for card 1234-5678-9876-5432
Paid $150.0 in cash.
Paid $300.0 using card.
```
