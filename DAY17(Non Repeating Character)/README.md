# First Non-Repeating Character 🔍

## 📜Problem Statement

Given a string s consisting of **lowercase Latin Letters**. Return the **first non-repeating character** in s. If there is no non-repeating character, return '$'.

**Note:** When you return **'$'** driver code will output **-1**.

---

## Function Description

**Function**:

```java
public static char nonRepeatingChar(String s)

Input: A single string of lowercase Latin letters.
Output: The first non-repeating character or '$'.
```

---

### **Input Format**

A single line containing the string s.

---

### **Output Format**

- A single character representing the first non-repeating character in the string.
- If all characters repeat, return '$' (which will display as -1 in the output).

---

## 📊 Examples

### Example 1

#### Input:

```
s = "geeksforgeeks"
```

**Output:**

```java
'f'
```

### Explanation:

In the given string, 'f' is the first character in the string which does not repeat.

---

### Example 2

#### Input:

```
s = "racecar"

```

**Output:**

```java
'e'
```

### Explanation:

In the given string, 'e' is the only character in the string which does not repeat.

---

## 🧠 Approach and Solution

1. **Use a Frequency Map:** Use a **LinkedHashMap** to maintain the order of characters and their counts.
2. **Iterate Through the String:** Populate the map with counts of each character.
3. **Find the First Non-Repeating Character:** Traverse the map to find the **first character with a count of 1**.
4. **Return Result:** If **no such character** exists, **return '$'**.

---

### Constraints:

```
1 <= s.size() <= 10^5
```

# Time Complexity

- Time complexity: O(n), where 𝑛 is the length of the string, as we traverse it twice (once to count and once to find the result).
- Space complexity: O(n), for storing the character frequencies in the map.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
