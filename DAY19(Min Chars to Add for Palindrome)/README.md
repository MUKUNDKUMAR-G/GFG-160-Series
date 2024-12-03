# Minimum Characters for Palindrome 🌀

## 📜Problem Statement

Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

**Note:** A palindrome string is a sequence of characters that reads the same forward and backward.

---

## Function Description

**Function**:

```java
Function Name: minChar(String s)
Input: A string s.
Output: An integer representing the minimum number of characters to add.
```

---

### **Input Format**

## A single string s containing only lowercase English letters.

### **Output Format**

- An integer representing the minimum characters to add to make s a palindrome.

---

## 📊 Examples

### Example 1

#### Input:

```
s = "abc"
```

**Output:**

```java
2
```

### Explanation:

## Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"

### Example 2

#### Input:

```
s = "aacecaaaa"

```

**Output:**

```java
2
```

### Explanation:

Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"

---

## 🧠 Approach(KMP Algorithm for LPS)

We concatenate the string s with its reverse using a special character (e.g., #) that doesn’t appear in the input. The longest prefix which is also a suffix (LPS) helps find the minimum characters needed to add.

---

### Constraints:

```
1 <= s.size() <= 10^6
```

# Time Complexity

- Time complexity: O(n), where n is the length of s.
- Space complexity: O(n) for the LPS array.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
