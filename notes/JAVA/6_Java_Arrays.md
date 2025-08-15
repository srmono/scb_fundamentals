## **Java Array Fundamentals**

### 1. **What is an Array?**

* An **array** in Java is a collection of elements of the **same type**, stored in **contiguous memory locations**.
* Each element in an array can be accessed using its **index** (starting from `0`).

---

### 2. **Why Use Arrays?**

* To store multiple values in a **single variable** instead of declaring separate variables for each value.
* Makes code shorter, cleaner, and easier to manage.
* Useful when the number of elements is **fixed** or **known in advance**.

---

### 3. **Types of Arrays in Java**

1. **Single-Dimensional Array**
   Example: `int[] arr = {10, 20, 30};`
2. **Multi-Dimensional Array** (Array of arrays)
   Example:

   ```java
   int[][] matrix = {
       {1, 2, 3},
       {4, 5, 6}
   };
   ```
3. **Jagged Array** (Multi-dimensional array where inner arrays have different lengths)
   Example:

   ```java
   int[][] jagged = {
       {1, 2},
       {3, 4, 5}
   };
   ```

---

### 4. **Array Declaration and Initialization**

* **Declaration only**:
  `int[] arr;`
* **Allocate memory**:
  `arr = new int[5];`
* **Declaration + allocation**:
  `int[] arr = new int[5];`
* **Declaration + initialization**:
  `int[] arr = {10, 20, 30, 40, 50};`

---

### 5. **Important Points**

* **Index range**: `0` to `length - 1`
* Accessing an invalid index → `ArrayIndexOutOfBoundsException`
* **Length**: Use `.length` to get the size of an array (e.g., `arr.length`)
* Arrays can store **primitive types** (`int`, `char`, `double`) or **objects**.

---

## Array Exercises:

---

## **Array in Java**

* Array in Java is a group of like-typed variables referred to by a common name.
* Elements are stored in **contiguous** memory locations.
* Size must be specified by an **int** value.
* Arrays can store **primitive types** or **objects**.
* Primitive values → stored in contiguous memory.
* Objects → stored in heap memory.

**Example:**

```java
int arr1[]; // declaration
arr1 = new int[5]; // allocation
arr1[0] = 10;
arr1[1] = 20;
arr1[2] = 30;
arr1[3] = 40;
arr1[4] = 50;

// Declaration + allocation
int arr2[] = new int[5];
int[] arr3 = new int[5];

// Declaration + allocation + initialization
int arr4[] = {10, 20, 30, 40, 50};
```

---

## **Iteration of an Array**

* Use **for loop** or **for-each loop**.
* **For-each loop** introduced in Java 5 → reduces bugs, improves readability.

**Example:**

```java
int arr[] = {10, 20, 30, 40, 50};

// Traditional for loop
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// For-each loop
for (int num : arr) {
    System.out.println(num);
}
```

