import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * DynamicArrays.java - Comprehensive Tutorial for Dynamic Arrays in Java
 * 
 * DYNAMIC ARRAYS (ArrayList) - KEY FEATURES AND CHARACTERISTICS:
 *
 * 1. LINEAR DATA STRUCTURE: Dynamic Arrays are linear data structures - each element is stored in sequential manner
 * 2. RESIZABLE: Can grow and shrink during runtime
 * 3. GENERIC: Type-safe with generics (ArrayList<T>)
 * 4. INDEXED ACCESS: Zero-based indexing like static arrays
 * 5. AUTOMATIC MEMORY MANAGEMENT: Handles resizing internally
 * 6. RICH API: Many built-in methods for manipulation
 * 7. THREAD-UNSAFE: Not synchronized by default
 * 8. ALLOWS DUPLICATES: Can store duplicate elements
 * 9. MAINTAINS INSERTION ORDER: Elements stay in the order they were added
 * 10. RANDOM ACCESS: Implements RandomAccess interface for fast indexed access
 * 11. DYNAMIC CAPACITY: Grows by ~50% when capacity is exceeded
 *
 * INTERNAL IMPLEMENTATION:
 * - Backed by a regular array (Object[])
 * - When capacity is exceeded, creates new larger array and copies elements
 * - Default initial capacity: 10 elements
 * - Growth factor: approximately 1.5x (newCapacity = oldCapacity + (oldCapacity >> 1))
 *
 * PERFORMANCE: Time Complexity Analysis
 * Operation                    Average Case    Worst Case          Notes
 * - Access (get)                   O(1)            O(1)            Direct array access
 * - Search (indexOf)               O(n)            O(n)            Linear search
 * - Insertion (add)                O(1)            O(n)            O(n) when resizing needed
 * - Insertion (add at i)           O(n)            O(n)            Requires shifting elements
 * - Deletion (remove)              O(n)            O(n)            Requires shifting elements
 * - Deletion (remove last)         O(1)            O(1)            No shifting needed
 */
public class ArraysDynamic {
    
    public static void main(String[] args) {
        System.out.println("=== COMPREHENSIVE DYNAMIC ARRAYS TUTORIAL ===\n");
        
        // 1. BASIC ARRAYLIST OPERATIONS
        demonstrateBasicOperations();
        
        // 2. CAPACITY AND RESIZING
        demonstrateCapacityAndResizing();
        
        // 3. DIFFERENT WAYS TO CREATE ARRAYLIST
        demonstrateCreationMethods();
        
        // 4. INSERTION AND DELETION
        demonstrateInsertionAndDeletion();
        
        // 5. SEARCHING AND ACCESSING
        demonstrateSearchingAndAccessing();
        
        // 6. ITERATION METHODS
        demonstrateIteration();
        
        // 7. ARRAYLIST VS ARRAY PERFORMANCE
        demonstratePerformanceComparison();
        
        // 8. THREAD SAFETY
        demonstrateThreadSafety();
        
        // 9. BEST PRACTICES AND PITFALLS
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic ArrayList operations
     */
    private static void demonstrateBasicOperations() {
        System.out.println("1. BASIC ARRAYLIST OPERATIONS");
        System.out.println("=============================");
        
        // Creating ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        System.out.println("Created empty ArrayList: " + fruits);
        System.out.println("Size: " + fruits.size() + ", Is empty: " + fruits.isEmpty());
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("After adding elements: " + fruits);
        System.out.println("Size: " + fruits.size());
        
        // Accessing elements
        System.out.println("First element: " + fruits.getFirst());
        System.out.println("Last element: " + fruits.getLast());
        
        // Modifying elements
        fruits.set(1, "Blueberry");
        System.out.println("After replacing Banana with Blueberry: " + fruits);
        
        // Removing elements
        fruits.remove("Cherry");
        System.out.println("After removing Cherry: " + fruits);
        fruits.remove(0); // Remove by index
        System.out.println("After removing first element: " + fruits);
        
        // Checking if element exists
        System.out.println("Contains 'Apple': " + fruits.contains("Apple"));
        System.out.println("Contains 'Blueberry': " + fruits.contains("Blueberry"));
        
        System.out.println();
    }
    
    /**
     * Demonstrates ArrayList capacity and automatic resizing
     */
    private static void demonstrateCapacityAndResizing() {
        System.out.println("2. CAPACITY AND RESIZING");
        System.out.println("========================");
        
        // ArrayList with default capacity (10)
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Created ArrayList with default capacity");
        
        // Add elements to trigger resizing
        System.out.println("Adding elements to observe resizing...");
        for (int i = 1; i <= 15; i++) {
            numbers.add(i);
            // Note: We can't directly access capacity, but we can observe behavior
            if (i == 10 || i == 15) {
                System.out.println("After adding " + i + " elements: size = " + numbers.size());
            }
        }
        
        // ArrayList with specified initial capacity
        ArrayList<String> largeList = new ArrayList<>(100);
        System.out.println("Created ArrayList with initial capacity of 100");
        
        // Demonstrate ensureCapacity
        ArrayList<Integer> optimizedList = new ArrayList<>();
        optimizedList.ensureCapacity(1000); // Pre-allocate space
        System.out.println("Pre-allocated capacity for 1000 elements");
        
        // Demonstrate trimToSize
        ArrayList<String> wastefulList = new ArrayList<>(1000);
        wastefulList.add("Only");
        wastefulList.add("Two");
        wastefulList.add("Elements");
        System.out.println("Before trimToSize: capacity is much larger than needed");
        wastefulList.trimToSize(); // Reduce capacity to actual size
        System.out.println("After trimToSize: capacity matches size (" + wastefulList.size() + ")");
        
        System.out.println();
    }
    
    /**
     * Demonstrates different ways to create ArrayList
     */
    private static void demonstrateCreationMethods() {
        System.out.println("3. DIFFERENT WAYS TO CREATE ARRAYLIST");
        System.out.println("=====================================");
        
        // Method 1: Default constructor
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Element1");
        System.out.println("Method 1 - Default constructor: " + list1);
        
        // Method 2: With initial capacity
        ArrayList<Integer> list2 = new ArrayList<>(50);
        list2.add(100);
        System.out.println("Method 2 - With initial capacity: " + list2);
        
        // Method 3: From another collection
        List<String> sourceList = Arrays.asList("A", "B", "C");
        ArrayList<String> list3 = new ArrayList<>(sourceList);
        System.out.println("Method 3 - From collection: " + list3);
        
        // Method 4: Using Arrays.asList() (creates fixed-size list)
        List<String> fixedList = Arrays.asList("X", "Y", "Z");
        ArrayList<String> list4 = new ArrayList<>(fixedList);
        System.out.println("Method 4 - From Arrays.asList: " + list4);
        
        // Method 5: Using Collections.nCopies()
        ArrayList<String> list5 = new ArrayList<>(Collections.nCopies(5, "Default"));
        System.out.println("Method 5 - With repeated elements: " + list5);
        
        // Method 6: Using List.of() (Java 9+) - creates immutable list first
        List<Integer> immutableList = List.of(1, 2, 3, 4, 5);
        ArrayList<Integer> list6 = new ArrayList<>(immutableList);
        System.out.println("Method 6 - From List.of(): " + list6);
        
        System.out.println();
    }
    
    /**
     * Demonstrates insertion and deletion operations
     */
    private static void demonstrateInsertionAndDeletion() {
        System.out.println("4. INSERTION AND DELETION");
        System.out.println("=========================");
        
        ArrayList<String> colors = new ArrayList<>();
        
        // Various insertion methods
        System.out.println("=== INSERTION METHODS ===");
        colors.add("Red"); // Add at end
        colors.add("Blue");
        colors.add(1, "Green"); // Insert at specific index
        System.out.println("After insertions: " + colors);
        
        // Add multiple elements
        colors.addAll(Arrays.asList("Yellow", "Purple"));
        System.out.println("After addAll: " + colors);
        
        // Insert collection at specific index
        colors.addAll(2, Arrays.asList("Orange", "Pink"));
        System.out.println("After addAll at index 2: " + colors);
        
        System.out.println("\n=== DELETION METHODS ===");
        // Remove by object
        colors.remove("Pink");
        System.out.println("After removing 'Pink': " + colors);
        
        // Remove by index
        colors.remove(1);
        System.out.println("After removing index 1: " + colors);
        
        // Remove multiple elements
        colors.removeAll(Arrays.asList("Orange", "Purple"));
        System.out.println("After removeAll: " + colors);
        
        // Remove elements matching condition (Java 8+)
        colors.add("DarkRed");
        colors.add("LightBlue");
        colors.removeIf(color -> color.length() > 6);
        System.out.println("After removeIf (length > 6): " + colors);
        
        // Clear all elements
        ArrayList<String> tempList = new ArrayList<>(colors);
        tempList.clear();
        System.out.println("After clear(): " + tempList + " (size: " + tempList.size() + ")");
        
        System.out.println();
    }
    
    /**
     * Demonstrates searching and accessing elements
     */
    private static void demonstrateSearchingAndAccessing() {
        System.out.println("5. SEARCHING AND ACCESSING");
        System.out.println("==========================");
        
        ArrayList<String> animals = new ArrayList<>(
            Arrays.asList("Cat", "Dog", "Bird", "Cat", "Fish", "Dog")
        );
        System.out.println("Animals list: " + animals);
        
        // Accessing elements
        System.out.println("First animal: " + animals.getFirst());
        System.out.println("Last animal: " + animals.get(animals.size() - 1));
        
        // Searching
        System.out.println("Index of 'Cat': " + animals.indexOf("Cat"));
        System.out.println("Last index of 'Cat': " + animals.lastIndexOf("Cat"));
        System.out.println("Index of 'Elephant': " + animals.indexOf("Elephant")); // -1 if not found
        
        // Checking existence
        System.out.println("Contains 'Dog': " + animals.contains("Dog"));
        System.out.println("Contains 'Elephant': " + animals.contains("Elephant"));
        
        // Check if contains any/all elements
        List<String> pets = Arrays.asList("Cat", "Dog");
        List<String> wildAnimals = Arrays.asList("Lion", "Tiger");
        System.out.println("Contains all pets: " + animals.containsAll(pets));
        System.out.println("Contains all wild animals: " + animals.containsAll(wildAnimals));
        
        // Get sublist
        List<String> subAnimals = animals.subList(1, 4); // From index 1 to 3
        System.out.println("Sublist (1-3): " + subAnimals);
        
        // Convert to array
        String[] animalArray = animals.toArray(new String[0]);
        System.out.println("Converted to array: " + Arrays.toString(animalArray));
        
        System.out.println();
    }
    
    /**
     * Demonstrates different iteration methods
     */
    private static void demonstrateIteration() {
        System.out.println("6. ITERATION METHODS");
        System.out.println("===================");
        
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Numbers: " + numbers);
        
        // Method 1: Traditional for loop
        System.out.println("Method 1 - Traditional for loop:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
        
        // Method 2: Enhanced for loop
        System.out.println("Method 2 - Enhanced for loop:");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Method 3: Iterator
        System.out.println("Method 3 - Iterator:");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // Method 4: ListIterator (bidirectional)
        System.out.println("Method 4 - ListIterator (reverse):");
        ListIterator<Integer> listIterator = numbers.listIterator(numbers.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        
        // Method 5: Stream API (Java 8+)
        System.out.println("Method 5 - Stream API:");
        numbers.stream().forEach(num -> System.out.print(num + " "));
        System.out.println();
        
        // Method 6: Stream with operations
        System.out.println("Method 6 - Stream with filtering and mapping:");
        numbers.stream()
               .filter(num -> num > 20)
               .map(num -> num * 2)
               .forEach(num -> System.out.print(num + " "));
        System.out.println();
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance comparison between ArrayList and arrays
     */
    private static void demonstratePerformanceComparison() {
        System.out.println("7. ARRAYLIST VS ARRAY PERFORMANCE");
        System.out.println("=================================");
        
        int size = 100000;
        
        // Array performance
        System.out.println("Testing with " + size + " elements...");
        
        long startTime = System.nanoTime();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        long arrayTime = System.nanoTime() - startTime;
        
        // ArrayList performance
        startTime = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>(size); // Pre-allocate capacity
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.nanoTime() - startTime;
        
        System.out.println("Array creation time: " + (arrayTime / 1_000_000.0) + " ms");
        System.out.println("ArrayList creation time: " + (arrayListTime / 1_000_000.0) + " ms");
        System.out.println("ArrayList is ~" + (arrayListTime / (double) arrayTime) + "x slower for creation");
        
        // Access performance
        startTime = System.nanoTime();
        int sum1 = 0;
        for (int i = 0; i < size; i++) {
            sum1 += array[i];
        }
        long arrayAccessTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        int sum2 = 0;
        for (int i = 0; i < size; i++) {
            sum2 += arrayList.get(i);
        }
        long arrayListAccessTime = System.nanoTime() - startTime;
        
        System.out.println("Array access time: " + (arrayAccessTime / 1_000_000.0) + " ms");
        System.out.println("ArrayList access time: " + (arrayListAccessTime / 1_000_000.0) + " ms");
        System.out.println("ArrayList is ~" + (arrayListAccessTime / (double) arrayAccessTime) + "x slower for access");
        
        System.out.println();
    }
    
    /**
     * Demonstrates thread safety issues and solutions
     */
    private static void demonstrateThreadSafety() {
        System.out.println("9. THREAD SAFETY");
        System.out.println("================");
        
        System.out.println("ArrayList is NOT thread-safe by default!");
        
        // Demonstrate race condition (unsafe)
        ArrayList<Integer> unsafeList = new ArrayList<>();
        
        // Create multiple threads adding to the same list
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    unsafeList.add(threadId * 1000 + j);
                }
            });
        }
        
        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }
        
        // Wait for completion
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Expected size: 5000, Actual size: " + unsafeList.size());
        if (unsafeList.size() != 5000) {
            System.out.println("❌ Race condition detected! Some elements were lost.");
        }
        
        // Thread-safe solutions
        System.out.println("\n=== THREAD-SAFE SOLUTIONS ===");
        
        // Solution 1: Collections.synchronizedList
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
        System.out.println("✅ Collections.synchronizedList - wraps ArrayList with synchronization");
        
        // Solution 2: CopyOnWriteArrayList
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
        System.out.println("✅ CopyOnWriteArrayList - thread-safe, optimized for reads");
        
        // Solution 3: Vector (legacy, but thread-safe)
        Vector<Integer> vector = new Vector<>();
        System.out.println("✅ Vector - legacy thread-safe dynamic array");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices and common pitfalls
     */
    private static void demonstrateBestPractices() {
        System.out.println("10. BEST PRACTICES AND PITFALLS");
        System.out.println("===============================");
        
        System.out.println("=== BEST PRACTICES ===");
        
        // 1. Specify initial capacity when size is known
        ArrayList<String> optimized = new ArrayList<>(1000);
        System.out.println("✅ Specify initial capacity when size is known");
        
        // 2. Use interface type for declarations
        List<String> goodPractice = new ArrayList<>(); // Not ArrayList<String>
        System.out.println("✅ Use List interface for variable declarations");
        
        // 3. Use enhanced for-loop when index is not needed
        List<String> items = Arrays.asList("A", "B", "C");
        for (String item : items) {
            // Process item
        }
        System.out.println("✅ Use enhanced for-loop when index not needed");
        
        // 4. Use streams for complex operations
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenSquares = numbers.stream()
                                          .filter(n -> n % 2 == 0)
                                          .map(n -> n * n)
                                          .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("✅ Use streams for complex operations: " + evenSquares);
        
        System.out.println("\n=== COMMON PITFALLS ===");
        
        // Pitfall 1: ConcurrentModificationException
        System.out.println("❌ Pitfall 1 - ConcurrentModificationException:");
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        try {
            for (String fruit : fruits) {
                if (fruit.equals("Banana")) {
                    fruits.remove(fruit); // This will throw exception
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Exception caught: " + e.getClass().getSimpleName());
        }
        
        // Correct way using iterator
        fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        Iterator<String> iter = fruits.iterator();
        while (iter.hasNext()) {
            String fruit = iter.next();
            if (fruit.equals("Banana")) {
                iter.remove(); // Safe removal
            }
        }
        System.out.println("✅ Safe removal using iterator: " + fruits);
        
        // Pitfall 2: Autoboxing performance cost
        System.out.println("❌ Pitfall 2 - Autoboxing with primitives");
        ArrayList<Integer> boxedList = new ArrayList<>();
        // Each add() creates an Integer object (boxing)
        // Each get() extracts int from Integer (unboxing)
        System.out.println("Consider using primitive collections for better performance");
        
        // Pitfall 3: Memory leaks with large objects
        System.out.println("❌ Pitfall 3 - Memory leaks");
        System.out.println("Remember to clear() or set to null when done with large ArrayLists");
        
        System.out.println("\n=== WHEN TO USE ARRAYLIST ===");
        System.out.println("✅ Frequent random access by index");
        System.out.println("✅ More reads than insertions/deletions");
        System.out.println("✅ Insertions/deletions mainly at the end");
        System.out.println("✅ Need to maintain insertion order");
        
        System.out.println("\n=== WHEN NOT TO USE ARRAYLIST ===");
        System.out.println("❌ Frequent insertions/deletions in middle");
        System.out.println("❌ Need thread safety (use CopyOnWriteArrayList)");
        System.out.println("❌ Working with primitives extensively (consider primitive collections)");
        System.out.println("❌ Need constant-time insertions/deletions (use LinkedList)");
        
        System.out.println("\n=== END OF DYNAMIC ARRAYS TUTORIAL ===");
    }
}
