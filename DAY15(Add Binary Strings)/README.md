# Add Binary Strings🔢 + 🔢

## 📜Problem Statement

Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.

**Note**: The input strings may contain leading zeros but the output string should not have any leading zeros.

---

## Function Description

**Function**:

```
public String addBinary(String s1, String s2)

Input: Two binary strings s1 and s2.
Output: A binary string representing the sum of the inputs.
```

---

### **Input Format**

- Two binary strings containing only 0 and 1.
- Length: 1≤∣s1∣,∣s2∣≤10^6.

---

### **Output Format**

- A single binary string representing the sum of s1 and s2.

---

## 📊 Examples

### Example 1

#### Input:

```
s1 = "1101", s2 = "111"
```

**Output:**

```java
10100
```

### Explanation:

```
 1101
+ 111
10100
```

---

### Example 2

#### Input:

```
s1 = "00100", s2 = "010"

```

**Output:**

```java
110
```

### Explanation:

```
  100
+  10
  110
```

---

## 🧠 Approach and Solution

1. Initialization:

   - Use two pointers starting at the end of each string.
   - Initialize a carry variable for managing bit addition overflow.

2. Bitwise Addition:

   - For each position, add corresponding bits and the carry.
   - Append the sum modulo 2 to the result.
   - Update the carry to sum / 2.

3. Edge Cases:

   - Handle carry after the loop.
   - Remove leading zeros from the result.

---

### Constraints:

```
1 ≤ ∣s1∣, ∣s2∣ ≤ 10^6.
```

# Time Complexity

- Time complexity : O(max(n, m)): Where 𝑛 and 𝑚 are the lengths of s1 and s2.
- Space complexity : O(max(n, m)): The output binary string (stored in a StringBuilder) also has a length proportional to the sum, which is at most one bit longer than the longer input string. This results in linear space complexity.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
