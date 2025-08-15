Let’s understand  **all Java operators** 

---

## **1. Arithmetic Operators**

Used for basic mathematical operations.

```java
public class ArithmeticExample {
    public static void main(String[] args) {
        int a = 10, b = 3;

        System.out.println("a + b = " + (a + b)); // Addition
        System.out.println("a - b = " + (a - b)); // Subtraction
        System.out.println("a * b = " + (a * b)); // Multiplication
        System.out.println("a / b = " + (a / b)); // Division (integer result)
        System.out.println("a % b = " + (a % b)); // Modulus (remainder)
    }
}
```

---

## **2. Assignment Operators**

Used to assign values to variables.

```java
public class AssignmentExample {
    public static void main(String[] args) {
        int x = 5;

        x += 3;  // x = x + 3
        System.out.println("x += 3 → " + x);

        x -= 2;  // x = x - 2
        System.out.println("x -= 2 → " + x);

        x *= 4;  // x = x * 4
        System.out.println("x *= 4 → " + x);

        x /= 2;  // x = x / 2
        System.out.println("x /= 2 → " + x);

        x %= 3;  // x = x % 3
        System.out.println("x %= 3 → " + x);

        x &= 2;  // Bitwise AND assignment
        System.out.println("x &= 2 → " + x);

        x |= 5;  // Bitwise OR assignment
        System.out.println("x |= 5 → " + x);

        x ^= 1;  // Bitwise XOR assignment
        System.out.println("x ^= 1 → " + x);
    }
}
```

---

## **3. Relational Operators**

Used to compare two values; returns boolean.

```java
public class RelationalExample {
    public static void main(String[] args) {
        int a = 10, b = 20;

        System.out.println("a > b → " + (a > b));
        System.out.println("a < b → " + (a < b));
        System.out.println("a == b → " + (a == b));
        System.out.println("a >= b → " + (a >= b));
        System.out.println("a <= b → " + (a <= b));
        System.out.println("a != b → " + (a != b));
    }
}
```

---

## **4. Unary Operators**

Operate on a single operand.

```java
public class UnaryExample {
    public static void main(String[] args) {
        int a = 5;

        System.out.println("++a → " + (++a)); // Pre-increment
        System.out.println("a++ → " + (a++)); // Post-increment
        System.out.println("--a → " + (--a)); // Pre-decrement
        System.out.println("a-- → " + (a--)); // Post-decrement
        System.out.println("!true → " + (!true)); // Logical NOT
    }
}
```

---

## **5. Logical Operators**

Used to combine boolean expressions.

```java
public class LogicalExample {
    public static void main(String[] args) {
        boolean x = true, y = false;

        System.out.println("x && y → " + (x && y)); // AND
        System.out.println("x || y → " + (x || y)); // OR
        System.out.println("!x → " + (!x));         // NOT
    }
}
```

---

## **6. Bitwise Operators**

Work on bits.

```java
public class BitwiseExample {
    public static void main(String[] args) {
        int a = 5;  // 0101
        int b = 3;  // 0011

        System.out.println("a & b → " + (a & b));  // AND → 0001 (1)
        System.out.println("a | b → " + (a | b));  // OR  → 0111 (7)
        System.out.println("a ^ b → " + (a ^ b));  // XOR → 0110 (6)
        System.out.println("a >> 1 → " + (a >> 1)); // Right shift → 0010 (2)
        System.out.println("a << 1 → " + (a << 1)); // Left shift  → 1010 (10)
    }
}
```

---

## **7. Ternary Operator**

Short form of `if-else`.

```java
public class TernaryExample {
    public static void main(String[] args) {
        int a = 10, b = 20;
        String result = (a > b) ? "a is greater" : "b is greater";
        System.out.println(result);
    }
}
```
