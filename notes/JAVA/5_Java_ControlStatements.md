Let’s understand **JAVA Control Statements** :

1. **Name**
2. **When to use it**
3. **Code example**
4. **Expected output**

---

## **1. Conditional Statements**

---

### **a) if-else**

**When to use:**
To make decisions — run one block of code if the condition is true, another if false.

```java
public class IfElseExample {
    public static void main(String[] args) {
        int num = 10;

        if (num > 0) {
            System.out.println("Positive number");
        } else {
            System.out.println("Non-positive number");
        }
    }
}
```

**Output:**

```
Positive number
```

---

### **b) Nested if**

**When to use:**
When you need to check a second condition **only if** the first one is true.

```java
public class NestedIfExample {
    public static void main(String[] args) {
        int num = 15;

        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println("Positive even number");
            } else {
                System.out.println("Positive odd number");
            }
        }
    }
}
```

**Output:**

```
Positive odd number
```

---

### **c) switch**

**When to use:**
When you have multiple possible values for a variable and want to choose different actions.

```java
public class SwitchExample {
    public static void main(String[] args) {
        int day = 3;

        switch (day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            default: System.out.println("Invalid day");
        }
    }
}
```

**Output:**

```
Wednesday
```

---

## **2. Iteration Statements (Loops)**

---

### **a) for loop**

**When to use:**
When you know **how many times** you want to repeat something.

```java
public class ForExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
    }
}
```

**Output:**

```
Count: 1
Count: 2
Count: 3
Count: 4
Count: 5
```

---

### **b) while loop**

**When to use:**
When you don’t know the number of repetitions beforehand — run while the condition is true.

```java
public class WhileExample {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println("Count: " + i);
            i++;
        }
    }
}
```

**Output:**

```
Count: 1
Count: 2
Count: 3
Count: 4
Count: 5
```

---

### **c) do-while loop**

**When to use:**
When you want the loop to **run at least once** before checking the condition.

```java
public class DoWhileExample {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println("Count: " + i);
            i++;
        } while (i <= 5);
    }
}
```

**Output:**

```
Count: 1
Count: 2
Count: 3
Count: 4
Count: 5
```

---

## **3. Jump Statements**

---

### **a) break**

**When to use:**
To exit a loop early when a certain condition is met.

```java
public class BreakExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; // exit the loop
            }
            System.out.println(i);
        }
    }
}
```

**Output:**

```
1
2
3
4
```

---

### **b) continue**

**When to use:**
To skip the **current** loop iteration and move to the next one.

```java
public class ContinueExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // skip printing 3
            }
            System.out.println(i);
        }
    }
}
```

**Output:**

```
1
2
4
5
```

