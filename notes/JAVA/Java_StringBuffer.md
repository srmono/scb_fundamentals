## 1. What is `StringBuffer`?

* A **mutable sequence of characters** (can be changed after creation).
* Part of `java.lang` package.
* **Thread-safe** → all its methods are synchronized.
* Slower than `StringBuilder` in single-threaded situations, but safe in multithreading.
* Used when you **need to modify a string repeatedly**.

---

## **2. Why not just use `String`?**

* **`String`** in Java is **immutable** → every modification creates a new object in heap.
* **`StringBuffer`** avoids creating new objects — it changes the existing sequence in memory.

---

## **3. Common Methods**

| Method        | Description                        |
| ------------- | ---------------------------------- |
| `append()`    | Adds text at the end               |
| `insert()`    | Inserts text at given index        |
| `replace()`   | Replaces part of string            |
| `delete()`    | Deletes characters between indexes |
| `reverse()`   | Reverses string                    |
| `capacity()`  | Returns buffer capacity            |
| `length()`    | Returns current length             |
| `setCharAt()` | Changes character at index         |

---

## **4. Full Java Example**

```java
public class StringBufferExample {
    public static void main(String[] args) {

        // Creating a StringBuffer
        StringBuffer sb = new StringBuffer("Hello");

        // Append
        sb.append(" World");
        System.out.println("After append: " + sb);

        // Insert
        sb.insert(5, ",");
        System.out.println("After insert: " + sb);

        // Replace
        sb.replace(0, 5, "Hi");
        System.out.println("After replace: " + sb);

        // Delete
        sb.delete(2, 3); // removes comma
        System.out.println("After delete: " + sb);

        // Reverse
        sb.reverse();
        System.out.println("After reverse: " + sb);

        // Length & Capacity
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());

        // Set character at position
        sb.setCharAt(0, 'X');
        System.out.println("After setCharAt: " + sb);

        // Capacity growth example
        StringBuffer sb2 = new StringBuffer(); // default capacity = 16
        sb2.append("1234567890123456"); // fills up
        sb2.append("A"); // exceeds capacity → grows to (old*2 + 2) = 34
        System.out.println("New capacity after overflow: " + sb2.capacity());
    }
}
```

---

## **5. Sample Output**

```
After append: Hello World
After insert: Hello, World
After replace: Hi, World
After delete: Hi World
After reverse: dlroW iH
Length: 8
Capacity: 21
After setCharAt: XlroW iH
New capacity after overflow: 34
```

---

## **6. Key Points to Remember**

* **Mutable** → changes happen in place.
* **Synchronized** → safe in multithreading, slower in single-thread.
* **Capacity grows dynamically** when exceeded (`newCapacity = oldCapacity * 2 + 2`).
* **Use cases** → when you need to frequently modify strings (append, insert, reverse, etc.).

