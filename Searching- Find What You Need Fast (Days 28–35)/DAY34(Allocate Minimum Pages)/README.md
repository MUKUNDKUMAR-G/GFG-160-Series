# 📘 Allocate Minimum Pages

---

## 💡 Problem Statement

Given an array `arr[]` of integers, where `arr[i]` represents the number of pages in the \(i^{th}\) book, and an integer `k` representing the number of students, allocate the books such that:

1. Each student receives **at least one book**.
2. Each student is assigned a **contiguous sequence of books**.
3. No book is assigned to more than one student.

The goal is to minimize the **maximum number of pages** assigned to any student. If it's not possible to assign books, return `-1`.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{size of }$ $arr$ $\leq 10^6$ \)
- \( 1 $\leq$ $arr[i]$ $\leq 10^3$ \)
- \( 1 $\leq$ $k$ $\leq$ $10^3$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static int findPages(int[] arr, int k);
}
```

### Parameters

- **`arr[]`**: An array of integers representing the number of pages in each book.
- **`k`**: The number of students.

### Returns

- The minimum possible value of the **maximum pages** assigned to any student, or `-1` if allocation is not possible.

---

## 📥 Input Format

1. An array `arr[]` representing the number of pages in the books.
2. An integer `k` representing the number of students.

---

## 📤 Output Format

- An integer representing the minimum possible maximum pages assigned to any student.

---

## 🎯 Examples

### Example 1

**Input**:  
`arr = [12, 34, 67, 90], k = 2`

**Output**:  
`113`

**Explanation**:  
Possible allocations:

1. \([12], [34, 67, 90]\): Maximum = \(191\)
2. \([12, 34], [67, 90]\): Maximum = \(157\)
3. \([12, 34, 67], [90]\): Maximum = \(113\)

The minimum among these is `113`.

---

### Example 2

**Input**:  
`arr = [15, 17, 20], k = 5`

**Output**:  
`-1`

**Explanation**:  
Allocation is not possible as there are fewer books than students.

---

### Example 3

**Input**:  
`arr = [22, 23, 67], k = 1`

**Output**:  
`112`

**Explanation**:  
All books must be assigned to one student.

---

## 💡 Approach

This problem can be solved using **Binary Search on Answer** combined with a **greedy allocation check**.

---

### Steps

1. **Range of Possible Answers**:

   - The minimum possible value of the maximum pages is the **largest book** (no student can get less than one book).
   - The maximum possible value of the maximum pages is the **sum of all pages** (one student takes all the books).

2. **Binary Search for the Answer**:

   - Use binary search on the range \([$\text{max(arr)}$, $\text{sum(arr)}$]\) to find the minimum possible maximum pages.

3. **Feasibility Function**:

   - Create a helper function `canAllocate(maxPages)` that checks if it's possible to allocate books such that no student gets more than `maxPages`.
   - Use a greedy approach:
     - Iterate through the books, and assign books to the current student until the total pages exceed `maxPages`.
     - If a new student is needed, increase the student count.

4. **Return Result**:
   - The binary search ensures that we find the smallest possible maximum pages that can satisfy the allocation constraints.

---

## ⏱️ Time Complexity

- **Binary Search**: \( $O(\log(\text{sum(arr)}$ - $\text{max(arr)}$)) \).
- **Feasibility Check**: \( $O(n)$ \), where \($n$ \) is the size of `arr`.
- **Overall Complexity**: \( $O(n$ $\cdot$ $\log$($\text{sum(arr)}$ - $\text{max(arr)}$)) \).

### Space Complexity

- \( O(1) \): No additional space is used.

---

## 🖥️ Solution

### Java Implementation

```java

class Solution {

    // Helper function to check if allocation is feasible
    private static boolean canAllocate(int[] arr, int k, int maxPages) {
        int studentCount = 1; // Start with the first student
        int currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages > maxPages) {
                studentCount++; // Assign to a new student
                currentPages = pages;

                if (studentCount > k) {
                    return false; // Too many students needed
                }
            } else {
                currentPages += pages;
            }
        }

        return true;
    }

    // Function to find the minimum possible maximum pages
    public static int findPages(int[] arr, int k) {
        if (arr.length < k) {
            return -1; // Not enough books for all students
        }

        int low = 0, high = 0;

        // Calculate the range for binary search
        for (int pages : arr) {
            low = Math.max(low, pages); // Largest book
            high += pages; // Total sum of pages
        }

        int result = -1;

        // Binary search to find the optimal maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                result = mid; // Update result
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Try for a larger maximum
            }
        }

        return result;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
12 34 67 90
k = 2
```

### Steps:

1. **Initial Range**:

   - \( $\text{low} = 90$\) (largest book).
   - \( $\text{high} = 203$ \) (sum of all pages).

2. **Binary Search**:

   - Check mid-points \( $\text{mid}$ = 146, 113, $\dots$ \) and use `canAllocate` to verify feasibility.

3. **Final Answer**:
   - The minimum possible maximum pages is `113`.

### Output:

```plaintext
The minimum possible maximum pages are: 113
```

---

## ✨ Key Takeaways

- **Binary Search on Answer** ensures efficient solution for large input sizes.
- **Greedy Feasibility Check** is crucial for verifying allocations.
- Handles edge cases like \( $k$ > $\text{size of arr}$ \) gracefully.

**Happy Coding!** 💻🚀
