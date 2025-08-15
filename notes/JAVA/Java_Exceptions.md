**Java Exception Handling** and cover **all core concepts** including **class hierarchy**, with explanations and examples.

---

## **1. What is Exception Handling?**

Exception handling in Java is a mechanism to deal with **runtime errors** so that the program can continue running instead of crashing.

**Example without exception handling:**

```java
public class Example {
    public static void main(String[] args) {
        int result = 10 / 0; // Causes ArithmeticException
        System.out.println("This will not run");
    }
}
```

This will throw:

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

---

## **2. Java Exception Class Hierarchy**

```
java.lang.Object
   └── java.lang.Throwable
        ├── java.lang.Error (unchecked, serious issues, don't handle usually)
        └── java.lang.Exception
             ├── Checked Exceptions (must handle or declare)
             │    ├── IOException
             │    ├── SQLException
             │    └── ClassNotFoundException
             └── Unchecked Exceptions (RuntimeException)
                  ├── ArithmeticException
                  ├── NullPointerException
                  ├── ArrayIndexOutOfBoundsException
                  └── IllegalArgumentException
```

* **Error** → Serious system errors (OutOfMemoryError, StackOverflowError). Rarely handled in code.
* **Exception** → Problems you can catch and handle.

  * **Checked Exceptions** → Checked at compile-time (must use `try-catch` or `throws`).
  * **Unchecked Exceptions** → Subclasses of `RuntimeException` (checked at runtime).

---

## **3. Exception Handling Keywords**

* **`try`** → Code that might cause an exception.
* **`catch`** → Handles the exception.
* **`finally`** → Always runs, whether exception occurs or not.
* **`throw`** → Used to throw an exception manually.
* **`throws`** → Declares exceptions a method might throw.

---

## **4. Basic try-catch Example**

```java
public class Example {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // risky code
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e);
        }
        System.out.println("Program continues...");
    }
}
```

**Output:**

```
Cannot divide by zero: java.lang.ArithmeticException: / by zero
Program continues...
```

---

## **5. Multiple catch Blocks**

```java
try {
    String text = null;
    System.out.println(text.length()); // NullPointerException
} catch (ArithmeticException e) {
    System.out.println("Math error");
} catch (NullPointerException e) {
    System.out.println("Null value found");
} catch (Exception e) {
    System.out.println("General exception: " + e);
}
```

---

## **6. finally Block**

Runs whether exception happens or not — useful for closing resources.

```java
try {
    int data = 10 / 2;
} catch (Exception e) {
    System.out.println(e);
} finally {
    System.out.println("This block always executes");
}
```

---

## **7. Nested try-catch**

```java
try {
    try {
        int result = 10 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Inner catch: " + e);
    }
} catch (Exception e) {
    System.out.println("Outer catch: " + e);
}
```

---

## **8. throw Keyword**

```java
public class Example {
    static void validateAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Not eligible to vote");
        } else {
            System.out.println("Eligible to vote");
        }
    }

    public static void main(String[] args) {
        validateAge(15); // throws exception
    }
}
```

---

## **9. throws Keyword**

Declares exceptions a method might throw.

```java
import java.io.*;

class Example {
    static void readFile() throws IOException {
        FileReader file = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(file);
        System.out.println(br.readLine());
        br.close();
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("File error: " + e);
        }
    }
}
```

---

## **10. Creating Custom Exceptions**

```java
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class TestCustomException {
    static void checkValue(int value) throws MyException {
        if (value < 0) {
            throw new MyException("Negative value not allowed");
        }
    }

    public static void main(String[] args) {
        try {
            checkValue(-5);
        } catch (MyException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
}
```

---

## **11. Best Practices**

✅ Catch only exceptions you can handle
✅ Always close resources (`finally` or try-with-resources)
✅ Avoid catching `Exception` unless necessary
✅ Throw custom exceptions for specific cases

