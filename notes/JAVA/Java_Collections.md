
## **1. Overview of the Java Collection Framework**

The Java Collection Framework is a **set of classes and interfaces** that provide common data structures and algorithms to store, retrieve, and manipulate data efficiently.

It’s part of `java.util` package.

### **Core Benefits**

* Reusable data structures (lists, sets, maps, queues, etc.).
* Algorithms like sorting, searching.
* Reduces boilerplate.
* Consistent API.

---

## **2. Collection Framework Hierarchy**

```
            Iterable (Interface)
                |
            Collection (Interface)
    -------------------------------
    |             |              |
   List          Set           Queue
    |             |              |
 ArrayList     HashSet       PriorityQueue
 LinkedList    LinkedHashSet  ArrayDeque
 Vector        TreeSet
 Stack
```

**Separate branch** for **Map** (not a subtype of Collection):

```
Map (Interface)
   |
HashMap
LinkedHashMap
TreeMap
Hashtable
```



## **Java Collection Framework Full Example**

```java
import java.util.*;

public class CollectionFrameworkDemo {
    public static void main(String[] args) {

        // 1. LISTS
        System.out.println("===== LIST Examples =====");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Apple"); // duplicates allowed
        System.out.println("ArrayList: " + arrayList);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Cat");
        linkedList.add(1, "Parrot");
        System.out.println("LinkedList: " + linkedList);

        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        System.out.println("Vector: " + vector);

        Stack<String> stack = new Stack<>();
        stack.push("First Plate");
        stack.push("Second Plate");
        System.out.println("Stack pop: " + stack.pop()); // LIFO

        // 2. SETS
        System.out.println("\n===== SET Examples =====");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Blue");
        hashSet.add("Red"); // duplicate ignored
        System.out.println("HashSet (no order): " + hashSet);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Monday");
        linkedHashSet.add("Wednesday");
        linkedHashSet.add("Tuesday");
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(42);
        treeSet.add(5);
        treeSet.add(17);
        System.out.println("TreeSet (sorted): " + treeSet);

        // 3. QUEUES & DEQUES
        System.out.println("\n===== QUEUE / DEQUE Examples =====");
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Banana");
        priorityQueue.add("Apple");
        priorityQueue.add("Cherry");
        System.out.println("PriorityQueue poll (sorted): " + priorityQueue.poll());
        System.out.println("PriorityQueue now: " + priorityQueue);

        Deque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst("Front");
        arrayDeque.addLast("Back");
        System.out.println("ArrayDeque: " + arrayDeque);
        arrayDeque.removeFirst();
        System.out.println("ArrayDeque after removeFirst: " + arrayDeque);

        // 4. MAPS
        System.out.println("\n===== MAP Examples =====");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(101, "John");
        hashMap.put(102, "Jane");
        hashMap.put(103, "Mike");
        System.out.println("HashMap: " + hashMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Apple", 50);
        linkedHashMap.put("Banana", 20);
        linkedHashMap.put("Cherry", 30);
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        System.out.println("TreeMap (sorted by key): " + treeMap);

        Map<String, String> hashtable = new Hashtable<>();
        hashtable.put("A", "Alpha");
        hashtable.put("B", "Beta");
        System.out.println("Hashtable: " + hashtable);

        // 5. COLLECTIONS UTILITY
        System.out.println("\n===== Collections Utility Examples =====");
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1);
        System.out.println("Original list: " + numbers);
        Collections.sort(numbers);
        System.out.println("Sorted list: " + numbers);
        Collections.reverse(numbers);
        System.out.println("Reversed list: " + numbers);
        System.out.println("Max: " + Collections.max(numbers));
        System.out.println("Frequency of 3: " + Collections.frequency(numbers, 3));

        // 6. ITERATION
        System.out.println("\n===== Iteration Examples =====");
        System.out.println("For-each loop over ArrayList:");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        System.out.println("Iterator over HashSet:");
        Iterator<String> setIterator = hashSet.iterator();
        while (setIterator.hasNext()) {
            System.out.println(setIterator.next());
        }

        System.out.println("forEach method over LinkedHashMap:");
        linkedHashMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
```

---

### **What This Code Covers**

✅ **List implementations** — ArrayList, LinkedList, Vector, Stack
✅ **Set implementations** — HashSet, LinkedHashSet, TreeSet
✅ **Queue/Deque implementations** — PriorityQueue, ArrayDeque
✅ **Map implementations** — HashMap, LinkedHashMap, TreeMap, Hashtable
✅ **Collections utility methods** — sort, reverse, max, frequency
✅ **Different iteration methods** — for-each, Iterator, forEach lambda

---

### **Example Output (may vary due to set/map ordering)**

```
===== LIST Examples =====
ArrayList: [Apple, Banana, Apple]
LinkedList: [Dog, Parrot, Cat]
Vector: [10, 20]
Stack pop: Second Plate

===== SET Examples =====
HashSet (no order): [Red, Blue]
LinkedHashSet (insertion order): [Monday, Wednesday, Tuesday]
TreeSet (sorted): [5, 17, 42]

===== QUEUE / DEQUE Examples =====
PriorityQueue poll (sorted): Apple
PriorityQueue now: [Banana, Cherry]
ArrayDeque: [Front, Back]
ArrayDeque after removeFirst: [Back]

===== MAP Examples =====
HashMap: {101=John, 102=Jane, 103=Mike}
LinkedHashMap (insertion order): {Apple=50, Banana=20, Cherry=30}
TreeMap (sorted by key): {1=One, 2=Two, 3=Three}
Hashtable: {B=Beta, A=Alpha}

===== Collections Utility Examples =====
Original list: [5, 3, 8, 1]
Sorted list: [1, 3, 5, 8]
Reversed list: [8, 5, 3, 1]
Max: 8
Frequency of 3: 1

===== Iteration Examples =====
For-each loop over ArrayList:
Apple
Banana
Apple
Iterator over HashSet:
Red
Blue
forEach method over LinkedHashMap:
Apple -> 50
Banana -> 20
Cherry -> 30
```


---

## **Iterating Through Collections**

```java
// For-each loop
for(String s : list) {
    System.out.println(s);
}

// Iterator
Iterator<String> it = list.iterator();
while(it.hasNext()) {
    System.out.println(it.next());
}

// forEach method (Java 8+)
list.forEach(System.out::println);
```

---

## **10. Summary Table**

| Interface/Class | Order Maintained | Allows Duplicates | Null Allowed | Thread-safe |
| --------------- | ---------------- | ----------------- | ------------ | ----------- |
| ArrayList       | Yes              | Yes               | Yes          | No          |
| LinkedList      | Yes              | Yes               | Yes          | No          |
| Vector          | Yes              | Yes               | Yes          | Yes         |
| Stack           | Yes (LIFO)       | Yes               | Yes          | Yes         |
| HashSet         | No               | No                | One null     | No          |
| LinkedHashSet   | Yes              | No                | One null     | No          |
| TreeSet         | Sorted           | No                | No           | No          |
| PriorityQueue   | Sorted           | Yes               | One null     | No          |
| ArrayDeque      | Yes              | Yes               | No nulls     | No          |
| HashMap         | No               | —                 | One null key | No          |
| LinkedHashMap   | Yes              | —                 | One null key | No          |
| TreeMap         | Sorted           | —                 | No null keys | No          |
| Hashtable       | No               | —                 | No nulls     | Yes         |

