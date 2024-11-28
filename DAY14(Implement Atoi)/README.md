# Implement Atoi()🔢

## 📜Problem Statement

Given a string s, the objective is to convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.

**Cases for atoi() conversion:**

    1. Skip any leading whitespaces.
    2. Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
    3. Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
    4. If the integer is greater than 2^31 – 1, then return 2^31 – 1 and if the integer is smaller than -2^31, then return -2^31.

---

## Function Description

**Function**:

```
public int myAtoi(String s)

Input: A string s containing alphanumeric characters, whitespace, and signs.
Output: An integer derived from the input string based on the given rules.
```

---

### **Input Format**

- A string s of length 1 ≤ |s| ≤ 15.
- Can contain spaces, digits, letters, and optional signs (+ or -).

---

### **Output Format**

- An integer after conversion or 0 if no valid digits are found.

---

## 📊 Examples

### Example 1

#### Input:

```
s = "-123"

```

**Output:**

```java
-123
```

### Explanation:

It is possible to convert -123 into an integer so we returned in the form of an integer

---

### Example 2

#### Input:

```
s = "  -"

```

**Output:**

```java
0
```

### Explanation:

No digits are present, therefore the returned answer is 0.

---

### Example 3

#### Input:

```
s = " 1231231231311133"

```

**Output:**

```java
2147483647
```

### Explanation:

The converted number will be greater than 231 – 1, therefore print 231 – 1 = 2147483647.

---

### Example 4

#### Input:

```
s = "-999999999999"
```

**Output:**

```java
-2147483648
```

### Explanation:

The converted number is smaller than -231, therefore print -231 = -2147483648.

---

### Example 5

#### Input:

```
s = "  -0012gfg4"
```

**Output:**

```java
-12
```

### Explanation:

Nothing is read after -12 as a non-digit character ‘g’ was encountered.

---

## 🧠 Approach and Solution

1. Initialization:

   - Set an index i = 0, a sign = 1 (for positive numbers), and num = 0.

2.Skip Leading Whitespaces:

- Increment i until a non-space character is found.

3. Check for Sign:

   - If s[i] is '-', set sign = -1.
   - If s[i] is '+', keep sign = 1.
   - Increment i after processing the sign.

4. Read Digits:

   - Iterate over digits, updating num = num \* 10 + digit.
   - Stop on encountering a non-digit character.

5. Overflow/Underflow Check:

   - Before adding a digit, ensure num will not exceed Integer.MAX_VALUE or go below Integer.MIN_VALUE.

6.Return Result:

- Return num \* sign.

---

### Constraints:

```
1 ≤ |s| ≤ 15.
```

# Time Complexity

- Time complexity : O(n) - where n is the length of the input string. The algorithm processes each character of the string once, making it linear in time complexity.
- Space complexity : O(n) - using hashing technique to store only positive number

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
