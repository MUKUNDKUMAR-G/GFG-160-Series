# Max Circular Subarray Sum 🔍

## 📜Problem Statement

Given an array of integers arr[], find the smallest positive missing number. The array can contain both negative and positive integers. The smallest positive integer starts from 1.

---

## Function Description

**Function**:

```
Function Name: missingNumber

Parameters:

int[] arr: The input array.

Returns:
int: The smallest positive missing number.
```

---

### **Input Format**

- arr[]: An array of integers, where 1≤arr.size()≤10^5.
- Array elements: −10^6≤arr[i]≤10^6.

---

### **Output Format**

- A single integer representing the maximum circular subarray sum.

---

## 📊 Examples

### Example 1

#### Input:

```
arr = [2, -3, 4, 1, 1, 7]

```

**Output:**

```java
3
```

### Explanation:

Smallest positive missing number is 3.

---

### Example 2

#### Input:

```
arr[] = [5, 3, 2, 5, 1]

```

**Output:**

```java
4
```

### Explanation:

Smallest positive missing number is 4.

---

## 🧠 Approach and Solution

**Approach 1 :**

**1. Sorting:** First, the array is sorted in ascending order to arrange elements systematically.
**2. Tracking the smallest positive number (count):** Start with count = 1 since the smallest positive number is always 1.
**3. Iterating through the array:** For each element:

- If count matches the current element, increment count by 1 (indicating the next smallest positive number is needed).
  **4. Return the result:** Once the iteration finishes, return the final value of count, which represents the smallest missing positive number.

---

**Appraoch 2 :**

**1. Remove negative numbers:** Ignore all negative numbers since the smallest positive number starts from 1.
**2. Hashing technique:** Use a boolean array to mark which numbers exist in the array.
**3. Identify the smallest missing number:** Iterate over the boolean array to find the first missing index.

---

### Constraints:

```
1 ≤ arr.size() ≤ 10^5
-10^5 ≤ arr[i] ≤ 10^5
```

# Time Complexity

Approach 1 :

- Time complexity : O(n log n) - for sorting (n log n) and traversing the array once(n).
- Space complexity : O(1) - No additional Data structure is used.

Approach 2:

- Time complexity : O(n) - for Traversing only once at.
- Space complexity : O(n) - using hashing technique to store only positive number

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
