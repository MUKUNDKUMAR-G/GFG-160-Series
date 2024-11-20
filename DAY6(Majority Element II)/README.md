# Next Permutation🔄

## Problem Statement

You are given an array of integers arr[] where each integer represents a vote for a candidate. Find all candidates that appear more than 𝑛/3 times in the array, where 𝑛 is the size of the array. If no such candidates exist, return an empty array. The result should be returned in sorted (increasing) order.

---

## Function Description

**Function Name:**

```
majorityElementII(int[] arr)
```

**Input:**

arr: An array of integers representing votes.

**Output:**
Returns a list of integers representing candidates that have votes more than n/3.

---

### **Input Format**

- An array of integers arr[].

---

### **Output Format**

- A list of integers representing candidates that meet the criteria. If no such elements exist, return an empty list.

---

## 📊 Examples

### Example 1

#### Input:

```
arr = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]

```

**Output:**

```java
[5, 6]
```

### Explanation:

5 occurs 5 > n/3 times, and 6 occurs 5 > n/3 times in the array.

### Example 2

#### Input

```
arr = [1, 2, 3, 4, 5]
```

**Output:**

```java
[]
```

#### Explanation:

No candidate appears more than n/3 times.

---

## 🧠 Approach and Solution

1.  Boyer-Moore Voting Algorithm Extension:

        - This algorithm efficiently finds up to two majority elements.
        - Use two candidate counters initialized to zero. Traverse the array:
            - Increment counters for matching candidates.
            - Reset candidates when counters reach zero.
        - Verify the counts of the candidates to confirm if they appear more than n/3.

2.  Sorting Result:

    - After finding valid candidates, sort the result in ascending order.

---

### Constraints:

```
1<=arr.size() 10^6
-10^9 <= arr[i] <= 10^9
```

# Time Complexity

- Time Complexity: O(n), two traversals of the array..
- Space Complexity: O(1), constant extra space used.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
