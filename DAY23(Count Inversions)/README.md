# H-Index Finder 📚

This task involves determining how "unsorted" an array is by calculating the Inversion Count. Two elements arr[i] and arr[j] form an inversion if arr[i]>arr[j] and 𝑖 < 𝑗.

## 📝Problem Insight

Inversion Count:

- Indicates how far the array is from being sorted.
- Sorted Array: Inversion Count = 0.
- Reverse-Sorted Array: Maximum Inversion Count.
- Duplicate Elements: Do not contribute to inversions.

---

🔒 Constraints:

```
- 1≤citations.size()≤10^6
- 0 ≤citations[𝑖] ≤ 10^6
```

---

## 📜 Function Signature

**Method Signature**:

```java
class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Implementation here
    }
}
```

---

### **📥 Input Format**

- An integer array arr[], where 1≤arr[i]≤10^4.
- Array size: 1≤arr.size()≤10^5.

### ** 📤Output Format**

- An integer representing the total inversion count.

---

## 🧩 Examples

### Example 1

#### Input:

```
arr[] = [2, 4, 1, 3, 5]
```

**Output:**

```java
3
```

### Explanation:

- The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

### Example 2

#### Input:

```
arr[] = [2, 3, 4, 5, 6]
```

**Output:**

```java
0
```

### Explanation:

As the sequence is already sorted so there is no inversion count.

---

## 🔧 Approach

#### 1. Brute Force (Inefficient)

Compare each pair of elements arr[i] and arr[j] wherei<j.

Time Complexity:
O(n²), as it involves nested iterations for all pairs.

Code (Inefficient):

```java

Copy code
static int inversionCount(int arr[]) {
    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] > arr[j]) {
                count++;
            }
        }
    }

    return count;
}
```

#### 2. Optimized Approach: Merge Sort

We can optimize the process to O(n log n) using a modified Merge Sort.

💡 Key Insights:

While merging two sorted subarrays, count the number of elements in the right subarray that are smaller than the current element in the left subarray.

Steps:

1. Use Divide and Conquer to divide the array into two halves recursively.
2. Count inversions during the merge step by comparing the left and right subarrays.

##### 🚀 Example Walkthrough

```
Input:
arr = [2, 4, 1, 3, 5]

Steps:
1. Divide the Array:

    - Left Half: [2,4], Right Half: [1,3,5].

2. Merge and Count:
    - [2,4]: No inversions.
    - [1,3,5]: No inversions.
    - Merge [2,4] and [1,3,5]:
        - [1,2,3,4,5], Inversions: 3 ((2, 1), (4, 1), (4, 3)).

Output:

Inversion Count = 3.

```

---

# 🔍 Complexity Analysis

Time Complexity:

Recursive division: O(logn).
Merge operation: O(n).
Total: O(nlogn).

Space Complexity: O(n), for the temporary array.

---

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me

# Happy Coding! 🚀
