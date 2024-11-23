# Today’s problem: Minimize the Heights II 🔧

## 📜Problem Statement

Given an array **arr[]** denoting heights of **N** towers and a positive integer **K**.

For **each** tower, you must perform exactly one of the following operations exactly once.

    - **Increase** the height of the tower by **K**
    - **Decrease** the height of the tower by **K**

Find out the **minimum** possible difference between the height of the shortest and tallest towers after you have modified each tower.

**Note:** It is **compulsory** to increase or decrease the height by K for each tower. **After** the operation, the resultant array should not contain any **negative integers**.

---

## Function Description

**Function Name**: `getMinDiff`

**Input:**
An array `arr[]` of size `N`.

An integer `K`.

**Output:**
An integer representing the minimized difference between the tallest and shortest towers.

---

### **Input Format**

- The first line contains the integer K.
- The second line contains N space-separated integers denoting the array arr[].

---

### **Output Format**

- Print a single integer, the minimized difference.

---

## 📊 Examples

### Example 1

#### Input:

```
K = 2
arr = [1, 5, 8, 10]

```

**Output:**

```java
5
```

### Explanation:

The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.

### Example 2

#### Input:

```
K = 3
arr = [3, 9, 12, 16, 20]

```

**Output:**

```java
11
```

### Explanation:

The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11.

---

## 🧠 Approach and Solution

1. Sort the Array: Start by sorting the array to structure the tower heights in ascending order. This helps in systematically evaluating the height adjustments.

2. Initial Difference: Calculate the initial difference between the maximum and minimum tower heights (arr[n-1] - arr[0]).

3. Iterate through Heights: Traverse the array and consider each tower height arr[i]:

   - Calculate potential new maximum and minimum heights:
     - Maximum Height: max(arr[i-1] + k, arr[n-1] - k)
     - Minimum Height: min(arr[0] + k, arr[i] - k)
   - Skip the iteration if subtracting K from the current height results in a negative value, as heights cannot be negative.

4. Update Result: Compute the difference between the new maximum and minimum heights. Update the result to store the minimum of the previous result and this new difference.

5. Return the Result: Once the loop completes, the result will hold the smallest possible difference between the tallest and shortest tower heights after adjustments.

## Example WalkThrough

Input: k = 2, arr[] = {1, 5, 8, 10}
Sort: arr[] = {1, 5, 8, 10}.
Initial Difference: result = 10 - 1 = 9.

Iteration:
i = 1: max = max(1 + 2, 10 - 2) = 8, min = min(1 + 2, 5 - 2) = 3, result = min(9, 8 - 3) = 5.
i = 2: max = max(5 + 2, 10 - 2) = 8, min = min(1 + 2, 8 - 2) = 3, result = min(5, 8 - 3) = 5.
i = 3: max = max(8 + 2, 10 - 2) = 10, min = min(1 + 2, 10 - 2) = 3, result = min(5, 10 - 3) = 5.
Output: result = 5.

---

### Constraints:

```
1 ≤ k ≤ 10^7
1 ≤ n ≤ 10^5
1 ≤ arr[i] ≤ 10^7
```

# Time Complexity

- Time Complexity:Sorting: O(NlogN).
  Iteration: O(N).
  Overall Complexity: O(NlogN).
- Space Complexity: O(1), We only use a few variables (No additional data structures are used).

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
