# 🎯 Number of Occurrence

Given a **sorted array** `arr[]` and a **target** number, the goal is to find **how many times** the target occurs in the array. Let's solve it with precision and efficiency using Binary Search! 🚀

---

## 💡 Problem Statement

Find the **number of occurrences** of a given target in a sorted array.

If the target is not present in the array, `return 0`.

---

## 🔒 Constraints

- \( 1 $\leq \text{size of } arr[]$ $\leq 10^6$ \) 🧮
- \( 1 $\leq arr[i]$, $\text{target}$ $\leq 10^6$ \) 🔢

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int countFreq(int[] arr, int target);
}
```

### Parameters

- **`arr[]`**: A sorted array of integers.
- **`target`**: An integer whose occurrences need to be counted.

### Returns

- An integer representing the number of occurrences of the `target` in the array.

---

## 📋 Examples

### Example 1

**Input**:  
`arr = [1, 1, 2, 2, 2, 2, 3], target = 2`

**Output**:  
`4`

**Explanation**:  
The target `2` appears 4️⃣ times.

---

### Example 2

**Input**:  
`arr = [1, 1, 2, 2, 2, 2, 3], target = 4`

**Output**:  
`0`

**Explanation**:  
The target `4` doesn’t exist in the array.

---

### Example 3

**Input**:  
`arr = [8, 9, 10, 12, 12, 12], target = 12`

**Output**:  
`3`

**Explanation**:  
The target `12` appears 3️⃣ times.

---

## 🛠️ Approach

### 1️⃣ Linear Search (Inefficient for Large Arrays)

- Traverse the array and count occurrences.
- **Time Complexity**: \( O(n) \) 🕒

### 2️⃣ Binary Search (Optimized for Sorted Arrays)

Using **binary search**, find:

1. The **first occurrence** of the target.
2. The **last occurrence** of the target.

**Formula for Count**:  
\[
$\text{Count}$ = ($\text{last occurrence} - \text{first occurrence}$) + 1
\]

---

## ⏱️ Time Complexity

- **Finding First and Last Occurrences**: \($ O(\log n) $\) 🔍
- **Total**: \( $O(\log n) $\) 🚀

### Space Complexity

- \( $O(1) $\): No extra space required.

---

## 🔍 Example Walkthrough

### Input:

`arr = [1, 1, 2, 2, 2, 2, 3], target = 2`

### Steps:

1. **Finding First Occurrence**:

   - Binary search narrows down to index \(2\).

2. **Finding Last Occurrence**:

   - Binary search narrows down to index \(5\).

3. **Calculating Count**:  
   \[$
   \text{Count}$ = (5 - 2) + 1 = 4
   \]

### Output:

`4️⃣`

---

### 🏆 Key Features

- **Optimized Search**: Leverages binary search for sorted arrays.
- **Handles Large Inputs**: Efficiently processes arrays of size up to (10<sup>6</sup>).
- **Interactive Output**: Emoji-based results for fun coding! 🎉

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me

**Happy Coding!** 💻🚀
