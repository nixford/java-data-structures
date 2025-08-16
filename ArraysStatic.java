
/**
 * ArraysStatic.java - Comprehensive Tutorial for Static Arrays in Java
 * 
 * STATIC ARRAYS - KEY FEATURES AND CHARACTERISTICS:
 *
 * 1. LINEAR DATA STRUCTURE: Static Arrays are linear data structures - each element is stored in sequential manner
 * 2. ONE DIMENSIONAL or MULTI-DIMENSIONAL: Arrays may have a single dimension or multiple dimensions (2D, 3D, etc.)
 * 3. FIXED SIZE: Arrays have a predetermined size that cannot be changed after creation
 * 4. HOMOGENEOUS: All elements must be of the same data type
 * 5. INDEXED ACCESS: Elements are accessed using zero-based indexing (0 to length-1)
 * 6. CONTIGUOUS MEMORY: Elements are stored in consecutive memory locations, example:
 *    - Memory Address:  1000  1004  1008  1012  1016
 *    - Array Element:   [10]  [20]  [30]  [40]  [50]
 *    - Array Index:      0     1     2     3     4
 *    - No extra pointers between elements, which needs to be followed (like pointers in linked lists), which leads to minimal memory overhead
 *    - Cache Performance: When you access arr[0], the CPU loads nearby elements into cache and accessing arr[1], arr[2] next is very fast (cache hits)
 * 7. REFERENCE TYPE: Arrays are objects in Java, stored in heap memory
 * 8. DEFAULT VALUES: Elements are automatically initialized with default values
 *    - Numeric types: 0 (int, double, etc.)
 *    - Boolean: false
 *    - Object references: null
 * 9. LENGTH PROPERTY: Arrays have a built-in 'length' property (not method: numbers.length;  // ← NO parentheses! It's a field). Different from String, ArrayList:
 *    Type	              Size Access	        Example
 *    - Array	       .length (field)	       arr.length
 *    - String	       .length() (method)	   str.length()
 *    - ArrayList	   .size() (method)	       list.size()
 *    - HashMap	        .size() (method)	    map.size()
 * 10. BOUNDS CHECKING: Java performs automatic bounds (limits) checking to prevent buffer overflows, in case of out-of-bounds: ArrayIndexOutOfBoundsException
 * 11. NOT THREAD-SAFE: Static Arrays are NOT thread-safe by default. Multiple threads can access and modify the same array simultaneously, leading to race conditions and data corruption
 *
 *
 * PERFORMANCE: O(1) access time for reading/writing elements by index
 * 
 * ADVANTAGES:
 * - Fast random access to elements, which makes them good for searching operations
 * - Memory efficient for fixed-size collections
 * - Simple and straightforward to use
 * - Cache-friendly due to contiguous memory layout
 * 
 * DISADVANTAGES:
 * - Fixed size cannot be changed dynamically
 * - Insertion/deletion in middle requires shifting elements
 * - Memory waste if array is not fully utilized
 * - No built-in methods for common operations (unlike Collections)
 */
public class ArraysStatic {
    
    public static void main(String[] args) {
        System.out.println("=== COMPREHENSIVE STATIC ARRAYS TUTORIAL ===\n");
        
        // 1. ARRAY DECLARATION AND INITIALIZATION
        demonstrateDeclarationAndInitialization();
        
        // 2. ACCESSING AND MODIFYING ELEMENTS
        demonstrateElementAccess();
        
        // 3. ARRAY LENGTH AND BOUNDS
        demonstrateLengthAndBounds();
        
        // 4. ITERATING THROUGH ARRAYS
        demonstrateIteration();
        
        // 5. MULTI-DIMENSIONAL ARRAYS
        demonstrateMultiDimensionalArrays();
        
        // 6. ARRAY REFERENCE TYPES AND HEAP MEMORY
        demonstrateArrayReferenceTypes();
        
        // 7. ARRAY COPYING
        demonstrateArrayCopying();
        
        // 8. SEARCHING IN ARRAYS
        demonstrateSearching();
        
        // 9. SORTING ARRAYS
        demonstrateSorting();
        
        // 10. COMMON ARRAY OPERATIONS
        demonstrateCommonOperations();
        
        // 11. ARRAY PITFALLS AND BEST PRACTICES
        demonstratePitfallsAndBestPractices();
        
        // 12. THREAD SAFETY AND ARRAYS
        demonstrateThreadSafety();
    }
    
    /**
     * Demonstrates various ways to declare and initialize arrays
     */
    private static void demonstrateDeclarationAndInitialization() {
        System.out.println("1. ARRAY DECLARATION AND INITIALIZATION");
        System.out.println("========================================");
        
        // Method 1: Declare then initialize with size
        int[] numbers1 = new int[5]; // Creates array of 5 integers, all initialized to 0
        System.out.println("Method 1 - Declare with size: " + java.util.Arrays.toString(numbers1));
        
        // Method 2: Declare and initialize with values
        int[] numbers2 = {1, 2, 3, 4, 5};
        System.out.println("Method 2 - Initialize with values: " + java.util.Arrays.toString(numbers2));
        
        // Method 3: Declare and initialize with 'new' keyword
        int[] numbers3 = new int[]{10, 20, 30, 40, 50};
        System.out.println("Method 3 - New with values: " + java.util.Arrays.toString(numbers3));
        
        // Different data types
        String[] names = {"Alice", "Bob", "Charlie"};
        double[] prices = {19.99, 29.99, 39.99};
        boolean[] flags = {true, false, true, false};
        
        System.out.println("String array: " + java.util.Arrays.toString(names));
        System.out.println("Double array: " + java.util.Arrays.toString(prices));
        System.out.println("Boolean array: " + java.util.Arrays.toString(flags));
        
        // Alternative declaration syntax (less common)
        int numbers4[] = {100, 200, 300}; // C-style, but valid in Java
        System.out.println("C-style declaration: " + java.util.Arrays.toString(numbers4));
        
        System.out.println();
    }
    
    /**
     * Demonstrates how to access and modify array elements
     */
    private static void demonstrateElementAccess() {
        System.out.println("2. ACCESSING AND MODIFYING ELEMENTS");
        System.out.println("===================================");
        
        int[] scores = {85, 92, 78, 96, 88};
        
        // Accessing elements (zero-based indexing)
        System.out.println("Original array: " + java.util.Arrays.toString(scores));
        System.out.println("First element (index 0): " + scores[0]);
        System.out.println("Last element (index " + (scores.length - 1) + "): " + scores[scores.length - 1]);
        System.out.println("Middle element (index 2): " + scores[2]);
        
        // Modifying elements
        scores[1] = 95; // Change second element
        scores[4] = 90; // Change last element
        System.out.println("After modifications: " + java.util.Arrays.toString(scores));
        
        // Using variables as indices
        int index = 3;
        scores[index] = 100;
        System.out.println("After setting index " + index + " to 100: " + java.util.Arrays.toString(scores));
        
        System.out.println();
    }
    
    /**
     * Demonstrates array length property and bounds checking
     */
    private static void demonstrateLengthAndBounds() {
        System.out.println("3. ARRAY LENGTH AND BOUNDS");
        System.out.println("==========================");
        
        int[] data = {10, 20, 30, 40, 50};
        
        // Length property (not a method!)
        System.out.println("Array: " + java.util.Arrays.toString(data));
        System.out.println("Array length: " + data.length);
        System.out.println("Valid indices: 0 to " + (data.length - 1));
        
        // Bounds checking demonstration
        System.out.println("\nBounds checking examples:");
        try {
            System.out.println("Accessing valid index [2]: " + data[2]);
            System.out.println("Accessing last valid index [" + (data.length - 1) + "]: " + data[data.length - 1]);
            
            // This will throw ArrayIndexOutOfBoundsException
            System.out.println("Attempting to access invalid index [" + data.length + "]:");
            System.out.println(data[data.length]); // This line will throw exception
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // Negative index also throws exception
        try {
            System.out.println("Attempting to access negative index [-1]:");
            System.out.println(data[-1]); // This will also throw exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates different ways to iterate through arrays
     */
    private static void demonstrateIteration() {
        System.out.println("4. ITERATING THROUGH ARRAYS");
        System.out.println("===========================");
        
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};
        
        // Method 1: Traditional for loop
        System.out.println("Method 1 - Traditional for loop:");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("  Index " + i + ": " + fruits[i]);
        }
        
        // Method 2: Enhanced for loop (for-each)
        System.out.println("\nMethod 2 - Enhanced for loop (for-each):");
        for (String fruit : fruits) {
            System.out.println("  " + fruit);
        }
        
        // Method 3: While loop
        System.out.println("\nMethod 3 - While loop:");
        int index = 0;
        while (index < fruits.length) {
            System.out.println("  " + fruits[index]);
            index++;
        }
        
        // Method 4: Reverse iteration
        System.out.println("\nMethod 4 - Reverse iteration:");
        for (int i = fruits.length - 1; i >= 0; i--) {
            System.out.println("  " + fruits[i]);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates multi-dimensional arrays (2D and 3D)
     */
    private static void demonstrateMultiDimensionalArrays() {
        System.out.println("5. MULTI-DIMENSIONAL ARRAYS");
        System.out.println("===========================");
        
        // 2D Array - Matrix
        System.out.println("2D Array (Matrix) Example:");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matrix dimensions: " + matrix.length + " x " + matrix[0].length);
        System.out.println("Matrix contents:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Alternative 2D array creation
        int[][] grades = new int[3][4]; // 3 students, 4 subjects
        grades[0] = new int[]{85, 90, 78, 92};
        grades[1] = new int[]{88, 85, 91, 87};
        grades[2] = new int[]{92, 89, 95, 90};
        
        System.out.println("\nStudent grades:");
        for (int student = 0; student < grades.length; student++) {
            System.out.print("Student " + (student + 1) + ": ");
            for (int subject = 0; subject < grades[student].length; subject++) {
                System.out.print(grades[student][subject] + " ");
            }
            System.out.println();
        }
        
        // Jagged arrays (arrays with different lengths)
        System.out.println("\nJagged Array Example:");
        int[][] jaggedArray = {
            {1, 2},
            {3, 4, 5, 6},
            {7, 8, 9}
        };
        
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.println("Row " + i + " (length " + jaggedArray[i].length + "): " + 
                             java.util.Arrays.toString(jaggedArray[i]));
        }
        
        // 3D Array example
        System.out.println("\n3D Array Example:");
        int[][][] cube = new int[2][3][4]; // 2x3x4 cube
        int value = 1;
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    cube[i][j][k] = value++;
                }
            }
        }
        
        System.out.println("3D Array dimensions: " + cube.length + " x " + cube[0].length + " x " + cube[0][0].length);
        System.out.println("Sample element cube[1][2][3]: " + cube[1][2][3]);
        
        System.out.println();
    }
    
    /**
     * Demonstrates that arrays are reference types stored in heap memory
     */
    private static void demonstrateArrayReferenceTypes() {
        System.out.println("6. ARRAY REFERENCE TYPES AND HEAP MEMORY");
        System.out.println("========================================");
        
        // Example 1: Arrays are objects (reference types)
        System.out.println("Example 1 - Arrays are Reference Types:");
        int[] array1 = {10, 20, 30};
        int[] array2 = {10, 20, 30};
        int[] array3 = array1; // Same reference!
        
        System.out.println("array1: " + java.util.Arrays.toString(array1));
        System.out.println("array2: " + java.util.Arrays.toString(array2));
        System.out.println("array3: " + java.util.Arrays.toString(array3));
        
        // Reference comparison vs content comparison
        System.out.println("array1 == array2 (different objects): " + (array1 == array2)); // false
        System.out.println("array1 == array3 (same reference): " + (array1 == array3)); // true
        System.out.println("Arrays.equals(array1, array2) (same content): " + java.util.Arrays.equals(array1, array2)); // true
        
        // Example 2: Modifying through shared references
        System.out.println("\nExample 2 - Shared References:");
        System.out.println("Before modification:");
        System.out.println("array1: " + java.util.Arrays.toString(array1));
        System.out.println("array3: " + java.util.Arrays.toString(array3));
        
        array3[0] = 999; // Modifies the same object that array1 references
        System.out.println("After array3[0] = 999:");
        System.out.println("array1: " + java.util.Arrays.toString(array1)); // Also changed!
        System.out.println("array3: " + java.util.Arrays.toString(array3));
        
        // Example 3: Arrays stored in heap memory
        System.out.println("\nExample 3 - Heap Memory Storage:");
        int[] heapArray = new int[1000000]; // Large array allocated in heap
        System.out.println("Large array created in heap memory (length: " + heapArray.length + ")");
        System.out.println("Array reference variable 'heapArray' is stored on stack");
        System.out.println("Actual array data is stored in heap memory");
        
        // Example 4: Passing arrays to methods (pass by reference)
        System.out.println("\nExample 4 - Pass by Reference:");
        int[] originalArray = {1, 2, 3, 4, 5};
        System.out.println("Before method call: " + java.util.Arrays.toString(originalArray));
        
        modifyArray(originalArray); // Pass reference, not copy
        System.out.println("After method call: " + java.util.Arrays.toString(originalArray)); // Modified!
        
        // Example 5: null references
        System.out.println("\nExample 5 - Null References:");
        int[] nullArray = null; // Reference points to nothing
        System.out.println("nullArray reference: " + nullArray);
        
        try {
            System.out.println("Attempting to access null array...");
            System.out.println(nullArray.length); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
        
        // Example 6: Array assignment creates new reference
        System.out.println("\nExample 6 - Array Assignment:");
        int[] arr1 = {100, 200, 300};
        int[] arr2 = {400, 500, 600};
        
        System.out.println("Before assignment:");
        System.out.println("arr1: " + java.util.Arrays.toString(arr1));
        System.out.println("arr2: " + java.util.Arrays.toString(arr2));
        
        arr1 = arr2; // arr1 now points to the same object as arr2
        System.out.println("After arr1 = arr2:");
        System.out.println("arr1: " + java.util.Arrays.toString(arr1)); // Now same as arr2
        System.out.println("arr2: " + java.util.Arrays.toString(arr2));
        System.out.println("arr1 == arr2: " + (arr1 == arr2)); // true - same reference
        
        // The original {100, 200, 300} array becomes eligible for garbage collection
        System.out.println("Original {100, 200, 300} array is now eligible for garbage collection");
        
        // Example 7: Memory addresses and heap visualization
        System.out.println("\nExample 7 - Memory Addresses and Heap Analysis:");
        demonstrateMemoryAddresses();
        
        System.out.println();
    }
    
    /**
     * Helper method to demonstrate pass by reference
     */
    private static void modifyArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            arr[0] = 999; // Modifies the original array
        }
    }
    
    /**
     * Demonstrates memory addresses and heap analysis techniques
     */
    private static void demonstrateMemoryAddresses() {
        // Get runtime information for HEAP memory
        Runtime runtime = Runtime.getRuntime();
        
        System.out.println("=== HEAP MEMORY ANALYSIS ===");
        System.out.println("Total heap memory: " + (runtime.totalMemory() / 1024 / 1024) + " MB");
        System.out.println("Free heap memory: " + (runtime.freeMemory() / 1024 / 1024) + " MB");
        System.out.println("Used heap memory: " + ((runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024) + " MB");
        
        // Create arrays and show their identity hash codes (memory addresses)
        System.out.println("\n=== ARRAY MEMORY ADDRESSES ===");
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = array1;
        
        System.out.println("array1 identity hash: " + System.identityHashCode(array1));
        System.out.println("array2 identity hash: " + System.identityHashCode(array2));
        System.out.println("array3 identity hash: " + System.identityHashCode(array3));
        System.out.println("Same reference (array1 == array3): " + (array1 == array3));
        System.out.println("Different objects (array1 == array2): " + (array1 == array2));
        
        // Show HEAP memory usage before and after large array creation
        System.out.println("\n=== HEAP MEMORY ALLOCATION DEMONSTRATION ===");
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory before large array: " + (beforeMemory / 1024 / 1024) + " MB");
        
        // Create large array (4MB for 1 million integers)
        int[] largeArray = new int[1000000];
        
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("HEAP Memory after large array: " + (afterMemory / 1024 / 1024) + " MB");
        System.out.println("HEAP Memory increase: " + ((afterMemory - beforeMemory) / 1024 / 1024) + " MB");
        System.out.println("Large array identity hash: " + System.identityHashCode(largeArray));
        
        // Demonstrate garbage collection
        System.out.println("\n=== GARBAGE COLLECTION DEMONSTRATION ===");
        largeArray = null; // Remove reference
        System.gc(); // Suggest garbage collection

        try {
            Thread.sleep(100); // Give GC time to run
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long afterGC = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("HEAP Memory after GC suggestion: " + (afterGC / 1024 / 1024) + " MB");
        // Garbage Collection Results: Memory after GC suggestion: 5 MB, including
        // - large array (4 MB), as well as
        // - other unreferenced objects created during the program
        // - temporary objects from previous demonstrations
        System.out.println("HEAP Memory potentially freed: " + ((afterMemory - afterGC) / 1024 / 1024) + " MB");
        // This is calculated as: afterMemory - afterGC = 12 MB - 5 MB = 7 MB

        // Summary:
        // - Runtime.getRuntime() shows the 4 MB increase when the large array is created because array data is stored in heap
        // - The reference variable largeArray is stored on stack (usually its size is tiny - just 8 bytes on 64-bit JVM)
        // - When set largeArray = null, the stack reference is removed, making the 4 MB heap data eligible for garbage collection
    }
    
    /**
     * Demonstrates different methods of copying arrays
     */
    private static void demonstrateArrayCopying() {
        System.out.println("7. ARRAY COPYING");
        System.out.println("================");
        
        int[] original = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + java.util.Arrays.toString(original));
        
        // Method 1: Manual copying with loop
        int[] copy1 = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy1[i] = original[i];
        }
        System.out.println("Manual copy: " + java.util.Arrays.toString(copy1));
        
        // Method 2: System.arraycopy()
        int[] copy2 = new int[original.length];
        System.arraycopy(original, 0, copy2, 0, original.length);
        System.out.println("System.arraycopy: " + java.util.Arrays.toString(copy2));
        
        // Method 3: Arrays.copyOf()
        int[] copy3 = java.util.Arrays.copyOf(original, original.length);
        System.out.println("Arrays.copyOf: " + java.util.Arrays.toString(copy3));
        
        // Method 4: Arrays.copyOfRange()
        int[] partialCopy = java.util.Arrays.copyOfRange(original, 1, 4); // Copy indices 1-3
        System.out.println("Partial copy (indices 1-3): " + java.util.Arrays.toString(partialCopy));
        
        // Method 5: clone() method
        int[] copy4 = original.clone();
        System.out.println("Clone method: " + java.util.Arrays.toString(copy4));
        
        // Demonstrating shallow vs deep copy for object arrays
        System.out.println("\nShallow vs Deep Copy for Object Arrays:");
        String[] stringArray = {"Hello", "World", "Java"};
        String[] shallowCopy = stringArray.clone();
        
        System.out.println("Original: " + java.util.Arrays.toString(stringArray));
        System.out.println("Shallow copy: " + java.util.Arrays.toString(shallowCopy));
        
        // Modifying original doesn't affect copy for immutable objects like String
        stringArray[0] = "Modified";
        System.out.println("After modifying original:");
        System.out.println("Original: " + java.util.Arrays.toString(stringArray));
        System.out.println("Shallow copy: " + java.util.Arrays.toString(shallowCopy));
        
        System.out.println();
    }
    
    /**
     * Demonstrates searching algorithms in arrays
     */
    private static void demonstrateSearching() {
        System.out.println("7. SEARCHING IN ARRAYS");
        System.out.println("======================");
        
        int[] numbers = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50};
        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        
        // Linear Search
        System.out.println("\nLinear Search:");
        int target = 22;
        int linearResult = linearSearch(numbers, target);
        if (linearResult != -1) {
            System.out.println("Found " + target + " at index " + linearResult);
        } else {
            System.out.println(target + " not found in array");
        }
        
        // Binary Search (requires sorted array)
        System.out.println("\nBinary Search:");
        int[] sortedNumbers = numbers.clone();
        java.util.Arrays.sort(sortedNumbers);
        System.out.println("Sorted array: " + java.util.Arrays.toString(sortedNumbers));
        
        int binaryResult = java.util.Arrays.binarySearch(sortedNumbers, target);
        if (binaryResult >= 0) {
            System.out.println("Found " + target + " at index " + binaryResult + " (in sorted array)");
        } else {
            System.out.println(target + " not found in sorted array");
        }
        
        // Finding min and max
        System.out.println("\nFinding Min and Max:");
        int min = findMin(numbers);
        int max = findMax(numbers);
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        
        System.out.println();
    }
    
    /**
     * Demonstrates sorting algorithms
     */
    private static void demonstrateSorting() {
        System.out.println("8. SORTING ARRAYS");
        System.out.println("=================");
        
        int[] numbers = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50};
        System.out.println("Original array: " + java.util.Arrays.toString(numbers));
        
        // Built-in sorting
        int[] sorted1 = numbers.clone();
        java.util.Arrays.sort(sorted1);
        System.out.println("Built-in sort (ascending): " + java.util.Arrays.toString(sorted1));
        
        // Bubble Sort implementation
        int[] sorted2 = numbers.clone();
        bubbleSort(sorted2);
        System.out.println("Bubble sort (ascending): " + java.util.Arrays.toString(sorted2));
        
        // Selection Sort implementation
        int[] sorted3 = numbers.clone();
        selectionSort(sorted3);
        System.out.println("Selection sort (ascending): " + java.util.Arrays.toString(sorted3));
        
        // Sorting in descending order
        Integer[] boxedNumbers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            boxedNumbers[i] = numbers[i];
        }
        java.util.Arrays.sort(boxedNumbers, java.util.Collections.reverseOrder());
        System.out.println("Descending order: " + java.util.Arrays.toString(boxedNumbers));
        
        System.out.println();
    }
    
    /**
     * Demonstrates common array operations
     */
    private static void demonstrateCommonOperations() {
        System.out.println("9. COMMON ARRAY OPERATIONS");
        System.out.println("==========================");
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        
        // Sum of elements
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of elements: " + sum);
        
        // Average
        double average = (double) sum / numbers.length;
        System.out.println("Average: " + average);
        
        // Count even and odd numbers
        int evenCount = 0, oddCount = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even numbers count: " + evenCount);
        System.out.println("Odd numbers count: " + oddCount);
        
        // Reverse array
        int[] reversed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }
        System.out.println("Reversed array: " + java.util.Arrays.toString(reversed));
        
        // Check if array is sorted
        boolean isSorted = true;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println("Is array sorted? " + isSorted);
        
        // Fill array with specific value
        int[] filled = new int[5];
        java.util.Arrays.fill(filled, 42);
        System.out.println("Array filled with 42: " + java.util.Arrays.toString(filled));
        
        // Check array equality
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {1, 2, 4};
        System.out.println("Arrays.equals([1,2,3], [1,2,3]): " + java.util.Arrays.equals(array1, array2));
        System.out.println("Arrays.equals([1,2,3], [1,2,4]): " + java.util.Arrays.equals(array1, array3));
        
        System.out.println();
    }
    
    /**
     * Demonstrates common pitfalls and best practices
     */
    private static void demonstratePitfallsAndBestPractices() {
        System.out.println("10. ARRAY PITFALLS AND BEST PRACTICES");
        System.out.println("=====================================");
        
        // Pitfall 1: Array reference vs array content
        System.out.println("Pitfall 1 - Array reference vs content:");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = arr1; // Same reference
        
        System.out.println("arr1 == arr2 (different objects): " + (arr1 == arr2)); // false
        System.out.println("arr1 == arr3 (same reference): " + (arr1 == arr3)); // true
        System.out.println("Arrays.equals(arr1, arr2): " + java.util.Arrays.equals(arr1, arr2)); // true
        
        // Pitfall 2: Modifying array through different references
        System.out.println("\nPitfall 2 - Shared references:");
        arr3[0] = 100; // Modifies arr1 as well
        System.out.println("After arr3[0] = 100:");
        System.out.println("arr1: " + java.util.Arrays.toString(arr1));
        System.out.println("arr3: " + java.util.Arrays.toString(arr3));
        
        // Pitfall 3: Array initialization with objects
        System.out.println("\nPitfall 3 - Object array initialization:");
        StringBuilder[] builders = new StringBuilder[3];
        System.out.println("Uninitialized StringBuilder array: " + java.util.Arrays.toString(builders));
        
        // Initialize each element
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder("Element " + i);
        }
        System.out.println("Initialized StringBuilder array: " + java.util.Arrays.toString(builders));
        
        // Best Practice 1: Use enhanced for-loop when index is not needed
        System.out.println("\nBest Practice 1 - Use enhanced for-loop:");
        int[] values = {10, 20, 30, 40, 50};
        int total = 0;
        for (int value : values) { // Cleaner than traditional for-loop
            total += value;
        }
        System.out.println("Sum using enhanced for-loop: " + total);
        
        // Best Practice 2: Validate array bounds
        System.out.println("\nBest Practice 2 - Validate bounds:");
        int index = 10; // Potentially invalid index
        if (index >= 0 && index < values.length) {
            System.out.println("Safe access: values[" + index + "] = " + values[index]);
        } else {
            System.out.println("Invalid index: " + index + " for array of length " + values.length);
        }
        
        // Best Practice 3: Use Arrays utility methods
        System.out.println("\nBest Practice 3 - Use Arrays utility methods:");
        int[] unsorted = {5, 2, 8, 1, 9};
        System.out.println("Before: " + java.util.Arrays.toString(unsorted));
        java.util.Arrays.sort(unsorted);
        System.out.println("After sort: " + java.util.Arrays.toString(unsorted));
        
        // Best Practice 4: Consider using Collections for dynamic sizing
        System.out.println("\nBest Practice 4 - Consider ArrayList for dynamic sizing:");
        System.out.println("Static array: Fixed size, fast access");
        System.out.println("ArrayList: Dynamic size, slightly slower access");
        System.out.println("Choose based on your specific requirements!");
        
        System.out.println();
        System.out.println("=== END OF STATIC ARRAYS TUTORIAL ===");
    }
    
    // Helper methods for searching and sorting
    
    /**
     * Linear search implementation
     */
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
    
    /**
     * Find minimum value in array
     */
    private static int findMin(int[] arr) {
        if (arr.length == 0) return Integer.MAX_VALUE;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    /**
     * Find maximum value in array
     */
    private static int findMax(int[] arr) {
        if (arr.length == 0) return Integer.MIN_VALUE;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Bubble sort implementation
     */
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * Selection sort implementation
     */
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap minimum element with first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    
    /**
     * Demonstrates thread safety issues with arrays and solutions
     */
    private static void demonstrateThreadSafety() {
        System.out.println("12. THREAD SAFETY AND ARRAYS");
        System.out.println("============================");
        
        // Example 1: Race condition demonstration
        // Demonstrates the issue: Two threads incrementing the same array element
        // Shows lost updates: Expected 2000, but often gets less due to race conditions
        System.out.println("Example 1 - Race Condition Problem:");
        demonstrateRaceCondition();
        
        // Example 2: Thread-safe solutions
        // Solution 1 - Synchronization: Using synchronized blocks with a lock object
        // Solution 2 - AtomicIntegerArray: Using java.util.concurrent.atomic.AtomicIntegerArray
        // Proves effectiveness: Both solutions consistently produce the expected result (2000)
        System.out.println("\nExample 2 - Thread-Safe Solutions:");
        demonstrateThreadSafeSolutions();
        
        // Example 3: Local arrays (thread-safe)
        // Demonstrates: Each thread gets its own local array copy
        // Shows safety: No conflicts because arrays are on separate thread stacks
        // Output: Each thread safely increments to 1000
        System.out.println("\nExample 3 - Local Arrays (Thread-Safe):");
        demonstrateLocalArrays();
        
        // Example 4: Read-only arrays (thread-safe)
        // Multiple readers: 3 threads reading from the same READ_ONLY_ARRAY
        // Safe concurrent access: Reading doesn't modify data
        // Consistent results: All threads get the same sum (150)
        System.out.println("\nExample 4 - Read-Only Arrays (Thread-Safe):");
        demonstrateReadOnlyArrays();
        
        System.out.println();
    }
    
    // Shared array for race condition demonstration
    private static int[] sharedArray = new int[5];
    private static final Object lock = new Object();
    
    /**
     * Demonstrates race condition with unsynchronized array access
     */
    private static void demonstrateRaceCondition() {
        System.out.println("Creating race condition with 2 threads modifying same array...");
        
        // Reset array
        java.util.Arrays.fill(sharedArray, 0);
        
        // Create two threads that increment the same array elements
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedArray[0]++; // NOT thread-safe!
            }
        }, "Thread-1");
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedArray[0]++; // NOT thread-safe!
            }
        }, "Thread-2");
        
        try {
            thread1.start();
            thread2.start();
            
            thread1.join(); // Wait for completion
            thread2.join();
            
            System.out.println("Expected result: 2000 (1000 + 1000)");
            System.out.println("Actual result: " + sharedArray[0]);
            
            if (sharedArray[0] != 2000) {
                System.out.println("❌ RACE CONDITION DETECTED! Lost updates due to concurrent access.");
            } else {
                System.out.println("✅ No race condition this time (but it's still not guaranteed!)");
            }
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates thread-safe solutions
     */
    private static void demonstrateThreadSafeSolutions() {
        System.out.println("Solution 1 - Synchronized Access:");
        
        // Reset array
        java.util.Arrays.fill(sharedArray, 0);
        
        Thread syncThread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized(lock) {
                    sharedArray[1]++; // Thread-safe with synchronization
                }
            }
        }, "SyncThread-1");
        
        Thread syncThread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized(lock) {
                    sharedArray[1]++; // Thread-safe with synchronization
                }
            }
        }, "SyncThread-2");
        
        try {
            syncThread1.start();
            syncThread2.start();
            
            syncThread1.join();
            syncThread2.join();
            
            System.out.println("Expected result with synchronization: 2000");
            System.out.println("Actual result with synchronization: " + sharedArray[1]);
            System.out.println("✅ Synchronization prevents race conditions!");
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        
        // Solution 2: AtomicIntegerArray
        System.out.println("\nSolution 2 - AtomicIntegerArray:");
        java.util.concurrent.atomic.AtomicIntegerArray atomicArray = 
            new java.util.concurrent.atomic.AtomicIntegerArray(5);
        
        Thread atomicThread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicArray.incrementAndGet(0); // Thread-safe atomic operation
            }
        }, "AtomicThread-1");
        
        Thread atomicThread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicArray.incrementAndGet(0); // Thread-safe atomic operation
            }
        }, "AtomicThread-2");
        
        try {
            atomicThread1.start();
            atomicThread2.start();
            
            atomicThread1.join();
            atomicThread2.join();
            
            System.out.println("Expected result with AtomicIntegerArray: 2000");
            System.out.println("Actual result with AtomicIntegerArray: " + atomicArray.get(0));
            System.out.println("✅ AtomicIntegerArray provides thread-safe operations!");
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates that local arrays are thread-safe
     */
    private static void demonstrateLocalArrays() {
        System.out.println("Local arrays are thread-safe (each thread has its own copy):");
        
        Runnable localArrayTask = () -> {
            int[] localArray = {0, 0, 0}; // Each thread gets its own array
            
            for (int i = 0; i < 1000; i++) {
                localArray[0]++; // Thread-safe because it's local
            }
            
            System.out.println(Thread.currentThread().getName() + 
                             " - Local array result: " + localArray[0]);
        };
        
        Thread localThread1 = new Thread(localArrayTask, "LocalThread-1");
        Thread localThread2 = new Thread(localArrayTask, "LocalThread-2");
        
        try {
            localThread1.start();
            localThread2.start();
            
            localThread1.join();
            localThread2.join();
            
            System.out.println("✅ Each thread operates on its own local array - no conflicts!");
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
    
    // Read-only array (thread-safe)
    private static final int[] READ_ONLY_ARRAY = {10, 20, 30, 40, 50};
    
    /**
     * Demonstrates that read-only arrays are thread-safe
     */
    private static void demonstrateReadOnlyArrays() {
        System.out.println("Read-only arrays are thread-safe:");
        
        Runnable readOnlyTask = () -> {
            int sum = 0;
            for (int value : READ_ONLY_ARRAY) {
                sum += value; // Only reading - thread-safe
            }
            System.out.println(Thread.currentThread().getName() + 
                             " - Sum of read-only array: " + sum);
        };
        
        Thread readThread1 = new Thread(readOnlyTask, "ReadThread-1");
        Thread readThread2 = new Thread(readOnlyTask, "ReadThread-2");
        Thread readThread3 = new Thread(readOnlyTask, "ReadThread-3");
        
        try {
            readThread1.start();
            readThread2.start();
            readThread3.start();
            
            readThread1.join();
            readThread2.join();
            readThread3.join();
            
            System.out.println("✅ Multiple threads can safely read from the same array!");
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        
        System.out.println("\n=== THREAD SAFETY SUMMARY ===");
        System.out.println("❌ Shared mutable arrays: NOT thread-safe");
        System.out.println("✅ Local arrays: Thread-safe (each thread has own copy)");
        System.out.println("✅ Read-only arrays: Thread-safe (no modifications)");
        System.out.println("✅ Synchronized access: Thread-safe (with performance cost)");
        System.out.println("✅ AtomicIntegerArray: Thread-safe (atomic operations)");
    }
}