
## **1. Display Table of 10**

**Code (TableOf10.java)**

```java
public class TableOf10 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("10 x " + i + " = " + (10 * i));
        }
    }
}
```

**How to Run**

1. Save this code in a file named `TableOf10.java`
2. Open terminal/command prompt in the same folder.
3. Compile:

   ```
   javac TableOf10.java
   ```
4. Run:

   ```
   java TableOf10
   ```

**Output**

```
10 x 1 = 10
10 x 2 = 20
10 x 3 = 30
...
10 x 10 = 100
```

---

## **2. Fibonacci Series of 10 Numbers**

**Code (Fibonacci.java)**

```java
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int first = 0, second = 0, third = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");
            int next = second + third;
            second = third;
            third = next;
            first = second;
        }
    }
}
```

**How to Run**

```
javac Fibonacci.java
java Fibonacci
```

**Output**

```
0 0 1 1 2 3 5 8 13 21
```

---

## **3. Check Odd or Even**

**Code (OddEven.java)**

```java
import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }
        sc.close();
    }
}
```

**How to Run**

```
javac OddEven.java
java OddEven
```

**Sample Run**

```
Enter a number: 7
7 is Odd
```

```
Enter a number: 10
10 is Even
```

---

## **4. Find Largest of Two Numbers**

**Code (LargestNumber.java)**

```java
import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        if (a > b) {
            System.out.println(a + " is larger");
        } else if (b > a) {
            System.out.println(b + " is larger");
        } else {
            System.out.println("Both numbers are equal");
        }
        sc.close();
    }
}
```

**Sample Run**

```
Enter first number: 45
Enter second number: 72
72 is larger
```

---

## **5. Array in Sorted Order**

**Code (ArraySort.java)**

```java
import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7};

        System.out.println("Original array: " + Arrays.toString(numbers));

        Arrays.sort(numbers);

        System.out.println("Sorted array: " + Arrays.toString(numbers));
    }
}
```

**Sample Run**

```
Original array: [5, 2, 9, 1, 7]
Sorted array: [1, 2, 5, 7, 9]
```

---

## **6. Array in Reverse Order**

**Code (ArrayReverse.java)**

```java
import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7};

        System.out.println("Original array: " + Arrays.toString(numbers));

        System.out.print("Reverse order: [");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
```

**Sample Run**

```
Original array: [5, 2, 9, 1, 7]
Reverse order: [7, 1, 9, 2, 5]
```

